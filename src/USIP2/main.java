package USIP2;

public class main {
    public static void main(String[] args) {
        graph graph = new graph();//Instantiate objek
        //Membuat objek graph dengan nama variable graph
        for (int i = 0; i < 6; i++) {//looping dari i = o sampai i < 6 dengan increment i++
            graph.addVertex((char) ('A' + i));
        }
        graph.addEdgeW(0, 1,50);
        graph.addEdgeW(0, 2,30);
        graph.addEdgeW(0, 3,100);
        graph.addEdgeW(0, 5,10);
        graph.addEdgeW(3, 2,50);
        graph.addEdgeW(3, 1,20);
        graph.addEdgeW(4, 3,15);
        graph.addEdgeW(4, 5,15);
        graph.addEdgeW(5, 3,10);
        graph.addEdgeW(1, 2,5);
        //graph.addEdgeW(2, 1,5); // <- Cycle; disable for sorting

        //Memanggil Method prinjADjMatrix
        System.out.println("Adj Matrix : ");
        graph.printAdjMatrix();

        System.out.println(graph.topologicalSort());


    }
}