import models.*;
import models.valueTypes.Coordinates;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import persistence.DBConnection;

import java.util.ArrayList;


public class Startup {
    public final static Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) {
        try {
            DBConnection dbConnection = new DBConnection();
            dbConnection.testConnection();

            ArrayList<Tower> towers = generateTowers(20);
            dbConnection.saveTower(towers);
            ArrayList<Vehicle> ships = generateShips(towers, 500);
            dbConnection.saveShip(ships);
            ArrayList<Vehicle> helicopters = generateHelicopters(towers, 100);
            dbConnection.saveHelicopter(helicopters);

            outputGeneratedActors(towers);
            simulateSos(towers, ships);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private static void outputGeneratedActors(ArrayList<Tower> towers) {
        for (Tower tower: towers){
            logger.debug(tower);
            for (Vehicle vehicle: tower.getVehicles()){
                logger.debug(vehicle);
            }
        }
    }

    private static void simulateSos(ArrayList<Tower> towers, ArrayList<Vehicle> ships) {
        logger.debug("Simulate SOS\n");
        randomSos(ships, 20);

        for (Tower tower: towers){
            logger.debug(tower);
            for (Vehicle vehicle: tower.getVehicles()){
                logger.debug(vehicle.getState());
            }
        }
    }

    private static void randomSos(ArrayList<Vehicle> ships, int amount) {
        for (int i = 0; i < amount; i++) {
            Vehicle ship = ships.get(Randomizer.getRandomIntBetweenBounds(ships.size(), 0));
            ship.setState(new SosState(ship));
            ship.act();
        }
    }

    private static ArrayList<Vehicle> generateShips(ArrayList<Tower> towers, int amount) {
        ArrayList<Vehicle> ships = new ArrayList<Vehicle>();
        for (int i = 0; i < amount; i++) {
            Vehicle ship = (Vehicle) ActorFactory.createActor(ActorFactory.SHIP, new Coordinates(Randomizer.getRandomDouble(), Randomizer.getRandomDouble()));
            ship.setTowers(towers);
            ships.add(ship);
        }
        return ships;
    }

    private static ArrayList<Vehicle> generateHelicopters(ArrayList<Tower> towers, int amount) {
        ArrayList<Vehicle> helicopters = new ArrayList<Vehicle>();
        for (int i = 0; i < amount; i++) {
            Vehicle helicopter = (Vehicle) ActorFactory.createActor(ActorFactory.HELICOPTER, new Coordinates(Randomizer.getRandomDouble(), Randomizer.getRandomDouble()));
            helicopter.setTowers(towers);
            helicopters.add(helicopter);
        }
        return helicopters;
    }

    private static ArrayList<Tower> generateTowers(int amount) {
        ArrayList<Tower> towers = new ArrayList<Tower>();
        for (int i = 0; i < amount; i++) {
            Tower tower = (Tower) ActorFactory.createActor(ActorFactory.TOWER, new Coordinates(Randomizer.getRandomDouble(), Randomizer.getRandomDouble()));
            towers.add(tower);
        }
        return towers;
    }


}
