package com.e.birdbook;

import java.util.Dictionary;
import java.util.List;

public interface Results
{
    enum TYPE{INVALID, BIRD, BIRDLIST, UPDATE}

    //returns a Dictionary of Strings,Strings which contain the values of the fields returned by the request
    public Dictionary<String, String> getResults();

    //updates a List of Strings which contain the values of the fields returned by the request
    public void setResults(Dictionary<String, String> newValues);

    public TYPE getType();
}
