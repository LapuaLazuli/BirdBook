package com.e.birdbook;

public class Requester
{

    public static UIFriendlyInfo Request(Request request)
    {
        UIFriendlyInfo UIinfo = null;
        Results results = null;

        try
        {
            results = DBAcessor.access(request);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        if(results != null)
        {
            Package bird = Packager.pack(results, Package.TYPE.BIRD);
            UIinfo = birdInfoContentPresenter.makeUIFriendly(bird);
        }
        else
            System.out.println("Error: Results null");

        return UIinfo;

    }
}
