package com.example.zeeshan.dublincycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Zeeshan Nasir(15438) on 3/14/2018.
 */


public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    //connecting this to main activity for list view of json data
    public void ListView (View view){

        startActivity(new Intent(FirstActivity.this,MainActivity.class));

    }

    //connecting map activity using onClick method
    public void MapView (View view){

        startActivity(new Intent(FirstActivity.this,MapsActivity.class));

    }

    //connecting about activity using onClcik method
    public void AboutView (View view){

        startActivity(new Intent(FirstActivity.this,About.class));

    }


}

