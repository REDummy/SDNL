package AdjMatr;

// Adjacency Matrix representation in Java

    public class Graph {
        private int numVertices;
        private int numEdges;
        private int[][] adjacencyMatrix;

        public Graph() {
            this(0);
        }

        public Graph(int numVertices) {
            this.numVertices = numVertices;
            this.numEdges = 0;
            this.adjacencyMatrix = new int[numVertices][numVertices];
        }

        public void addEdge(int vertex1, int vertex2) {
            if (vertex1 < 0 || vertex1 >= numVertices || vertex2 < 0 || vertex2 >= numVertices) {
                throw new IllegalArgumentException("Invalid vertex number");
            }
            adjacencyMatrix[vertex1][vertex2] = 1;
            adjacencyMatrix[vertex2][vertex1] = 1;
            numEdges++;
        }

        public void removeEdge(int vertex1, int vertex2) {
            if (vertex1 < 0 || vertex1 >= numVertices || vertex2 < 0 || vertex2 >= numVertices) {
                throw new IllegalArgumentException("Invalid vertex number");
            }
            adjacencyMatrix[vertex1][vertex2] = 0;
            adjacencyMatrix[vertex2][vertex1] = 0;
            numEdges--;
        }

        public int getNumVertices() {
            return numVertices;
        }

        public int getNumEdges() {
            return numEdges;
        }

        public int[][] getAdjacencyMatrix() {
            return adjacencyMatrix;
        }
}