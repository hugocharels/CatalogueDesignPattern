// Memento Interface
interface Memento {
    String getText();
}

// Concrete Memento
class TextMemento implements Memento {
    private String text;

    public TextEditorMemento(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}

// Originator
class TextEditor {
    private String text;

    public void write(String text) {
        this.text = text;
    }

    public TextMemento save() {
        return new TextMemento(text);
    }

    public void restore(TextMemento memento) {
        text = memento.getText();
    }

    public void display() {
        System.out.println("Current Text: " + text);
    }
}

// Caretaker
class TextHistory {
    private Stack<TextMemento> history = new Stack<>();

    public void push(TextMemento memento) {
        history.push(memento);
    }

    public TextMemento pop() {
        return history.pop();
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextHistory history = new TextHistory();

        textEditor.write("Hello, world!");
        textEditor.display();

        // Save state
        history.push(textEditor.save());

        textEditor.write("Hello, Design Pattern Memento!");
        textEditor.display();

        // Restore state
        textEditor.restore(history.pop());
        textEditor.display();
    }
}