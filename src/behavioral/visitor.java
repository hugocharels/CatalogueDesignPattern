import java.util.ArrayList;
import java.util.List;

// Visitor Interface
interface ShapeVisitor {
    void visitCircle(Circle circle);
    void visitSquare(Square square);
    void visitTriangle(Triangle triangle);
}

// Concrete Visitors
class AreaCalculator implements ShapeVisitor {
    private double totalArea = 0;

    @Override
    public void visitCircle(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        totalArea += area;
    }

    @Override
    public void visitSquare(Square square) {
        double area = Math.pow(square.getSide(), 2);
        totalArea += area;
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        double area = 0.5 * triangle.getBase() * triangle.getHeight();
        totalArea += area;
    }

    public double getTotalArea() {
        return totalArea;
    }
}

class ShapeMover implements ShapeVisitor {
    private int xOffset;
    private int yOffset;

    public ShapeMover(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    @Override
    public void visitCircle(Circle circle) {
        circle.setX(circle.getX() + xOffset);
        circle.setY(circle.getY() + yOffset);
    }

    @Override
    public void visitSquare(Square square) {
        square.setX(square.getX() + xOffset);
        square.setY(square.getY() + yOffset);
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        triangle.setX(triangle.getX() + xOffset);
        triangle.setY(triangle.getY() + yOffset);
    }
}

// Element Interface
interface Shape {
    void accept(ShapeVisitor visitor);
}

// Concrete Elements
class Circle implements Shape {
    private int x;
    private int y;
    private double radius;

    public Circle(int x, int y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitCircle(this);
    }
}

class Square implements Shape {
    private int x;
    private int y;
    private int side;

    public Square(int x, int y, int side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSide() {
        return side;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitSquare(this);
    }
}

class Triangle implements Shape {
    private int x;
    private int y;
    private int base;
    private int height;

    public Triangle(int x, int y, int base, int height) {
        this.x = x;
        this.y = y;
        this.base = base;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitTriangle(this);
    }
}

// ObjectStructure
class ShapeCollection {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public void accept(ShapeVisitor visitor) {
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.addShape(new Circle(10, 20, 5));
        shapeCollection.addShape(new Square(30, 40, 10));
        shapeCollection.addShape(new Triangle(50, 60, 8, 12));

        AreaCalculator areaCalculator = new AreaCalculator();
        ShapeMover shapeMover = new ShapeMover(5, 5);

        shapeCollection.accept(areaCalculator);
        shapeCollection.accept(shapeMover);

        System.out.println("Total area: " + areaCalculator.getTotalArea());
    }
}