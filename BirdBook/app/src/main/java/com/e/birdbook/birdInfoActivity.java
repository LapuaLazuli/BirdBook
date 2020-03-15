package com.e.birdbook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Enumeration;
import java.util.Hashtable;

public class birdInfoActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bird_info_page);

        //get info about what page this is
        String birdName = getIntent().getStringExtra("Bird");

        //call request packager to get request
        BirdInfoRequest req = BirdInfoRequest.createInfoRequest("name", birdName);

        //send request to requester
        Results res = Requester.request(req);

        //apply UI friendly info
        loadUIfriendlyInfo(res);
    }

    public void loadUIfriendlyInfo(Hashtable<String, String> UIInfo)
    {
        //loop through UI elements
        //update each element with corresponding data pieces

        Enumeration<String> keysEnu = UIInfo.keys();
        View currentUIElement;
        String currentKey;
        int resourceID;

        while(keysEnu.hasMoreElements())
        {
            currentKey = keysEnu.nextElement();
            resourceID = getResources().getIdentifier(currentKey, "id", getPackageName());
            currentUIElement = this.findViewById(resourceID);

            if(currentUIElement != null)
            {
                switch(currentUIElement.getClass().toString())
                {
                    case "TextView":
                        TextView currentTextView = (TextView)currentUIElement;
                        currentTextView.setText(UIInfo.get(currentKey));
                        break;

                    case "ImageView":
                        ImageView currentImageView = (ImageView)currentUIElement;
                        int imageId = getResources().getIdentifier(UIInfo.get(currentKey), null, getPackageName());
                        currentImageView.setImageResource(imageId);
                        break;
                }
            }

        }
    }
}
