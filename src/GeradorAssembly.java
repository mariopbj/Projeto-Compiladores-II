import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class GeradorAssembly {

    private List<String> codigoAsm = new ArrayList<>();

    private Set<String> variaveis = new HashSet<>();

    private int contadorComparacao = 0;

    private TabelaSimbolos tabela;

    public GeradorAssembly(List<String> codigo, TabelaSimbolos tabela) {

        this.tabela = tabela;
    }

    private String novoLabelCmp() {

        return "CMP_" + contadorComparacao++;
    }

    private void coletarVariaveis(List<String> codigo3AC) {

        for (String linha : codigo3AC) {

            String[] partes = linha.split(" ");

            if (partes.length >= 3 && partes[1].equals("=")) {

                variaveis.add(partes[0]);
            }
        }
    }

    public List<String> getCodigoAsm() {
        return codigoAsm;
    }

    public void gerar(List<String> codigo3AC) {

        coletarVariaveis(codigo3AC);

        codigoAsm.add(".data");

        for (String var : variaveis) {

            if (!tabela.existe(var)) {

                codigoAsm.add(var + " dw 0");
            }
        }

        for (Simbolo s : tabela.getTabela().values()) {

            if (s.getTipo().equals("INTEGER")) {

                codigoAsm.add(s.getNome() + " dw 0");

            } else if (s.getTipo().equals("BOOLEAN")) {

                codigoAsm.add(s.getNome() + " db 0");
            }
        }

        codigoAsm.add("");

        codigoAsm.add(".text");

        codigoAsm.add("start:");

        for (String linha : codigo3AC) {

            traduzir(linha);
        }
    }

    private void traduzir(String linha) {
        if (linha.endsWith(":")) {

            codigoAsm.add(linha);

            return;
        }

        if (linha.startsWith("GOTO ")) {

            String label = linha.substring(5);

            codigoAsm.add("jmp " + label);

            return;
        }

        String[] partes = linha.split(" ");

        if (partes.length == 5 && partes[3].equals(">")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            String label = novoLabelCmp();

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("cmp ax, word ptr [" + op2 + "]");

            codigoAsm.add("jg " + label + "_TRUE");

            codigoAsm.add("mov word ptr [" + destino + "], 0");

            codigoAsm.add("jmp " + label + "_END");

            codigoAsm.add(label + "_TRUE:");

            codigoAsm.add("mov word ptr [" + destino + "], 1");

            codigoAsm.add(label + "_END:");

            return;
        }

        if (partes.length == 5 && partes[3].equals("<")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            String label = novoLabelCmp();

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("cmp ax, word ptr [" + op2 + "]");

            codigoAsm.add("jl " + label + "_TRUE");

            codigoAsm.add("mov word ptr [" + destino + "], 0");

            codigoAsm.add("jmp " + label + "_END");

            codigoAsm.add(label + "_TRUE:");

            codigoAsm.add("mov word ptr [" + destino + "], 1");

            codigoAsm.add(label + "_END:");

            return;
        }

        if (partes.length == 5 && partes[3].equals(">=")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            String label = novoLabelCmp();

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("cmp ax, word ptr [" + op2 + "]");

            codigoAsm.add("jge " + label + "_TRUE");

            codigoAsm.add("mov word ptr [" + destino + "], 0");

            codigoAsm.add("jmp " + label + "_END");

            codigoAsm.add(label + "_TRUE:");

            codigoAsm.add("mov word ptr [" + destino + "], 1");

            codigoAsm.add(label + "_END:");

            return;
        }

        if (partes.length == 5 && partes[3].equals("<=")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            String label = novoLabelCmp();

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("cmp ax, word ptr [" + op2 + "]");

            codigoAsm.add("jle " + label + "_TRUE");

            codigoAsm.add("mov word ptr [" + destino + "], 0");

            codigoAsm.add("jmp " + label + "_END");

            codigoAsm.add(label + "_TRUE:");

            codigoAsm.add("mov word ptr [" + destino + "], 1");

            codigoAsm.add(label + "_END:");

            return;
        }

        if (partes.length == 5 && partes[3].equals("==")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            String label = novoLabelCmp();

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("cmp ax, word ptr [" + op2 + "]");

            codigoAsm.add("je " + label + "_TRUE");

            codigoAsm.add("mov word ptr [" + destino + "], 0");

            codigoAsm.add("jmp " + label + "_END");

            codigoAsm.add(label + "_TRUE:");

            codigoAsm.add("mov word ptr [" + destino + "], 1");

            codigoAsm.add(label + "_END:");

            return;
        }

        if (partes.length == 5 && partes[3].equals("<>")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            String label = novoLabelCmp();

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("cmp ax, word ptr [" + op2 + "]");

            codigoAsm.add("jne " + label + "_TRUE");

            codigoAsm.add("mov word ptr [" + destino + "], 0");

            codigoAsm.add("jmp " + label + "_END");

            codigoAsm.add(label + "_TRUE:");

            codigoAsm.add("mov word ptr [" + destino + "], 1");

            codigoAsm.add(label + "_END:");

            return;
        }

        if (partes.length == 5 && partes[3].equals("+")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("add ax, word ptr [" + op2 + "]");

            codigoAsm.add("mov word ptr [" + destino + "], ax");

            return;
        }

        if (partes.length == 5 && partes[3].equals("-")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("sub ax, word ptr [" + op2 + "]");

            codigoAsm.add("mov word ptr [" + destino + "], ax");

            return;
        }

        if (partes.length == 5 && partes[3].equals("*")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("imul word ptr [" + op2 + "]");

            codigoAsm.add("mov word ptr [" + destino + "], ax");

            return;
        }

        if (partes.length == 5 && partes[3].equals("/")) {

            String destino = partes[0];

            String op1 = partes[2];

            String op2 = partes[4];

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("cwd");

            codigoAsm.add("idiv word ptr [" + op2 + "]");

            codigoAsm.add("mov word ptr [" + destino + "], ax");

            return;
        }

        if (partes.length == 5 && partes[3].equalsIgnoreCase("AND")) {

            String destino = partes[0];
            String op1 = partes[2];
            String op2 = partes[4];

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("and ax, word ptr [" + op2 + "]");

            codigoAsm.add("mov word ptr [" + destino + "], ax");

            return;
        }

        if (partes.length == 5 && partes[3].equalsIgnoreCase("OR")) {

            String destino = partes[0];
            String op1 = partes[2];
            String op2 = partes[4];

            codigoAsm.add("mov ax, word ptr [" + op1 + "]");

            codigoAsm.add("or ax, word ptr [" + op2 + "]");

            codigoAsm.add("mov word ptr [" + destino + "], ax");

            return;
        }

        if (partes.length == 4 && partes[2].equals("~")) {

            String destino = partes[0];
            String op = partes[3];

            codigoAsm.add("mov ax, word ptr [" + op + "]");

            codigoAsm.add("xor ax, 1");

            codigoAsm.add("mov word ptr [" + destino + "], ax");

            return;
        }

        if (linha.startsWith("IF ")) {

            String[] p = linha.split(" ");

            String variavel = p[1];

            String label = p[5];

            codigoAsm.add("mov ax, word ptr [" + variavel + "]");

            codigoAsm.add("cmp ax, 0");

            codigoAsm.add("je " + label);

            return;
        }

        if (linha.startsWith("WRITE ")) {

            String valor = linha.substring(6);

            codigoAsm.add("push word ptr [" + valor + "]");

            codigoAsm.add("call _print_integer");

            return;
        }

        if (linha.startsWith("READ ")) {

            String variavel = linha.substring(5);

            codigoAsm.add("call _read_integer");

            codigoAsm.add("mov word ptr [" + variavel + "], ax");

            return;
        }

        if (partes.length == 3 && partes[1].equals("=")) {

            String destino = partes[0];

            String origem = partes[2];

            if (origem.matches("-?\\d+")) {

                codigoAsm.add("mov word ptr [" + destino + "], " + origem);

            } else {

                codigoAsm.add("mov ax, word ptr [" + origem + "]");

                codigoAsm.add("mov word ptr [" + destino + "], ax");
            }

            return;
        }

    }

}