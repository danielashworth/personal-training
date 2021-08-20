package uk.co.danielashworth.springcache;

class Car {

  private final int id;

  private final String name;

  Car(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
