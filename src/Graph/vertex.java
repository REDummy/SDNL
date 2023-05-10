package Graph;

public class vertex {
    private char label; //Atribut char Label vertex
    private boolean isVisited;//Atribut Boolean yang menunjukan apakah sudah visit ke vertex

    public vertex(char a) {//Constructor dengan param
        this.label = a;
    }

    public char getLabel() {//Method getter label dari vertex
        return label;
    }

    public void setLabel(char label) {//method Setter label
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        this.isVisited = visited;
    }
}
