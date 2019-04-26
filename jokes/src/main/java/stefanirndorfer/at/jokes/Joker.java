package stefanirndorfer.at.jokes;

import java.util.Random;

public class Joker {
    private final String[] jokes = {
            "This is a funny joke",
            "This is also a funny joke",
            "And this one too!"
    };

    public String getJoke() {
        int index = new Random().nextInt(jokes.length);
        return jokes[index];
    }
}
