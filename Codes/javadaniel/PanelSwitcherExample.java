package javadaniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelSwitcherExample extends JFrame {
    private JPanel panelContainer;
    private CardLayout cardLayout;

    public PanelSwitcherExample() {

        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout); 

        Panel1 panel1 = new Panel1(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContainer, "Panel 2");
            }
        });

        Panel2 panel2 = new Panel2(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContainer, "Panel 1");
            }
        });

        panelContainer.add(panel1, "Panel 1");
        panelContainer.add(panel2, "Panel 2");

        this.add(panelContainer);

        setTitle("Panel Switcher Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Create and display the frame
        SwingUtilities.invokeLater(() -> {
            PanelSwitcherExample example = new PanelSwitcherExample();
            example.setVisible(true);
        });
    }
}

