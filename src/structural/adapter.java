// Adaptee (LegacyPrinter)
class LegacyPrinter {
    public void print(String document) {
        System.out.println("Printing document: " + document);
    }
}

// Adapter
class ModernPrinterAdapter extends LegacyPrinter {
    private ModernPrinter modernPrinter;

    public ModernPrinterAdapter(ModernPrinter modernPrinter) {
        this.modernPrinter = modernPrinter;
    }

    @Override
    public void print(String document) {
        modernPrinter.print(document);
    }
}

// New Printer (Using a different interface)
class ModernPrinter {
    public void print(String document) {
        System.out.println("Printing modern document: " + document);
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        // Using Legacy Printer with the Adapter
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        ModernPrinterAdapter adapter = new ModernPrinterAdapter(new ModernPrinter());

        legacyPrinter.print("Legacy Document"); // Using Legacy Printer directly
        adapter.print("Modern Document"); // Using Modern Printer with the Adapter
    }
}