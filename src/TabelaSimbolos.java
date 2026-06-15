import java.util.*;

public class TabelaSimbolos {

    private Map<String, Simbolo> tabelaAtual = new HashMap<>();
    private TabelaSimbolos escopoPai;
    private int proximoDeslocamento = 0;

    public TabelaSimbolos(TabelaSimbolos pai) {
        this.escopoPai = pai;

        this.proximoDeslocamento = (pai != null) ? pai.proximoDeslocamento : 0;
    }

    public TabelaSimbolos entrarEscopo() {
        return new TabelaSimbolos(this);
    }

    public TabelaSimbolos sairEscopo() {
        return this.escopoPai;
    }

    public void adicionar(String nome, String tipo) {
        if (tabelaAtual.containsKey(nome))
            throw new RuntimeException("Erro Semantico: Variavel " + nome + " ja declarada");
        tabelaAtual.put(nome, new Simbolo(nome, tipo, proximoDeslocamento));
        proximoDeslocamento += 2;
    }

    public boolean existe(String nome) {
        if (tabelaAtual.containsKey(nome)) return true;
        if (escopoPai != null) return escopoPai.existe(nome);
        return false;
    }

    public String buscar(String nome) {
        if (tabelaAtual.containsKey(nome)) return tabelaAtual.get(nome).getTipo();
        if (escopoPai != null) return escopoPai.buscar(nome);
        return null;
    }

    public Map<String, Simbolo> getTabela() { return tabelaAtual; }
}