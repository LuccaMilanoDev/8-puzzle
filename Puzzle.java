import java.util.*;

public class Puzzle {
    private Estado estadoInicial;
    private Estado estadoObjetivo;

    public Puzzle(Estado inicial, Estado objetivo) {
        this.estadoInicial = inicial;
        this.estadoObjetivo = objetivo;
    }

    public No iddfs() {
        int profundidadeMaxima = 0;
        while (true) {
            Set<Estado> visitados = new HashSet<>();
            No resultado = dls(new No(estadoInicial, null, 0), profundidadeMaxima, visitados);
            if (resultado != null) {
                return resultado;
            }
            profundidadeMaxima++;
        }
    }

    private No dls(No atual, int limite, Set<Estado> visitados) {
        if (atual.getEstado().equals(estadoObjetivo)) {
            return atual;
        } else if (atual.getProfundidade() == limite) {
            return null;
        } else {
            List<No> sucessores = gerarSucessores(atual);
            for (No no : sucessores) {
                if (!visitados.contains(no.getEstado())) {
                    visitados.add(no.getEstado());
                    No resultado = dls(no, limite, visitados);
                    if (resultado != null) {
                        return resultado;
                    }
                }
            }
            return null;
        }
    }

    private List<No> gerarSucessores(No noAtual) {
        List<No> sucessores = new ArrayList<>();
        Estado estadoAtual = noAtual.getEstado();
        int[][] tabuleiro = estadoAtual.getTabuleiro();

        
        int linhaVazia = -1, colunaVazia = -1;
        boolean encontrado = false;
        for (int i = 0; i < 3 && !encontrado; i++) {
            for (int j = 0; j < 3 && !encontrado; j++) {
                if (tabuleiro[i][j] == 0) {
                    linhaVazia = i;
                    colunaVazia = j;
                    encontrado = true;
                }
            }
        }

        int[][] movimentos = {
            {linhaVazia - 1, colunaVazia}, 
            {linhaVazia + 1, colunaVazia}, 
            {linhaVazia, colunaVazia - 1}, 
            {linhaVazia, colunaVazia + 1}  
        };

        for (int[] movimento : movimentos) {
            int novaLinha = movimento[0];
            int novaColuna = movimento[1];

            
            if (novaLinha >= 0 && novaLinha < 3 && novaColuna >= 0 && novaColuna < 3) {
                
                int[][] novoTabuleiro = new int[3][3];
                for (int i = 0; i < 3; i++) {
                    System.arraycopy(tabuleiro[i], 0, novoTabuleiro[i], 0, 3);
                }

            
                novoTabuleiro[linhaVazia][colunaVazia] = novoTabuleiro[novaLinha][novaColuna];
                novoTabuleiro[novaLinha][novaColuna] = 0;

                
                Estado novoEstado = new Estado(novoTabuleiro);
                No novoNo = new No(novoEstado, noAtual, noAtual.getProfundidade() + 1);
                sucessores.add(novoNo);
            }
        }

        return sucessores;
    }

    
    public void imprimirCaminho(No no) {
        List<No> caminho = new ArrayList<>();
        No atual = no;
        while (atual != null) {
            caminho.add(atual);
            atual = atual.getPai();
        }
        Collections.reverse(caminho);
        for (No n : caminho) {
            n.getEstado().imprimirEstado();
        }
    }
}
