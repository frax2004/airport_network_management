import static com.raylib.Raylib.*;

private Network network;
private Network msf;

public void main(String[] args) {
  if(args.length < 1) {
    System.err.println("No input file.");
    return;
  }
  
  this.network = Network.loadFromFile(args[0]).get();
  this.msf = network.computeMinimumSpanningForest();

  rl.show(
    () -> {},
    (w, h) -> {},
    (w, h) -> {
      final int a = (int)Math.round(.05*Math.min(w, h));
      final var rec1 = rl.rect(a, a, w/2 - 2*a, h - 2*a);
      final var rec2 = rl.rect(a + w/2, a, w/2 - 2*a, h - 2*a);
      ClearBackground(rl.hex2rgb(0x111111ff));
      
      DrawRectangleLinesEx(rec1, 4, rl.hex2rgb(0xffffffff));
      this.network.draw(rec1);
    
      DrawRectangleLinesEx(rec2, 4, rl.hex2rgb(0xffffffff));
      this.msf.draw(rec2);
    }
  );
}
