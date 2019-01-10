package models;

/**
 * interface used in Observer pattern, also known as Subject
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */

public interface IObservable {
    void registerObserver(Vehicle observer);
    void removeObserver(Vehicle observer);
    void notifyObservers();
}
