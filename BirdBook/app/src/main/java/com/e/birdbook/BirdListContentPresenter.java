package com.e.birdbook;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class BirdListContentPresenter
{
    public static UIFriendlyInfo makeUIFriendly(BirdListPackage bird)
    {
        //input
        List<String> names = bird.getNames();
        List<String> imageURLs = bird.getImageURLs();

        //output
        List<String> ui = new ArrayList<String>();
        List<String> values = new ArrayList<String>();

        for(int i = 0; i < names.size(); i++)
        {
            values.add(names.get(i));
            values.add(imageURLs.get(i));

            ui.add("TextName");
            ui.add("ImageView");
        }

        return new UIFriendlyInfo(ui, values);
    }
}
