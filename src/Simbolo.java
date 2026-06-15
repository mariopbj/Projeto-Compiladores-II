public class Simbolo {

    private String nome;
    private String tipo;
    private int deslocamento;

    public Simbolo(
            String nome,
            String tipo,
            int deslocamento) {

        this.nome = nome;
        this.tipo = tipo;
        this.deslocamento = deslocamento;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDeslocamento() {
        return deslocamento;
    }
}