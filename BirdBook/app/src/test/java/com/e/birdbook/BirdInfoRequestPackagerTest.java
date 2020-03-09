package com.e.birdbook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class BirdInfoRequestPackagerTest
{
    @Test
    public void nullTest()
    {
        //setup
        BirdInfoRequest req = BirdInfoRequestPackager.createInfoRequest("name", "Crow");

        assertNotNull(req);
    }


    @Test
    public void fieldTest()
    {
        //setup
        BirdInfoRequest req = BirdInfoRequestPackager.createInfoRequest("name", "Crow");

        assertEquals("name" , req.getSearchField());
    }

    @Test
    public void valueTest()
    {
        //setup
        BirdInfoRequest req = BirdInfoRequestPackager.createInfoRequest("name", "Crow");

        assertEquals("Crow" , req.getSearchValue());
    }


    @Test
    public void requestedFieldsTest()
    {
        //setup
        BirdInfoRequest req = BirdInfoRequestPackager.createInfoRequest("name", "Crow");

        List<String> testRequestFields = new ArrayList<String>();

        //add all fields
        testRequestFields.add("name");
        testRequestFields.add("description");
        testRequestFields.add("size");
        testRequestFields.add("shape");
        testRequestFields.add("finding");
        testRequestFields.add("habitat");
        testRequestFields.add("diet");
        testRequestFields.add("nest");
        testRequestFields.add("behavior");
        testRequestFields.add("conservation");


        assertEquals(testRequestFields , req.getRequestedFields());
    }
}
