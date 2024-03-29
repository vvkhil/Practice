package users;

import app.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Provider {

    static Logger logger = Logger.getLogger(Provider.class.getName());

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

    public Provider() {
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

    public void addProvider(int idProvider, int idUserApp) throws SQLException {

        query = "INSERT INTO provider"
                + "VALUES"
                + "(" + idProvider + ", "  + idUserApp + ");";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteProvider(int idProvider) throws SQLException {

        query = "DELETE FROM provider WHERE id = " + idProvider + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from provider table!");

    }

    public void updateProvider(int idProvider, String data, String field) throws SQLException {

        query = "UPDATE provider SET " + field + " = " + data + " WHERE id = " + idProvider + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to provider table!");

    }

    public void updateProvider(int idProvider, int data, String field) throws SQLException {

        query = "UPDATE provider SET " + field + " = " + data + " WHERE id = " + idProvider + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to provider table!");

    }

}
