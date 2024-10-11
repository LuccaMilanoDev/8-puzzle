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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Estado)) {
            return false;
        }
        Estado outro = (Estado) obj;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tabuleiro[i][j] != outro.tabuleiro[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int resultado = 0;
        for (int[] linha : tabuleiro) {
            for (int num : linha) {
                resultado = resultado * 31 + num;
            }
        }
        return resultado;
    }
}
