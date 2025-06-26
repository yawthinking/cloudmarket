package com.yawthinking.webapp.controller;

import com.yawthinking.core.domain.*;
import com.yawthinking.core.service.MovieService;
import com.yawthinking.core.support.Snowflake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class DefaultController {

    @Autowired
    private Snowflake snowflake;

    @Autowired
    private MovieService movieService;

    @RequestMapping(path = "/*", method = {RequestMethod.HEAD, RequestMethod.GET})
    @Transactional
    public String fallback(Model model) {
        long movieId = 593028741896040448L;

        Optional<Movie> maybeMovie = movieService.findById(movieId);
        if (maybeMovie.isEmpty()) {
            System.out.printf("movie id '%d' not existed %n", movieId);

            long actorId1 = snowflake.nextId();
            long actorId2 = snowflake.nextId();
            long actorId3 = snowflake.nextId();

            Actor keanu = new Actor(actorId1);
            keanu.setName("Keanu Reeves");
            keanu.setSex(1);
            keanu.setBorn(LocalDate.of(1964, 9, 6));

            Actor laurence = new Actor(actorId2);
            laurence.setName("Laurence Fishburne");
            laurence.setSex(1);
            laurence.setBorn(LocalDate.of(1961, 7, 30));

            Actor carrieanne = new Actor(actorId3);
            carrieanne.setName("Carrie-Anne Moss");
            carrieanne.setSex(0);
            carrieanne.setBorn(LocalDate.of(1967, 8, 21));

            Movie movie = new Movie(movieId);
            movie.setName("The Matrix");
            movie.setPhoto("https://upload.wikimedia.org/wikipedia/zh/c/c1/The_Matrix_Poster.jpg");
            movie.setCreateDate(LocalDate.of(1999, 3, 31));

            movie.addPosition(keanu, "Neo");
            movie.addPosition(laurence, "Morpheus");
            movie.addPosition(carrieanne, "Trinity");

            movieService.create(movie);
        } else {
            Movie movie = maybeMovie.get();
            System.out.printf("%s%n", movie);
            movie.getPositions().forEach(position -> {
                                    System.out.printf("\t name: '%s' %n", position.getName());
                                    System.out.printf("\t actor: '%s' %n", position.getActor());
                                    System.out.printf("\t movie: '%s' %n", position.getMovie().getName());
                                    System.out.println();
                                });

        }

        return "index";
    }

}
