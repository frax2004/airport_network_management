import java.util.Arrays;

public final record Route(Airport src, Airport dst, String[] territories, double cost) {
  @Override
  public final String toString() {
    return "%s => %s :: %s / %s".formatted(
      this.src.id(), 
      this.dst.id(), 
      Arrays.toString(territories), 
      cost
    );
  }

  public double distance() {
    double x = this.src.x() - this.dst.x();
    double y = this.src.y() - this.dst.y();
    double z = this.src.z() - this.dst.z();
    return Math.sqrt(x*x + y*y + z*z);
  }

  public final String toJSONString() {
    return "{\"from\": \"%s\", \"to\": \"%s\", \"weight\": %s, \"territories\": %s}".formatted(
      this.src.id(),
      this.dst.id(),
      this.cost,
      Arrays
      .stream(this.territories)
      .map(s -> "\"%s\"".formatted(s))
      .toList()
      .toString()
    );
  }
}
