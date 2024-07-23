package services;

import dominio.Movi;

import java.util.ArrayList;
import java.util.List;

public class ServiceMoviesList implements IserviceMovies{

  private final List<Movi> movies;

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
  public void addMovi(Movi movi) {
    movies.add(movi);
  }

  @Override
  public void searchMovi(Movi movi) {

    var index = movies.indexOf(movi);

    if(index == -1){
      System.out.println("No se encontro "+movi.getName()+" en la lista");
    } else {
      System.out.println("Pelicula " + movi.getName() + " encontrada en el index: " + index);
    }
  }

  public static void main(String[] args) {
   var pelicula = new Movi("Batman");
   var pelicula2 = new Movi("Superman");

   // dising pathern SERVICE
   IserviceMovies peliculas = new ServiceMoviesList();

   peliculas.addMovi(pelicula2);
   peliculas.addMovi(pelicula);

   peliculas.listMoives();

   peliculas.searchMovi(new Movi("Iron man"));
  }
}
