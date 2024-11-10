package simulatortest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionPanel extends JPanel {
    public InstructionPanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(new BorderLayout());

        JTextArea instructions = new JTextArea(
                "instructions test"
        );
        instructions.setEditable(false);
        add(instructions, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Simulation");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Simulation");
            }
        });

        add(startButton, BorderLayout.SOUTH);
    }
}
