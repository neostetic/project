package cz.polacek.game.utils;

import cz.polacek.game.config.Config;

import java.util.Random;

public class UtilRandom extends Config {

    Random random = new Random();

    // Chance generator
    public boolean toBoolean(double chance) {
        int percentage = random.nextInt(100);
        return !(percentage > chance * 100);
    }

    // 2 or more EQUAL choices
    public int toChoice(int choices) {
        return random.nextInt(choices);
    }


}
