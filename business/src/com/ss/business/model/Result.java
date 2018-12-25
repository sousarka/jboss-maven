package com.ss.business.model;

public class Result<T> {
    T retObject;
    String message;

    /**
     * @return the retObject
     */
    public T getRetObject() {
        return retObject;
    }

    /**
     * @param retObject the retObject to set
     */
    public void setRetObject(T retObject) {
        this.retObject = retObject;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}