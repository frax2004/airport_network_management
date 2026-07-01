package collections;


public final class UndirectedWeightedEdge implements Comparable<UndirectedWeightedEdge> {
  private final int u, v;
  private final double weight;

  public UndirectedWeightedEdge(int u, int v, double weight) {
    this.u = u;
    this.v = v;
    this.weight = weight;
  }

  public String toJSONString() {
    return "{\"from\": %s, \"to\": %s, \"cost\": %s}".formatted(
      this.u, 
      this.v, 
      this.weight
    );
  }

  public double weight() {
    return this.weight;
  }

  public int either() {
    return u;
  }

  public int other(int o) {
    return o == this.v ? this.u : this.v;
  }

  @Override
  public final boolean equals(Object o) {
    if(o == null || !(o instanceof UndirectedWeightedEdge)) return false;
    UndirectedWeightedEdge other = (UndirectedWeightedEdge)o;

    return this.weight == other.weight
    && (
      (this.either() == other.either() && this.other(this.either()) == other.other(other.either()))
      || (this.either() == other.other(other.either()) && this.other(this.either()) == other.either())
    );
  }

  @Override
  public int compareTo(UndirectedWeightedEdge o) {
    if(this.equals(o)) return 0;
    else return Double.compare(this.weight, o.weight);
  }
}