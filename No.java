public class No {
    private Estado estado;
    private No pai;
    private int profundidade;

    // Construtor
    public No(Estado estado, No pai, int profundidade) {
        this.estado = estado;
        this.pai = pai;
        this.profundidade = profundidade;
    }

    // Métodos getters
    public Estado getEstado() {
        return estado;
    }

    public No getPai() {
        return pai;
    }

    public int getProfundidade() {
        return profundidade;
    }
}
