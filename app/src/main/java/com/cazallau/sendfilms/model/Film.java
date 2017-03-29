package com.cazallau.sendfilms.model;

import java.io.Serializable;

/**
 * Created by gemabeltran on 23/1/17.
 */

public class Film implements Serializable{

    private String name;
    private String poster;
    private String imdbID;

    public Film(String name, String poster, String imdbID) {
        this.name = name;
        this.poster = poster;
        this.imdbID = imdbID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}
