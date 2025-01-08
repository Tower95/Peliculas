package services;
import dominio.Movie;
import java.io.*;

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
        System.out.println("Sfilee ha creado el archivo");
      }
    } catch (Throwable e){
      System.out.println("Ocurrio un error al abrir el archivo " + e.getMessage());
    }
  }


  @Override
  public void listMoives() {
    //Open  the file again
    var file = new File(FILE_NAME);
    try{

      System.out.println("Listado de Peliculas");

      // Open file to read it
      var entrance = new BufferedReader(new FileReader(file));

      // read line to line
      String line;
      line = entrance.readLine();

      // reasd all the lines
      while(line != null){

        var movie = new Movie(line);
        System.out.println(movie);
        // Before of end the loop read again the next line
        line = entrance.readLine();

      }

      entrance.close();
    } catch (Exception Error){
      System.out.println("Ocurrio un error al leer el archivo: ");
      System.out.print(Error.getMessage());
    }
  }

  @Override
  public void addMovie(Movie movie) {

    boolean append = false;
    var file = new File(FILE_NAME);

    try{

      // check if file already exist
      append = file.exists();

      var output = new PrintWriter(new FileWriter(file, append));

      // Adding the movie (toString)
      output.println(movie);

      // close the file
      output.close();

      System.out.println("Se agrego al archivo: " + movie.getName());
    } catch (Exception e) {

      System.out.println("Occurrio un error al agregar una pelicula:\n"+e.getMessage());

    }
  }

  @Override
  public void searchMovie(Movie movie) {

    var file = new File(FILE_NAME);

    try{
      // Open the file for reading line by line
      var input = new BufferedReader(new FileReader(file));
      String textLine = input.readLine();

      var index = 1;
      var finded = false;
      var movieSearch = movie.getName();

      while(textLine != null){
        // We search regardless of upper or lower case
        if(movieSearch != null && movieSearch.equalsIgnoreCase(textLine)){
          finded = true;
          break;
        }
        //read the next line before next cicle
        textLine = input.readLine();
        index++;
      }// End while loop

      // Print resluts of search.
      if(finded) {
        System.out.println("Pelicula " + textLine + " encontrada - linea " + index);
      } else {
        System.out.println("No se encontro la pelicula: " + movieSearch);
      }

      input.close();

    } catch (Exception e) {
      System.out.println("Ocurrio un error al buscar en el archivo: " + e.getMessage());
    }

  }
}
