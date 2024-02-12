// Product
class Computer {
    private String processor;
    private String graphicsCard;
    private int memory;

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Computer: " + processor + ", " + graphicsCard + ", " + memory + "GB RAM";
    }
}

// Abstract Builder
interface ComputerBuilder {
    void buildProcessor();
    void buildGraphicsCard();
    void buildMemory();
    Computer getResult();
}

// Concrete Builders
class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    public void buildProcessor() {
        computer.setProcessor("Intel i7");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("Nvidia RTX 3080");
    }

    public void buildMemory() {
        computer.setMemory(32);
    }

    public Computer getResult() {
        return computer;
    }
}

class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    public void buildProcessor() {
        computer.setProcessor("Intel i5");
    }

    public void buildGraphicsCard() {
        computer.setGraphicsCard("Intel UHD Graphics");
    }

    public void buildMemory() {
        computer.setMemory(16);
    }

    public Computer getResult() {
        return computer;
    }
}

// Director
class ComputerDirector {
    private ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void constructComputer() {
        computerBuilder.buildProcessor();
        computerBuilder.buildGraphicsCard();
        computerBuilder.buildMemory();
    }

    public Computer getComputer() {
        return computerBuilder.getResult();
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        ComputerBuilder gamingComputerBuilder = new GamingComputerBuilder();
        ComputerBuilder officeComputerBuilder = new OfficeComputerBuilder();

        ComputerDirector director = new ComputerDirector(gamingComputerBuilder);
        director.constructComputer();
        Computer gamingComputer = director.getComputer();
        System.out.println("Gaming Computer: " + gamingComputer);

        director = new ComputerDirector(officeComputerBuilder);
        director.constructComputer();
        Computer officeComputer = director.getComputer();
        System.out.println("Office Computer: " + officeComputer);
    }
}