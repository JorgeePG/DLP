grammar Grammar;

import Tokenizer;

program
	: (cuerpo_programa)* EOF
	;

cuerpo_programa
	:'struct'  IDENT '{' cuerpo_struct* '}'
	| funcion
	| 'var' declaracion
	;


statement
	:'var' declaracion
	|'print' (expr(','expr)*)? ';'
	|'printsp' (expr(','expr)*)? ';'
	|'println' (expr(','expr)*)? ';'
	| expr '=' expr ';'
	| 'return' expr? ';'
	| expr ';'
	|'if' '('expr')' '{'statement*'}' ('else' '{'statement*'}')*
	|'while' '('expr')' '{'statement*'}'
	|'read' expr ';'
	;

expr
	: expr '.' expr 
	|expr '['expr']' 
	| '('expr')'
	| '<'tipo'>''('expr')'
	| '!' expr
	| expr ('*'|'/') expr
	| expr ('+'|'-') expr
	| expr ('<'|'>') expr
	| expr ('=='|'<='|'>=') expr
	| expr '&&' expr
	| expr '||' expr
	| IDENT '(' (expr(','expr)*)?')'
	| INT_LITERAL | REAL_LITERAL | IDENT | array | CHAR_LITERAL
	;
	
declaracion
	: IDENT ':' tipo ';'
	| IDENT ':' IDENT ';'
	| IDENT ':' array ';'
	;

array
	: ('['expr']')+ (tipo|IDENT)  
	;
	
cuerpo_struct
	: declaracion 
	| funcion
	;

funcion
	: IDENT'('(IDENT ':' tipo(','IDENT ':' tipo)*)?')'(':'tipo)?'{'statement* '}'
	;
	
tipo
	: 'int'
	| 'float'
	| 'char'
	;