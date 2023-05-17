package Graph;

public class main {
    public static void main(String[] args) {
        graph graph = new graph();//Instantiate objek
        for (int i = 0; i < 6; i++) {
            graph.addVertex((char) ('A' + i));
        }
        graph.addEdgeW(0, 1,50);
        graph.addEdgeW(0, 2,30);
        graph.addEdgeW(0, 3,100);
        graph.addEdgeW(0, 5,10);
        graph.addEdgeW(1, 2,5);
        graph.addEdgeW(2, 1,5);
        graph.addEdgeW(3, 2,50);
        graph.addEdgeW(3, 1,20);
        graph.addEdgeW(4, 3,15);
        graph.addEdgeW(4, 5,15);
        graph.addEdgeW(5, 3,10);

        graph.shortestPathDijkstra(4);


        //Memanggil Method prinjADjMatrix
        System.out.println("Adj Matrix : ");
        graph.printAdjMatrix();

//        graph.topologicalSort();

//        System.out.println();
//        graph.getMSTPrim();
//
//        System.out.println();
//        graph.Show();
//
//
//        //Memanggil Method BFS
//        System.out.print("BFS Traversal: ");
//        graph.bfs();
//        System.out.println();
//
//        //Memanggil Method DFS
//        System.out.print("DFS Traversal: ");
//        graph.dfs();
//        System.out.println();


    }
}