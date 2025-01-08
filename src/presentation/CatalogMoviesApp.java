package presentation;

import dominio.Movie;
import services.IserviceMovies;
import services.ServiceMoviesFiles;

import java.util.Scanner;

public class CatalogMoviesApp {

  public static void main(String[] args) {
    var salir = false;
    var consola = new Scanner(System.in);

    // service implementation
    IserviceMovies ServiceMovice = new ServiceMoviesFiles();
    while (!salir){
      try {
        showMenu();
        salir = executeOptinons(consola, ServiceMovice);
      } catch (Exception e){
        System.out.println("Ocuerrio un error: "+e.getMessage());
      }
      System.out.println();
    } // end while

  }

  public static void showMenu(){
    System.out.print("""
            *** Catalogo de Peliculas ***
            1.- Agregar Peliculla.
            2.- Listar Peliculas.
            3.- Buscar Pelicula.
            4.- Salir.
            Elije una opcion : 
            """);
  }

  public static void waitImput(Scanner consola){
    System.out.println("Precione Enter para continuar!");
    consola.nextLine();
  }

  private static boolean executeOptinons(Scanner consola, IserviceMovies movies){
    var opcion = Integer.parseInt(consola.nextLine());
    var salir = false;
    switch (opcion){
      case 1 :
        System.out.println("Ingrese el nombre de la pelicula: ");
        movies.addMovie(new Movie(consola.nextLine()));
        salir = false;
        String texto = "hola acontinuacion pasare a describir los paso necesrios que tenemos que realizar";
        break;
      case 2 :
        movies.listMoives();
        waitImput(consola);
        salir = false;
        break;
      case 3:
        System.out.println("Porfavor ingrese el nombre de la pelicula que quiere buscar");
        movies.searchMovie(new Movie(consola.nextLine()));
        waitImput(consola);
        salir = false;
        break;
      case 4 :
        System.out.println("Gracias Adios...");
        salir = true;
        break;
      default:
        System.out.println("Lo siento" + opcion +" No es una opcion valida");
        break;
    }
    return salir;
  }
}