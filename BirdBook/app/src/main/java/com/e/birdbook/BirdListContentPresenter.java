package com.e.birdbook;

import java.util.Dictionary;
import java.util.Hashtable;

public class BirdListContentPresenter
{
    public static UIFriendlyInfo makeUIFriendly(BirdPackage bird)
    {
        Dictionary<String, String> info = new Hashtable<String, String>();

        info.put("infoName", bird.getName());
        //info.put("infoImage", bird.getImage());

        return new UIFriendlyInfo(info);
    }
}
