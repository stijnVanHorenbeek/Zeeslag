package models;

import models.valueTypes.Coordinates;

public class Helicopter extends Vehicle {


    public Helicopter(Coordinates coordinates, double speed, double reactionTime, double agility, double size, int capacity, double vector) {
        super(coordinates, speed, reactionTime, agility, size, capacity, vector);
    }

    @Override
    public String toString() {
        return String.format("Helicopter with location lat: %f long: %f", getCoordinates().getLatitude(), getCoordinates().getLongitude());
    }
}
