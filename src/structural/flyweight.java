import java.util.HashMap;
import java.util.Map;

// Flyweight Interface
interface CharacterFlyweight {
    void draw();
}

// Concrete Flyweight
class CharacterFlyweightImpl implements CharacterFlyweight {
    private char symbol;

    public CharacterFlyweightImpl(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void draw() {
        System.out.println("Drawing character: " + symbol);
    }
}

// Unshared Concrete Flyweight
class UnsharedConcreteFlyweight implements CharacterFlyweight {
    private String data;

    public UnsharedConcreteFlyweight(String data) {
        this.data = data;
    }

    @Override
    public void draw() {
        System.out.println("Drawing unshared character data: " + data);
    }
}

// Flyweight Factory
class CharacterFlyweightFactory {
    private Map<Character, CharacterFlyweight> characterCache = new HashMap<>();

    public CharacterFlyweight getCharacter(char symbol) {
        CharacterFlyweight character = characterCache.get(symbol);

        if (character == null) {
            character = new CharacterFlyweightImpl(symbol);
            characterCache.put(symbol, character);
        }

        return character;
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        CharacterFlyweightFactory characterFactory = new CharacterFlyweightFactory();

        // Drawing characters in a text
        char[] text = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};

        for (char c : text) {
            CharacterFlyweight character = characterFactory.getCharacter(c);
            character.draw();
        }
    }
}