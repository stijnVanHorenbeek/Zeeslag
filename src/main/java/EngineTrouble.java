/**
 * Decorator pattern
 *
 * @author Evy Dehaene
 * @version 17/12/2018
 */

public class EngineTrouble extends VehicleDecorator{
    public EngineTrouble(IVehicle vehicle) {
        super(vehicle);
    }


    @Override
    public String toString(){
        return getStatus() +" Engine Trouble";
    }
}
