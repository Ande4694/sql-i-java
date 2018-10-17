package jdbc.mysql.mvc.demo.models;

import java.util.ArrayList;

public class Movie {
    private int idmovies;
    private String title;
    private String productionYear;
    private String genre;
    private ArrayList<Actor> actors = new ArrayList<>();

    public Movie() {}
    public Movie(String title, String productionYear) {
        this.title = title;
        this.productionYear = productionYear;
    }

    public Movie(int movieId, String title, String productionYear, String genre) {
        this.idmovies = movieId;
        this.title = title;
        this.productionYear = productionYear;
        this.genre = genre;
    }

    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getIdmovies() {
        return idmovies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }
}
