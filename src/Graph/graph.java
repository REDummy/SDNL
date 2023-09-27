package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class graph {

    private static final int MAX_VER = 10; // Maximum Vertex
    private final int[][] adjMatrix; // Atribut AdjMatrix yang berupa array 2D
    public vertex[] listVer; // Atribut listVer yang berupa array dari vertex
    private int numVertices; // Atribut jumlah vertex

    // Default Constructor
    public graph() {
        listVer = new vertex[MAX_VER];
        adjMatrix = new int[MAX_VER][MAX_VER];
        numVertices = 0;

        for (int i = 0; i < MAX_VER; i++) {
            for (int j = 0; j < MAX_VER; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public int getnVerts() {// Method public int untuk get jumlah vertex
        return numVertices;
    }

    public void addVertex(char label) {//Method void untuk menambahkan Vertex
        listVer[numVertices++] = new vertex(label);
    }

    public void displayVertex(int temp) {//Method Print vertex yang ada
        System.out.println(listVer[temp].getLabel());
    }

    public void addEdgeW(int i, int j, int k) {// Method menambahkan edge ke adj Matrix

        adjMatrix[i][j] = k;
    }

    public void addEdgeD(int i, int j) {// Method menambahkan edge ke adj Matrix
        adjMatrix[i][j] = 1;
    }

    public void addEdge(int i, int j) {// Method menambahkan edge ke adj Matrix
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void dfs() {//Method Traversal DFS
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (!listVer[temp].isVisited()) {
                System.out.print(listVer[temp].getLabel() + ", ");
                listVer[temp].setVisited(true);
            }
            for (int i = numVertices - 1; i >= 0; i--) {
                if (adjMatrix[temp][i] >= 1 && !listVer[i].isVisited()) {
                    stack.push(i);
                }

            }
        }
    }


    public void bfs() {//Method Traversal BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!listVer[temp].isVisited()) {
                System.out.print(listVer[temp].getLabel() + ", ");
                listVer[temp].setVisited(true);
            }
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[temp][i] >= 1 && !listVer[i].isVisited()) {
                    queue.add(i);
                }
            }
        }
        this.reset();
    }

    public void reset() {//Method reset boolean visited pada vertex
        for (int i = 0; i < numVertices; i++) {
            listVer[i].setVisited(false);
        }
    }


    public void printAdjMatrix() {
        System.out.print("  ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print((char) ('A' + i) + "\t\t");
        }
        System.out.println();
        for (int i = 0; i < numVertices; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < numVertices; j++) {
                if ((j >= i && adjMatrix[i][j] == 0)) {
                    System.out.print("0 ");
                } else {
                    System.out.print(adjMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        this.reset();
    }


    private int indexVertex(char c) {// Method menghitung index  vertex
        for (int i = 0; i <= numVertices; i++) {
            if (listVer[i].getLabel() == c) {
                return i;
            }
        }
        return -1;
    }


    public void Show() {//Method cetak edge antar vertex
        for (int i = 0; i < numVertices; i++) {
            System.out.println();
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] == 0 || adjMatrix[i][j] == -1) {
                    System.out.print("");
                } else {
                    System.out.println(listVer[i].getLabel() + "- " + listVer[j].getLabel() + " , Weight = " + adjMatrix[1][j]);

                }
            }
        }
    }


    public ArrayList<Edge> getPrimEdges() {
        this.reset();
        ArrayList<Edge> primEdge = new ArrayList<Edge>();
        ArrayList<Integer> primVer = new ArrayList<Integer>();

        int seed = indexVertex('G');
        primVer.add(seed);
        listVer[seed].setVisited(true);
        while (primVer.size() < numVertices) {
            int tempMinWeight = Integer.MAX_VALUE;
            int tempMinIndekVertexI = -1;
            int tempMinIndekVertexJ = -1;
            for (int i = 0; i < primVer.size(); i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (adjMatrix[primVer.get(i)][j] > 0 && !listVer[j].isVisited() && adjMatrix[primVer.get(i)][j] < tempMinWeight) {
                        tempMinWeight = adjMatrix[primVer.get(i)][j];
                        tempMinIndekVertexI = primVer.get(i);
                        tempMinIndekVertexJ = j;

                    }

                }

            }
            primVer.add(tempMinIndekVertexJ);
            listVer[tempMinIndekVertexJ].setVisited(true);
            primEdge.add(new Edge(tempMinIndekVertexI, tempMinIndekVertexJ, tempMinWeight));
        }
        return primEdge;

    }

    public void getMSTPrim() {//Method untuk mencari MST dengan algoritma Prim
        ArrayList<Edge> edge = getPrimEdges();
        int total = 0;
        for (int i = 0; i < edge.size(); i++) {
            System.out.println("(" + listVer[edge.get(i).getVertexA()].getLabel() + ", " + listVer[edge.get(i).getVertexB()].getLabel() + ") =" + edge.get(i).getWeight());
            total = total + edge.get(i).getWeight();
        }
        System.out.println("Total Minimum Spanning tree  =" + total);
        this.reset();
    }

    // Method for topological sorting
    public void topologicalSort() {
        int[] inDegree = new int[numVertices]; // Array untuk menyimpan vertex dengan weight
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] > 0) {
                    inDegree[j]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>(); // Queue untuk menyimpan vertex tanpa weight
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0; // Counter
        ArrayList<Integer> sortedVertices = new ArrayList<>(); // List untuk meyimpan vertex yang disimpan
        while (!queue.isEmpty()) { //Selama queue tidak kosong
            int vertex = queue.poll();//mengambil vertex dari queue menggunakan poll()
            sortedVertices.add(vertex);// menambahkannya ke dalam sortedVertices.
            count++;
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[vertex][i] > 0) {
                    if (--inDegree[i] == 0) {// mengurangi inDegree[i] jika terdapat edge dari vertex yang diproses ke vertex i.
                        //Jika inDegree[i] menjadi 0 setelah pengurangan, maka vertex i ditambahkan ke dalam queue.
                        queue.add(i);
                    }
                }
            }
        }
        if (count != numVertices) {//Jika count tidak sama dengan jumlah vertex maka ada cycle
            System.out.println("Error: Graph contains a cycle!");
            return;
        }
        System.out.print("Topological Sort: ");//Cetak label yang sudah di sortir
        for (int i = 0; i < sortedVertices.size(); i++) {
            System.out.print(listVer[sortedVertices.get(i)].getLabel() + " ");
        }
        System.out.println();
    }

    public void shortestPathDijkstra(int startVertex) {
        int[] dist = new int[numVertices]; // Array untuk menyimpan weight/jarak
        boolean[] visited = new boolean[numVertices]; // Array menyimpan status visited
        int[] previous = new int[numVertices]; // Array untuk menyimpan array seblumnya

        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE; //set jarak ke maxium value dari integer
            visited[i] = false; // set visited ke false
            previous[i] = -1; // Set previous ke undefined
        }

        dist[startVertex] = 0; // Set jarak start vertex ke 0

        for (int count = 0; count < numVertices - 1; count++) {
            int current = findMinimumDistanceVertex(dist, visited); // Cari jarak minimum dari yang belum di visit
            visited[current] = true; // set vertex yang dikunjungi menjadi visited

            for (int neighbor = 0; neighbor < numVertices; neighbor++) {
                int edgeWeight = adjMatrix[current][neighbor];
                if (edgeWeight > 0) { // Jika ada edge
                    int newDistance = dist[current] + edgeWeight;
                    if (newDistance < dist[neighbor]) { // jika jarak baru lebih kecil dari jarak
                        dist[neighbor] = newDistance; // Update jarak
                        previous[neighbor] = current; // Update previous
                    }
                }
            }

        }

        // cetak shortest path
        for (int i = 0; i < numVertices; i++) {
            if (i != startVertex) {
                System.out.println("Shortest path from " +
                        listVer[startVertex].getLabel() + " to " + listVer[i].getLabel() + ":");
                if (dist[i] == Integer.MAX_VALUE) {
                    System.out.println("No path available.");
                } else {
                    printShortestPath(previous, i);
                    System.out.println("Distance: " + dist[i]);
                }
                System.out.println();
            }
        }
    }

    //Method mencari minimum distance dengan iterating over array
    private int findMinimumDistanceVertex(int[] dist, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && dist[v] < minDistance) {
                minDistance = dist[v];
                minVertex = v;
            }
        }

        return minVertex;
    }

    //Method cetak shortest path dengan stack
    private void printShortestPath(int[] previous, int destination) {
        Stack<Integer> stack = new Stack<>();
        int current = destination;
        while (previous[current] != -1) {
            stack.push(current);
            current = previous[current];
        }
        stack.push(current);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            System.out.print(listVer[vertex].getLabel() + " ");
        }
        System.out.println();
    }

}

