package models;

/**
 * Sos State class for vehicles
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */

public class SosState implements IState {
    Vehicle vehicle;

    public SosState(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void act(Vehicle vehicle) {
        Tower tower = vehicle.getActiveTower();
        tower.setVehicleSos(vehicle);
        vehicle.setState(this);
    }

    @Override
    public String toString() {
        return String.format("Vehicle has a problem at (lat: %f, long: %f), %d people are in danger",
                vehicle.getCoordinates().getLatitude(),
                vehicle.getCoordinates().getLongitude(),
                vehicle.getCapacity());
    }
}
