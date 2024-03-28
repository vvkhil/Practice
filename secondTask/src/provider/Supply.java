package provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Supply {

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
