lexer grammar NetScanner;

// Ignored characters
INLINE_COMMENT: '//'(~[\r\n])* -> skip;
COMMENT: '/*'([.\n\r])*'*/' -> skip;
SPACE: [ \t\r\n] -> skip;

// Keywords
DECLARE: 'declare';
ROUTE: 'route';
FROM: 'from';
TO: 'to';
THROUGH: 'through';
AIRPORT: 'airport';
AT: 'at';
COST: 'cost';
MOUNTAIN: 'mountain';
PLAIN: 'plain';
SEA: 'sea';
RIVER: 'river';
DESERT: 'desert';

// Literals
NUMBER: ('0' | [1-9][0-9]*) ('.' [0-9]+)?;

// Symbols
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
LEFT_SQUARE: '[';
RIGHT_SQUARE: ']';
SEMI: ';';
COMMA: ',';

// Identifier
IDENTIFIER: [a-zA-Z_];