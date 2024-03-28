package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static cred.Credentials.DB_URL;
import static cred.Credentials.USER;
import static cred.Credentials.PASS;

public class CatalogShoes {

    static Logger logger;

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
