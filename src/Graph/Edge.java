package Graph;

public class Edge {
    private int vertexA, vertexB, weight;//Atribut integer

    public Edge(int verA, int verB) {//Constructor dengan param
        this.vertexA = verA;
        this.vertexB = verB;
    }

    public Edge(int verA, int verB, int weight) {//Constructor dengan param
        this.vertexA = verA;
        this.vertexB = verB;
        this.weight = weight;
    }

    public int getVertexA() {//Method getter
        return vertexA;
    }

    public void setVertexA(int vertexA) {//Method setter
        this.vertexA = vertexA;
    }

    public int getVertexB() {//Method getter
        return vertexB;
    }

    public void setVertexB(int vertexB) {//Method setter
        this.vertexB = vertexB;
    }

    public int getWeight() {//Method getter
        return weight;
    }

    public void setWeight(int weight) {//Method setter
        this.weight = weight;
    }
}
