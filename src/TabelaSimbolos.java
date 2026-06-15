import java.util.HashMap;
import java.util.Map;

public class TabelaSimbolos {

    private Map<String, Simbolo> tabela = new HashMap<>();

    public Map<String, Simbolo> getTabela() {

        return tabela;
    }

    private int proximoDeslocamento = 0;

    public void adicionar(String nome, String tipo) {

        if (tabela.containsKey(nome)) {

            throw new RuntimeException("Erro Semantico: Variavel " + nome + " ja declarada");
        }

        Simbolo simbolo = new Simbolo(nome, tipo, proximoDeslocamento);

        tabela.put(nome, simbolo);

        proximoDeslocamento += 2;
    }

    public boolean existe(String nome) {

        return tabela.containsKey(nome);
    }

    public String buscar(String nome) {

        return tabela.get(nome).getTipo();
    }

    public int deslocamento(String nome) {

        return tabela.get(nome)
                     .getDeslocamento();
    }
}