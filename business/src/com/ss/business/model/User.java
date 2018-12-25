package com.ss.business.model;

import org.springframework.lang.NonNull;

/**
 * model object
 *
 */
public class User 
{
    @NonNull
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
