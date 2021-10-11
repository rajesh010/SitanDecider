package com.example.sitandecider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //-- Some variables to be decided here

                 //var platz!!!!
    public static int maxOfDatabase;
    public static   String maxNameOfDatabase;
    public static  int randomNumber;
    public static boolean truenum;

    int min = 0;

    public static String RandomName;

    ArrayList<Integer> includedIDs = new ArrayList<Integer>();

          //  -- till here



    Button btn_rand, btn_showall;

    ImageButton btn_Help;

    TextView tv_decide;

    DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn_rand = findViewById(R.id.btn_rand);
        btn_showall = findViewById(R.id.btn_showall);

        btn_Help = findViewById(R.id.btn_Help);

        tv_decide = findViewById(R.id.tv_decide);




        btn_rand.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                maxOfDatabase = dataBaseHelper.MaxNum();


                randomNumber = (int) Math.floor(Math.random()*(maxOfDatabase-min+1)+min);

                //new lkine //
                truenum = true;

                rand();

              /*  if (truenum == false) {
                    randomNumber = (int) Math.floor(Math.random() * (maxOfDatabase - min + 1) + min);
                    rand();
                } else {
                    randomNumber = (int) Math.floor(Math.random()*(maxOfDatabase-min+1)+min);  //newly added
                    RandomName = dataBaseHelper.maxName(randomNumber);
                    tv_decide.setText(RandomName);
                } */
               // Toast.makeText(MainActivity.this, "Random num = " + randomNumber + "and rand name = " + RandomName , Toast.LENGTH_SHORT).show();
            }
        });


        btn_showall.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SavedDinner.class);
                startActivity(i);

            }
        });


        btn_Help.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Help_Activity.class);
                startActivity(i);

            }
        });





    }  //------------------------------------------- end of on Create-----------------------------------

    public void rand() {

        includedIDs = dataBaseHelper.onlyInclude();
        Collections.sort(includedIDs);
        int n = 0;

        while(truenum == true){
        try {
            while (includedIDs.get(n) <= maxOfDatabase) {
                    if (includedIDs.get(n) == randomNumber) {
                        RandomName = dataBaseHelper.maxName(randomNumber);
                        tv_decide.setText(RandomName);
                        truenum = false;
                        break;
                    } else {
                        n++;
                       // truenum = false;   //gonna try down
                    }
                }





        } catch (Exception e) {
            n = 0;
            randomNumber = (int) Math.floor(Math.random()*(maxOfDatabase-min+1)+min);  //newly added
        }

    }

    }

}