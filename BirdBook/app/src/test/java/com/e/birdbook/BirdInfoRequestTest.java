package com.e.birdbook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class BirdInfoRequestTest
{
    @Test
    public void noParamsTest()
    {
        //setup
        Request req = new BirdInfoRequest();

        //check that requested field is empty
        assertEquals(new ArrayList<String>(), req.getRequestedFields());

        //check values are actually nulled out
        assertNull(req.getSearchField());
        assertNull(req.getSearchValue());
    }

    @Test
    public void simpleParamsTest()
    {
        //setup
        List<String> fields = new ArrayList<String>();
        fields.add("name");

        Request req = new BirdInfoRequest(fields, "name", "Crow");

        //check parameters
        assertEquals(fields, req.getRequestedFields());
        assertEquals("name", req.getSearchField());
        assertEquals("Crow", req.getSearchValue());
    }

    @Test
    public void multipleFieldsTest()
    {
        //setup
        List<String> fields = new ArrayList<String>();
        fields.add("name");
        fields.add("color");
        fields.add("habitat");

        Request req = new BirdInfoRequest(fields, "color", "red");

        //check parameters
        assertEquals(fields, req.getRequestedFields());
        assertEquals("color", req.getSearchField());
        assertEquals("red", req.getSearchValue());
    }

    @Test
    public void settersTest()
    {
        //setup
        List<String> fields = new ArrayList<String>();
        fields.add("name");
        fields.add("color");
        fields.add("lifespan");
        fields.add("region");

        Request req = new BirdInfoRequest(fields, "region", "Pacific West");

        fields.add("behavior");

        req.setRequestedFields(fields);
        req.setSearchField("behavior");
        req.setSearchValue("absolutely bonkers");

        //check parameters
        assertEquals(fields, req.getRequestedFields());
        assertEquals("behavior", req.getSearchField());
        assertEquals("absolutely bonkers", req.getSearchValue());
    }
}
