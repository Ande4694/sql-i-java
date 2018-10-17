package jdbc.mysql.mvc.demo.controllers;

import jdbc.mysql.mvc.demo.models.Movie;
import jdbc.mysql.mvc.demo.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class MovieController {

    @Autowired
    MovieRepo movieRepo;

    @GetMapping("/")
    public String index(Model model) {
        List<Movie> movies = movieRepo.getMovies();
        model.addAttribute("movies", movies);

        return "index";
    }

}
