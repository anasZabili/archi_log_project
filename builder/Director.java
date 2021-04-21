package builder;

public class Director {
  private Builder builder;

  public Director(Builder builder) {
    this.builder = builder;
  }

  public void construct(String filename) {
    try {
      XMLShapeLoader.load(filename, builder);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
