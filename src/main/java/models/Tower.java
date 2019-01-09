package models;

import models.valueTypes.Coordinates;

import java.util.LinkedList;

public class Tower extends Actor implements IObservable {
    private long towerId;
    private LinkedList<Vehicle> vehicles;
    private LinkedList<Vehicle> vehiclesInRescue;
    private LinkedList<Vehicle> vehiclesInSos;

    public Tower(Coordinates coordinates, double speed, double reactionTime, double agility, double size, int capacity, double vector) {
        super(coordinates, speed, reactionTime, agility, size, capacity, vector);
        if (speed != 0) throw new IllegalArgumentException("Tower can't move");
        if (reactionTime != 0) throw new IllegalArgumentException("Tower can't move");
        if (agility != 0) throw new IllegalArgumentException("Tower can't move");
        if (vector != 0) throw new IllegalArgumentException("Tower can't move");

        vehicles = new LinkedList<Vehicle>();
        vehiclesInRescue = new LinkedList<Vehicle>();
        vehiclesInSos = new LinkedList<Vehicle>();
    }

    public void registerObserver(Vehicle observer) {
        vehicles.add(observer);
    }

    public void removeObserver(Vehicle observer) {
        vehicles.remove(observer);
    }

    public void notifyObservers() {
        for (Vehicle vehicleInSos : vehiclesInSos) {
            int capacity = vehicleInSos.getCapacity();

            for (Vehicle vehicle : vehicles) {
                if (!vehiclesInSos.contains(vehicle) && !vehiclesInRescue.contains(vehicle)) {
                    // notify ships to rescue capacity of shipInSos
                            vehicle.update(vehicleInSos);
                }
            }
        }
    }

    public void setVehicleSos(Vehicle vehicle){
        vehiclesInSos.add(vehicle);
        notifyObservers();
        vehiclesInSos.remove(vehicle);
    }

    public LinkedList<Vehicle> getVehicles() {
        return vehicles;
    }

    public LinkedList<Vehicle> getVehiclesInRescue() {
        return vehiclesInRescue;
    }

    public LinkedList<Vehicle> getVehiclesInSos() {
        return vehiclesInSos;
    }

    public long getTowerId() {
        return towerId;
    }

    public void setTowerId(long towerId) {
        if (towerId <=0) throw new IllegalArgumentException("id can't be zero or lower");

        this.towerId = towerId;
    }
    @Override
    public String toString() {
        return String.format("Tower => lat: %f, long: %f", getCoordinates().getLatitude(), getCoordinates().getLongitude());
    }
}
