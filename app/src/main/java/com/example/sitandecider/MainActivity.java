package com.example.sitandecider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //-- Some variables to be decided here

                 //var platz!!!!

          //  -- till here



    Button btn_rand, btn_showall;
    TextView tv_decide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_rand = findViewById(R.id.btn_rand);
        btn_showall = findViewById(R.id.btn_showall);

        tv_decide = findViewById(R.id.tv_decide);


        btn_showall.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SavedDinner.class);
                startActivity(i);
            }
        });


    }  //------------------------------------------- end of on Create-----------------------------------
}