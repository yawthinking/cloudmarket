package com.yawthinking.core.service;

import com.yawthinking.core.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private ActorMapper actorMapper;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Transactional
    public void create(Movie movie) {
        movieMapper.save(movie);

        List<Position> positions = movie.getPositions();
        positions.forEach( position -> {
            Actor actor = position.getActor();
            Optional<Actor> maybeActor = actorMapper.findById(actor.getId());
            if (maybeActor.isEmpty()) {
                actorMapper.save(actor);
            }
            Optional<Position> maybePosition = positionMapper.findById(actor.getId(), movie.getId());
            if (maybePosition.isEmpty()) {
                positionMapper.save(position);
            }
        });
    }

    @Transactional(readOnly = true)
    public Optional<Movie> findById(long id) {
        return movieMapper.findById(id);
    }

}
