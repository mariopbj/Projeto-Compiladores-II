parser grammar MiniLangParser;

options {
    tokenVocab=MiniLangLexer;
}

prog: PROGRAM ID PVIG decls cmdComp PONTO EOF;

decls: (VAR listDecl)?;
listDecl: declTip+;
declTip: listId DPONTOS tip PVIG;
listId: ID (VIG ID)*;
tip: INTEGER | BOOLEAN | STRING;

cmdComp: BEGIN listCmd END;
listCmd: cmd (PVIG cmd)*;
cmd: cmdIf | cmdWhile | cmdRead | cmdWrite | cmdAtrib | cmdComp;

cmdIf: IF ABPAR expr FPAR THEN bloco | IF ABPAR expr FPAR THEN bloco ELSE bloco;

cmdWhile: WHILE ABPAR expr FPAR DO bloco;

bloco: ABCHA listCmd FCHA;

cmdRead: READ ABPAR listId FPAR;

cmdWrite: WRITE ABPAR listW FPAR;
listW: elemW (VIG elemW)*;
elemW: expr | CADEIA;

cmdAtrib: ID ATRIB expr;

expr: exprRel | expr OPLOG exprRel;
exprRel: exprAd | exprAd OPREL exprAd;
exprAd: exprMult | exprAd OPAD exprMult;
exprMult: fator | exprMult OPMULT fator;
fator: ID | CTE | TRUE | FALSE | ABPAR expr FPAR | OPNEG fator;