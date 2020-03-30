package com.e.birdbook;

import org.junit.Test;

import java.util.Dictionary;
import java.util.Hashtable;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class BPTest {
    @Test
    public void bpValueTest(){
        Dictionary d = new Hashtable();
        d.put("name", "American Crow");
        Results r = new BirdInfoResults();
        r.setResults(d);
        BirdPackage p = (BirdPackage) Packager.pack(r);
        BirdPackage control = new BirdPackage();
        control.setName("American Crow");
        assertEquals(p.getName(), control.getName());
    }

    @Test
    public void bpNotNull(){
        Dictionary d = new Hashtable();
        d.put("name", "American Crow");
        BirdInfoResults r = new BirdInfoResults();
        r.setResults(d);
        BirdPackage p = (BirdPackage) Packager.pack(r);
        assertNotNull(p);
    }

    @Test
    public void bpMultiFieldTest(){
        Dictionary d = new Hashtable();
        d.put("name", "American Crow");
        d.put("habitat", "New York probably");
        d.put("size", "about the size of my grade in this class LUL");
        BirdInfoResults r = new BirdInfoResults();
        r.setResults(d);
        BirdPackage b = (BirdPackage)Packager.pack(r);
        BirdPackage control = new BirdPackage();
        control.setName("American Crow");
        control.setHabitat((String) d.get("habitat"));
        control.setSize((String) d.get("size"));
        assertEquals(b.getName(), control.getName());
        assertEquals(b.getHabitat(), control.getHabitat());
        assertEquals(b.getHabitat(), control.getHabitat());

    }
}
