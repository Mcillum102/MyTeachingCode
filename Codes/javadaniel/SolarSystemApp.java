package javadaniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolarSystemApp extends JFrame implements ActionListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public SolarSystemApp() {
        setTitle("Solar System Simulator");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel solarSystemPanel = new SolarSystemSimulator();
        JPanel instructionPanel = createInstructionPanel();

        cardPanel.add(solarSystemPanel, "Solar System");
        cardPanel.add(instructionPanel, "Instructions");

        add(cardPanel);

        cardLayout.show(cardPanel, "Solar System");

        setVisible(true);
    }

    // Creates the instruction panel
    private JPanel createInstructionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Add instructions label
        JLabel instructions = new JLabel("<html><h1>Instructions</h1><ul>"
                + "<li>Watch the planets orbit around the Sun.</li>"
                + "<li>Earth and Mars will orbit in circular paths.</li>"
                + "<li>Use the button below to start the simulation.</li>"
                + "</ul></html>", JLabel.CENTER);
        panel.add(instructions, BorderLayout.CENTER);

        // Add a button to switch to the simulation
        JButton startSimulationButton = new JButton("Start Simulation");
        startSimulationButton.addActionListener(e1 -> cardLayout.show(cardPanel, "Solar System"));
        panel.add(startSimulationButton, BorderLayout.SOUTH);

        return panel;
    }
    
    public static void main(String[] args) {
        new SolarSystemApp();
    }

    // The SolarSystemSimulator class that extends JPanel to draw the simulation
    static class SolarSystemSimulator extends JPanel implements ActionListener {
        private Timer timer;
        private Image sunImage;
        private Image earthImage;
        private Image marsImage;
        private double earthAngle = 0;
        private double marsAngle = 0;

        public SolarSystemSimulator() {
            // Load images
            sunImage = new ImageIcon("sun.png").getImage();
            earthImage = new ImageIcon("earth.png").getImage();
            marsImage = new ImageIcon("mars.png").getImage();

            // Set up the timer for animation
            timer = new Timer(16, this);
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Get the center of the JPanel
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            // Draw the Sun
            int sunSize = 80;
            g2d.drawImage(sunImage, centerX - sunSize / 2, centerY - sunSize / 2, sunSize, sunSize, this);

            // Draw the Earth and Mars with orbits
            int earthOrbitRadius = 150;
            int marsOrbitRadius = 220;
            double earthX = centerX + earthOrbitRadius * Math.cos(earthAngle) - 25;
            double earthY = centerY + earthOrbitRadius * Math.sin(earthAngle) - 25;
            double marsX = centerX + marsOrbitRadius * Math.cos(marsAngle) - 25;
            double marsY = centerY + marsOrbitRadius * Math.sin(marsAngle) - 25;

            // Draw Earth and Mars
            g2d.drawImage(earthImage, (int) earthX, (int) earthY, 50, 50, this);
            g2d.drawImage(marsImage, (int) marsX, (int) marsY, 50, 50, this);

            // Update the angles for the orbit
            earthAngle += 0.01;
            marsAngle += 0.008;
        }

        @Override
        public void actionPerformed(ActionEvent e1) {
            // Redraw the panel
            repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cardLayout.show(cardPanel, "Solar System");
    }
}
