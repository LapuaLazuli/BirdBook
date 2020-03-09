package com.e.birdbook;

import java.util.ArrayList;
import java.util.List;

public class BirdListingRequestPackager
{

    public BirdListingRequestPackager()
    {
        List<String> requestFields = new ArrayList<String>();
        String searchField = "all"; //not an actual field -- this is used by the database accessor to grab all entries.
        String searchValue = "";

        requestFields.add("Name");
        requestFields.add("Image");

        BirdInfoRequest request = new BirdInfoRequest(requestFields, searchField, searchValue);
    }
}
