package com.e.birdbook;

import org.junit.Test;

import java.util.Dictionary;
import java.util.Hashtable;

import static junit.framework.TestCase.assertEquals;

public class BirdInfoResultsTest
{
    @Test
    public void nullTest()
    {
        //setup
        BirdInfoResults res = new BirdInfoResults();
        Dictionary<String, String> dict = new Hashtable<String, String>();

        assertEquals(dict, res.getResults());
    }

    @Test
    public void simpleParametersTest()
    {
        //setup
        Dictionary<String, String> dict = new Hashtable<String, String>();
        dict.put("Name", "Crow");

        BirdInfoResults res = new BirdInfoResults(dict);


        assertEquals(dict, res.getResults());
    }

    @Test
    public void multiParametersTest()
    {
        //setup
        Dictionary<String, String> dict = new Hashtable<String, String>();
        dict.put("Name", "Sparrow");
        dict.put("Color", "blue");
        dict.put("Attack Stat", "52");
        dict.put("Defense Stat", "36");

        BirdInfoResults res = new BirdInfoResults(dict);


        assertEquals(dict, res.getResults());
    }

    @Test
    public void settersTest()
    {
        //setup
        Dictionary<String, String> dict = new Hashtable<String, String>();
        dict.put("Name", "Pidgeon");
        dict.put("Color", "Gray");
        dict.put("Attack Stat", "52");
        dict.put("Defense Stat", "36");

        BirdInfoResults res = new BirdInfoResults(dict);

        dict.remove("Color");
        dict.put("Speed Stat", "75");

        assertEquals(dict, res.getResults());
    }
