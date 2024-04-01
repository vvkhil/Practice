package repositories;

import app.Main;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShoesShopRepository {

    static final String ID = "id : {0}";

    static Logger logger = Logger.getLogger(ShoesShopRepository.class.getName());

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

    public ShoesShopRepository() {
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

    public void getAllFromBaskShop() throws SQLException {
        query = "SELECT * FROM bask_shop";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            int rating = resultSet.getInt("rating");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, "title : {0}", title);
            logger.log(Level.INFO, "rating: {0}", rating);

        }

    }

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
