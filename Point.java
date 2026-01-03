public class Point {
    //Fields:
    private double x;
    private double y;

    //Constructors:
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    //Methods:
    //Moves the shape by adding delta x to the x field , and delta y to the y field.
    public void move(double dx, double dy) {
        this.y += dy;
        this.x += dx;
    }

    //Moves the point to the given point.
    public void moveTo(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    //Moves the point to the given coordinates.
    public void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Point p) {
        return Math.sqrt(((p.x - x) * (p.x - x)) + ((p.y - y) * (p.y - y)));
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Point) {
            Point otherP = (Point) other;
            result = (x == otherP.x && y == otherP.y);
        }
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
