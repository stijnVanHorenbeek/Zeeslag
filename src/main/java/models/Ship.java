package models;

import models.valueTypes.Coordinates;


public class Ship extends Vehicle implements IObserver {

    public Ship(Coordinates coordinates, double speed, double reactionTime, double agility, double size, int capacity, double vector) {
        super(coordinates, speed, reactionTime, agility, size, capacity, vector);
    }

    @Override
    public String toString() {
        return String.format("Ship with location lat: %f long: %f", getCoordinates().getLatitude(), getCoordinates().getLongitude());
    }
}
