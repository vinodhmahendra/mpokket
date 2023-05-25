package com.simplilearn.model;

public class Welcome {

    private String message;


    public Welcome(String message){
        this.message = message;
    }

    //this is used by spring-boot convertors
    public String getMessage() {
        return message;
    }
}
