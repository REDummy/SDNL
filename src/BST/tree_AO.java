package BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class tree_AO {

    private treeNode root;//atribut private treeNode

    public tree_AO(

    ) {
        root = null;
    }//constructor default

    public tree_AO(treeNode node) {
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

        public void bfs() {
            Queue<treeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                treeNode tempNode = queue.poll();
                System.out.print(tempNode.getiData() + " ");
                if (tempNode.getLeft() != null) {
                    queue.add(tempNode.getLeft());
                }
                if (tempNode.getRight() != null) {
                    queue.add(tempNode.getRight());
                }
            }
        }

        public void dfsPreorder() {
            Stack<treeNode> stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }
            while (!stack.isEmpty()) {
                treeNode tempNode = stack.pop();
                System.out.print(tempNode.getiData() + " ");
                if (tempNode.getRight() != null) {
                    stack.push(tempNode.getRight());
                }
                if (tempNode.getLeft() != null) {
                    stack.push(tempNode.getLeft());
                }
            }
        }

        public void dfsInorder() {
            Stack<treeNode> stack = new Stack<>();
            treeNode current = root;
            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.getLeft();
                }
                current = stack.pop();
                System.out.print(current.getiData() + " ");
                current = current.getRight();
            }
        }

        public void dfsPostorder() {
            Stack<treeNode> stack1 = new Stack<>();
            Stack<treeNode> stack2 = new Stack<>();
            if (root != null) {
                stack1.push(root);
            }
            while (!stack1.isEmpty()) {
                treeNode tempNode = stack1.pop();
                stack2.push(tempNode);
                if (tempNode.getLeft() != null) {
                    stack1.push(tempNode.getLeft());
                }
                if (tempNode.getRight() != null) {
                    stack1.push(tempNode.getRight());
                }
            }
            while (!stack2.isEmpty()) {
                treeNode tempNode = stack2.pop();
                System.out.print(tempNode.getiData() + " ");
            }
        }
    }



