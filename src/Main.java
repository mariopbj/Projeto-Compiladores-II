import java.util.List;
import org.antlr.v4.runtime.*;

public class Main {

    public static void main(String[] args) {

        try {

            CharStream input =
                CharStreams.fromFileName("input/teste.txt");

            System.out.println("=== ANALISE LEXICA ===");

            MiniLangLexer lexer =
                new MiniLangLexer(input);

            Token token;

            while ((token = lexer.nextToken()).getType() != Token.EOF) {

                String tipo =
                    lexer.getVocabulary()
                         .getSymbolicName(token.getType());

                String atributo = null;

                switch (tipo) {

                    case "OPAD":

                        atributo =
                            token.getText().equals("+")
                            ? "MAIS"
                            : "MENOS";

                        break;

                    case "OPMULT":

                        atributo =
                            token.getText().equals("*")
                            ? "VEZES"
                            : "DIV";

                        break;

                    case "OPREL":

                        switch (token.getText()) {

                            case "<":  atributo = "MENOR"; break;
                            case "<=": atributo = "MENIG"; break;
                            case ">":  atributo = "MAIOR"; break;
                            case ">=": atributo = "MAIG"; break;
                            case "==": atributo = "IGUAL"; break;
                            case "<>": atributo = "DIFER"; break;
                        }

                        break;

                    case "OPLOG":

                        atributo =
                            token.getText().equalsIgnoreCase("OR")
                            ? "OR"
                            : "AND";

                        break;

                    case "OPNEG":

                        atributo = "NEG";
                        break;

                    case "ID":
                    case "CTE":
                    case "CADEIA":

                        atributo = token.getText();
                        break;
                }

                if (atributo != null) {

                    //System.out.println("LEXEMA: " + token.getText() + " | TIPO: " + tipo + " | ATRIBUTO: " + atributo);

                } else {

                    //System.out.println("LEXEMA: " + token.getText() + " | TIPO: " + tipo);
                }
            }
            

            System.out.println("\n=== ANALISE SINTATICA ===");

            input = CharStreams.fromFileName("input/teste.txt");

            lexer = new MiniLangLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            MiniLangParser parser = new MiniLangParser(tokens);

            MiniLangParser.ProgContext arvore = parser.prog();

            if (parser.getNumberOfSyntaxErrors() == 0) {

                Semantico semantico = new Semantico();

                semantico.visit(arvore);

                //System.out.println("Analise semantica concluida");

                Gerador3AC gerador = new Gerador3AC();

                gerador.visit(arvore);

                System.out.println("\n=== CODIGO 3AC ===");

                for (String linha : gerador.getCodigo()) {

                    System.out.println(linha);
                }

                Otimizador otimizador = new Otimizador();

                List<String> codigoFold = otimizador.constantFolding(gerador.getCodigo());

                System.out.println("\n=== CONSTANT FOLDING ===");

                for (String linha : codigoFold) {

                    System.out.println(linha);
                }

                List<String> codigoProp = otimizador.constantPropagation(codigoFold);

                List<String> codigoFinal = otimizador.constantFolding(codigoProp);

                List<String> codigoStrength = otimizador.strengthReduction(codigoFinal);

                List<String> codigoDead = otimizador.deadCodeElimination(codigoStrength);

                System.out.println("\n=== CONSTANT PROPAGATION ===");

                for (String linha : codigoProp) {

                    System.out.println(linha);
                }

                System.out.println("\n=== STRENGTH REDUCTION ===");

                for (String linha : codigoStrength) {

                    System.out.println(linha);
                }

                System.out.println("\n=== DEAD CODE ELIMINATION ===");

                for (String linha : codigoDead) {

                    System.out.println(linha);
                }

                GeradorAssembly asm = new GeradorAssembly(codigoDead, semantico.getTabela());

                asm.gerar(codigoDead);

                System.out.println("\n=== ASSEMBLY ===");

                for (String linha : asm.getCodigoAsm()) {

                    System.out.println(linha);
                }

                System.out.println(
                    "Programa reconhecido com sucesso"
                );

                System.out.println("\n=== EXECUCAO (INTERPRETADOR) ===");

                Interpretador interpretador = new Interpretador(codigoDead);

                interpretador.executar();

            } else {

                System.out.println(
                    "Programa contém erros sintáticos"
                );
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}