package com.e.birdbook;

import java.util.ArrayList;
import java.util.List;

class UpdateContentPresenter
{
    public static UIFriendlyInfo makeUIFriendly(UpdatePackage bird)
    {
        //output
        List<String> ui = new ArrayList<String>();
        List<String> values = new ArrayList<String>();

        try
        {
            ui.add("seenCheckbox");
            values.add(bird.getSeenStatusString());
        }
        catch (NullPointerException e)
        {
            System.out.println("Error: NULL");
        }

        return new UIFriendlyInfo(ui, values);
    }
}
