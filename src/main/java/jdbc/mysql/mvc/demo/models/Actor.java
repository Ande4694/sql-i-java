package jdbc.mysql.mvc.demo.models;

public class Actor {
    private int idactors;
    private String name;

    public Actor() {}

    public Actor(int idactors, String name) {
        this.idactors = idactors;
        this.name = name;
    }

    public int getIdactors() {
        return idactors;
    }

    public void setIdactors(int idactors) {
        this.idactors = idactors;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


}
