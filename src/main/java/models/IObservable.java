package models;

public interface IObservable {
    void registerObserver(Vehicle observer);
    void removeObserver(Vehicle observer);
    void notifyObservers();
}
