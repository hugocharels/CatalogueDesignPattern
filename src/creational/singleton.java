// Singleton
class Configuration {
    private static Configuration instance;

    // Empêcher l'instanciation directe depuis l'extérieur de la classe
    private Configuration() { }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    // Autres méthodes et attributs
}

// Client Code
public class Client {
    public static void main(String[] args) {
        Configuration config1 = Configuration.getInstance();
        Configuration config2 = Configuration.getInstance();

        System.out.println(config1 == config2); // true, car il n'y a qu'une seule instance
    }
}