lexer grammar Tokenizer;

INT_LITERAL
	: [0-9]+
	;
REAL_LITERAL
	: [0-9]+'.'[0-9]+
	;
CHAR_LITERAL
	: '\''~[\n\r]'\''
	| '\'\\n\''
	;
	
IDENT
	: [a-zA-Z_][a-zA-Z0-9_]*
	;

LINE_COMMENT
	: '//' .*? ('\n' | EOF) -> skip
	;

MULTILINE_COMMENT
	: '/*' .*? '*/' -> skip
	;

WHITESPACE
	: [ \t\r\n]+ -> skip
	;
