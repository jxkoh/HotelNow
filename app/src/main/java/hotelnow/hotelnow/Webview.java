package hotelnow.hotelnow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import hotelnow.hotelnow.ReviewActivity.account.LoginActivity;


public class Webview extends AppCompatActivity {
    private static final String TAG = "Webview";

    private WebView mWebView;
    private Button btnNext,btnHome;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack()) {
                        mWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Toast.makeText(this, "Launching Activity...", Toast.LENGTH_LONG).show();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);


        setupWebView();

    }

    private void setupWebView()
    {
        String text = "Hotel";

        WebView webView = findViewById(R.id.webView);
        mWebView = (WebView) findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                return true;
            }
        });

        webSettings.setJavaScriptEnabled(true);
        webSettings.setGeolocationEnabled(true);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin,
                                                           GeolocationPermissions.Callback callback) {

                callback.invoke(origin, true, false);
            }
        });

        webView.loadUrl("https://www.google.com.my/maps/search/"+text+"/");

        btnNext = (Button) findViewById(R.id.btn_next);
        btnHome = (Button) findViewById(R.id.btn_home);

        btnNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Webview.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(Webview.this, "Redirecting...", Toast.LENGTH_SHORT).show();
        }
    });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Webview.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(Webview.this, "Redirecting...", Toast.LENGTH_SHORT).show();
            }
        });

    }



}
