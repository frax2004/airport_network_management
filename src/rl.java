import static com.raylib.Raylib.*;

import java.util.function.BiConsumer;

import com.raylib.Raylib.Rectangle;


public interface rl {
  static void show(
    Runnable init, 
    BiConsumer<Integer, Integer> update, 
    BiConsumer<Integer, Integer> render
  ) {
    int WIDTH = 1200;
    int HEIGHT = 800;
    
    SetConfigFlags(FLAG_WINDOW_RESIZABLE);
    InitWindow(WIDTH, HEIGHT, "Prim's Minimum Spanning Tree (Eager Version)");
    SetTargetFPS(60);
  
    init.run();

    while(!WindowShouldClose()) {
      WIDTH = GetRenderWidth();
      HEIGHT = GetRenderHeight();
      update.accept(WIDTH, HEIGHT);
      
      BeginDrawing();
      render.accept(WIDTH, HEIGHT);
      EndDrawing();
    }

    CloseWindow();
  }

  static Rectangle rect(float x, float y, float w, float h) {
    Rectangle rec = new Rectangle();
    rec.x(x);
    rec.y(y);
    rec.width(w);
    rec.height(h);
    return rec;
  }

  static Vector2 vec2(float x, float y) {
    Vector2 vec = new Vector2();
    vec.x(x);
    vec.y(y);
    return vec;
  }

  static Color hex2rgb(int color) {
    return GetColor(color);
  }

  static Color rgblerp(Color from, Color to, float alpha) {
    return ColorLerp(from, to, alpha);
  }
}
