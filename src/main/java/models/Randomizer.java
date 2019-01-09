package models;

import java.util.Random;

public class Randomizer {
    private static Random random = new Random();

    public static double getRandomDouble() {
        return 50 * random.nextDouble();
    }

    public static int getRandomInt() {
       return 1 + (int)(Math.random() * 150);
    }

    public static int getRandomIntBetweenBounds(int upper, int lower) {
        return random.nextInt(upper - lower) + lower;
    }

}
