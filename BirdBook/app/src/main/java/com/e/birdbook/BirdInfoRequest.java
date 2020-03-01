package com.e.birdbook;

import java.util.ArrayList;
import java.util.List;

//Bird info requests specificied information about a bird
public class BirdInfoRequest implements Request {

    private List<String> requestFields;

    public BirdInfoRequest()
    {
        this.requestFields = new ArrayList<String>();
    }

    public BirdInfoRequest(List<String> requestFields)
    {
        this.requestFields = requestFields;
    }

    @Override
    public List<String> getRequestedFields() {
        return this.requestFields;
    }

    @Override
    public void setRequestedFields(List<String> newFields) {
        this.requestFields = newFields;
    }
}
