package simulatortest;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Simulation extends JPanel {
    ArrayList<Planet> planets;
    double timeStep = 0.01;

    public Simulation() {
        planets = new ArrayList<>();
        planets.add(new Planet(5.972e24, 20, 400, 300, 0, 0.1));
    }

    public void update() {
        for (Planet planet : planets) {
            planet.updatePosition(timeStep);
        }
        repaint(); 
    }

    // Draw planets
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        for (Planet planet : planets) {
            int x = (int) planet.x;
            int y = (int) planet.y;
            g.fillOval(x, y, (int) planet.radius, (int) planet.radius);
        }
    }
}
