import java.util.Collection;

public class Network {
  public Network(Collection<Airport> airports, Collection<Route> routes) {
    airports.stream().map(Airport::toJSONString).forEach(System.out::println);
    routes.stream().map(Route::toJSONString).forEach(System.out::println);
  }
}
