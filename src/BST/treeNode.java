package BST;//deklarasi package
//Antonius Miquel - 215314181
public class treeNode {//deklarasi class
    private int iData;//atribut private integer data node
    private treeNode left, right;//atribut private treeNode left dan right

    public treeNode(int data) {//constructor dengan parameter int
        this.iData = data;//set int dari parameter ke iData
        left = null;//set null untuk left
        right = null;//set null untuk right
    }

    public int getiData() {//method getter
        return iData;//return atribut
    }

    public void setiData(int iData) {//method setter
        this.iData = iData;//set parameter ke atribut
    }

    public treeNode getLeft() {//method getter
        return left;//return atribut
    }

    public void setLeft(treeNode left) {//method setter
        this.left = left;//set parameter ke atribut
    }

    public treeNode getRight() {//method getter
        return right;//return atribut
    }

    public void setRight(treeNode right) {//method setter
        this.right = right;//set parameter ke atribut
    }

}
