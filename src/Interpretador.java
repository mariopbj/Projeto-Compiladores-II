import java.util.*;

public class Interpretador {

    private Map<String, Object> memoria = new HashMap<>();

    private List<String> codigo;

    private Map<String, Integer> labels = new HashMap<>();

    private Scanner scanner = new Scanner(System.in);

    public Interpretador(List<String> codigo) {

        this.codigo = new ArrayList<>(codigo);

        for (int i = 0; i < this.codigo.size(); i++) {

            String linha = this.codigo.get(i).trim();

            if (linha.endsWith(":") && !linha.contains(" ")) {

                String label = linha.substring(0, linha.length() - 1);

                labels.put(label, i);
            }
        }
    }


    public void executar() {

        int pc = 0;

        while (pc < codigo.size()) {

            String linha = codigo.get(pc).trim();

            if (linha.isEmpty() || (linha.endsWith(":") && !linha.contains(" "))) {
                pc++;
                continue;
            }

            if (linha.startsWith("GOTO ")) {

                String label = linha.substring(5).trim();

                pc = resolverLabel(label) + 1;

                continue;
            }

            if (linha.startsWith("IF ")) {

                String[] partes = linha.split(" ");

                String nomeCondicao = partes[1];
                String labelDest    = partes[5];

                int valorCond = toInt(getValor(nomeCondicao));

                if (valorCond == 0) {
                    pc = resolverLabel(labelDest) + 1;
                } else {
                    pc++;
                }

                continue;
            }

            if (linha.startsWith("READ ")) {

                String variavel = linha.substring(5).trim();

                System.out.print("Leitura de " + variavel + ": ");

                String entrada = scanner.nextLine().trim();

                try {
                    memoria.put(variavel, Integer.parseInt(entrada));
                } catch (NumberFormatException e) {
                    memoria.put(variavel, entrada);
                }

                pc++;
                continue;
            }

            if (linha.startsWith("WRITE ")) {

                String valor = linha.substring(6).trim();

                if (valor.startsWith("\"")) {
                    System.out.println(valor.substring(1, valor.length() - 1));

                } else {
                    Object val = getValor(valor);

                    if (val instanceof Integer) {
                        int v = (Integer) val;
                        System.out.println(v);
                    } else {
                        System.out.println(val);
                    }
                }

                pc++;
                continue;
            }

            String[] partes = linha.split(" ");

            if (partes.length >= 3 && partes[1].equals("=")) {

                String destino = partes[0];

                if (partes.length == 3) {
                    memoria.put(destino, getValor(partes[2]));

                } else if (partes.length == 4 && partes[2].equals("~")) {
                    int val = toInt(getValor(partes[3]));
                    memoria.put(destino, val == 0 ? 1 : 0);

                } else if (partes.length == 5) {
                    Object op1 = getValor(partes[2]);
                    String  op  = partes[3];
                    Object op2 = getValor(partes[4]);

                    memoria.put(destino, aplicarOp(op1, op, op2));

                } else {
                    System.err.println("Aviso: instrucao nao reconhecida: " + linha);
                }

                pc++;
                continue;
            }

            pc++;
        }
    }


    private int resolverLabel(String label) {

        Integer idx = labels.get(label);

        if (idx == null) {
            throw new RuntimeException("Erro de execucao: label nao encontrado: " + label);
        }

        return idx;
    }


    private Object getValor(String s) {

        if (s == null) return 0;

        s = s.trim();

        if (s.equalsIgnoreCase("TRUE"))  return 1;
        if (s.equalsIgnoreCase("FALSE")) return 0;

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {

            Object val = memoria.get(s);
            return val != null ? val : 0;
        }
    }


    private int toInt(Object val) {

        if (val == null)            return 0;
        if (val instanceof Integer) return (Integer) val;
        if (val instanceof Boolean) return (Boolean) val ? 1 : 0;

        if (val instanceof String) {
            try { return Integer.parseInt((String) val); }
            catch (Exception e) { return 0; }
        }

        return 0;
    }


    private Object aplicarOp(Object op1, String operador, Object op2) {

        int a = toInt(op1);
        int b = toInt(op2);

        switch (operador) {

            case "+":  return a + b;
            case "-":  return a - b;
            case "*":  return a * b;
            case "/":
                if (b == 0) throw new RuntimeException("Erro de execucao: divisao por zero");
                return a / b;
            case "<<": return a << b;

            case "==": return a == b ? 1 : 0;
            case "<>": return a != b ? 1 : 0;
            case "<":  return a <  b ? 1 : 0;
            case "<=": return a <= b ? 1 : 0;
            case ">":  return a >  b ? 1 : 0;
            case ">=": return a >= b ? 1 : 0;

            default:
                if (operador.equalsIgnoreCase("AND")) return (a != 0 && b != 0) ? 1 : 0;
                if (operador.equalsIgnoreCase("OR"))  return (a != 0 || b != 0) ? 1 : 0;

                throw new RuntimeException("Erro de execucao: operador desconhecido: " + operador);
        }
    }
}