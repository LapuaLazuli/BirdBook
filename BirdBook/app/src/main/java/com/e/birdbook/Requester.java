package com.e.birdbook;

public class Requester
{
    public static UIFriendlyInfo Request(Request request)
    {
        UIFriendlyInfo UIinfo = null;
        Results results = DBAcessor.access(request);

        if(results != null)
        {
            UIinfo = packager.pack(results);
        }
        else
            System.out.println("Error: Results null");

        return UIinfo;
    }
}
