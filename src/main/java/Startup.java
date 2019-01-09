import models.*;
import models.valueTypes.Coordinates;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;


public class Startup {
    public final static Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) {
        ArrayList<Tower> towers = generateTowers();
        ArrayList<Vehicle> ships = generateShips(towers);
        ArrayList<Vehicle> helicopters = generateHelicopters(towers);

        for (Tower tower: towers){
            System.out.println(tower);
            for (Vehicle vehicle: tower.getVehicles()){
                System.out.println(vehicle);
            }
        }

        System.out.println("\nSimulate SOS\n");
        randomSos(ships);

        System.out.println("\nResponse to SOS\n");
        for (Tower tower: towers){
            System.out.println(tower);
            for (Vehicle vehicle: tower.getVehicles()){
                System.out.println(vehicle.getState());
            }
        }

    }

    private static void randomSos(ArrayList<Vehicle> ships) {
        for (int i = 0; i < 5; i++) {
            Vehicle ship = ships.get(Randomizer.getRandomIntBetweenBounds(ships.size(), 0));
            ship.setState(new SosState(ship));
            ship.act();
        }
    }

    private static ArrayList<Vehicle> generateShips(ArrayList<Tower> towers) {
        ArrayList<Vehicle> ships = new ArrayList<Vehicle>();
        for (int i = 0; i < 50; i++) {
            Vehicle ship = (Vehicle) ActorFactory.createActor(ActorFactory.SHIP, new Coordinates(Randomizer.getRandomDouble(), Randomizer.getRandomDouble()));
            ship.setTowers(towers);
            ships.add(ship);
        }
        return ships;
    }

    private static ArrayList<Vehicle> generateHelicopters(ArrayList<Tower> towers) {
        ArrayList<Vehicle> helicopters = new ArrayList<Vehicle>();
        for (int i = 0; i < 15; i++) {
            Vehicle helicopter = (Vehicle) ActorFactory.createActor(ActorFactory.HELICOPTER, new Coordinates(Randomizer.getRandomDouble(), Randomizer.getRandomDouble()));
            helicopter.setTowers(towers);
            helicopters.add(helicopter);
        }
        return helicopters;
    }

    private static ArrayList<Tower> generateTowers() {
        ArrayList<Tower> towers = new ArrayList<Tower>();
        for (int i = 0; i < 5; i++) {
            Tower tower = (Tower) ActorFactory.createActor(ActorFactory.TOWER, new Coordinates(Randomizer.getRandomDouble(), Randomizer.getRandomDouble()));
            towers.add(tower);
        }
        return towers;
    }


}
