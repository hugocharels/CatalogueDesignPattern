// Prototype
interface Shape extends Cloneable {
    void draw();
    Shape clone();
}

// Concrete Prototypes
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }

    public Shape clone() {
        return new Circle();
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }

    public Shape clone() {
        return new Rectangle();
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape clonedCircle = circle.clone();
        clonedCircle.draw();

        Shape rectangle = new Rectangle();
        Shape clonedRectangle = rectangle.clone();
        clonedRectangle.draw();
    }
}