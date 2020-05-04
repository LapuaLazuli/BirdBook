package com.e.birdbook;

import java.util.Dictionary;

public class UpdatePackage implements Package
{
    private boolean isSeen;

    public UpdatePackage(Results bir)
    {
        Dictionary d = bir.getResults();
        this.isSeen = (boolean)d.get("seenStatus");
    }

    void setSeenStatus(Boolean isSeen)
    {
        this.isSeen = isSeen;
    }

    boolean getSeenStatus()
    {
        return this.isSeen;
    }

    String getSeenStatusString()
    {
        String result = "";

        if(this.isSeen)
            result = "true";
        else
            result = "false";

        return result;
    }
}
