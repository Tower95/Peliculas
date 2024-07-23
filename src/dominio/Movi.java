package dominio;

import java.util.Objects;

public class Movi {
  private String name;

  public Movi(){}

  public Movi(String name){
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

    Movi movi = (Movi) o;
    return Objects.equals(name, movi.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "Movi{" +
            "name='" + name + '\'' +
            '}';
  }
}
