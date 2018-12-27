/**
 * Decorator pattern
 *
 * @author Evy Dehaene
 * @version 17/12/2018
 */

public class OnFire extends VehicleDecorator {

    public OnFire(IVehicle vehicle) {
        super(vehicle);
    }


    @Override
    public String toString(){
        return getStatus() +" On Fire";
    }
}
