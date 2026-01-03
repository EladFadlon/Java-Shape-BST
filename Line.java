
public class Line implements GeometricShape {
    //Fields:
    private final Point p1;
    private final Point p2;
    private final Point anchor; //the point representing the middle of the Line.

    //Constructors
    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        double anchorX = (p1.getX() + p2.getX()) / 2;
        double anchorY = (p1.getY() + p2.getY()) / 2;
        this.anchor = new Point(anchorX, anchorY);
    }

    //Methods:
    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

    public double getLength() {
        return p1.distanceTo(p2);
    }

    @Override
    public boolean contains(Point p) {
        double epsilon = 0.001;
        return Math.abs(p1.distanceTo(p) + p.distanceTo(p2) - getLength()) < epsilon;
    }

    @Override
    public boolean contains(double x, double y) {
        return contains(new Point(x, y));
    }

    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
        anchor.move(dx, dy);
    }

    @Override
    public void moveTo(Point p) {
        double dx = p.getX() - anchor.getX();
        double dy = p.getY() - anchor.getY();
        this.move(dx, dy);
    }

    @Override
    public void moveTo(double x, double y) {
        moveTo(new Point(x, y));
    }

    public String toString() {
        return "Line : Top end point = " + p1.toString() + " Bottom end point = " + p2.toString() + " Middle point = " + anchor.toString();
    }

    @Override
    public String getShapeName() {
        return "Line";
    }

    public Point getP2() {
        return p2;
    }

    public Point getP1() {
        return p1;
    }
}
