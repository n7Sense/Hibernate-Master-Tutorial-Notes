package model.hasA.mtm;
import java.util.Set;

public class Actor {

    private int actorId;
    private String actorName;
    private Set<Movies> moviesSet;

    public Actor() {
    }

    public Actor(String actorName) {
        this.actorName = actorName;
    }

    public Actor(int actorId, String actorName, Set<Movies> moviesSet) {
        this.actorId = actorId;
        this.actorName = actorName;
        this.moviesSet = moviesSet;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Set<Movies> getMoviesSet() {
        return moviesSet;
    }

    public void setMoviesSet(Set<Movies> moviesSet) {
        this.moviesSet = moviesSet;
    }
}
