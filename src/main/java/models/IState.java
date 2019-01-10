package models;

/**
 * interface for state pattern
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */

public interface IState {
    public void act(Vehicle actor);
}
