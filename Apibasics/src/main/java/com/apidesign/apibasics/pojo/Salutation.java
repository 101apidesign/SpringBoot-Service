package com.apidesign.apibasics.pojo;

public class Salutation {
	 
    private String message;
 
    public Salutation() {}
 
    public Salutation(String message) {
        this.message = message;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
}
