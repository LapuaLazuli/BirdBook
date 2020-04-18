
package com.e.birdbook;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class birdInfoActivity extends AppCompatActivity
{
    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bird_info_page);
        //get info about what page this is
        String birdName = getIntent().getStringExtra("Bird");

        if(birdName != null)
        {
            //call request packager to get request
            BirdInfoRequest req = BirdInfoRequestPackager.createInfoRequest("name", birdName);

            //send request to requester
            UIFriendlyInfo res = Requester.request(req, this);

            //apply UI friendly info
            loadUIfriendlyInfo(res);
        }

    }

    public void loadUIfriendlyInfo(UIFriendlyInfo UIInfo)
    {
        //loop through UI elements
        //update each element with corresponding data pieces

        //get 0 since there is only 1 bird entry to use
        List<String> ui = UIInfo.getUIElements();
        List<String> values = UIInfo.getValues();

        View currentUIElement;
        String currentUIElementName;
        int resourceID;

        for(int i = 0; i < ui.size(); i++)
        {
            currentUIElementName = ui.get(i);
            resourceID = getResources().getIdentifier(currentUIElementName, "id", getPackageName());
            currentUIElement = this.findViewById(resourceID);

            if(currentUIElement != null)
            {
                switch(currentUIElement.getClass().toString())
                {
                    case "class androidx.appcompat.widget.AppCompatTextView":
                        TextView currentTextView = (TextView)currentUIElement;
                        currentTextView.setText(values.get(i));
                        break;

                    case "class androidx.appcompat.widget.AppCompatImageView":
                        ImageView currentImageView = (ImageView)currentUIElement;
                        int imageId = getResources().getIdentifier(values.get(i), "drawable", getPackageName());
                        currentImageView.setImageResource(imageId);
                        break;

                    default:
                        System.out.println("DEBUG: unrecognized class: " + currentUIElement.getClass().toString());
                        break;
                }
            }
        }

    }
}