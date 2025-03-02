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
	: expr '.' IDENT 
	|expr '['expr']' 
	| '<'tipo'>''('expr')'
	| '!' expr
	| expr ('*'|'/') expr
	| expr ('+'|'-') expr
	| expr ('<'|'>') expr
	| expr ('=='|'<='|'>=' |'!=') expr
	| expr '&&' expr
	| expr '||' expr
	| IDENT '(' (expr(','expr)*)?')'
	| '('expr')'
	| INT_LITERAL | REAL_LITERAL | IDENT | CHAR_LITERAL
	;
	
declaracion
	: IDENT ':' tipo ';'
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
	| ('['expr']')+ (tipo|IDENT) 
	| IDENT
	;