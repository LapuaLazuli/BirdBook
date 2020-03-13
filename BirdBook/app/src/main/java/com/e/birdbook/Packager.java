package com.e.birdbook;

import java.util.Dictionary;
import java.util.Hashtable;

public class Packager {

    public static Bird pack(BirdInfoResults bir){
        Bird b;
        Dictionary d =  bir.getResults();
        b = new Bird((String) d.get("name"), (String) d.get("description"), (String) d.get("finding"), (String) d.get("habitat"), (String) d.get("diet"), (String) d.get("nest"), (String) d.get("behavior"), (String) d.get("conservation"), (String) d.get("size"), (String) d.get("shape"));
        /*
        b.setName((String) d.get("name"));
        b.setDescription((String) d.get("Description"));
        b.setName((String) d.get("name"));
        b.setName((String) d.get("name"));
        b.setName((String) d.get("name"));
        b.setName((String) d.get("name"));
        */


        return b;
    }
}
