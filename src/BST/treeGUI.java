package BST;

import javax.swing.*;
import java.awt.*;

public class treeGUI extends JPanel {
    private tree tree;
    public JFrame frame;

    public treeGUI(tree tree) {
        this.tree = tree;
        frame = new JFrame("Binary Search Tree Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(this);
        frame.setVisible(true);

    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawNode(g2, tree.getRoot(), getWidth() / 2, 50, getWidth() / 4);
    }

    private void drawNode(Graphics2D g2, treeNode node, int x, int y, int spread) {
        if (node == null) {
            return;
        }
        g2.setColor(Color.BLACK);
        g2.fillOval(x - 15, y - 15, 30, 30);
        g2.setColor(Color.WHITE);
        g2.drawString(Integer.toString(node.getiData()), x - 5, y + 5);
        if (node.getLeft() != null) {
            int x2 = x - spread;
            int y2 = y + 50;
            g2.setColor(Color.BLACK);
            g2.drawLine(x, y, x2, y2);
            drawNode(g2, node.getLeft(), x2, y2, spread / 2);
        }
        if (node.getRight() != null) {
            int x2 = x + spread;
            int y2 = y + 50;
            g2.setColor(Color.BLACK);
            g2.drawLine(x, y, x2, y2);
            drawNode(g2, node.getRight(), x2, y2, spread / 2);
        }
    }

}