package javadaniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Panel2 extends JPanel {
    private JButton switchButton;

    public Panel2(ActionListener switchListener) {
        setBackground(Color.CYAN);
        switchButton = new JButton("Go to Panel 1");

        // Add ActionListener passed from the main class
        switchButton.addActionListener(switchListener);

        // Add components to this panel
        add(switchButton);
    }
}

