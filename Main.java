public class Main {
    public static void main(String[] args) {
        // estado inicial
        int[][] inicial = {
            {1, 4, 3},
            {0, 2, 8},
            {7, 5, 6}
        };
        Estado estadoInicial = new Estado(inicial);
        // objetivo
        int[][] objetivo = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}
        };
        Estado estadoObjetivo = new Estado(objetivo);

        Puzzle solver = new Puzzle(estadoInicial, estadoObjetivo);


        // Verificar e imprimir o resultado
        
        System.out.println("Solução encontrada:");
            
        
        System.out.println("Nenhuma solução encontrada.");
        
    }
}
