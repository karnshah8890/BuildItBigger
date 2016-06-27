package com.example;

import java.util.Random;

public class Jokes {

    private String[] jokes;
    private Random random;

    public Jokes() {
        jokes = new String[5];
        jokes[0] = "Q: Why couldn't the leopard play hide and seek? " +
                "A: Because he was always spotted.";
        jokes[1] = "Q: Why can't orphans play baseball?" +
                "A: Because they don't know where home is.";
        jokes[2] = "Q: What do you get when you cross a fish and an elephant? " +
                "A: Swimming trunks.";
        jokes[3] = "Q. What is the color of the wind? " +
                "A. Blew.";
        jokes[4] = "Q. What did the pop star do when he locked himself out? " +
                "A. He sang until he found the right key!";
        random = new Random();
    }

    public String[] getJokes() {
        return jokes;
    }

    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
