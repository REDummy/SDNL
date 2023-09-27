package USIP2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GraphGUI extends JFrame {
    private JButton addVertexButton;
    private JButton addEdgeButton;
    private JButton displayButton;
    private JButton topologicalSortButton;
    private JTextArea outputArea;
    private graph graphObject;

    public GraphGUI() {
        graphObject = new graph();
        initializeComponents();
        addComponentsToFrame();
        registerListeners();
    }

    private void initializeComponents() {
        addVertexButton = new JButton("Add Vertex");
        addEdgeButton = new JButton("Add Edge");
        displayButton = new JButton("Display");
        topologicalSortButton = new JButton("Detect Deadlock");
        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
    }

    private void addComponentsToFrame() {
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel.add(addVertexButton);
        buttonPanel.add(addEdgeButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(topologicalSortButton);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void registerListeners() {
        addVertexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter vertex label:");
                if (input != null && !input.isEmpty()) {
                    char label = input.charAt(0);
                    graphObject.addVertex(label);
                    outputArea.append("Added vertex: " + label + "\n");
                }
            }
        });

        addEdgeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input1 = JOptionPane.showInputDialog("Enter source vertex label:");
                String input2 = JOptionPane.showInputDialog("Enter destination vertex label:");
                String weightStr = JOptionPane.showInputDialog("Enter the weight:");

                if (input1 != null && !input1.isEmpty() && input2 != null && !input2.isEmpty() && weightStr != null && !weightStr.isEmpty()) {
                    char source = input1.charAt(0);
                    char destination = input2.charAt(0);
                    int weight;
                    try {
                        weight = Integer.parseInt(weightStr);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(GraphGUI.this,
                                "Invalid weight. Please enter a numeric value.",
                                "Invalid Weight",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int sourceIndex = getIndexByLabel(source);
                    int destinationIndex = getIndexByLabel(destination);
                    if (sourceIndex != -1 && destinationIndex != -1) {
                        graphObject.addEdgeW(sourceIndex, destinationIndex, weight);
                        outputArea.append("Added edge: " + source + " -> " + destination + " (Weight: " + weight + ")\n");
                    } else {
                        outputArea.append("Invalid vertex labels!\n");
                    }
                }
            }
        });


        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder matrix = new StringBuilder();
                matrix.append("  ");
                for (int i = 0; i < graphObject.getnVerts(); i++) {
                    matrix.append((char) ('A' + i)).append("\t\t");
                }
                matrix.append("\n");
                for (int i = 0; i < graphObject.getnVerts(); i++) {
                    matrix.append((char) ('A' + i)).append(" ");
                    for (int j = 0; j < graphObject.getnVerts(); j++) {
                        if (j >= i && graphObject.adjMatrix[i][j] == 0) {
                            matrix.append("0\t\t");
                        } else {
                            matrix.append(graphObject.adjMatrix[i][j]).append("\t\t");
                        }
                    }
                    matrix.append("\n");
                }

                JTextArea matrixArea = new JTextArea(matrix.toString());
                matrixArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(matrixArea);

                JOptionPane.showMessageDialog(GraphGUI.this, scrollPane, "Adjacency Matrix", JOptionPane.PLAIN_MESSAGE);
            }
        });


        topologicalSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.append("Topological Sort: ");
                ArrayList<Integer> sortedVertices = graphObject.topologicalSort();
                if (sortedVertices != null) {
                    StringBuilder sortedLabels = new StringBuilder();
                    for (int i = 0; i < sortedVertices.size(); i++) {
                        char label = graphObject.listVer[sortedVertices.get(i)].getLabel();
                        sortedLabels.append(label).append(" ");
                    }
                    outputArea.append(sortedLabels.toString() +"\n");
                } else {
                    JOptionPane.showMessageDialog(GraphGUI.this,
                            "Error: Graph contains a cycle!\nDeadlock detected!",
                            "Cycle Detected",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    private int getIndexByLabel(char label) {
        for (int i = 0; i < graphObject.getnVerts(); i++) {
            if (graphObject.listVer[i].getLabel() == label) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GraphGUI gui = new GraphGUI();
                gui.setTitle("Graph GUI");
                gui.setSize(400, 300);
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setVisible(true);
            }
        });
    }
}

