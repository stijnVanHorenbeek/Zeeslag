package models;

import models.valueTypes.Coordinates;

public class Helicopter extends Vehicle {

    private long helicopterId;

    protected Helicopter() {}
    public Helicopter(Coordinates coordinates, double speed, double agility, double size, int capacity, double vector) {
        super(coordinates, speed, agility, size, capacity, vector);
    }

    public long getHelicopterId() {
        return helicopterId;
    }

    public void setHelicopterId(long helicopterId) {
        this.helicopterId = helicopterId;
    }

    @Override
    public String toString() {
        return String.format("Helicopter with location lat: %f long: %f", getCoordinates().getLatitude(), getCoordinates().getLongitude());
    }
}
