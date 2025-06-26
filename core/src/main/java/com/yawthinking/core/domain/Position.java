package com.yawthinking.core.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Alias("position")
public class Position implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private Actor actor;
    private Long movieId;

    public Position() {
        super();
    }

    public Position(Actor actor, Movie movie, String name) {
        this.actor = actor;
        this.movieId = movie.getId();
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

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position position)) return false;
        return Objects.equals(actor, position.actor) && Objects.equals(movieId, position.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, movieId);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Position.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("actor=" + actor)
                .add("movieId=" + movieId)
                .toString();
    }

}
