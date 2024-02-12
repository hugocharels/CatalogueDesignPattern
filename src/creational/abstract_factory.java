// Abstract Factory
interface AbstractFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory for Windows
class WindowsFactory implements AbstractFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory for Linux
class LinuxFactory implements AbstractFactory {
    public Button createButton() {
        return new LinuxButton();
    }

    public Checkbox createCheckbox() {
        return new LinuxCheckbox();
    }
}

// Abstract Product
interface Button {
    String render();
}

// Concrete Products for Windows and Linux
class WindowsButton implements Button {
    public String render() {
        return "Render Windows button";
    }
}

class LinuxButton implements Button {
    public String render() {
        return "Render Linux button";
    }
}

interface Checkbox {
    String render();
}

class WindowsCheckbox implements Checkbox {
    public String render() {
        return "Render Windows checkbox";
    }
}

class LinuxCheckbox implements Checkbox {
    public String render() {
        return "Render Linux checkbox";
    }
}

// Client Code
public class Client {
    public static void renderGui(AbstractFactory factory) {
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        System.out.println(button.render());
        System.out.println(checkbox.render());
    }

    public static void main(String[] args) {
        AbstractFactory windowsFactory = new WindowsFactory();
        AbstractFactory linuxFactory = new LinuxFactory();

        renderGui(windowsFactory);
        renderGui(linuxFactory);
    }
}