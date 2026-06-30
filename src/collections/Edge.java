package collections;


public final record Edge(int from, int to, double weight) implements Comparable<Edge> {
  public String toJSONString() {
    return "{\"from\": %s, \"to\": %s, \"cost\": %s}".formatted(
      this.from, 
      this.to, 
      this.weight
    );
  }

  @Override
  public final boolean equals(Object o) {
    if(o == null || !(o instanceof Edge)) return false;
    Edge other = (Edge)o;

    return this.weight == other.weight
    && this.from == other.from
    && this.to == other.to;
  }

  @Override
  public int compareTo(Edge o) {
    if(this.equals(o)) return 0;
    else return Double.compare(this.weight, o.weight);
  }
}