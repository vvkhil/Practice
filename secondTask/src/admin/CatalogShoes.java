package admin;

import app.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogShoes {

    static Logger logger = Logger.getLogger(CatalogShoes.class.getName());
    private static final Properties properties = new Properties();
    static {
        try{
            properties.load(Main.class.getClassLoader().getResourceAsStream("db.properties"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    String query = null;
    static Connection connection;

    public static Connection connect() throws SQLException {

        try {
            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password"));
        } catch (SQLException  e) {
            logger.warning(e.getMessage());
        }
        return null;
    }

    Statement statement = null;

    public void addCatalogShoes(int idShoes, int shoesShopId) throws SQLException {

        query = "INSERT INTO catalog_products"
                + "VALUES"
                + "(" + idShoes + "," + shoesShopId + ");";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteCatalogShoes(int idShoesShop, int idBaskShoes) throws SQLException {

        query = "DELETE FROM catalog_products WHERE bask_shoe_id = " + idBaskShoes +
                " AND " + "shop_id = " + idShoesShop + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from catalog_shoes table!");

    }

}
