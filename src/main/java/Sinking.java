/**
 * Decorator pattern
 *
 * @author Evy Dehaene
 * @version 17/12/2018
 */

public class Sinking extends VehicleDecorator {
    public Sinking(IVehicle vehicle) {
        super(vehicle);
    }


    @Override
    public String toString(){
        return getStatus() +" Sinking";
    }
}
