package models;

import models.valueTypes.Coordinates;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Tower extends Actor implements IObservable {
    private LinkedList<Vehicle> vehicles;
    private LinkedList<Vehicle> vehiclesInRescue;
    private LinkedList<Vehicle> vehiclesInSos;
    private List<Vehicle> vehiclesSortedByReactionTime;


    public Tower(Coordinates coordinates, double speed, double reactionTime, double agility, double size, int capacity, double vector) {
        super(coordinates, speed, reactionTime, agility, size, capacity, vector);
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

    @Override
    public void notifyObservers() {
        for (Vehicle vehicleInSos: vehiclesInSos){
            for (Vehicle vehicle: vehicles){
                if (!vehiclesInSos.contains(vehicle) && !vehiclesInRescue.contains(vehicle)){
                    vehiclesSortedByReactionTime= vehicles.stream().sorted(Comparator.comparing(Vehicle::getReactionTime).reversed()).collect(Collectors.toList());
                    for (Vehicle vehicleByReactionTime: vehiclesSortedByReactionTime){
                        if (vehicleByReactionTime.getCapacity()>= vehicleInSos.getCapacity()){
                            //notify ships to rescue shipInSos
                            vehicle.update(vehicleInSos);
                            return;
                        }
                    }
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

    @Override
    public String toString() {
        return String.format("Tower => lat: %f, long: %f", getCoordinates().getLatitude(), getCoordinates().getLongitude());
    }
}
