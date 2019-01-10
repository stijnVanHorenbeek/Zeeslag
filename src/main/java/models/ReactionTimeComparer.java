package models;

import java.util.Comparator;

/**
 * Comparator class to sort vehicles on reactionTime;
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */

public class ReactionTimeComparer implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        if(v1.getReactionTime() < v2.getReactionTime()) {
            return -1;
        }
        return 1;
    }
}
