import static com.raylib.Raylib.*;

public final record Airport(String id, double x, double y, double z) {
  @Override
  public final String toString() {
    return "%s at (%s, %s, %s)".formatted(this.id, this.x, this.y, this.y);
  }
  
  public void draw(Vector2 position, float radius, Color color) {
    DrawCircleV(position, radius, color);
  }

  public final String toJSONString() {
    return "{\"id\": \"%s\", \"coords\": [%s, %s, %s]}".formatted(
      this.id, 
      this.x, 
      this.y, 
      this.z
    );
  }
}
  