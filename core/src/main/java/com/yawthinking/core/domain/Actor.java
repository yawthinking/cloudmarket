package com.yawthinking.core.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.StringJoiner;

@Alias("actor")
public class Actor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Long id;
    private String name;
    private int sex;
    private LocalDate born;

    public Actor(Long id) {
        this.id = id;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public LocalDate getBorn() {
        return born;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Actor actor)) return false;
        return Objects.equals(id, actor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Actor.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("sex=" + sex)
                .add("born=" + born)
                .toString();
    }

}
