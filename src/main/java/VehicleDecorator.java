/**
 * Decorator pattern
 *
 * @author Evy Dehaene
 * @version 27/12/2018
 */

public abstract class VehicleDecorator implements IVehicle {
    // instance variables - replace the example below with your own
    private IVehicle vehicle;
    public VehicleDecorator(IVehicle vehicle){
        this.vehicle = vehicle;
    }

    public String getStatus(){
        return vehicle.toString();
    }
    public void setStatus(boolean status){
        vehicle.setStatus(status);
    }
    @Override
    public PACKAGE_NAME.Coordinates getLocatie() {
        return vehicle.getLocatie();
    }

    @Override
    public String toString(){
        return getStatus();
    }
}
