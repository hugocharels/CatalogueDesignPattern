// Abstraction
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    public abstract void draw();
}

// Refined Abstractions for specific shapes
class CircleShape extends Shape {
    private double x, y, radius;

    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

// Implementor Interface
interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
}

// Concrete Implementations of DrawingAPI
class DrawingVector implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing Circle in Vector at (" + x + "," + y + ") with radius " + radius);
    }
}

class DrawingRaster implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing Circle in Raster at (" + x + "," + y + ") with radius " + radius);
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        DrawingAPI vectorDrawingAPI = new DrawingVector();
        DrawingAPI rasterDrawingAPI = new DrawingRaster();

        Shape circle = new CircleShape(1, 2, 3, vectorDrawingAPI);
        circle.draw();

        circle = new CircleShape(5, 7, 10, rasterDrawingAPI);
        circle.draw();
    }
}