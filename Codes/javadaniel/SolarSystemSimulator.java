package javadaniel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolarSystemSimulator extends JPanel implements ActionListener {

    private Image sunImage;
    private Image mercuryImage;
    private Image venusImage;
    private Image earthImage;

    private double angleMercury = 0;
    private double angleVenus = 0;
    private double angleEarth = 0;
    private final Timer timer;

    public SolarSystemSimulator() {

        sunImage = new ImageIcon("/Users/shuhancao/Desktop/TestSolar/Free-PNG-Picture.png").getImage();
        mercuryImage = new ImageIcon("/Users/shuhancao/Desktop/TestSolar/Free-PNG-Picture.png").getImage();
        venusImage = new ImageIcon("/Users/shuhancao/Desktop/TestSolar/Free-PNG-Picture.png").getImage();
        earthImage = new ImageIcon("/Users/shuhancao/Desktop/TestSolar/Free-PNG-Picture.png").getImage();

        sunImage = sunImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);  
        mercuryImage = mercuryImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        venusImage = venusImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);   
        earthImage = earthImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH);    

        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        g2d.drawImage(sunImage, getWidth() / 2 - sunImage.getWidth(null) / 2,  getHeight() / 2 - sunImage.getHeight(null) / 2, null);

        drawPlanet(g2d, centerX, centerY, 100, mercuryImage, angleMercury);

        drawPlanet(g2d, centerX, centerY, 150, venusImage, angleVenus);

        drawPlanet(g2d, centerX, centerY, 200, earthImage, angleEarth);
    }

    private void drawPlanet(Graphics2D g2d, int centerX, int centerY, int orbitRadius, Image planetImage, double angle) {
        int planetX = centerX + (int) (orbitRadius * Math.cos(angle)) - planetImage.getWidth(null) / 2;
        int planetY = centerY + (int) (orbitRadius * Math.sin(angle)) - planetImage.getHeight(null) / 2;

        g2d.drawImage(planetImage, planetX, planetY, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angleMercury += 0.05;
        angleVenus += 0.03;   
        angleEarth += 0.02; 


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Solar System Simulator with Images");
        SolarSystemSimulator simulator = new SolarSystemSimulator();

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(simulator);
        frame.setVisible(true);
    }
}
