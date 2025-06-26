package com.yawthinking.core.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serial;
import java.io.Serializable;

@Alias("position")
public class Position implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private Actor actor;
    private Movie movie;

    public Position() {
        super();
    }

    public Position(Actor actor, Movie movie, String name) {
        this.actor = actor;
        this.movie = movie;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
