package com.e.birdbook;

import java.util.List;

class BirdListPackage extends BirdPackage implements Package
{
    private List<String> names;
    private Request.TYPE type;
    public BirdListPackage(Results bir)
    {

        this.type = Request.TYPE.BIRDLIST;
    }

    public List<String> getNames()
    {
        return this.names;
    }
}
