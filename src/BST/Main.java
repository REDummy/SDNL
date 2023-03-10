package BST;
import javax.swing.*;
public class Main {
    public static void main(String[] args) { // Membuat method main
        tree bst = new tree(); // Membuat objek Tree
        treeGUI gui = new treeGUI(bst);

        int[] barisInsert = {56, 30, 40, 22, 70, 95, 60, 65, 11, 16, 63, 67, 3, 37, 88};

        for (int i : barisInsert) {
            bst.insert(i);
        }
        int cek = JOptionPane.showConfirmDialog(null, "Lanjut ke delete ?", "Warning", JOptionPane.YES_NO_OPTION);
        if (cek == 1) {
            System.exit(0);
        }
        System.out.println();
        System.out.print("In-Order : ");
        bst.inorder();
        System.out.println();

        int[] barisNilai = {100, 63, 65, 60, 95, 88, 67, 70, 56, 22, 16, 11, 3, 30, 40, 37};

        for (int j : barisNilai) {
            int status = JOptionPane.showConfirmDialog(null, "Delete " + j + " ?", "Warning", JOptionPane.YES_NO_OPTION);
            if (status == 1)
                break;
            if (bst.search(j)) {
                bst.delete(j);
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