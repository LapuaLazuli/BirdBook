package com.e.birdbook;

import java.util.Dictionary;
import java.util.Hashtable;

public class UIFriendlyInfo
{
    // key: UIelement name | value: new value
    private Dictionary<String, String> info;

    public UIFriendlyInfo()
    {
        this.info = new Hashtable<String, String>();
    }

    public UIFriendlyInfo(Dictionary<String, String> results)
    {
        this.info = results;
    }

    public void setInfo(Dictionary<String, String> newValues)
    {
        this.info = newValues;
    }

    public Dictionary<String, String> getInfo()
    {
        return this.info;
    }
}
