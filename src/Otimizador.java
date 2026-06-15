import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Otimizador {

    public List<String> constantFolding(List<String> codigo) {

        List<String> resultado = new ArrayList<>();

        for (String linha : codigo) {

            String regex = "(\\w+) = (-?\\d+) ([+\\-*/]) (-?\\d+)";

            if (linha.matches(regex)) {

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

            } else {

                resultado.add(linha);
            }
        }

        return resultado;
    }

    public List<String> constantPropagation(
            List<String> codigo) {

        Map<String, String> constantes =
            new HashMap<>();

        List<String> resultado =
            new ArrayList<>();

        for (String linha : codigo) {

            String novaLinha = linha;

            for (String variavel : constantes.keySet()) {

                novaLinha =
                    novaLinha.replaceAll(
                        "\\b" + variavel + "\\b",
                        constantes.get(variavel)
                    );
            }

            resultado.add(novaLinha);

            String[] partes =
                novaLinha.split(" ");

            if (partes.length == 3) {

                String destino =
                    partes[0];

                String valor =
                    partes[2];

                if (valor.matches("-?\\d+")) {

                    constantes.put(
                        destino,
                        valor
                    );

                } else {

                    constantes.remove(
                        destino
                    );
                }
            }
        }

        return resultado;
    }

}