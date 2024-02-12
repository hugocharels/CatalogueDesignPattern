import java.util.ArrayList;
import java.util.List;

// Component Interface
interface Shape {
    void draw();
}

// Leaf (Individual Shape)
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// Composite (Group of Shapes)
class CompositeShape implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        CompositeShape compositeShape1 = new CompositeShape();
        compositeShape1.addShape(circle);
        compositeShape1.addShape(square);

        Shape circle2 = new Circle();
        CompositeShape compositeShape2 = new CompositeShape();
        compositeShape2.addShape(circle2);
        compositeShape2.addShape(compositeShape1);

        compositeShape2.draw();
    }
}