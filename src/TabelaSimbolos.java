import java.util.HashMap;
import java.util.Map;

public class TabelaSimbolos {

    private Map<String, String> tabela =
        new HashMap<>();

    public void adicionar(String nome,
                           String tipo) {

        if (tabela.containsKey(nome)) {

            throw new RuntimeException(
                "Erro Semantico: Variavel "
                + nome
                + " ja declarada"
            );
        }

        tabela.put(nome, tipo);
    }

    public boolean existe(String nome) {

        return tabela.containsKey(nome);
    }

    public String buscar(String nome) {

        return tabela.get(nome);
    }
}