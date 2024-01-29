import java.lang.Math;

// Base class Shape
class Shape {
    public double calculateArea() {
        return 0.0; 
    }
}

// Subclass Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

// Subclass Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Subclass Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main class to demonstrate the program
public class ShapeDemo {
    public static void main(String[] args) {
        Circle myCircle = new Circle(5.0);
        Rectangle myRectangle = new Rectangle(4.0, 6.0);
        Triangle myTriangle = new Triangle(3.0, 4.0);

        System.out.println("Circle Area: " + myCircle.calculateArea());
        System.out.println("Rectangle Area: " + myRectangle.calculateArea());
        System.out.println("Triangle Area: " + myTriangle.calculateArea());
    }
}
