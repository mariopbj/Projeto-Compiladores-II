import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Otimizador {

    public List<String> constantFolding(List<String> codigo) {

        List<String> resultado = new ArrayList<>();

        for (String linha : codigo) {

            String regexArit =
                "(\\w+) = (-?\\d+) ([+\\-*/]) (-?\\d+)";

            String regexRel =
                "(\\w+) = (-?\\d+) (==|<>|<|<=|>|>=) (-?\\d+)";

            if (linha.matches(regexArit)) {

                String[] partes = linha.split(" ");

                String destino = partes[0];

                int op1 = Integer.parseInt(partes[2]);

                String operador = partes[3];

                int op2 = Integer.parseInt(partes[4]);

                int valor = 0;

                switch (operador) {

                    case "+":
                        valor = op1 + op2;
                        break;

                    case "-":
                        valor = op1 - op2;
                        break;

                    case "*":
                        valor = op1 * op2;
                        break;

                    case "/":
                        valor = op1 / op2;
                        break;
                }

                resultado.add(destino + " = " + valor);

            } else if (linha.matches(regexRel)) {

                String[] partes = linha.split(" ");

                String destino = partes[0];

                int op1 = Integer.parseInt(partes[2]);

                String operador = partes[3];

                int op2 = Integer.parseInt(partes[4]);

                boolean valor = false;

                switch (operador) {

                    case "==":
                        valor = op1 == op2;
                        break;

                    case "<>":
                        valor = op1 != op2;
                        break;

                    case "<":
                        valor = op1 < op2;
                        break;

                    case "<=":
                        valor = op1 <= op2;
                        break;

                    case ">":
                        valor = op1 > op2;
                        break;

                    case ">=":
                        valor = op1 >= op2;
                        break;
                }

                resultado.add(
                    destino + " = " + (valor ? 1 : 0)
                );
            } else {

                resultado.add(linha);
            }
        }

        return resultado;
    }

    public List<String> constantPropagation(List<String> codigo) {

        Map<String, String> constantes = new HashMap<>();
        List<String> resultado = new ArrayList<>();

        for (String linha : codigo) {

            if ((linha.endsWith(":") && !linha.contains(" ")) || linha.startsWith("GOTO ")) {
                constantes.clear();
            }

            String novaLinha = linha;

            String[] tokens = linha.split(" ");

            if (tokens.length >= 3 && tokens[1].equals("=")) {

                String esquerda = tokens[0];

                int idx = linha.indexOf(" = ");
                String direita = linha.substring(idx + 3).trim();

                for (String var : constantes.keySet()) {
                    direita = direita.replaceAll("\\b" + var + "\\b", constantes.get(var));
                }

                novaLinha = esquerda + " = " + direita;

                if (direita.matches("-?\\d+")) {
                    constantes.put(esquerda, direita);
                } else {
                    constantes.remove(esquerda);
                }

            } else {

                String temp = linha;

                for (String var : constantes.keySet()) {
                    temp = temp.replaceAll("\\b" + var + "\\b", constantes.get(var));
                }

                novaLinha = temp;
            }

            resultado.add(novaLinha);
        }

        return resultado;
    }

    public List<String> strengthReduction(List<String> codigo) {

        List<String> resultado = new ArrayList<>();

        for (String linha : codigo) {

            String[] partes = linha.split(" ");

            if (partes.length == 5 && partes[3].equals("*")) {

                String destino = partes[0];

                String op1 = partes[2];

                String op2 = partes[4];

                try {

                    int valor = Integer.parseInt(op2);

                    if (valor > 0 && (valor & (valor - 1)) == 0) {

                        int shift = Integer.numberOfTrailingZeros(valor);

                        resultado.add(destino + " = " + op1 + " << " + shift);

                        continue;
                    }

                } catch (NumberFormatException e) {

                }
            }

            resultado.add(linha);
        }

        return resultado;
    }

    public List<String> deadCodeElimination(List<String> codigo) {

        List<String> resultado = new ArrayList<>();

        boolean ignorar = false;

        String labelDestino = null;

        for (String linha : codigo) {

            if (linha.matches("IF 1 == 0 GOTO .*")) {

                continue;
            }

            if (linha.matches("IF 0 == 0 GOTO .*")) {

                labelDestino = linha.substring(linha.indexOf("GOTO") + 5);

                ignorar = true;

                continue;
            }

            if (ignorar) {

                if (linha.equals(labelDestino + ":")) {

                    ignorar = false;

                    resultado.add(linha);
                }

                continue;
            }

            resultado.add(linha);
        }

        return resultado;
    }

}