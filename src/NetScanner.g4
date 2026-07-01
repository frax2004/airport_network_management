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
AIRPORT: 'airport';
AT: 'at';
COST: 'cost';

// Literals
NUMBER: '-'? ('0' | [1-9][0-9]*) ('.' [0-9]+)?;

// Symbols
LEFT_PAREN: '(';
RIGHT_PAREN: ')';
SEMI: ';';
COMMA: ',';

// Identifier
IDENTIFIER: [A-Z][A-Z][A-Z] '-' [0-9][0-9][0-9];