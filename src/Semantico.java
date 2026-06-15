public class Semantico
    extends MiniLangParserBaseVisitor<Void> {

    private TabelaSimbolos tabela = new TabelaSimbolos();


    @Override
    public Void visitDeclTip(
            MiniLangParser.DeclTipContext ctx) {

        String tipo = ctx.tip().getText().toUpperCase();

        for (var id : ctx.listId().ID()) {

            tabela.adicionar(id.getText(), tipo);
        }

        return visitChildren(ctx);
    }

    @Override
    public Void visitFator(MiniLangParser.FatorContext ctx) {

        if (ctx.ID() != null) {

            String nome = ctx.ID().getText();

            if (!tabela.existe(nome)) {

                throw new RuntimeException("Erro Semantico: Variavel " + nome + " nao declarada");
            }
        }

        return visitChildren(ctx);
    }

    @Override
    public Void visitCmdAtrib(MiniLangParser.CmdAtribContext ctx) {

        String nome = ctx.ID().getText();

        if (!tabela.existe(nome)) {

            throw new RuntimeException("Erro Semantico: Variavel " + nome + " nao declarada");
        }

        String tipoVariavel = tabela.buscar(nome);

        String tipoExpressao = descobrirTipo(ctx.expr());

        if (!tipoVariavel.equals(tipoExpressao)) {

            throw new RuntimeException("Erro Semantico: atribuicao incompativel");
        }

        return visitChildren(ctx);
    }

    private String tipoFator(MiniLangParser.FatorContext ctx) {

        if (ctx.TRUE() != null || ctx.FALSE() != null) {

            return "BOOLEAN";
        }

        if (ctx.CTE() != null) {

            return "INTEGER";
        }

        if (ctx.ID() != null) {

            return tabela.buscar(ctx.ID().getText());
        }

        if (ctx.expr() != null) {

            return descobrirTipo(ctx.expr());
        }

        return null;
    }

    private String descobrirTipo(MiniLangParser.ExprContext ctx) {

        if (!ctx.OPLOG().isEmpty()) {

            for (int i = 0; i < ctx.exprRel().size(); i++) {

                String tipo = descobrirTipoExprRel(ctx.exprRel(i));

                if (!tipo.equals("BOOLEAN")) {

                    throw new RuntimeException("Erro Semantico: operador logico exige operandos BOOLEAN");
                }
            }

            return "BOOLEAN";
        }

        return descobrirTipoExprRel(ctx.exprRel(0));
    }

    private String descobrirTipoExprRel(MiniLangParser.ExprRelContext ctx) {

        if (ctx.OPREL() != null) {

            String tipo1 = descobrirTipoExprAd(ctx.exprAd(0));

            String tipo2 = descobrirTipoExprAd(ctx.exprAd(1));

            if (!tipo1.equals(tipo2)) {

                throw new RuntimeException("Erro Semantico: comparacao entre tipos diferentes");
            }

            return "BOOLEAN";
        }

        return descobrirTipoExprAd(ctx.exprAd(0));
    }

    private String descobrirTipoExprAd(MiniLangParser.ExprAdContext ctx) {

        if (!ctx.OPAD().isEmpty()) {

            for (int i = 0; i < ctx.exprMult().size(); i++) {

                String tipo = descobrirTipoExprMult(ctx.exprMult(i));

                if (!tipo.equals("INTEGER")) {

                    throw new RuntimeException("Erro Semantico: operador + ou - exige operandos INTEGER");
                }
            }

            return "INTEGER";
        }

        return descobrirTipoExprMult(ctx.exprMult(0));
    }
    
    private String descobrirTipoExprMult(MiniLangParser.ExprMultContext ctx) {

        if (!ctx.OPMULT().isEmpty()) {

            for (int i = 0; i < ctx.fator().size(); i++) {

                String tipo = tipoFator(ctx.fator(i));

                if (!tipo.equals("INTEGER")) {

                    throw new RuntimeException("Erro Semantico: operador * ou / exige operandos INTEGER");
                }
            }

            return "INTEGER";
        }

        return tipoFator(ctx.fator(0));
    }

}