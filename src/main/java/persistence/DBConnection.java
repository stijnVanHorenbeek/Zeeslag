package persistence;

import models.Tower;
import models.Vehicle;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class used for database connection, and saving of entities
 *
 * @author Stijn Van Horenbeek, Evy Dehaene, Olivier Morias
 *
 */

public class DBConnection {
    public static final Logger logger = LogManager.getRootLogger();
    String url = "jdbc:mysql://localhost:3306/ZeeslagDb?useSSL=false";
    String user = "";
    String password = "";

    String query = "SELECT VERSION()";

    public void testConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch(SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void saveShip(ArrayList<Vehicle> ships) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            for (Vehicle ship: ships
            ) {
                String query = "INSERT INTO SHIP (speed, size, capacity) VALUES ("+ ship.getSpeed()+","+ship.getSize()+","+ship.getCapacity()+")";
                statement.executeUpdate(query);
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void saveHelicopter(ArrayList<Vehicle> helicopters) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            for (Vehicle helicopter: helicopters
            ) {
                String query = "INSERT INTO HELICOPTER (speed, size, capacity) VALUES ("+ helicopter.getSpeed()+","+helicopter.getSize()+","+helicopter.getCapacity()+")";
                statement.executeUpdate(query);
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void saveTower(ArrayList<Tower> towers) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            for (Tower tower: towers
            ) {
                String query = "INSERT INTO TOWER (lattitude, longitude, capacity)VALUES ("+ tower.getCoordinates().getLatitude()+","+tower.getCoordinates().getLongitude()+","+tower.getCapacity()+")";
                statement.executeUpdate(query);
            }
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
    }

}
