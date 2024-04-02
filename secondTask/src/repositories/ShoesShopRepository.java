package repositories;

import app.Main;
import entities.ShoesShop;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShoesShopRepository {

    static final String ID = "id : {0}";

    static final String INSERT_INTO = "INSERT INTO catalog_shoes VALUES ";

    static final String D_D = "(%d, %d), ";

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

    public void addBaskShoesShop(ShoesShop shoesShop) throws SQLException {

        int idShoesShop = shoesShop.getId();
        String title = shoesShop.getTitle();
        int rating = shoesShop.getRating();

        query = "INSERT INTO bask_shop"
                + "(id, title, rating) " + "VALUES"
                + "(" + idShoesShop + "," + "'" + title + "', " + rating + ");";

        StringBuilder secondQuery = new StringBuilder(INSERT_INTO);
        for (Integer baskShoesId : shoesShop.getBaskShoes()) {
            secondQuery.append(String.format(D_D, baskShoesId, idShoesShop));
        }
        secondQuery = new StringBuilder(secondQuery.substring(0, secondQuery.length() - 2));
        try (Statement stat = connection.createStatement()) {
            stat.executeUpdate(query);
            stat.executeUpdate(secondQuery.toString());
        } catch (SQLException e) {
            logger.info(e.toString());
        }

        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteShoesShop(ShoesShop shoesShop) throws SQLException {

        int idShoesShop = shoesShop.getId();

        query = "DELETE FROM catalog_shoes WHERE shop_id = " + idShoesShop + ";";
        String secondQuery = "DELETE FROM bask_shop WHERE id = " + idShoesShop + ";";

        statement = connection.createStatement();

        statement.execute(query);
        statement.execute(secondQuery);
        logger.log(Level.INFO, "Record is deleted from bask_shop table!");

    }

    public void updateShoesShop(ShoesShop shoesShop, String data, String field) throws SQLException {

        int idShoesShop = shoesShop.getId();

        query = "UPDATE bask_shop SET " + field + " = '" + data + "' WHERE id = " + idShoesShop + ";";
        String secondQuery = String.format("DELETE FROM catalog_shoes WHERE shop_id = %d", idShoesShop);
        StringBuilder thirdQuery = new StringBuilder(INSERT_INTO);
        for (Integer baskShoesId : shoesShop.getBaskShoes()) {
            thirdQuery.append(String.format(D_D, baskShoesId, idShoesShop));
        }
        thirdQuery = new StringBuilder(thirdQuery.substring(0, thirdQuery.length() - 2));
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
            stmt.executeUpdate(secondQuery);
            stmt.executeUpdate(thirdQuery.toString());
        } catch (SQLException e) {
            logger.info(e.toString());
        }

        logger.log(Level.INFO, "Record is updated to bask_shop table!");

    }

    public void updateShoesShop(ShoesShop shoesShop, int data, String field) throws SQLException {

        int idShoesShop = shoesShop.getId();

        query = "UPDATE bask_shop SET " + field + " = " + data + " WHERE id = " + idShoesShop + ";";
        String secondQuery = String.format("DELETE FROM catalog_shoes WHERE shop_id = %d", idShoesShop);
        StringBuilder thirdQuery = new StringBuilder(INSERT_INTO);
        for (Integer baskShoesId : shoesShop.getBaskShoes()) {
            thirdQuery.append(String.format(D_D, baskShoesId, idShoesShop));
        }
        thirdQuery = new StringBuilder(thirdQuery.substring(0, thirdQuery.length() - 2));
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
            stmt.executeUpdate(secondQuery);
            stmt.executeUpdate(thirdQuery.toString());
        } catch (SQLException e) {
            logger.info(e.toString());
        }
        logger.log(Level.INFO, "Record is updated to bask_shop table!");

    }

}
