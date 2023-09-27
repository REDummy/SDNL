package Graph;

public class temp {
        public static void main(String[] args) {
            graph graph = new graph();//Instantiate objek
            for (int i = 0; i < 8; i++) {
                graph.addVertex((char) ('A' + i));
            }
            graph.addEdgeD(7, 0);
            graph.addEdgeD(3, 7);
            graph.addEdgeD(3, 4);
            graph.addEdgeD(2, 7);
            graph.addEdgeD(7, 6);
            graph.addEdgeD(7, 5);
            graph.addEdgeD(1, 4);
            graph.addEdgeD(1, 6);
            graph.addEdgeD(4, 5);


            //Memanggil Method prinjADjMatrix
            System.out.println("Adj Matrix : ");
            graph.printAdjMatrix();

            graph.topologicalSort();

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