package BST;

public class main_AO {
    public static void main(String[] args) {
        tree_AO bst = new tree_AO();

        int[] barisInsert = {47, 22, 80, 12, 30, 60, 100, 52, 75};

        for (int i : barisInsert) {
            bst.insert(i);
        }
        System.out.println("Breadth-First Search:");
        bst.bfs();
        System.out.println("\nDepth-First Search Preorder:");
        bst.dfsPreorder();
        System.out.println("\nDepth-First Search Inorder:");
        bst.dfsInorder();
        System.out.println("\nDepth-First Search Postorder:");
        bst.dfsPostorder();
    }
}