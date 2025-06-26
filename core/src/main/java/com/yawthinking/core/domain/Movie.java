package com.yawthinking.core.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@Alias("movie")
public class Movie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Long id;
    private String name;
    private String photo;
    private LocalDate createDate;

    private List<Position> positions;

    public Movie(Long id) {
        this.id = id;
        this.positions = new ArrayList<>();
    }

    public Position addPosition(Actor actor, String name){
        Position position = new Position(actor, this, name);
        this.positions.add(position);
        return position;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Movie movie)) return false;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Movie.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("photo='" + photo + "'")
                .add("createDate=" + createDate)
                .add("positions=" + positions)
                .toString();
    }

}
