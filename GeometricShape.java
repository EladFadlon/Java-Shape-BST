public interface GeometricShape {

    //Calculates the area of the shape and returns the double value of it.
    public double getArea();

    //Calculates the perimeter of the shape and returns the double value of it.
    public double getPerimeter();

    //Returns true iff Point p is inside the shape or on the perimeter.
    public boolean contains(Point p);

    //returns true iff the input coordinates points to a point inside the shape or on the perimeter.
    public boolean contains(double x, double y);

    //Moves the shape by moving its anchor point by adding the given coordinates.
    public void move(double dx, double dy);

    //Moves the shape's anchor to the given point.
    public void moveTo(Point p);

    //Moves the shape's anchor to the given coordinates
    public void moveTo(double x, double y);

    //Returns the name of the shape.
    public String getShapeName();
}
