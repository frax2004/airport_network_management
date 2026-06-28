parser grammar NetParser;

options {
  tokenVocab = NetScanner; 
  language = Java;
}

network: airportStatement+ routeStatement+;

airportStatement: DECLARE AIRPORT airport_id = IDENTIFIER AT LEFT_PAREN x = NUMBER COMMA y = NUMBER COMMA z = NUMBER RIGHT_PAREN SEMI;

routeStatement: DECLARE ROUTE FROM src_id = IDENTIFIER TO dst_id = IDENTIFIER THROUGH LEFT_SQUARE territories += territory (COMMA territories += territory)*? RIGHT_SQUARE COST cost = NUMBER SEMI;

territory: MOUNTAIN
  | PLAIN
  | SEA
  | RIVER
  | DESERT
  ;
