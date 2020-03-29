package com.e.birdbook;


import org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import static com.e.birdbook.DBAcessor.access;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class DBTest {
    @Test
    public void dbNullTest() throws Exception {
        List<String> reqFields = new ArrayList<>();
        reqFields.add("habitat");
        reqFields.add("conservation");
        reqFields.add("behavior");
        Request req = new BirdInfoRequest(reqFields, "name", "American Crow", Request.TYPE.BIRD);
        BirdInfoResults res = (BirdInfoResults) access(req);
        Dictionary<String, String> r = res.getResults();
        assertNotNull(res);
    }

    @Test
    public void dbValueTest() throws Exception{
        List<String> reqFields = new ArrayList<>();
        reqFields.add("habitat");
        reqFields.add("conservation");
        reqFields.add("behavior");
        Request req = new BirdInfoRequest(reqFields, "name", "American crow", Request.TYPE.BIRD);
        BirdInfoResults res = (BirdInfoResults) access(req);
        Dictionary<String, String> r = res.getResults();
        assertEquals("American crow", r.get("name"));
    }

    @Test
    public void dbResultsClassTest() throws Exception {
        List<String> reqFields = new ArrayList<>();
        reqFields.add("description");
        reqFields.add("conservation");
        reqFields.add("behavior");
        Request req = new BirdInfoRequest(reqFields, "name", "Barn owl", Request.TYPE.BIRD);
        BirdInfoResults res = (BirdInfoResults) access(req);
        Dictionary<String, String> r = res.getResults();
        Dictionary d = new Hashtable();
        d.put("name", "Barn owl");
        d.put("description", "Ghostly pale and normally strictly nocturnal, Barn Owls are silent predators of the night world. Lanky, with a whitish face, chest, and belly, and buffy upperparts, this owl roosts in hidden, quiet places during the day. By night, they hunt on buoyant wingbeats in open fields and meadows. You can find them by listening for their eerie, raspy calls, quite unlike the hoots of other owls. Despite a worldwide distribution, Barn Owls are declining in parts of their range due to habitat loss.");
        d.put("conservation", "Low Concern");
        d.put("behavior", "Aerial Dive");
        assertEquals(d.get("description"), r.get("description"));
        assertEquals(d.get("name"), r.get("name"));
        assertEquals(d.get("conservation"), r.get("conservation"));
        assertEquals(d.get("behavior"), r.get("behavior"));

    }

    @Test
    public void dbDicNotNull() throws Exception {
        //checks if the dictionary of <name, BirdInfoResults> is not NULL
        List<String> reqFields = new ArrayList<>();
        reqFields.add("description");
        reqFields.add("conservation");
        reqFields.add("behavior");
        Request req = BirdListingRequestPackager.BirdListRequest();
        Results res = access(req);
        Dictionary<String, String> test = res.getResults();
        assertNotNull(test);

        System.out.println(">>>PRINTING KEYS");
        Enumeration<String> testEnum = test.keys();
        while(testEnum.hasMoreElements())
            System.out.println(">>>DEBUG: " + testEnum.nextElement());

        //check if the BirdInfoResults in dictionary test isn't NULL
        assertNotNull(test.get("American crow"));
    }


}