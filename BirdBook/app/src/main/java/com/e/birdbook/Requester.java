package com.e.birdbook;

public class Requester
{
    public static Results request(Request request)
    {
        //TODO: update after discussing with designer of database accessor
//        Results results = accessor.makeQuery(request);
//
//        if(results != null)
//        {
//            //TODO: update after discussing with designer of packager (check bookmarks)
////            packager.createModel(results);
//        }
//        else
//            System.out.println("Error: Results null");

        return new BirdInfoResults();
    }
}
