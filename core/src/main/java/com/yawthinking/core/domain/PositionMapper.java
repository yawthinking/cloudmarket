package com.yawthinking.core.domain;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface PositionMapper {

    Optional<Position> findById(@Param("actorId") Long actorId, @Param("movieId") Long movieId);
    List<Position> findByMovieId(Long movieId);
    long save(Position position);

}
