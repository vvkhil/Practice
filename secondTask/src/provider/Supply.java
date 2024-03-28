package provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static cred.Credentials.DB_URL;
import static cred.Credentials.USER;
import static cred.Credentials.PASS;

public class Supply {

    static Logger logger;

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
