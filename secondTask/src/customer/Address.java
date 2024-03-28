package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static cred.Credentials.DB_URL;
import static cred.Credentials.USER;
import static cred.Credentials.PASS;

public class Address {

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

    public void addAddress(int idAddress, String city, String street,
                           String house, String flat) throws SQLException {

        query = "INSERT INTO address"
                + "VALUES"
                + "(" + idAddress + ", '" + city + "', '" + street + "', '" +
                house + "', '" + flat + "');";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteAddress(int idAddress) throws SQLException {

        query = "DELETE FROM address WHERE id = " + idAddress + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from address table!");

    }

    public void updateAddress(int idAddress, String data, String field) throws SQLException {

        query = "UPDATE address SET " + field + " = " + data + " WHERE id = " + idAddress + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to address table!");

    }

}
