package customer;

import app.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Address {

    static Logger logger = Logger.getLogger(Address.class.getName());

    private static final Properties properties = new Properties();

    static {
        try{
            properties.load(Main.class.getClassLoader().getResourceAsStream("db.properties"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    String query = null;
    Connection connection;

    public Address() {
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
