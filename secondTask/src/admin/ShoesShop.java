package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShoesShop {

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

    public void addBaskShoesShop(int idShoesShop, String title, int rating) throws SQLException {

        query = "INSERT INTO bask_shop"
                + "(id, title, rating) " + "VALUES"
                + "(" + idShoesShop + "," + "'" + title + "', " + rating + ");";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteShoesShop(int idShoesShop) throws SQLException {

        query = "DELETE FROM bask_shop WHERE id = " + idShoesShop + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from bask_shop table!");

    }

    public void updateShoesShop(int idShoesShop, String data, String field) throws SQLException {

        query = "UPDATE bask_shop SET " + field + " = '" + data + "' WHERE id = " + idShoesShop + ";";

        statement = connection.createStatement();

        statement.execute(query);

        logger.log(Level.INFO, "Record is updated to bask_shop table!");

    }

    public void updateShoesShop(int idShoesShop, int data, String field) throws SQLException {

        query = "UPDATE bask_shop SET " + field + " = " + data + " WHERE id = " + idShoesShop + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to bask_shop table!");

    }

}
