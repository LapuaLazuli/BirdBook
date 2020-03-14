package com.e.birdbook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class BPTest {
    @Test
    public void bpValueTest(){
        Dictionary d = new Hashtable();
        d.put("name", "American Crow");
        BirdInfoResults r = new BirdInfoResults();
        r.setResults(d);
        Package p = Packager.pack(r, Package.TYPE.BIRD);
        Package control = new Package();
        control.setName("American Crow");
        assertEquals(p.getName(), control.getName());
    }

    @Test
    public void bpNotNull(){
        Dictionary d = new Hashtable();
        d.put("name", "American Crow");
        BirdInfoResults r = new BirdInfoResults();
        r.setResults(d);
        Package p = Packager.pack(r, Package.TYPE.BIRD);
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
        Package b = Packager.pack(r, Package.TYPE.BIRD);
        Package control = new Package();
        control.setName("American Crow");
        control.setHabitat((String) d.get("habitat"));
        control.setSize((String) d.get("size"));
        assertEquals(b.getName(), control.getName());
        assertEquals(b.getHabitat(), control.getHabitat());
        assertEquals(b.getHabitat(), control.getHabitat());

    }
}
