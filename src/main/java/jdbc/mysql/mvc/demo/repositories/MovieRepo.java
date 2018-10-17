package jdbc.mysql.mvc.demo.repositories;

import jdbc.mysql.mvc.demo.models.Movie;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface MovieRepo {

    List<Movie> getMovies() throws SQLException;
    Movie createMovie(Movie movie);
    void updateMovie(Movie movie);
    void deleteMovie(int id);
    Movie displayMovie(int id);
    List<Movie> searchMovie(String title);
    List<Movie> searchMovie(int productionYear);


}
