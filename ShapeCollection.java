import java.awt.*;
import java.util.*;
import java.util.List;

public class ShapeCollection implements Iterable<GeometricShape> {
    //Fields:
    private List<GeometricShape> shapes;

    //Constructor:
    public ShapeCollection() {
        shapes = new ArrayList<>();
    }

    //Methods:
    public void addShape(GeometricShape s) {
        if (s == null)
            throw new NullPointerException("Input shape is null");
        shapes.add(s);

    }

    public void removeShape(GeometricShape s) {
        if (s == null)
            throw new NullPointerException("Input shape is null");
        shapes.remove(s);
    }

    //Returns the shape at given point p.
    public GeometricShape getShapeAt(Point p) {
        for (int i = shapes.size() - 1; i >= 0; i--)
            if (shapes.get(i).contains(p))
                return shapes.get(i);
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShapeCollection with ").append(shapes.size()).append(" shapes: \n");
        for (GeometricShape shape : shapes)
            sb.append("\t• ").append(shape.toString()).append("\n");
        return sb.toString();
    }

    public void sortShapesByArea(){
        shapes.sort(new ShapeAreaComparator());
    }

    @Override
    public Iterator<GeometricShape> iterator() {
        return shapes.iterator();
    }
}
