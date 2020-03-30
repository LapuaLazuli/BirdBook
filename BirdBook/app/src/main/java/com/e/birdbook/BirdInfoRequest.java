package com.e.birdbook;

import java.util.ArrayList;
import java.util.List;

//Bird info requests specificied information about a bird
public class BirdInfoRequest implements Request
{

    private List<String> requestFields;
    private String searchField;
    private String searchValue;
    private Request.TYPE type;

    public BirdInfoRequest()
    {
        this.requestFields = new ArrayList<String>();
        this.searchValue = null;
        this.searchField = null;
        this.type = TYPE.INVALID;
    }

    public BirdInfoRequest(List<String> requestFields, String searchField, String searchValue, TYPE type)
    {
        this.requestFields = requestFields;
        this.searchField = searchField;
        this.searchValue = searchValue;
        this.type = type;
    }

    @Override
    public List<String> getRequestedFields()
    {
        return this.requestFields;
    }

    @Override
    public void setRequestedFields(List<String> newFields)
    {
        this.requestFields = newFields;
    }

    @Override
    public String getSearchField()
    {
        return this.searchField;
    }

    public void setSearchField(String field)
    {
        this.searchField = field;
    }

    public String getSearchValue()
    {
        return this.searchValue;
    }

    public void setSearchValue(String value)
    {
        this.searchValue = value;
    }

    @Override
    public Request.TYPE getType()
    {
        return this.type;
    }

    @Override
    public void setType(Request.TYPE type)
    {
        this.type = type;
    }
}
