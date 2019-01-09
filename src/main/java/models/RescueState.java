package models;

public class RescueState implements IState {
    private Vehicle vehicleToRescue;
    private Vehicle vehicle;

    public RescueState(Vehicle vehicleToRescue, Vehicle vehicle) {
        this.vehicleToRescue = vehicleToRescue;
        this.vehicle = vehicle;
    }

    public void act(Vehicle vehicle) {
        vehicle.setCoordinates(vehicleToRescue.getCoordinates());
        vehicle.setState(this);
    }

    @Override
    public String toString() {
        return String.format("Vehicle going to rescue at (lat: %f, long: %f)",
                vehicle.getCoordinates().getLatitude(),
                vehicle.getCoordinates().getLongitude());
    }
}
