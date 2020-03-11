package com.e.birdbook;

import java.util.ArrayList;
import java.util.List;

public class BirdListingRequestPackager
{
    public static BirdInfoRequest createListingRequest()
    {
        List<String> requestFields = new ArrayList<String>();
        String searchField = "all"; //not an actual field -- this is used by the database accessor to grab all entries.
        String searchValue = "";

        requestFields.add("Name");
        requestFields.add("Image");

        return new BirdInfoRequest(requestFields, searchField, searchValue);
    }
}
