package com.e.birdbook;

import java.util.Dictionary;
import java.util.Hashtable;

public class UpdateResults implements Results
{
    private Dictionary<String, String> results;
    private Results.TYPE type;

    public UpdateResults()
    {
        this.results = new Hashtable<String, String>();
        this.type = Results.TYPE.UPDATE;
    }

    public UpdateResults(Dictionary<String, String> results)
    {
        this.results = results;
        this.type = Results.TYPE.UPDATE;
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

    @Override
    public Results.TYPE getType()
    {
        return this.type;
    }
}
