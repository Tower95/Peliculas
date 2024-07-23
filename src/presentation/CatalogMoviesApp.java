package presentation;

import dominio.Movi;
import services.IserviceMovies;
import services.ServiceMoviesList;

import java.util.Scanner;

public class CatalogMoviesApp {

  public static void main(String[] args) {
    var salir = false;
    var consola = new Scanner(System.in);

    // service implementation
    IserviceMovies ServiceMovice = new ServiceMoviesList();
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
        movies.addMovi(new Movi(consola.nextLine()));
        salir = false;
        break;
      case 2 :
        movies.listMoives();
        waitImput(consola);
        salir = false;
        break;
      case 3:
        System.out.println("Porfavor ingrese el nombre de la pelicula que quiere buscar");
        movies.searchMovi(new Movi(consola.nextLine()));
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