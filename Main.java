public class Main {
    public static void main(String[] args) {
        // estado inicial
        int[][] inicial = {
            {1, 4, 3},
            {0, 2, 8},
            {7, 5, 6}
        };
        int[][] segundo = {
            {6, 0, 3},
            {4, 2, 1},
            {7, 5, 8}
        };
        int[][] terceiro = {
            {1, 4, 3},
            {7, 2, 6},
            {0, 5, 8}
        };
        Estado estadoInicial = new Estado(inicial);
        Estado estadoSecundario = new Estado(segundo);
        Estado estadoTerceiro = new Estado(terceiro);
        // objetivo
        int[][] objetivo = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
        };
        Estado estadoObjetivo = new Estado(objetivo);

        Puzzle solver = new Puzzle(estadoInicial, estadoObjetivo);
        No solucao = solver.iddfs();

        if (solucao != null) {
            System.out.println("Solução encontrada:");
            solver.imprimirCaminho(solucao);
        } else {
            System.out.println("Nenhuma solução encontrada.");
        }
    }
}
