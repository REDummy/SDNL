package AVLTree;

import javax.swing.*;

public class TestAVLTree {
    public static void main(String[] args) {
        // Create an AVL tree
        AVLTree<Integer> tree = new AVLTree<>(new Integer[]{});
        AVLtreeGUI temp = new AVLtreeGUI(tree);
        int[] dataList = {25, 20, 5, 34, 50, 30, 10};
        int[] delList = {34, 30, 50,5};
        //deklarasi array berisi nilai yang akan dimasukan ke tree

        for (int j : dataList) {//looping for
            int status = JOptionPane.showConfirmDialog(null, "Insert " + j + " ?", "Warning", JOptionPane.YES_NO_OPTION);
            if (status == 1)
                break;
            else {
                tree.insert(j);//memanggil method insert dari tree dengan parameter elemen ke j dari data list

                SwingUtilities.updateComponentTreeUI(temp.frame);
                JOptionPane.showMessageDialog(null, j + " berhasil di-insert");
                tree.root.print();

            }

        }
        JOptionPane.showMessageDialog(null, "Insert node sudah selesai dijalankan", "Warning !", JOptionPane.ERROR_MESSAGE);


        for (int j : delList) {
            int status = JOptionPane.showConfirmDialog(null, "Delete " + j + " ?", "Warning", JOptionPane.YES_NO_OPTION);
            if (status == 1)
                break;
            if (tree.search(j)) {
                tree.delete(j);
                SwingUtilities.updateComponentTreeUI(temp.frame);
                JOptionPane.showMessageDialog(null, j + " berhasil dihapus");
//                printTree(tree);
                tree.root.print();
            } else {
                System.out.println();
                JOptionPane.showMessageDialog(null, j + " Tidak ditemukan dan tidak dihapus");
            }
        }
        JOptionPane.showMessageDialog(null, "Delete node sudah selesai dijalankan", "Warning !", JOptionPane.ERROR_MESSAGE);
        temp.frame.dispose();


        System.out.print("\nTraverse the elements in the tree: ");
        for (int e : tree) {
            System.out.print(e + " ");
        }
    }

    public static void printTree(BST tree) {
        // Traverse tree
        System.out.print("\nInorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.getSize());
        System.out.println();
    }
}
