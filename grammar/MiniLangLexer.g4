lexer grammar MiniLangLexer;

@lexer::members {

    private void erroLexico() {
        throw new RuntimeException(
            "Erro Léxico! Linha "
            + getLine()
            + ": "
            + getText()
        );
    }
}

// Palavras reservadas

PROGRAM : [Pp][Rr][Oo][Gg][Rr][Aa][Mm];
INTEGER : [Ii][Nn][Tt][Ee][Gg][Ee][Rr];
BOOLEAN : [Bb][Oo][Oo][Ll][Ee][Aa][Nn];
BEGIN : [Bb][Ee][Gg][Ii][Nn];
END : [Ee][Nn][Dd];
WHILE : [Ww][Hh][Ii][Ll][Ee];
DO : [Dd][Oo];
READ : [Rr][Ee][Aa][Dd];
VAR : [Vv][Aa][Rr];
FALSE : [Ff][Aa][Ll][Ss][Ee];
TRUE : [Tt][Rr][Uu][Ee];
WRITE : [Ww][Rr][Ii][Tt][Ee];
STRING : [Ss][Tt][Rr][Ii][Nn][Gg];
IF : [Ii][Ff];
THEN : [Tt][Hh][Ee][Nn];
ELSE : [Ee][Ll][Ss][Ee];

// Comentarios

COMENTARIO : '//' ~[\r\n]* -> skip;

// Operadores

OPAD    : '+' | '-';
OPMULT  : '*' | '/';
OPREL   : '>='
         | '<='
         | '=='
         | '<>'
         | '>'
         | '<';
OPLOG   : [Oo][Rr] | [Aa][Nn][Dd];
OPNEG   : '~';

// Simbolos

PVIG : ';';
PONTO : '.';
ATRIB : ':=';
DPONTOS : ':';
VIG : ',';
ABPAR : '(';
FPAR : ')';
ABCHA : '{';
FCHA  : '}';

// Cadeia

CADEIA : '"' (~["\r\n])* '"';

// Tokens

ID : [a-zA-Z][a-zA-Z0-9]* {
          if (getText().length() > 16) {
            setText(getText().substring(0, 16));
          }
      };

CTE : [+-]?[0-9]+ {
        try {
            int valor = Integer.parseInt(getText());

            if (valor > 32767) {
                throw new RuntimeException(
                    "Erro! Linha " + getLine()
                    + ": Valor inteiro acima do limite máximo de 2 bytes : "
                    + getText()
                );
            }
        }
        catch (NumberFormatException e) {
            throw new RuntimeException(
                "Erro! Linha " + getLine()
                + ": Valor inteiro acima do limite máximo de 2 bytes : "
                + getText()
            );
        }
    };

// Ignorar

EB : [ \t\r\n]+ -> skip;

// Erro léxico

ERRO : . { erroLexico(); };