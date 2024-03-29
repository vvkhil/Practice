package provider;

import app.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Supply {

    static Logger logger = Logger.getLogger(Supply.class.getName());

    private static final Properties properties = new Properties();

    static {
        try{
            properties.load(Main.class.getClassLoader().getResourceAsStream("db.properties"));
        }catch(Exception e){
            logger.warning(e.getMessage());
        }
    }

    String query = null;
    Connection connection;

    public Supply() {
        try {
            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password"));
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
    }

    Statement statement = null;

    public void addSupply(int idSupply, int idProvider) throws SQLException {

        query = "INSERT INTO supply"
                + "(id, provider_id) " + "VALUES"
                + "(" + idSupply + "," + idProvider + ");";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteSupply(int idSupply) throws SQLException {

        query = "DELETE FROM supply WHERE id = " + idSupply + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from supply table!");

    }

    public void updateSupply(int idSupply, String data, String field) throws SQLException {

        query = "UPDATE supply SET " + field + " = " + data + " WHERE id = " + idSupply + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to supply table!");

    }

    public void updateSupply(int idSupply, int data, String field) throws SQLException {

        query = "UPDATE supply SET " + field + " = " + data + " WHERE id = " + idSupply + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to supply table!");

    }

}
