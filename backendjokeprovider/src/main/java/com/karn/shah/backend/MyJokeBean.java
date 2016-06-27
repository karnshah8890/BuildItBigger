package com.karn.shah.backend;

import com.example.Jokes;

/** The object model for the data we are sending through endpoints */
public class MyJokeBean {

    private Jokes jokes;

    public MyJokeBean(){
        jokes = new Jokes();
    }

    public String getJoke() {
        return jokes.getRandomJoke();
    }
}