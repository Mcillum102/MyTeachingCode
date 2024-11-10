package simulatortest;

import javax.swing.*;
import java.awt.*;

public class SolarSystemSimulator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        InstructionPanel instructionPanel = new InstructionPanel(cardLayout, mainPanel);

        Simulation simulation = new Simulation();

        mainPanel.add(instructionPanel, "Instructions");
        mainPanel.add(simulation, "Simulation");

        frame.add(mainPanel);
        frame.setVisible(true);

        cardLayout.show(mainPanel, "Instructions");

        Timer timer = new Timer(16, e -> {
            if (mainPanel.isAncestorOf(simulation) && simulation.isShowing()) {
                simulation.update();
            }
        });
        timer.start();
    }
}
