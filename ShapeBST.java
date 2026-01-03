public class ShapeBST {
    //Internal Class for Node:
    private static class Node {
        public GeometricShape shape;
        public Node left;
        public Node right;

        public Node(GeometricShape shape) {
            this.shape = shape;
            this.left = null;
            this.right = null;
        }
    }

    //Fields:
    private Node root;

    //Constructor:
    public ShapeBST() {
        root = null;
    }

    //Assumes shape is not null.
    //Adds shape to the binary tree.
    public void add(GeometricShape shape) {
        root = addRecursive(root, shape);
    }

    //Helper function to the adding function
    private Node addRecursive(Node current, GeometricShape shape) {
        if (current == null)
            return new Node(shape);
        if (current.shape.getArea() > shape.getArea())
            current.left = addRecursive(current.left, shape);
        else
            current.right = addRecursive(current.right, shape);
        return current;
    }

    public void printInOrder() {
        if (root == null)
            return;
        System.out.println("Shapes in BST(Sorted by Area): ");
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.println(" * Area: " + String.format("%.2f", node.shape.getArea()) + " | " + node.shape.toString());
            printInOrderRecursive(node.right);
        }
    }

    //Returns the shape with the biggest Area, if tree is empty returns null.
    public GeometricShape getBiggestShape() {
        if (root == null)
            return null;
        Node current = root;
        while (current.right != null)
            current = current.right;
        return current.shape;
    }

    //Calculates the depth of the tree.
    public int getMaxDepth() {
        return getMaxDepth(root);
    }

    public int getMaxDepth(Node current) {
        if (current == null)
            return 0;

        int leftMaxDepth = getMaxDepth(current.left);
        int rightMaxDepth = getMaxDepth(current.right);

        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public void printTree() {
        System.out.println("\n---- Visual Tree Presentation ----");
        printTreeRecursive(root, 0);
        System.out.println("----------------------------------");
    }

    private void printSpaces(int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("    ");
        if (depth > 0)
            System.out.print("|-- ");
    }

    private void printTreeRecursive(Node current, int depth) {
        if (current == null)
            return;
        printTreeRecursive(current.right, depth + 1);
        printSpaces(depth);
        String ShapeInfo = current.shape.getShapeName();
        System.out.printf("[%s | Area: %.2f]%n", ShapeInfo, current.shape.getArea());
        printTreeRecursive(current.left, depth + 1);
    }

    //Removes Node from Tree.
    public void remove(GeometricShape target) {
        if (target == null) return;
        root = remove(root, target);
    }

    private Node remove(Node current, GeometricShape target) {
        if (current == null)
            return null;
        if (target.getArea() > current.shape.getArea()) {
            current.right = remove(current.right, target);
        } else if (target.getArea() < current.shape.getArea()) {
            current.left = remove(current.left, target);
        } else if (target.getArea() == current.shape.getArea()) {
            if (current.left == null)
                return current.right;
            else if (current.right == null)
                return current.left;
            GeometricShape smallestValue = findSmallestValue(current.right);
            current.shape = smallestValue;
            current.right = remove(current.right, smallestValue);
        }
        return current;
    }

    private GeometricShape findSmallestValue(Node root) {
        return root.left == null ? root.shape : findSmallestValue(root.left);
    }
}
