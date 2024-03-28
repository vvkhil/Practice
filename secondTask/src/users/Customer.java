package users;

import app.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer {

    static Logger logger = Logger.getLogger(Customer.class.getName());

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

    public Customer() {
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
