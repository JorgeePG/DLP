grammar Grammar;

import Tokenizer;

@header {
	    import ast.statement.*;
	    import ast.expr.*;
	    import ast.tipo.*;
	    import ast.cuerpoprograma.*;
	    import ast.*;
}

program returns[Program ast]
	: cuerpo_programas+=cuerpo_programa*  { $ast = new Program($cuerpo_programas); }
	;
	
cuerpo_programa returns [CuerpoPrograma ast]
	:'struct'  IDENT '{' declaraciones  funciones '}' 	{ $ast = new StructDefinition($IDENT , $declaraciones.ast, $funciones.ast); }
	| funcion 											{ $ast = $funcion.ast; }
	| 'var' declaracion 								{ $ast = new VarDefinition($declaracion.ast); }
	;
declaraciones returns [List<VarDefinition> ast = new ArrayList<VarDefinition>()]
	:(declaracion{$ast.add(new VarDefinition($declaracion.ast));})* 
	;
funciones returns [List<Function> ast = new ArrayList<Function>()]
	: (funcion{$ast.add($funcion.ast);})*
	;
	
statement returns [Statement ast]
 locals [Expr ex=null , List<Statement> st=null;]
	:'var' declaracion 																{ $ast = new StmtVarDefinition($declaracion.ast); }
	|'print' ceromuchasexpr ';' 													{ $ast = new Print($ceromuchasexpr.ast); }
	|'printsp' ceromuchasexpr ';' 													{ $ast = new PrintSp($ceromuchasexpr.ast); }
	|'println' ceromuchasexpr ';'													{ $ast = new PrintLn($ceromuchasexpr.ast); }
	| ex1=expr '=' ex2=expr ';' 													{ $ast = new Asignacion($ex1.ast, $ex2.ast); }
	| 'return'(expr{$ex=$expr.ast;})? ';'											{ $ast = new Return($ex); }
	| expr ';'																		{ $ast = new OneExpr($expr.ast); }
	|'if' '('expr')' '{'statements'}' ('else' '{'st2=statements{$st=$st2.ast;}'}')?	{ $ast = new If($expr.ast, $statements.ast, $st); }
	|'while' '('expr')' '{'statements'}' 											{ $ast = new While($expr.ast, $statements.ast); }
	|'read' expr ';' 																{ $ast = new Read($expr.ast); }
	;
ceromuchasexpr returns [List<Expr> ast = new ArrayList<Expr>()]
	: (ex1=expr{$ast.add($ex1.ast);}(','ex2=expr{$ast.add($ex2.ast);})*)?
	;
statements returns[List<Statement> ast = new ArrayList<Statement>()]
	: (statement{$ast.add($statement.ast);})*
	;

expr returns[Expr ast]
	: ex1=expr '.' IDENT 							{ $ast = new FieldAccess($ex1.ast, $IDENT ); }
	|ex1=expr '['ex2=expr']' 						{ $ast = new ArrayAccess($ex1.ast, $ex2.ast); }
	| '<'tipo'>''('expr')'							{ $ast = new Cast($tipo.ast, $expr.ast); }
	| '!' expr 										{ $ast = new Not($expr.ast); }
	| ex1=expr op=('*'|'/') ex2=expr 				{ $ast = new OperacionAritmetica($ex1.ast, $op, $ex2.ast); }
	| ex1=expr op=('+'|'-') ex2=expr 				{ $ast = new OperacionAritmetica($ex1.ast, $op, $ex2.ast); }
	|ex1=expr op=('<'|'>') ex2=expr 				{ $ast = new Comparacion($ex1.ast, $op, $ex2.ast); }
	| ex1=expr op=('=='|'<='|'>=' |'!=') ex2=expr  	{ $ast = new Comparacion($ex1.ast, $op, $ex2.ast); } 
	| ex1=expr op='&&' ex2=expr 					{ $ast = new OperacionLogica($ex1.ast, $op, $ex2.ast); }
	| ex1=expr op='||' ex2=expr 					{ $ast = new OperacionLogica($ex1.ast, $op, $ex2.ast); }
	| IDENT '(' ceromuchasexpr')' 					{ $ast = new FunctionCall($IDENT , $ceromuchasexpr.ast); }
	| '('expr')' 									{ $ast = new Parentesis($expr.ast); }
	| INT_LITERAL									{ $ast = new IntLiteral($INT_LITERAL); } 
	| REAL_LITERAL									{ $ast = new RealLiteral($REAL_LITERAL); } 
	| IDENT											{ $ast = new Variable($IDENT); } 
	| CHAR_LITERAL									{ $ast = new CharLiteral($CHAR_LITERAL);}
	;
	
declaracion returns [Declaracion ast]
	: IDENT ':' tipo ';' 							{ $ast = new Declaracion($IDENT , $tipo.ast); }
	;

funcion returns [Function ast] locals [Tipo tipoAux= new VoidType();]
	: IDENT'('parametros')'(':'tipo{$tipoAux=$tipo.ast;})?'{'statements '}'{ $ast = new Function($IDENT ,$parametros.ast,$tipoAux,$statements.ast); }											
	;
	
parametros returns [List <Declaracion> ast= new ArrayList<Declaracion>()]
	:(IDENT ':' tipo {$ast.add(new Declaracion($IDENT ,$tipo.ast));}(','id2=IDENT ':' t2=tipo {$ast.add(new Declaracion($id2 ,$t2.ast));})*)?
	;
tipo returns [Tipo ast]
	: 'int' 										{ $ast = new IntType(); }
	| 'float' 										{ $ast = new FloatType(); }
	| 'char' 										{ $ast = new CharType(); }
	| 'void' 										{ $ast = new VoidType(); }
	| ('['expr']')+ tipo 							{ $ast = new ArrayType( $tipo.ast,$expr.ast); }
	| IDENT 										{ $ast = new NomType($IDENT ); }
	;