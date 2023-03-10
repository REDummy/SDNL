package BST;//deklarasi package

import java.util.LinkedList;//import linkedlist
import java.util.Queue;//import queue

//Antonius Miquel - 215314181
public class tree {//deklarasi class
    private treeNode root;//atribut private treeNode

    public tree(
            
    ) {
        root = null;
    }//constructor default

    public tree(treeNode node) {
        root = node;
    }//construtor dengan parameter

    public void insert(int data) {//method public void untuk insert node dengan parameter integer
        this.root = insert(this.root, data);//simpan return node dari method insert ke root
    }


    private treeNode insert(treeNode node, int data) {
        //method private insert dengan parameter treeNode dan integer
        if (node == null)//mengecek apakah node kosong(null)
            node = new treeNode(data);//membuat node baru jika kosong(null)
        else {//jika node tidak null
            if (data <= node.getiData())//jika data kurang dari sama dengan nilai dari node
                node.setLeft(insert(node.getLeft(), data));
            //set left dari node dengan node return dari method insert dengan parameter left dari node dan data
            else//jika data lebih dari nilai node
                node.setRight(insert(node.getRight(), data));
            //set right dari node dengan node return dari method insert dengan parameter right dari node dan data
        }
        return node;//return node
    }


    public boolean search(int data){//method search dengan parameter int
        return search(this.root,data);//return search dengan paramater treeNode root dan data
    }
    private boolean search(treeNode node, int value) {
        //method private search dengan param treeNode dan integer

        if (node == null) {//jika node kosong
            return false;//return falsse
        }
        if (node.getiData() == value) {//jika data dari node sama dengan nilai yang dicari
            return true;//return true
        }
        if (value < node.getiData()) {//jika nilai yang di cari lebih kecil dari data node
            return search(node.getLeft(), value);
            //return method search dengan param left dari node dan nilai yang di cari
        }
        else if (value > node.getiData()) {//jika nilai yang di cari lebih besar dari data node
            return search(node.getRight(), value);
            //return method search dengan param right dari node dan nilai yang di cari
        }

        return false;//return false
    }

    public Boolean delete(int data){
        //method public boolean untuk delete node dengan parameter integer
        if (!search(data)) {//jika hasil search false
            return false;//return false
        }else{
            root = deleteRec(this.root,data);
            //simpan hasil dari method deleteRec dengan param root dan data ke root
        }
        return (root!=null);//return true ketika root tidak null
    }
    private treeNode deleteRec(treeNode root, int data)
    //method private treeNode untuk delete node secara rekursif dengan parameter treeMpde dam integer
    {

        if (root == null)//jika node kosong atau null
            return root;//return  root


        if (data < root.getiData())//jika nilai data kurang dari nilai node
            root.setLeft(deleteRec(root.getLeft(), data));
        //set left dari node dengan hasil dari method deleteRec dengan parameter left dari node dandata
        else if (data > root.getiData())//jika nilai data lebih dari nilai node
            root.setRight(deleteRec(root.getRight(), data));
            //set right dari node dengan hasil dari method deleteRec dengan parameter right dari node dandata

        else {//jika nilai node sama dengan data
            if (root.getLeft() == null)//jika left dari node kosong
                return root.getRight();//return right dari node
            else if (root.getRight() == null)//jika right dari node kosong
                return root.getLeft();//return left dari node

            //jika memiliki anak 2
            //set data node dengan minValue dari right subtree
            root.setiData(minValue(root.getRight()));

            //set right dari node dengan hasil dari method deleteRec dengan parameter kanan dari node dan nilai node
            root.setRight(deleteRec(root.getRight(), root.getiData()));
        }

        return root;//return node
    }

    public int minValue(treeNode root)//method mencari successor
    {
        int minv = root.getiData();//simpan data dari node ke minv
        while (root.getLeft() != null) {//selama masih ada left dari node
            minv = root.getLeft().getiData();//simpan data left dari node ke minv
            root = root.getLeft();//update node dengan left dari node
        }
        return minv;//return nilai minv
}

    public void preorder() {//method public preorder
        preorder(root);//memanggil method preorder dari root
    }
    private void preorder(treeNode temp) {//method traversal preorder
        if (temp != null) {//jika node tidak null
            System.out.print(temp.getiData() + " ");//cetak nilai dari node
            preorder(temp.getLeft());//memanggil method preOrder dengan parameter left dari node
            preorder(temp.getRight());//memanggil method preOrder dengan parameter right dari node
        }
    }

    public void inorder() {//method public preorder
        inorder(root);//memanggil method preorder dari root
    }
    private void inorder(treeNode temp) {//method traversal preorder
        if (temp != null) {//jika node tidak null
            inorder(temp.getLeft());//memanggil method preOrder dengan parameter left dari node
            System.out.print(temp.getiData() + " ");//cetak nilai dari node
            inorder(temp.getRight());//memanggil method preOrder dengan parameter right dari node
        }
    }

    public void postorder() {//method public preorder
        postorder(root);//memanggil method preorder dari root
    }
    private void postorder(treeNode temp) {//method traversal preorder
        if (temp != null) {//jika node tidak null
            postorder(temp.getLeft());//memanggil method preOrder dengan parameter left dari node
            postorder(temp.getRight());//memanggil method preOrder dengan parameter right dari node
            System.out.print(temp.getiData() + " ");//cetak nilai dari node
        }
    }
    public void levelOrder() {//method public level order
        Queue<treeNode> queue = new LinkedList<>();//deklarasi linked list bertipe treeNode dengan nama queue
        queue.add(root);//menambahkan root ke queue dan otomatis menjadikan head
        while (!queue.isEmpty()) {//selama queue tidak kosong

            treeNode tempNode = queue.poll();//deklarasi treeNode tempNode dengan method poll dari queue
            System.out.print(tempNode.getiData() + " ");//cetak nilai dari tempNode
            if (tempNode.getLeft() != null) {//jika left dari tempNode tidak kosong
                queue.add(tempNode.getLeft());//add left dari tempNode ke queue
            }
            if (tempNode.getRight() != null) {//jika right dari tempNode tidak kosong
                queue.add(tempNode.getRight());//add right dari tempNode ke queue
            }
        }

    }
        public static void main(String[] args) {//main
        tree bst = new tree();//deklarasi objek tree

        System.out.println("Binary Search Tree Test\n");//cetak teks

        int[] dataList = {56, 30, 40, 22, 70, 95, 60, 65, 11, 16, 63, 67, 3, 37, 88};
        int[] delList = {100, 63, 65, 60, 95, 88, 67, 70, 56, 22, 16, 11, 3, 30, 40, 37};
        //deklarasi array berisi nilai yang akan dimasukan ke tree

        for (int j : dataList) {//looping for
            bst.insert(j);//memanggil method insert dari tree dengan parameter elemen ke j dari data list
        }
/*
        for(int i : delList){
            System.out.println("Deleting "+i+" from tree");
            if (bst.delete(i)){
                System.out.println(i+" berhasil di hapus dari tree");
            }else{
                System.out.println(i+" tidak ada dalam tree");
            }
            System.out.print("InOrder : ");
            bst.inorder();
            System.out.println("");
        }
        */
    }

    public treeNode getRoot() {
        return root;
    }
}
