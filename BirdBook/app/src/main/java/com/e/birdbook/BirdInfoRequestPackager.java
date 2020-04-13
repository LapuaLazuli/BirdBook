package com.e.birdbook;

import java.util.ArrayList;
import java.util.List;

public class BirdInfoRequestPackager
{
    public static BirdInfoRequest createInfoRequest(String field, String value)
    {
        List<String> requestFields = new ArrayList<String>();

        //add all fields
        requestFields.add("name");
        requestFields.add("description");
        requestFields.add("size");
        requestFields.add("shape");
        requestFields.add("finding");
        requestFields.add("habitat");
        requestFields.add("diet");
        requestFields.add("nest");
        requestFields.add("behavior");
        requestFields.add("conservation");
        requestFields.add("image_path");

        return new BirdInfoRequest(requestFields, field, value, Request.TYPE.BIRD);
    }
}
