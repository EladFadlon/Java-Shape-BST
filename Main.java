
public class Main {
    public static void main(String[] args) {
        ShapeCollection canvas = new ShapeCollection();

        Rectangle rectangle = new Rectangle(100, 100, new Point(300,250));
        Circle circle = new Circle(new Point(50, 50), 10);
        Line line = new Line(new Point(40, 50), new Point(60, 50));

        canvas.addShape(rectangle);
        canvas.addShape(circle);
        canvas.addShape(line);

        System.out.println("--- Initial State---");
        System.out.println(canvas);

        Point clickPoint = new Point(50, 50);
        GeometricShape clickedShape = canvas.getShapeAt(clickPoint);
        System.out.println("* Clicked Point --> " + clickPoint);
        if (clickedShape != null)
            System.out.println("* Selected Shape --> " + clickedShape);
        else System.out.println("Shape not found");
        canvas.sortShapesByArea();

        System.out.println("\n--- Area of the shapes ---");
        for (GeometricShape shape : canvas) {
            System.out.println("* Shape --> " + shape + " * Area: " + shape.getArea());
        }
        System.out.println("\n--- Final State After Sorting---");
        System.out.println(canvas);

        Rectangle rectangle2 = new Rectangle(200, 200, new Point(130,180));

        ShapeBST tree = new ShapeBST();
        tree.add(rectangle);
        tree.add(circle);
        tree.add(line);
        tree.add(rectangle2);

        System.out.println("Adding shapes to the Tree...");
        tree.printInOrder();

        System.out.println("\nBiggest Shape: " + tree.getBiggestShape().toString()+ " , Area: " + tree.getBiggestShape().getArea());
        System.out.println("The depth of the tree right now is: " + tree.getMaxDepth());

        tree.printTree();

        System.out.println("Removing the Circle.....");
        tree.remove(circle);
        tree.printTree();


    }
}