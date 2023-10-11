package BST;

import javax.swing.*;

public class Main {
    public static void main(String[] args) { // Membuat method main
        tree bst = new tree(); // Membuat objek Tree
        treeGUI gui = new treeGUI(bst);

        int[] dataList = { 60, 55, 100, 107, 67, 105, 57, 45, 59, 106, 43};
        int[] delList = { 100, 55, 60, 57, 67, 105, 106, 59};

        for (int i : dataList) {
            bst.insert(i);
        }
//        int cek = JOptionPane.showConfirmDialog(null, "Lanjut ke delete ?", "Warning", JOptionPane.YES_NO_OPTION);
//        if (cek == 1) {
//            System.exit(0);
//        }
//        System.out.println();
//        System.out.print("In-Order : ");
//        bst.inorder();
//        System.out.println("\nPost-Order");
//        bst.postorder();
//        System.out.println("\nPre-Order");
//        bst.preorder();


        for (int j : delList) {
            int status = JOptionPane.showConfirmDialog(null, "Delete " + j + " ?", "Warning", JOptionPane.YES_NO_OPTION);
            if (status == 1)
                break;
            if (bst.search(j)) {
                bst.deleteIter(j);
//                bst.delete(j);
                SwingUtilities.updateComponentTreeUI(gui.frame);
                JOptionPane.showMessageDialog(null, j + " berhasil dihapus");
                System.out.print("Hasil In-Order setelah " + j + " dihapus : ");
                bst.inorder();
                System.out.println();
            } else {
                System.out.println();
                JOptionPane.showMessageDialog(null, j + " Tidak ditemukan dan tidak dihapus");
            }
        }
        JOptionPane.showMessageDialog(null, "Delete node sudah selesai dijalankan", "Warning !", JOptionPane.ERROR_MESSAGE);
        gui.frame.dispose();


    }
}