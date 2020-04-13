package com.e.birdbook;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class BirdListPackage extends BirdPackage implements Package
{
    private List<String> names;
    private List<String> imageURLs;
    private Request.TYPE type;

    public BirdListPackage(Results bir)
    {
        names = new ArrayList<String>();
        imageURLs = new ArrayList<String>();

        //alternates between names and images
        Enumeration<String> nameImageEnum = bir.getResults().keys();
        while(nameImageEnum.hasMoreElements())
        {
            names.add(nameImageEnum.nextElement());
            imageURLs.add(nameImageEnum.nextElement());
        }

        Request.TYPE type = Request.TYPE.BIRDLIST;
    }

    public List<String> getNames()
    {
        return this.names;
    }

    public List<String> getImageURLs() { return this.imageURLs; }
}
