package models;

import java.util.Random;

/**
 * Random generator class
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */

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

    public static double getRandomDoubleBetweenBounds(double upper, double lower) {
        return lower + (upper - lower) * random.nextDouble();
    }

}
