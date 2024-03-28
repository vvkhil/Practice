package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static cred.Credentials.DB_URL;
import static cred.Credentials.USER;
import static cred.Credentials.PASS;

public class Customer {

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

    public void addCustomer(int idCustomer, int idUserApp, int money, int idAddress) throws SQLException {

        query = "INSERT INTO customer"
                + "VALUES"
                + "(" + idCustomer + ", "  + idUserApp + ", " + money + ", " + idAddress + ");";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteCustomer(int idCustomer) throws SQLException {

        query = "DELETE FROM courier WHERE id = " + idCustomer + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from customer table!");

    }

    public void updateCustomer(int idCustomer, String data, String field) throws SQLException {

        query = "UPDATE customer SET " + field + " = " + data + " WHERE id = " + idCustomer + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to customer table!");

    }

    public void updateCustomer(int idCustomer, int data, String field) throws SQLException {

        query = "UPDATE customer SET " + field + " = " + data + " WHERE id = " + idCustomer + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to customer table!");

    }

}
