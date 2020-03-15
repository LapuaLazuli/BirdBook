package com.e.birdbook;

public class Requester
{

    public static UIFriendlyInfo request(Request request)
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
            switch(results.getType())
            {
                case BIRD:
                    BirdPackage bird = Packager.pack(results);
                    UIinfo = birdInfoContentPresenter.makeUIFriendly(bird);
                    break;

                case BIRDLIST:
                    BirdListPackage bird = Packager.pack(results);
                    UIinfo = birdInfoContentPresenter.makeUIFriendly(bird);
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
