package com.e.birdbook;

import java.util.ArrayList;
import java.util.List;

public class UpdateRequestPackager
{

    public static UpdateRequest createUpdateRequest(String searchField, String searchValue, String requestField, List newValue)
    {
        List<String> requestFields = new ArrayList<String>();

        //add all fields
        requestFields.add(requestField);

        return new UpdateRequest(requestFields, searchField, searchValue, newValue);
    }
}
