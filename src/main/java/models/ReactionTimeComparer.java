package models;

import java.util.Comparator;

public class ReactionTimeComparer implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        if(v1.getReactionTime() < v2.getReactionTime()) {
            return -1;
        }
        return 1;
    }
}
