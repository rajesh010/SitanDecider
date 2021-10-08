package com.example.sitandecider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    //-- Some variables to be decided here

                 //var platz!!!!
    int maxOfDatabase;
    String maxNameOfDatabase;
    int randomNumber;
   static boolean truenum;

    String RandomName;

    ArrayList<Integer> includedIDs = new ArrayList<Integer>();

          //  -- till here



    Button btn_rand, btn_showall;
    TextView tv_decide;

    DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_rand = findViewById(R.id.btn_rand);
        btn_showall = findViewById(R.id.btn_showall);

        tv_decide = findViewById(R.id.tv_decide);




        btn_rand.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                maxOfDatabase = dataBaseHelper.MaxNum();

                int min = 0;
                randomNumber = (int) Math.floor(Math.random()*(maxOfDatabase-min+1)+min);

                rand();

                if (truenum == false) {
                    randomNumber = (int) Math.floor(Math.random() * (maxOfDatabase - min + 1) + min);
                    rand();
                } else {
                    RandomName = dataBaseHelper.maxName(randomNumber);
                    tv_decide.setText(RandomName);
                }

            }
        });


        btn_showall.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SavedDinner.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "Deleted: " + randomNumber + "and rand name " + RandomName , Toast.LENGTH_SHORT).show();

            }
        });





    }  //------------------------------------------- end of on Create-----------------------------------

    public void rand(){

        includedIDs = dataBaseHelper.onlyInclude();
        Collections.sort(includedIDs);
        int n = 0 ;
        try{
        while (includedIDs.get(n) <= maxOfDatabase) {
            if (includedIDs.get(n) == randomNumber){
                RandomName = dataBaseHelper.maxName(randomNumber);
                truenum = true;
                break;
        }else {
                n++;
                truenum = false;
            }
        } }
        catch(Exception e) {
             n = 0;
        }

    }

}