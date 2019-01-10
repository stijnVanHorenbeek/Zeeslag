package models;
/**
 * Rescue State for vehicles
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */
public class RescueState implements IState {
    private Vehicle vehicleToRescue;
    private Vehicle vehicle;

    public RescueState(Vehicle vehicleToRescue, Vehicle vehicle) {
        this.vehicleToRescue = vehicleToRescue;
        this.vehicle = vehicle;
    }

    public void act(Vehicle vehicle) {
        vehicle.setCoordinates(vehicleToRescue.getCoordinates());
        vehicle.setReactionTime(vehicleToRescue);
        vehicle.setState(this);
    }

    @Override
    public String toString() {
        return String.format("Vehicle going to rescue at (lat: %f, long: %f), can carry %d people",
                vehicle.getCoordinates().getLatitude(),
                vehicle.getCoordinates().getLongitude(),
                vehicle.getCapacity());
    }
}
