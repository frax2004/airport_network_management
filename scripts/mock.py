import json as JSON
import random

class Airport:
  def __init__(self, airport):
    self.icao = airport["icao"]
    self.iata = airport["iata"]
    self.name = airport["name"]
    self.city = airport["city"]
    self.state = airport["state"]
    self.country = airport["country"]
    self.elevation = airport["elevation"]
    self.lat = airport["lat"]
    self.lon = airport["lon"]
    self.tz = airport["tz"]

with open('airports.json', 'r') as f:
  AIRPORTS = map(Airport, JSON.load(f).values())
  AIRPORTS = filter(lambda a: a.iata != '', AIRPORTS)
  AIRPORTS = [*AIRPORTS]


airports = random.choices(AIRPORTS, k = int(round(.05 * len(AIRPORTS))))

declarations = [
  f"declare airport {airport.iata}-000 at ({airport.lat}, {airport.elevation}, {airport.lon});\n" 
  for airport in airports
]

routes = [
  f"declare route from {random.choice(airports).iata}-000 to {random.choice(airports).iata}-000 through [mountain] cost {random.random()*1000};\n"
  for _ in range(10, random.randint(15, 50))
]

with open("input.net", "w") as f:
  f.writelines(declarations)
  f.writelines(routes)
