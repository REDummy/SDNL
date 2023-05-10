package Graph;

public class main {
    public static void main(String[] args) {
        graph graph = new graph();//Instantiate objek
        for (int i = 0; i < 10; i++) {
            graph.addVertex((char) ('A' + i));
        }
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 5);

        graph.addEdge(1, 3, 4);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 0, 5);

        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 5, 7);
        graph.addEdge(2, 0, 5);

        graph.addEdge(3, 4, 8);
        graph.addEdge(3, 5, 6);
        graph.addEdge(3, 1, 4);
        graph.addEdge(3, 2, 4);

        graph.addEdge(4, 5, 10);
        graph.addEdge(4, 6, 10);
        graph.addEdge(4, 7, 8);
        graph.addEdge(4, 8, 9);
        graph.addEdge(4, 1, 9);
        graph.addEdge(4, 3, 8);

        graph.addEdge(5, 6, 3);
        graph.addEdge(5, 2, 7);
        graph.addEdge(5, 3, 6);
        graph.addEdge(5, 4, 10);

        graph.addEdge(6, 7, 6);
        graph.addEdge(6, 9, 7);
        graph.addEdge(6, 4, 10);
        graph.addEdge(6, 5, 3);

        graph.addEdge(7, 8, 4);
        graph.addEdge(7, 9, 6);
        graph.addEdge(7, 4, 8);
        graph.addEdge(7, 6, 6);

        graph.addEdge(8, 9, 7);
        graph.addEdge(8, 4, 9);
        graph.addEdge(8, 7, 4);

        graph.addEdge(9, 6, 7);
        graph.addEdge(9, 7, 6);
        graph.addEdge(9, 8, 7);

        System.out.println();
        graph.getMSTPrim();

        System.out.println();
        graph.Show();
         
        //Memanggil Method prinjADjMatrix
        System.out.println("Adj Matrix : ");
        graph.printAdjMatrix();

        //Memanggil Method BFS
        System.out.print("BFS Traversal: ");
        graph.bfs();
        System.out.println();

        //Memanggil Method DFS
        System.out.print("DFS Traversal: ");
        graph.dfs();
        System.out.println();


    }
}