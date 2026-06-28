import java.util.stream.Stream;

public record Airport(String id, double x, double y, double z) {
  @Override
  public final String toString() {
    return "%s at (%s, %s, %s)".formatted(this.id, this.x, this.y, this.y);
  }
  
  public final String toJSONString() {
    return "{\"id\": \"%s\", \"coords\": %s}".formatted(
      this.id, 
      Stream.of(
        this.x, 
        this.y, 
        this.z
      )
      .toList()
      .toString()
    );
  }
}
  
