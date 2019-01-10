package models;

import models.valueTypes.Coordinates;

/**
 * Ship entity class, Observer
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */
public class Ship extends Vehicle {
    private long shipId;

    protected Ship() { }

    public Ship(Coordinates coordinates, double speed, double agility, double size, int capacity, double vector) {
        super(coordinates, speed, agility, size, capacity, vector);
    }

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        if (shipId <=0) throw new IllegalArgumentException("id can't be zero or lower");
        this.shipId = shipId;
    }

    @Override
    public String toString() {
        return String.format("Ship with location lat: %f long: %f", getCoordinates().getLatitude(), getCoordinates().getLongitude());
    }
}
