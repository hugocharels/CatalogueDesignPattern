// Component Interface
interface Coffee {
    double getCost();
    String getDescription();
}

// Concrete Component (Base Coffee)
class BaseCoffee implements Coffee {
    @Override
    public double getCost() {
        return 3.0;
    }

    @Override
    public String getDescription() {
        return "Base Coffee";
    }
}

// Decorator (Decorator Base Class)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        Coffee baseCoffee = new BaseCoffee();
        Coffee coffeeWithMilk = new MilkDecorator(baseCoffee);
        Coffee coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);

        System.out.println("Description: " + coffeeWithMilkAndSugar.getDescription());
        System.out.println("Cost: " + coffeeWithMilkAndSugar.getCost());
    }
}