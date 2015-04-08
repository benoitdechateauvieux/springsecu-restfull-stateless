package org.exoplatform.bch.service;

/**
 * Created by bdechateauvieux on 4/8/15.
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
