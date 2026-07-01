parser grammar NetParser;

options {
  tokenVocab = NetScanner; 
  language = Java;
}

network: airportStatement+ routeStatement+;
airportStatement: DECLARE AIRPORT airport_id = IDENTIFIER AT LEFT_PAREN x = NUMBER COMMA y = NUMBER COMMA z = NUMBER RIGHT_PAREN SEMI;
routeStatement: DECLARE ROUTE FROM src_id = IDENTIFIER TO dst_id = IDENTIFIER COST cost = NUMBER SEMI;

