package com.yawthinking.core.domain;

import java.util.Optional;

public interface ActorMapper {

    Optional<Actor> findById(Long id);
    long save(Actor actor);

}
