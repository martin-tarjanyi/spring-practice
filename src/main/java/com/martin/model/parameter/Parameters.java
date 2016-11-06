package com.martin.model.parameter;

import javax.validation.constraints.Pattern;

public class Parameters
{
    @Pattern(regexp = "[A-Za-z ]+")
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
