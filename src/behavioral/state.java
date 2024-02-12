// State Interface
interface State {
    void play();
    void pause();
    void stop();
}

// Concrete States
class PlayingState implements State {
    @Override
    public void play() {
        System.out.println("Already playing.");
    }

    @Override
    public void pause() {
        System.out.println("Paused the music.");
    }

    @Override
    public void stop() {
        System.out.println("Stopped the music.");
    }
}

class PausedState implements State {
    @Override
    public void play() {
        System.out.println("Resumed playing.");
    }

    @Override
    public void pause() {
        System.out.println("Already paused.");
    }

    @Override
    public void stop() {
        System.out.println("Stopped the music.");
    }
}

class StoppedState implements State {
    @Override
    public void play() {
        System.out.println("Started playing.");
    }

    @Override
    public void pause() {
        System.out.println("Music is stopped. Cannot pause.");
    }

    @Override
    public void stop() {
        System.out.println("Already stopped.");
    }
}

// Context (Contexte)
class MusicPlayer {
    private State currentState;

    public MusicPlayer() {
        currentState = new StoppedState();
    }

    public void setState(State state) {
        currentState = state;
    }

    public void play() {
        currentState.play();
        setState(new PlayingState());
    }

    public void pause() {
        currentState.pause();
        setState(new PausedState());
    }

    public void stop() {
        currentState.stop();
        setState(new StoppedState());
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();

        musicPlayer.play(); // Output: Started playing.
        musicPlayer.pause(); // Output: Paused the music.
        musicPlayer.pause(); // Output: Already paused.
        musicPlayer.stop(); // Output: Stopped the music.
        musicPlayer.stop(); // Output: Already stopped.
        musicPlayer.play(); // Output: Started playing.
    }
}