package com.e.birdbook;

import java.util.Dictionary;
import java.util.Hashtable;

public class birdInfoContentPresenter
{
    public static UIFriendlyInfo makeUIFriendly(BirdPackage bird)
    {
        Dictionary<String, String> info = new Hashtable<String, String>();

        info.put("infoName", bird.getName());
        //info.put("infoImage", bird.getImage());
        info.put("infoDescription", bird.getDescription());
        info.put("infoSize", bird.getSize());
        info.put("infoShape", bird.getShape());
        info.put("infoFinding", bird.getFinding());
        info.put("infoHabitat", bird.getHabitat());
        info.put("infoDiet", bird.getDiet());
        info.put("infoNest", bird.getNest());
        info.put("infoBehavior", bird.getBehavior());
        info.put("infoConservation", bird.getConservation());

        return new UIFriendlyInfo(info);
    }
}
