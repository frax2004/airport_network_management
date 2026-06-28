public record Edge(int from, int to, double cost) {
  public final String toJSONString() {
    return "{\"from\": %s, \"to\": %s, \"cost\": %s}".formatted(this.from, this.to, this.cost);
  }
}