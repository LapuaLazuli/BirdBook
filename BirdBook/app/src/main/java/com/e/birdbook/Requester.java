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
