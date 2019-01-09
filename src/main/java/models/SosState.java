package models;

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
        return String.format("Vehicle has a problem at (lat: %f, long: %f)",
                vehicle.getCoordinates().getLatitude(),
                vehicle.getCoordinates().getLongitude());
    }
}
