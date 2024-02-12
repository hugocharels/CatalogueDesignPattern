// Subsystem classes
class Engine {
    public void start() {
        System.out.println("Engine started");
    }

    public void stop() {
        System.out.println("Engine stopped");
    }
}

class Brakes {
    public void apply() {
        System.out.println("Brakes applied");
    }

    public void release() {
        System.out.println("Brakes released");
    }
}

class Electronics {
    public void activate() {
        System.out.println("Electronics activated");
    }

    public void deactivate() {
        System.out.println("Electronics deactivated");
    }
}

// Facade class
class Car {
    private Engine engine;
    private Brakes brakes;
    private Electronics electronics;

    public Car() {
        engine = new Engine();
        brakes = new Brakes();
        electronics = new Electronics();
    }

    public void startCar() {
        engine.start();
        electronics.activate();
    }

    public void stopCar() {
        electronics.deactivate();
        engine.stop();
    }

    public void applyBrakes() {
        brakes.apply();
    }

    public void releaseBrakes() {
        brakes.release();
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();

        // Drive the car...

        car.applyBrakes();

        // Stop the car...

        car.stopCar();
    }
}