/**
 * Decorator pattern
 *
 * @author Evy Dehaene
 * @version 17/12/2018
 */

public class NoSignal extends VehicleDecorator {
    public NoSignal(IVehicle vehicle) {
        super(vehicle);
    }


    @Override
    public String toString(){
        return getStatus() +" No Signal";
    }
}
