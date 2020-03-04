package com.e.birdbook;

public class Requester
{
    private Request request;
    private Results results;

    public Requester(Request request)
    {
        this.request = request;

        if(request != null)
        {
            //TODO: update after discussing with designer of database accessor
            //this.results = accessor.makeQuery(this.request);
        }
        else
            System.out.println("Error: Request null");

        if(results != null)
        {
            //TODO: update after discussing with designer of packager (check bookmarks)
            //packager.createModel(this.results);
        }
        else
            System.out.println("Error: Results null");

    }
}
