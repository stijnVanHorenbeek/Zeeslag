package models;

import models.valueTypes.Coordinates;

import java.util.Collections;
import java.util.LinkedList;

public class Tower extends Actor implements IObservable {
    private long towerId;
    private LinkedList<Vehicle> vehicles;
    private LinkedList<Vehicle> vehiclesInRescue;
    private LinkedList<Vehicle> vehiclesInSos;

    public Tower(Coordinates coordinates, double speed, double agility, double size, int capacity, double vector) {
        super(coordinates, speed, agility, size, capacity, vector);
        if (speed != 0) throw new IllegalArgumentException("Tower can't move");
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
            int capacityInSos = vehicleInSos.getCapacity();
            determineShipsForRescue(capacityInSos, vehicles);
            for (Vehicle vehicle : vehiclesInRescue) {
                            vehicle.update(vehicleInSos);
            }
        }
    }

    private void determineShipsForRescue(int capacity, LinkedList<Vehicle> vehicles) {
        Collections.sort(vehicles, new ReactionTimeComparer());
        for(Vehicle vehicle : vehicles) {
            if (capacity > 0) {
                capacity -= vehicle.getCapacity();
                vehiclesInRescue.add(vehicle);
            }
        }
    }

    public void setVehicleSos(Vehicle vehicle){
        vehiclesInSos.add(vehicle);
        notifyObservers();
        vehiclesInSos.remove(vehicle);
        vehiclesInRescue.clear();
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
