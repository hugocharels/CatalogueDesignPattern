import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String weatherData);
}

// Subject Interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String weatherData;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(weatherData);
        }
    }

    public void setWeatherData(String weatherData) {
        this.weatherData = weatherData;
        notifyObservers();
    }
}

// Concrete Observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String weatherData) {
        System.out.println(name + " received weather update: " + weatherData);
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        User user1 = new User("John");
        User user2 = new User("Alice");

        weatherStation.registerObserver(user1);
        weatherStation.registerObserver(user2);

        weatherStation.setWeatherData("Sunny"); // Output: John received weather update: Sunny, Alice received weather update: Sunny
    }
}