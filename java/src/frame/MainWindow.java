package frame;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame{
    private JPanel mainContainer;
    private JPanel adderContainer;
    private JTextField adderText;
    private JButton adderButton;
    private JScrollPane toDoPane;

    public MainWindow(){
        this.add(mainContainer);

        JPanel itemContainer = new JPanel();
        itemContainer.setLayout(new BoxLayout(itemContainer, BoxLayout.Y_AXIS));
        itemContainer.setBackground(Color.RED);
        toDoPane.setPreferredSize(new Dimension(475,360));
        toDoPane.setMinimumSize(new Dimension(475,360));
        toDoPane.setMaximumSize(new Dimension(475,360));
        toDoPane.setViewportView(itemContainer);

        // when button is clicked, new item (wrapped in a JPanel) is added to JScrollPane
        adderButton.addActionListener(e -> {
            String toDoItemInput = adderText.getText();
            if(toDoItemInput.length() == 0){
                JOptionPane.showMessageDialog(adderText, "No input of to-do-item");
                return;
            }
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
            itemPanel.setMinimumSize(new Dimension(475, 40));
            itemPanel.setMaximumSize(new Dimension(475, 40));
            JCheckBox toDoItem = new JCheckBox(toDoItemInput);
            toDoItem.setMaximumSize(new Dimension(475, 40));

            // handle too-long item text
            if(toDoItemInput.length() > 100){
                toDoItem.setText(toDoItemInput.substring(0, 100) + "...");
                toDoItem.setToolTipText(toDoItemInput);
            }
            itemPanel.add(toDoItem);
            itemContainer.add(itemPanel);

            //reset state
            adderText.setText("");
            // 2 methods to update scroll pane view
            toDoPane.repaint();
            toDoPane.revalidate();
        });



        this.setTitle("TO-DO LIST");
        this.setSize(new Dimension(490, 432));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
