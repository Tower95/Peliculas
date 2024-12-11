package services;

import dominio.Movi;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServiceMoviesFiles implements IserviceMovies{

  private final String FILE_NAME = "Movies.txt";

  public ServiceMoviesFiles(){
    var file = new File(FILE_NAME);

    try {

      // if the file alredy exist it wouldn't be created again
      if(file.exists()){
        System.out.println("El archivo ya existe");
      }
      else {
        // if the file doesn't exist it will be created
        var output = new PrintWriter(new FileWriter(file));
        output.close();
        System.out.println("Se ha creado el archivo");
      }
    } catch (Throwable e){
      System.out.println("Ocurrio un error al abrir el archivo " + e.getMessage());
    }
  }


  @Override
  public void listMoives() {

  }

  @Override
  public void addMovi(Movi movi) {

  }

  @Override
  public void searchMovi(Movi movi) {

  }
}
