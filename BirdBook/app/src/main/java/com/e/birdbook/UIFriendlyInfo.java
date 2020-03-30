package com.e.birdbook;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

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

    public void setInfo(Dictionary<String, String> info)
    {
        this.info = info;
    }

    public Dictionary<String, String> getInfo()
    {
        return this.info;
    }
}
