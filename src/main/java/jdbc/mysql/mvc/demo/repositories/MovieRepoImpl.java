package jdbc.mysql.mvc.demo.repositories;

import jdbc.mysql.mvc.demo.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepoImpl implements MovieRepo {

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Movie> getMovies() throws SQLException {
        String sql = "SELECT * FROM movie;";

        Statement stmt = null;

       ResultSet rs = stmt.executeQuery(sql);

       List<Movie> gettedMovies = new ArrayList<>();

       while (rs.next()){
           int id = rs.getInt("movieid");
           String title = rs.getString("title");
           String production = rs.getString("production");
           String genre = rs.getString("genre");

           gettedMovies.add(new Movie(id, title, production, genre));
       }

        return gettedMovies;

    }

    @Override
    public Movie createMovie(Movie movie) {
        String sql = "INSERT INTO movies VALUES(default, ?, ?, ?);";
        this.template.update(sql, movie.getTitle(), movie.getProductionYear(), movie.getProductionYear());

        return movie;
    }

    @Override
    public void updateMovie(Movie movie) {
        String sql = "UPDATE movie set genre=?, title=?, production=? where idmovie=?;";
        this.template.update(sql, movie.getGenre(), movie.getTitle(), movie.getProductionYear(), movie.getIdmovies());

    }

    @Override
    public void deleteMovie(int id) {
        String sql ="DELETE FROM movie WHERE idmovie=?";
        this.template.update(sql, id);

    }

    //DUR IKKE
    @Override
    public Movie displayMovie(int id) {
        String sql="SELECT * FROM movie WHERE idmovie=?";

        RowMapper<Movie> rm = new BeanPropertyRowMapper<>(Movie.class);
        Movie movie = template.queryForObject(sql, rm, id);
        return movie;
    }

    @Override
    public List<Movie> searchMovie(String title) {
        String sql = "Select * from movie where title =?;";
        this.template.query(sql, title);

    }

    @Override
    public List<Movie> searchMovie(int productionYear) {
        return null;
    }

}
