package com.dmtaiwan.alexander.jokelibrary;

import java.util.Random;

public class JokeLibrary {
    private String[] jokes = {"I wondered why the ball was getting bigger! Then it hit me.",
            "If you want to catch a squirrel just climb a tree and act like a nut.",
            "Why does Snoop Dogg carry an umbrella? Fo’ drizzle.",
            "Time flies like an arrow, fruit flies like a banana."};

    public String getJoke() {
        String randomJoke = jokes[new Random().nextInt(jokes.length)];
        return randomJoke;
    }
}
