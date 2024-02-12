import java.util.HashMap;
import java.util.Map;

// Flyweight Interface
interface Character {
    void draw();
}

// Concrete Flyweight
class CharacterImpl implements Character {
    private char symbol;

    public CharacterImpl(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void draw() {
        System.out.println("Drawing character: " + symbol);
    }
}

// Flyweight Factory
class CharacterFactory {
    private Map<char, Character> characterCache = new HashMap<>();

    public Character getCharacter(char symbol) {
        CharacterImpl character = characterCache.get(symbol);

        if (character == null) {
            character = new CharacterImpl(symbol);
            characterCache.put(symbol, character);
        }

        return character;
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();

        // Drawing characters in a text
        char[] text = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};

        for (char c : text) {
            Character character = characterFactory.getCharacter(c);
            character.draw();
        }
    }
}