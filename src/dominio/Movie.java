package dominio;

import java.util.Objects;

public class Movie {
  private String name;

  public Movie(){}

  public Movie(String name){
    if(name == "") {
      throw new RuntimeException("Lo siento el valor de name no puede ser null");
    }
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Movie movie = (Movie) o;
    return Objects.equals(name, movie.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return name ;
  }
}
