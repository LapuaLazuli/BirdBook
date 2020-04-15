
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

public class birdInfoActivity extends AppCompatActivity
{
    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bird_info_page);
        //get info about what page this is
        String birdName = getIntent().getStringExtra("Bird");

        //test loading image
//        ImageView currentImageView = (ImageView)this.findViewById(R.id.infoImage);;
//        currentImageView.setImageBitmap(BitmapFactory.decodeFile("../../media/pictures/american_coot"));

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
        Dictionary<String, String> info = UIInfo.getInfo();
        Enumeration<String> keysEnu = info.keys();
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
                    case "class androidx.appcompat.widget.AppCompatTextView":
                        TextView currentTextView = (TextView)currentUIElement;
                        currentTextView.setText(info.get(currentKey));
                        break;

                    case "class androidx.appcompat.widget.AppCompatImageView":
                        ImageView currentImageView = (ImageView)currentUIElement;
                        //int imageId = getResources().getIdentifier(info.get(currentKey), null, getPackageName());
                        //currentImageView.setImageResource(imageId);
                        currentImageView.setImageBitmap(BitmapFactory.decodeFile(info.get(currentKey)));
                        break;

                    default:
                        System.out.println("DEBUG: unrecognized class: " + currentUIElement.getClass().toString());
                        break;
                }
            }
        }
    }
}