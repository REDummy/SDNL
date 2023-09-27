package USIP2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class  graph {

    private static final int MAX_VER = 10; // Maximum Vertexrtex
    protected final int[][] adjMatrix; // Atribut AdjMatrix yang berupa array 2D
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

    public void addEdge(int i, int j) {// Method menambahkan edge ke adj Matrix
        adjMatrix[i][j] = 1;
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
                    System.out.print("0\t\t");
                } else {
                    System.out.print(adjMatrix[i][j] + "\t\t");
                }
            }
            System.out.println();
        }
        this.reset();
    }

    // Method for topological sorting
    public ArrayList<Integer> topologicalSort() {
        int[] inDegree = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] > 0) {
                    inDegree[j]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        ArrayList<Integer> sortedVertices = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            sortedVertices.add(vertex);
            count++;
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[vertex][i] > 0) {
                    if (--inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        if (count != numVertices) {
            return null; // Cycle detected
        }

        return sortedVertices;
    }

}
