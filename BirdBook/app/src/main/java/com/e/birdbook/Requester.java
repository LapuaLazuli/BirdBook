package com.e.birdbook;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Requester
{

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public static UIFriendlyInfo request(Request request, Context context)
    {
        UIFriendlyInfo UIinfo = null;
        Results results = null;

        try
        {
            results = DBAcessor.access(request, context);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if(results != null)
        {
            Package bird = Packager.pack(results);
            switch(results.getType())
            {
                case BIRD:
                    UIinfo = BirdInfoContentPresenter.makeUIFriendly((BirdPackage) bird);
                    break;

                case BIRDLIST:
                    UIinfo = BirdListContentPresenter.makeUIFriendly((BirdListPackage) bird);
                    break;

                case INVALID:
                default:
                    System.out.println("ERROR: invalid type in requester");
                    break;
            }

        }
        else
            System.out.println("Error: Results null");

        return UIinfo;

    }
}
