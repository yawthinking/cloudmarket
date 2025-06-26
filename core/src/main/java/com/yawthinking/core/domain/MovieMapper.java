package com.yawthinking.core.domain;

import java.util.Optional;

public interface MovieMapper {

    Optional<Movie> findById(Long id);
    long save(Movie movie);

}
