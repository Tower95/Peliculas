package services;

import dominio.Movie;

import java.util.ArrayList;
import java.util.List;

public class ServiceMoviesList implements IserviceMovies{

  private final List<Movie> movies;

  public ServiceMoviesList () {
    this.movies = new ArrayList<>();
  }


  @Override
  public void listMoives() {
    if(movies.size() <= 0){
      System.out.println("La lista esta vacia");
    } else {
      System.out.println("Listado de peliculas...");
      movies.forEach(System.out::println);
    }
  }

  @Override
  public void addMovie(Movie movie) {
    movies.add(movie);
  }

  @Override
  public void searchMovie(Movie movie) {

    var index = movies.indexOf(movie);

    if(index == -1){
      System.out.println("No se encontro "+ movie.getName()+" en la lista");
    } else {
      System.out.println("Pelicula " + movie.getName() + " encontrada en el index: " + index);
    }
  }

  public static void main(String[] args) {
   var pelicula = new Movie("Batman");
   var pelicula2 = new Movie("Superman");

   // dising pathern SERVICE
   IserviceMovies peliculas = new ServiceMoviesList();

   peliculas.addMovie(pelicula2);
   peliculas.addMovie(pelicula);

   peliculas.listMoives();

   peliculas.searchMovie(new Movie("Iron man"));
  }
}
