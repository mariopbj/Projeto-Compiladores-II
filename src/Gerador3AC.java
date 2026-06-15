import java.util.ArrayList;
import java.util.List;

public class Gerador3AC
    extends MiniLangParserBaseVisitor<String> {

    private List<String> codigo =
        new ArrayList<>();

    public List<String> getCodigo() {

        return codigo;
    }

    private int contadorTemp = 0;

    private String novaTemp() {

        return "t" + contadorTemp++;
    }

    @Override
    public String visitCmdAtrib(
            MiniLangParser.CmdAtribContext ctx) {

        String resultado =
            visit(ctx.expr());

        codigo.add(
            ctx.ID().getText()
            + " = "
            + resultado
        );

        return null;
    }

    @Override
    public String visitFator(
            MiniLangParser.FatorContext ctx) {

        if (ctx.ID() != null) {

            return ctx.ID().getText();
        }

        if (ctx.CTE() != null) {

            return ctx.CTE().getText();
        }

        if (ctx.TRUE() != null) {

            return "TRUE";
        }

        if (ctx.FALSE() != null) {

            return "FALSE";
        }

        if (ctx.expr() != null) {

            return visit(ctx.expr());
        }

        return null;
    }

    @Override
    public String visitExprMult(
            MiniLangParser.ExprMultContext ctx) {

        String resultado =
            visit(ctx.fator(0));

        for (int i = 1;
            i < ctx.fator().size();
            i++) {

            String direita =
                visit(ctx.fator(i));

            String temp =
                novaTemp();

            String op =
                ctx.OPMULT(i - 1).getText();

            codigo.add(
                temp
                + " = "
                + resultado
                + " "
                + op
                + " "
                + direita
            );

            resultado = temp;
        }

        return resultado;
    }

    @Override
    public String visitExprAd(
            MiniLangParser.ExprAdContext ctx) {

        String resultado =
            visit(ctx.exprMult(0));

        for (int i = 1;
            i < ctx.exprMult().size();
            i++) {

            String direita =
                visit(ctx.exprMult(i));

            String temp =
                novaTemp();

            String op =
                ctx.OPAD(i - 1).getText();

            codigo.add(
                temp
                + " = "
                + resultado
                + " "
                + op
                + " "
                + direita
            );

            resultado = temp;
        }

        return resultado;
    }

    @Override
    public String visitExprRel(
            MiniLangParser.ExprRelContext ctx) {

        return visit(ctx.exprAd(0));
    }

    @Override
    public String visitExpr(
            MiniLangParser.ExprContext ctx) {

        return visit(ctx.exprRel(0));
    }

}