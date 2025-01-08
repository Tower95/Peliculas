package services;

import dominio.Movie;

public interface IserviceMovies{
  public void listMoives();

  public void addMovie(Movie movie);

  public void searchMovie(Movie movie);
 }
