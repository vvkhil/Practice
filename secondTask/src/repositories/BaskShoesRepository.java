package repositories;

import app.Main;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaskShoesRepository {

    static final String ID = "id : {0}";

    static Logger logger = Logger.getLogger(BaskShoesRepository.class.getName());

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

    public BaskShoesRepository() {
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

    public void getAllFromBaskShoes() throws SQLException {
        query = "SELECT * FROM bask_shoe";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String brand = resultSet.getString("brand");
            String manufacturer = resultSet.getString("manufacturer");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, "title : {0}", title);
            logger.log(Level.INFO, "description : {0}", description);
            logger.log(Level.INFO, "brand : {0}", brand);
            logger.log(Level.INFO, "manufacturer : {0}", manufacturer);
        }

    }

    public void addBaskShoes(int idBaskShoes, String title, String description,
                             int price, String manufacturer, String brand, int size) throws SQLException {

        query = "INSERT INTO bask_shoe"
                + "VALUES"
                + "(" + idBaskShoes + ", '" + title + "', '" + description + "', " + price + ", '" +
                manufacturer + "', '" + brand + "', " + size + ");";

        statement = connection.createStatement();

        statement.executeUpdate(query);

        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteBaskShoes(int idBaskShoes) throws SQLException {

        query = "DELETE FROM bask_shoe WHERE id = " + idBaskShoes + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from bask_shoe table!");

    }

    public void updateBaskShoes(int idBaskShoes, String data, String field) throws SQLException {

        query = "UPDATE bask_shoe SET " + field + " = " + data + " WHERE id = " + idBaskShoes + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to bask_shoe table!");

    }

    public void updateBaskShoes(int idBaskShoes, int data, String field) throws SQLException {

        query = "UPDATE bask_shoe SET " + field + " = " + data + " WHERE id = " + idBaskShoes + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to bask_shoe table!");

    }

}
