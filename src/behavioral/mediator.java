// Mediator Interface
interface ChatMediator {
    void sendMessage(User user, String message);
}

// Concrete Mediator
class ChatRoom implements ChatMediator {
    @Override
    public void sendMessage(User user, String message) {
        System.out.println(user.getName() + " sends message: " + message);
    }
}

// Colleague Interface
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

// Concrete Colleague
class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(this, message);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " receives: " + message);
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatRoom();

        User user1 = new ChatUser(chatMediator, "User1");
        User user2 = new ChatUser(chatMediator, "User2");
        User user3 = new ChatUser(chatMediator, "User3");

        chatMediator.sendMessage(user1, "Hello, everyone!");

        user2.send("Hi, User1!");
    }
}
