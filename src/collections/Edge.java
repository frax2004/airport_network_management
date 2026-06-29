package collections;

public final record Edge(int from, int to, double weight) {
  public String toJSONString() {
    return "{\"from\": %s, \"to\": %s, \"cost\": %s}".formatted(
      this.from, 
      this.to, 
      this.weight
    );
  }
}