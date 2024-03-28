package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Provider {

    static Logger logger;

    static final String DB_URL = "jdbc:postgresql://localhost/practice";
    static final String USER = "postgres";
    static final String PASS = "vvkhil682423";

    String query = null;
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
