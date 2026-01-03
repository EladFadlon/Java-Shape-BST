
public class Circle implements GeometricShape {
    //Fields:
    private double radius;
    private Point center;

    //Constructors:
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    //Methods:
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean contains(Point p) {
        double distanceFromCenter = center.distanceTo(p);
        return radius >= distanceFromCenter;
    }

    @Override
    public boolean contains(double x, double y) {
        return contains(new Point(x, y));
    }

    public void setRadius(double radius) {
        if (radius < 0)
            throw new IllegalArgumentException("input radius cannot be negative");
        this.radius = radius;
    }

    @Override
    public void move(double dx, double dy) {
        this.center.move(dx, dy);
    }

    @Override
    public void moveTo(Point p) {
        this.center.moveTo(p);
    }

    @Override
    public void moveTo(double x, double y) {
        this.center.moveTo(x, y);
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle : Radius = " + radius + " Center point = " + center.toString();
    }

    @Override
    public String getShapeName(){
        return "Circle";
    }
}
