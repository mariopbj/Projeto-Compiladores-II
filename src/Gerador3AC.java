import java.util.ArrayList;
import java.util.List;

public class Gerador3AC extends MiniLangParserBaseVisitor<String> {

    private List<String> codigo = new ArrayList<>();

    public List<String> getCodigo() {

        return codigo;
    }

    private int contadorTemp = 0;
    private int labelCount = 0;

    private String novaTemp() {

        return "t" + contadorTemp++;
    }

    private String novoLabel() {
        return "L" + labelCount++;
    }

    @Override
    public String visitCmdAtrib(MiniLangParser.CmdAtribContext ctx) {

        String resultado = visit(ctx.expr());

        codigo.add(ctx.ID().getText() + " = " + resultado);

        return null;
    }

    @Override
    public String visitFator(MiniLangParser.FatorContext ctx) {

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

        if (ctx.OPNEG() != null) {

            String valor = visit(ctx.fator());

            String temp = novaTemp();

            codigo.add(temp + " = ~ " + valor);

            return temp;
        }

        return null;
    }

    @Override
    public String visitExprMult(MiniLangParser.ExprMultContext ctx) {

        String resultado = visit(ctx.fator(0));

        for (int i = 1; i < ctx.fator().size(); i++) {

            String direita = visit(ctx.fator(i));

            String temp = novaTemp();

            String op = ctx.OPMULT(i - 1).getText();

            codigo.add(temp + " = " + resultado + " " + op + " " + direita);

            resultado = temp;
        }

        return resultado;
    }

    @Override
    public String visitExprAd(MiniLangParser.ExprAdContext ctx) {

        String resultado = visit(ctx.exprMult(0));

        for (int i = 1; i < ctx.exprMult().size(); i++) {

            String direita = visit(ctx.exprMult(i));

            String temp = novaTemp();

            String op = ctx.OPAD(i - 1).getText();

            codigo.add(temp + " = " + resultado + " " + op + " " + direita);

            resultado = temp;
        }

        return resultado;
    }

    @Override
    public String visitExprRel(MiniLangParser.ExprRelContext ctx) {

        String esquerda = visit(ctx.exprAd(0));

        if (ctx.OPREL() == null) {

            return esquerda;
        }

        String direita = visit(ctx.exprAd(1));

        String temp = novaTemp();

        codigo.add(temp + " = " + esquerda + " " + ctx.OPREL().getText() + " " + direita);

        return temp;
    }

    @Override
    public String visitExpr(MiniLangParser.ExprContext ctx) {

        String resultado = visit(ctx.exprRel(0));

        for (int i = 1; i < ctx.exprRel().size(); i++) {

            String direita = visit(ctx.exprRel(i));

            String temp = novaTemp();

            String op = ctx.OPLOG(i - 1).getText();

            codigo.add(temp + " = " + resultado + " " + op + " " + direita);

            resultado = temp;
        }

        return resultado;
    }

    @Override
    public String visitCmdIf(
            MiniLangParser.CmdIfContext ctx) {

        String condicao = visit(ctx.expr());

        String fim = novoLabel();

        if (ctx.bloco().size() == 1) {

            codigo.add("IF " + condicao + " == 0 GOTO " + fim);

            visit(ctx.bloco(0));

            codigo.add(fim + ":");

        } else {

            String senao = novoLabel();

            codigo.add("IF " + condicao + " == 0 GOTO " + senao);

            visit(ctx.bloco(0));

            codigo.add("GOTO " + fim);

            codigo.add(senao + ":");

            visit(ctx.bloco(1));

            codigo.add(fim + ":");
        }

        return null;
    }

    @Override
    public String visitCmdWhile(MiniLangParser.CmdWhileContext ctx) {

        String inicio = novoLabel();

        String fim = novoLabel();

        codigo.add(inicio + ":");

        String condicao = visit(ctx.expr());

        codigo.add("IF " + condicao + " == 0 GOTO " + fim);

        visit(ctx.bloco());

        codigo.add("GOTO " + inicio);

        codigo.add(fim + ":");

        return null;
    }

    @Override
    public String visitCmdRead(MiniLangParser.CmdReadContext ctx) {

        for (var id : ctx.listId().ID()) {

            codigo.add("READ " + id.getText());
        }

        return null;
    }

    @Override
    public String visitCmdWrite(MiniLangParser.CmdWriteContext ctx) {

        for (var elem : ctx.listW().elemW()) {

            if (elem.CADEIA() != null) {

                codigo.add("WRITE " + elem.CADEIA().getText());

            } else {

                String valor = visit(elem.expr());

                codigo.add("WRITE " + valor);
            }
        }

        return null;
    }

}