package com.yawthinking.core.domain;

import java.util.Optional;

public interface UserMapper {

    Optional<User> findByEmail(String email);

    long save(User user);

}
