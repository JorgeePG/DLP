// Generated with VGen 2.0.0

grammar Grammar;

@header {
	    import ast.statement.*;
	    import ast.expr.*;
	    import ast.tipo.*;
	    import ast.cuerpoprograma.*;
	    import ast.*;
}

program returns[Program ast]
    : cuerpoProgramas+=cuerpoPrograma*    { $ast = new Program($cuerpoProgramas); }              
	;

cuerpoPrograma returns[CuerpoPrograma ast]
    : nombre=IDENT atributos+=varDefinition* metodos+=function* { $ast = new StructDefinition($nombre, $atributos, $metodos); }
    | declaracion                         { $ast = new VarDefinition($declaracion.ast); }        
    | nombre=IDENT parametros+=declaracion* variables+=varDefinition* tipo cuerpo+=statement* { $ast = new Function($nombre, $parametros, $variables, $tipo.ast, $cuerpo); }
	;

varDefinition returns[VarDefinition ast]
    : declaracion                         { $ast = new VarDefinition($declaracion.ast); }        
	;

declaracion returns[Declaracion ast]
    : nombre=IDENT tipo                   { $ast = new Declaracion($nombre, $tipo.ast); }        
	;

tipo returns[Tipo ast]
    :                                     { $ast = new IntType(); }                              
    |                                     { $ast = new FloatType(); }                            
    |                                     { $ast = new CharType(); }                             
    |                                     { $ast = new VoidType(); }                             
    | tipo INT_LITERAL                    { $ast = new ArrayType($tipo.ast, $INT_LITERAL); }     
    | nombre=IDENT                        { $ast = new NomType($nombre); }                       
	;

function returns[Function ast]
    : nombre=IDENT parametros+=declaracion* variables+=varDefinition* tipo cuerpo+=statement* { $ast = new Function($nombre, $parametros, $variables, $tipo.ast, $cuerpo); }
	;

statement returns[Statement ast]
    : exprs+=expr*                        { $ast = new Print($exprs); }                          
    | exprs+=expr*                        { $ast = new PrintSp($exprs); }                        
    | exprs+=expr*                        { $ast = new PrintLn($exprs); }                        
    | left=expr right=expr                { $ast = new Asignacion($left.ast, $right.ast); }      
    | expr?                               { $ast = new Return(($expr.ctx == null) ? null : $expr.ast); }
    | expr                                { $ast = new OneExpr($expr.ast); }                     
    | expr thenBlock+=statement* elseBlock+=statement* { $ast = new If($expr.ast, $thenBlock, $elseBlock); }  
    | expr body+=statement*               { $ast = new While($expr.ast, $body); }                
    | expr                                { $ast = new Read($expr.ast); }                        
    | nombre=IDENT exprs+=expr*           { $ast = new StmtFunctionCall($nombre, $exprs); }      
	;

expr returns[Expr ast]
    : expr field=IDENT                    { $ast = new FieldAccess($expr.ast, $field); }         
    | array=expr index=expr               { $ast = new ArrayAccess($array.ast, $index.ast); }    
    | tipo expr                           { $ast = new Cast($tipo.ast, $expr.ast); }             
    | expr                                { $ast = new Not($expr.ast); }                         
    | left=expr operador=IDENT right=expr { $ast = new OperacionAritmetica($left.ast, $operador, $right.ast); }
    | left=expr operador=IDENT right=expr { $ast = new OperacionLogica($left.ast, $operador, $right.ast); }
    | left=expr operador=IDENT right=expr { $ast = new Comparacion($left.ast, $operador, $right.ast); }
    | nombre=IDENT exprs+=expr*           { $ast = new FunctionCall($nombre, $exprs); }          
    | expr                                { $ast = new Parentesis($expr.ast); }                  
    | nombre=IDENT                        { $ast = new Variable($nombre); }                      
    | INT_LITERAL                         { $ast = new IntLiteral($INT_LITERAL); }               
    | FLOAT_LITERAL                       { $ast = new RealLiteral($FLOAT_LITERAL); }            
    | name=IDENT                          { $ast = new CharLiteral($name); }                     
	;


// ---------------------------------------------------------------
// Tokens

IDENT: [a-zA-Z_][a-zA-Z0-9_]*;
FLOAT_LITERAL: [0-9]+ '.' [0-9]+;
INT_LITERAL: [0-9]+;
