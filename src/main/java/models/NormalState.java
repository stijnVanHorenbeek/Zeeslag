package models;

/**
 * State all vehicles start with
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */

public class NormalState implements IState {
    private Vehicle vehicle;

    public NormalState(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void act(Vehicle vehicle) {
        vehicle.setState(this);
    }

    @Override
    public String toString() {
        return String.format("Vehicle is operating normal at (lat: %f, long: %f), moving at %f with a bearing of %f",
                vehicle.getCoordinates().getLatitude(),
                vehicle.getCoordinates().getLongitude(),
                vehicle.getSpeed(),
                vehicle.getVector());
    }
}
