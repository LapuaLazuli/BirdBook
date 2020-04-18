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
        Enumeration<String> nameEnum = bir.getResults().keys();
        Enumeration<String> imageEnum = bir.getResults().elements();
        while(nameEnum.hasMoreElements() && imageEnum.hasMoreElements())
        {
            String newElement = nameEnum.nextElement();
            System.out.println("DEBUG: NEWELEMENT = " + newElement);
            names.add(newElement);

            newElement = imageEnum.nextElement();
            System.out.println("DEBUG: NEWELEMENT = " + newElement);
            imageURLs.add(newElement);
        }

        Request.TYPE type = Request.TYPE.BIRDLIST;
    }

    public List<String> getNames()
    {
        return this.names;
    }

    public List<String> getImageURLs() { return this.imageURLs; }
}
