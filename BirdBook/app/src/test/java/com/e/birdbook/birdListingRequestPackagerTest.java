package com.e.birdbook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


public class birdListingRequestPackagerTest
{
    @Test
    public void nullTest()
    {
        BirdInfoRequest req = BirdListingRequestPackager.createListingRequest();

        AssertNotNull(req);
    }

    @Test
    public void fieldTest()
    {
        BirdInfoRequest req = BirdListingRequestPackager.createListingRequest();

        assertEquals("all", req.getSearchField());
    }

    @Test
    public void valueTest()
    {
        BirdInfoRequest req = BirdListingRequestPackager.createListingRequest();

        assertEquals("", req.getValueField());
    }

    @Test
    public void requestedFieldsTest()
    {
        BirdInfoRequest req = BirdListingRequestPackager.createListingRequest();
        List<String> requestFieldsTest = new ArrayList<String>();
        requestFields.add("Name");
        requestFields.add("Image");

        assertEquals(requestFieldsTest, req.getRequestedFields());
    }
}
