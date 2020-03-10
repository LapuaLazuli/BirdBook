package com.e.birdbook;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class birdInfoActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bird_info_page);

        //call request packager to get request
        //send request to requester
        //get UI friendly info

        loadUIfriendlyInfo();
    }

    public void loadUIfriendlyInfo()
    {
        //loop through UI elements
            //update each element with corresponding data pieces
    }
}
