package simulatortest;

public class Planet {
    double mass;
    double radius;
    double x, y;
    double vx, vy;

    public Planet(double mass, double radius, double x, double y, double vx, double vy) {
        this.mass = mass;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void updatePosition(double timeStep) {
        this.x += vx * timeStep;
        this.y += vy * timeStep;
    }
}

