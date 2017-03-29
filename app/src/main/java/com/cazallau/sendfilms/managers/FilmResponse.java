package com.cazallau.sendfilms.managers;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gemabeltran on 23/1/17.
 */

public class FilmResponse {

    private @SerializedName("Search") List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public class Film{
        private @SerializedName("Title") String title;
        private @SerializedName("Poster") String poster;
        private @SerializedName("imdbID") String imdbID;

        public Film() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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
}
