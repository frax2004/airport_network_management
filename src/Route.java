import java.util.Arrays;

public record Route(Airport src, Airport dst, String[] territories, double cost) {
  @Override
  public final String toString() {
    return "%s => %s :: %s / %s".formatted(this.src.id(), this.dst.id(), Arrays.toString(territories), cost);
  }

  public double distance() {
    return Math.sqrt(
      Math.pow(this.src.x() - this.dst.x(), 2)
      + Math.pow(this.src.y() - this.dst.y(), 2)
      + Math.pow(this.src.z() - this.dst.z(), 2)
    );
  }

  public final String toJSONString() {
    return "{\"from\": \"%s\", \"to\": \"%s\", \"cost\": %s, \"territories\": %s}".formatted(
      this.src.id(),
      this.dst.id(),
      this.cost,
      Arrays.stream(this.territories)
      .map(s -> "\"%s\"".formatted(s))
      .toList()
      .toString()
    );
  }
}
