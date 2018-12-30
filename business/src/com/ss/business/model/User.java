package com.ss.business.model;

/**
 * model object
 *
 */
public class User 
{
    private String name;

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "[name : " + name+ " ]";
    }

}
