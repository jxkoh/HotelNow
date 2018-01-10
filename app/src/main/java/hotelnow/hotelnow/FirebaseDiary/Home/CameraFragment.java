package hotelnow.hotelnow.FirebaseDiary.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import hotelnow.hotelnow.MainActivity;
import hotelnow.hotelnow.R;


/**
 * Created by User on 5/28/2017.
 */

public class CameraFragment extends Fragment {
    private static final String TAG = "CameraFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_camera, container, false);

        Button btnHome = (Button) view.findViewById(R.id.btn_home);

        btnHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Returning to Previous Activity", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
