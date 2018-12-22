package model.hasA.mtm;

import java.util.Set;

public class Movies {

    private int movieId;
    private String movieName;
    private Set<Actor> actorSet;

    public Movies() {
    }

    public Movies(String movieName) {
        this.movieName = movieName;
    }

    public Movies(int movieId, String movieName, Set<Actor> actorSet) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.actorSet = actorSet;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Set<Actor> getActorSet() {
        return actorSet;
    }

    public void setActorSet(Set<Actor> actorSet) {
        this.actorSet = actorSet;
    }
}

