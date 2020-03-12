package com.e.birdbook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import static com.e.birdbook.DBAcessor.access;

public class DBTest {
    @Test
    public void dbIsCorrect1() throws Exception {
        List<String> reqFields = new ArrayList<>();
        reqFields.add("habitat");
        reqFields.add("conservation");
        reqFields.add("behavior");
        Request req = new BirdInfoRequest(reqFields, "name", "American Crow");
        BirdInfoResults res = (BirdInfoResults) access(req);
        Dictionary<String, String> r = res.getResults();
        System.out.println(r);

    }
}