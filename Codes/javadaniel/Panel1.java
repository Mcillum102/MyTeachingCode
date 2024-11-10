package javadaniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Panel1 extends JPanel {
    private JButton switchButton;

    public Panel1(ActionListener switchListener) {
        setBackground(Color.LIGHT_GRAY);
        switchButton = new JButton("Go to Panel 2");

        // Add ActionListener passed from the main class
        switchButton.addActionListener(switchListener);

        // Add components to this panel
        add(switchButton);
    }
}
