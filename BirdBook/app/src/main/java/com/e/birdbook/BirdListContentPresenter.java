package com.e.birdbook;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class BirdListContentPresenter
{
    public static UIFriendlyInfo makeUIFriendly(BirdListPackage bird)
    {
        Dictionary<String, String> info = new Hashtable<String, String>();

        List<String> names = bird.getNames();
        List<String> imageURLs = bird.getImageURLs();

        for(int i = 0; i < names.size(); i++)
        {
            info.put("TextName" + i, names.get(i));
            info.put("ImageView", imageURLs.get(i));
        }

        return new UIFriendlyInfo(info);
    }
}
