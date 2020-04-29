package com.e.birdbook;

import java.util.ArrayList;
import java.util.List;

public class UpdateRequest implements Request
{
    private List<String> requestFields;
    private String searchField;
    private String searchValue;
    private Request.TYPE type;
    private List newValues;

    public UpdateRequest()
    {
        this.requestFields = new ArrayList<String>();
        this.searchValue = null;
        this.searchField = null;
        this.type = TYPE.INVALID;
        this.newValues = null;
    }

    public UpdateRequest(List<String> requestFields, String searchField, String searchValue, TYPE type, List newValues)
    {
        this.requestFields = requestFields;
        this.searchField = searchField;
        this.searchValue = searchValue;
        this.type = type;
        this.newValues = newValues;
    }

    public void setNewValues(List newValue)
    {
        this.newValues = newValue;
    }

    public List getNewValues()
    {
        return this.newValues;
    }

    //interface methods
    @Override
    public List<String> getRequestedFields()
    {
        return this.getRequestedFields();
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

    @Override
    public void setSearchField(String field)
    {
        this.searchField = field;
    }

    @Override
    public String getSearchValue()
    {
        return this.searchValue;
    }

    @Override
    public void setSearchValue(String value)
    {
        this.searchValue = value;
    }

    @Override
    public TYPE getType()
    {
        return this.type;
    }

    @Override
    public void setType(TYPE type)
    {
        this.type = type;
    }
}
