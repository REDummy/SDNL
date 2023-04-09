package AdjMatr;

public class graphMain {
    public static void main(String[] args) {
        // Membuat graph dengan 5 vertex
        Graph graph = new Graph(5);

        // Menambahkan edge antara vertex 0 dan 1
        graph.addEdge(0, 1);

        // Menambahkan edge antara vertex 1 dan 2
        graph.addEdge(1, 2);

        // Menambahkan edge antara vertex 2 dan 3
        graph.addEdge(2, 3);

        // Menambahkan edge antara vertex 3 dan 4
        graph.addEdge(3, 4);

        // Menampilkan jumlah vertex dan edge
        System.out.println("Jumlah vertex: " + graph.getNumVertices());
        System.out.println("Jumlah edge: " + graph.getNumEdges());

        // Mendapatkan matriks adjacency
        int[][] adjacencyMatrix = graph.getAdjacencyMatrix();
        System.out.println("Matriks adjacency:");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Menghapus edge antara vertex 1 dan 2
        graph.removeEdge(1, 2);

        // Menampilkan jumlah vertex dan edge setelah edge dihapus
        System.out.println("Jumlah vertex: " + graph.getNumVertices());
        System.out.println("Jumlah edge: " + graph.getNumEdges());

        // Mendapatkan matriks adjacency setelah edge dihapus
        adjacencyMatrix = graph.getAdjacencyMatrix();
        System.out.println("Matriks adjacency setelah edge dihapus:");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[0].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
