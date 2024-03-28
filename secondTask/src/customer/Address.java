package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Address {

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
