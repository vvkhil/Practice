package repositories;

import app.Main;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerRepository {

    static final String ID = "id : {0}";

    static Logger logger = Logger.getLogger(CustomerRepository.class.getName());

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

    public CustomerRepository() {
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

    public void getAllFromCustomer() throws SQLException {
        query = "SELECT * FROM customer";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int addressId = resultSet.getInt("address_id");
            int moneyUser = resultSet.getInt("money_user");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, "address_id : {0}", addressId);
            logger.log(Level.INFO, "money_user : {0}", moneyUser);
        }

    }

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
