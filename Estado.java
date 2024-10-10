public class Estado {
    private int[][] tabuleiro; 

   
    public Estado(int[][] tabuleiro) {
        this.tabuleiro = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(tabuleiro[i], 0, this.tabuleiro[i], 0, 3);
        }
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void imprimirEstado() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
