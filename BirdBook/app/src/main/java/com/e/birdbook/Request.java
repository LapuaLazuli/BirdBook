package com.e.birdbook;

import java.util.List;

public interface Request {

    //returns a List of Strings which contain the names of the fields desired from the request
    public List<String> getRequestedFields();

    //sets the fields to request to newFields
    public void setRequestedFields(List<String> newFields);
}
