package com.e.birdbook;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class UIFriendlyInfo
{
    // key: UIelement name | value: new value
    private List<String> uiElements;
    private List<String> values;

    public UIFriendlyInfo()
    {
        this.uiElements = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public UIFriendlyInfo(List<String> uiElements, List<String> values)
    {
        this.uiElements = uiElements;
        this.values = values;
    }

    public List<String> getUIElements()
    {
        return this.uiElements;
    }

    public List<String> getValues() { return this.values; }
}
