package com.e.birdbook;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

//results from a request including info about a bird
public class BirdInfoResults implements Results
{

    private Dictionary<String, String> results;

    public BirdInfoResults()
    {
        this.results = new Hashtable<String, String>();
    }

    public BirdInfoResults(Dictionary<String, String> results)
    {
        this.results = results;
    }

    @Override
    public void setResults(Dictionary<String, String> newValues)
    {
        this.results = newValues;
    }

    @Override
    public Dictionary<String, String> getResults()
    {
        return this.results;
    }
}
