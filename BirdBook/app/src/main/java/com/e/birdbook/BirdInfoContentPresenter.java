package com.e.birdbook;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class BirdInfoContentPresenter
{
    public static UIFriendlyInfo makeUIFriendly(BirdPackage bird)
    {
        //output
        List<String> ui = new ArrayList<String>();
        List<String> values = new ArrayList<String>();

        try
        {
            ui.add("infoName");
            values.add(bird.getName());

            ui.add("infoImage");
            values.add(bird.getImageURL());

            ui.add("infoDescription");
            values.add(bird.getDescription());

            ui.add("infoSize");
            values.add(bird.getSize());

            ui.add("infoShape");
            values.add(bird.getShape());

            ui.add("infoFinding");
            values.add(bird.getFinding());

            ui.add("infoHabitat");
            values.add(bird.getHabitat());

            ui.add("infoDiet");
            values.add(bird.getDiet());

            ui.add("infoNest");
            values.add(bird.getNest());

            ui.add("infoBehavior");
            values.add(bird.getBehavior());

            ui.add("infoConservation");
            values.add(bird.getConservation());

            ui.add("birdCall"); //special case; see birdInfoActivity
            values.add(bird.getCallURL());
        }
        catch (NullPointerException e)
        {
            System.out.println("Error: NULL");
        }

        return new UIFriendlyInfo(ui, values);
    }
}
