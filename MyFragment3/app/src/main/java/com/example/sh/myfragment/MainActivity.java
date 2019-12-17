package com.example.sh.myfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements FragmentCallback{

    Fragment1 fragment1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment1).commit();

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fragment1 != null)
                {
                    fragment1.onCommandFromActivity("show","액티비티로부터 전달됨.");
                }
            }
        });

    }

    public void onCommand(String command,String data)
    {
        button.setText(data);
    }
}
