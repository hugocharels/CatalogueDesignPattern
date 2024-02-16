// Target Interface
interface Printer {
    void print(String document);
}

// Adaptee (LegacyPrinter)
class LegacyPrinter {
    public void printDocument(String document) {
        System.out.println("Printing document: " + document);
    }
}

// Adapter
class LegacyPrinterAdapter implements Printer {
    private LegacyPrinter legacyPrinter;

    public LegacyPrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String document) {
        legacyPrinter.printDocument(document);
    }
}

// New Printer (Using a different interface)
class ModernPrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("Printing modern document: " + document);
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        // Using Legacy Printer with the Adapter
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        Printer legacyPrinterAdapter = new LegacyPrinterAdapter(legacyPrinter);

        legacyPrinter.printDocument("Legacy Document"); // Using Legacy Printer directly
        legacyPrinterAdapter.print("Modern Document"); // Using Modern Printer with the Adapter
    }
}
