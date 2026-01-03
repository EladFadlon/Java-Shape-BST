[README.md](https://github.com/user-attachments/files/24415028/README.md)
# Geometric Shapes Management System 📐

A Java-based project demonstrating Object-Oriented Programming (OOP) principles and custom Data Structures.
This application manages a collection of geometric shapes using a Binary Search Tree (BST) for efficient sorting and retrieval based on area.

## 🚀 Key Features

* **Polymorphism:** Unified interface (`GeometricShape`) for all shapes (Circle, Rectangle, Line).
* **Custom Data Structure:** Implemented a **Binary Search Tree (BST)** from scratch to store shapes sorted by area.
* **Algorithms:**
    * Recursive insertion and deletion in BST.
    * Efficient searching.
    * Tree depth calculation.
* **Math Logic:** Custom logic for geometric calculations (Area, Perimeter, Point containment).

## 🛠️ Tech Stack

* Language: **Java**
* Concepts: **OOP, Recursion, Data Structures (BST)**
* IDE: **IntelliJ IDEA**

## 💻 Code Example

Adding shapes and sorting them automatically using the BST:

```java
ShapesBST tree = new ShapesBST();
tree.add(new Rectangle(100, 100)); // Area: 10,000
tree.add(new Circle(new Point(0,0), 10)); // Area: ~314

// Will print the shapes sorted by size (Smallest -> Largest)
tree.printSorted();
