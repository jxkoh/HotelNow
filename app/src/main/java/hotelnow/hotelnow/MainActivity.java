package hotelnow.hotelnow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import hotelnow.hotelnow.FirebaseDiary.Login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final int ERROR_DIALOG_REQUEST = 9001;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        ImageButton btnSearch = (ImageButton) findViewById(R.id.btn_search);
        ImageButton btnHome= (ImageButton) findViewById(R.id.btn_home);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Webview.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Launching Searching Activity", Toast.LENGTH_SHORT).show();
            }
        });


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Launching Diary Activity", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
