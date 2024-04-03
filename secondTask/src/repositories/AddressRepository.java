package repositories;

import app.Main;
import entities.Address;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddressRepository {

    static final String ID = "id : {0}";

    static Logger logger = Logger.getLogger(AddressRepository.class.getName());

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

    public AddressRepository() {
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

    public void getAllFromAddress() throws SQLException {
        query = "SELECT * FROM address";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String city = resultSet.getString("city");
            String street = resultSet.getString("street");
            String house = resultSet.getString("house");
            String flat = resultSet.getString("flat");
            int idUser = resultSet.getInt("user_id");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, "city : {0}", city);
            logger.log(Level.INFO, "street : {0}", street);
            logger.log(Level.INFO, "house : {0}", house);
            logger.log(Level.INFO, "flat : {0}", flat);
            logger.log(Level.INFO, "idUser: {0}", idUser);

        }

    }

    public void addAddress(Address address) throws SQLException {

        Integer idAddress = address.getId();
        String city = address.getCity();
        String street = address.getStreet();
        String house = address.getHouse();
        String flat = address.getFlat();
        Integer idUser = address.getUserId();


        query = "INSERT INTO address "
                + "VALUES"
                + "(" + idAddress + ", '" + city + "', '" + street + "', '" +
                house + "', '" + flat + "', '" + idUser + "');";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteAddress(Address address) throws SQLException {

        Integer idAddress = address.getId();

        query = "DELETE FROM address WHERE id = " + idAddress + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from address table!");

    }

    public void updateAddress(Address address, String data, String field) throws SQLException {

        Integer idAddress = address.getId();

        query = "UPDATE address SET " + field + " = " + data + " WHERE id = " + idAddress + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to address table!");

    }

}
