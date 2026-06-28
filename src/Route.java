import java.util.Arrays;

public record Route(Airport src, Airport dst, String[] territories, double cost) {
  @Override
  public final String toString() {
    return "%s => %s :: %s / %s".formatted(this.src.id(), this.dst.id(), Arrays.toString(territories), cost);
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
