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

        return visitChildren(ctx);
    }

}