parser grammar NetParser;

options {
  tokenVocab = NetScanner; 
  language = Java;
}

network: airportStatement+ routeStatement+;

airportStatement: DECLARE AIRPORT IDENTIFIER AT LEFT_PAREN NUMBER COMMA NUMBER COMMA NUMBER RIGHT_PAREN SEMI;

