package com.yawthinking.core.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Alias("user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String uuid;
    private String name;
    private final String email;
    private String password;
    private String city;
    private Role role;
    private Long version;

    public User(String uuid, String email) {
        super();
        this.uuid = uuid;
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(uuid, user.uuid) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, email);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("uuid='" + uuid + "'")
                .add("name='" + name + "'")
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("city='" + city + "'")
                .add("role=" + role)
                .add("version=" + version)
                .toString();
    }

}
