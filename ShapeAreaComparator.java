import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<GeometricShape> {

    @Override
    public int compare(GeometricShape o1, GeometricShape o2) {
        return Double.compare(o1.getArea(), o2.getArea());
    }
}
