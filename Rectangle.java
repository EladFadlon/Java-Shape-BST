
public class Rectangle implements GeometricShape {

    //Fields:
    private double width;
    private double height;
    private Point anchor; //Top left corner point.

    //Constructors:
    public Rectangle(double width, double height, Point anchor) {
        if (width < 0|| height < 0)
            throw new IllegalArgumentException("Dimensions cannot be negative");
        this.width = width;
        this.height = height;
        this.anchor = anchor;
    }

    public Rectangle(double width, double height) {
        this(width, height, new Point(0, 0));
    }

    //Methods:
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (2 * width) + (2 * height);
    }

    @Override
    public boolean contains(Point p) {
        if (p == null)
            throw new IllegalArgumentException("p cannot be null");
        double rightBorder = anchor.getX() + width;
        double bottomBorder = anchor.getY() - height;
        return p.getX() <= rightBorder &&
                p.getY() >= bottomBorder &&
                p.getX() >= anchor.getX() &&
                p.getY() <= anchor.getY();
    }

    @Override
    public boolean contains(double x, double y) {
        return contains(new Point(x, y));
    }

    @Override
    public void move(double dx, double dy) {
        anchor.move(dx, dy);
    }

    @Override
    public void moveTo(Point p) {
        anchor.moveTo(p);
    }

    @Override
    public void moveTo(double x, double y) {
        anchor.moveTo(x, y);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Point getAnchor() {
        return anchor;
    }

    public String toString() {
        return "Rectangle : Width = " + width + ", Height = " + height + ", Anchor point = " + anchor.toString();
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }

}
