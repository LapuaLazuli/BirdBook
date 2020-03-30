package com.e.birdbook;

import java.util.List;

public interface Request {

    enum TYPE{INVALID, BIRD, BIRDLIST}

    //returns a List of Strings which contain the names of the fields desired from the request
    public List<String> getRequestedFields();

    //sets the fields to request to newFields
    public void setRequestedFields(List<String> newFields);

    //search field is how the db should identify which info to grab, eg: name of bird
    public String getSearchField();
    public void setSearchField(String field);
    public String getSearchValue();
    public void setSearchValue(String value);

    public TYPE getType();
    public void setType(TYPE type);
}
