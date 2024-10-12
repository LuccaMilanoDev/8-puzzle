public class Main {
    public static void main(String[] args) {
        //estado inicial 
        int[][] inicial = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 5, 8}
        };
        Estado estadoInicial = new Estado(inicial);

        //estado objetivo 
        int[][] objetivo = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
        };
        Estado estadoObjetivo = new Estado(objetivo);

        // copy and edit
        Puzzle solverCopia = new Puzzle(estadoInicial, estadoObjetivo);
        long inicioCopia = System.currentTimeMillis();
        No solucaoCopia = solverCopia.iddfs();
        long fimCopia = System.currentTimeMillis();

        if (solucaoCopia != null) {
            System.out.println("Solução encontrada (Cópia e Edição):");
            solverCopia.imprimirCaminho(solucaoCopia);
            System.out.println("Tempo de execução: " + (fimCopia - inicioCopia) + " ms\n");
        } else {
            System.out.println("Nenhuma solução encontrada (Cópia e Edição).\n");
        }

        // modificar diretamente
        PuzzleSolverModificado solverModificado = new PuzzleSolverModificado(estadoInicial, estadoObjetivo);
        long inicioModificado = System.currentTimeMillis();
        No solucaoModificado = solverModificado.iddfs();
        long fimModificado = System.currentTimeMillis();

        if (solucaoModificado != null) {
            System.out.println("Solução encontrada (Modificação Direta):");
            solverModificado.imprimirCaminho(solucaoModificado);
            System.out.println("Tempo de execução: " + (fimModificado - inicioModificado) + " ms");
        } else {
            System.out.println("Nenhuma solução encontrada (Modificação Direta).");
        }
    }
}
