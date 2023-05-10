package AdjMatr;
class Vertex {
    public String label;

    public Vertex(String label) {
        this.label = label;
    }
}

class Graph {
    private final int MAX_VERTS = 50;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private int jumVert;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        jumVert = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public Graph(int n) {
        vertexList = new Vertex[n];
        adjMatrix = new int[n][n];
        jumVert = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(String label) {
        vertexList[jumVert++] = new Vertex(label);
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void tampilMatrik() {
        for (int i = 0; i < jumVert; i++) {
            for (int j = 0; j < jumVert; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getJumVert() {
        return jumVert;
    }
}
