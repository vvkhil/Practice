package select;

import app.Main;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Selects {

    static final String BASK_SHOE_ID = "bask_shoe_id";
    static final String USER_ID = "user_id";
    static final String SHOP_ID = "shop_id";

    static final String ID = "id : {0}";

    static final String BASK_SHOE_ID_ZERO = "bask_shoe_id : {0}";
    static final String USER_ID_ZERO = "user_id : {0}";
    static final String SHOP_ID_ZERO = "shop_id : {0}";


    static Logger logger = Logger.getLogger(Selects.class.getName());
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

    public Selects() {
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

    public void getAllFromUserApp() throws SQLException {
        query = "SELECT * FROM user_app";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int userId = resultSet.getInt("user_app_id");
            String login = resultSet.getString("login");

            logger.log(Level.INFO, "Successfully append");

            logger.log(Level.INFO, "userid : {0}", userId);
            logger.log(Level.INFO, "login : {0}", login);
        }

    }

    public void getAllFromAdminShop() throws SQLException {
        query = "SELECT * FROM admin_shop";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt(USER_ID);
            int shopId = resultSet.getInt(SHOP_ID);

            logger.log(Level.INFO, "id: {0}", id);
            logger.log(Level.INFO, USER_ID_ZERO, userId);
            logger.log(Level.INFO, SHOP_ID_ZERO, shopId);
        }

    }

    public void getAllFromCourier() throws SQLException {
        query = "SELECT * FROM courier";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt(USER_ID);
            int rating = resultSet.getInt("rating");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, USER_ID_ZERO, userId);
            logger.log(Level.INFO, "rating : {0}", rating);
        }

    }

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

    public void getAllFromProvider() throws SQLException {
        query = "SELECT * FROM provider";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt(USER_ID);

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, USER_ID_ZERO, userId);
        }

    }

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

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, "city : {0}", city);
            logger.log(Level.INFO, "street : {0}", street);
            logger.log(Level.INFO, "house : {0}", house);
            logger.log(Level.INFO, "flat : {0}", flat);

        }

    }

    public void getAllFromBaskCart() throws SQLException {
        query = "SELECT * FROM bask_cart";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int baskShoeId = resultSet.getInt(BASK_SHOE_ID);
            int shoppingCartId = resultSet.getInt("shopping_cart_id");

            logger.log(Level.INFO, BASK_SHOE_ID_ZERO, baskShoeId);
            logger.log(Level.INFO, "shopping_cart_id : {0}", shoppingCartId);
        }

    }

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

    public void getAllFromCatalogProducts() throws SQLException {
        query = "SELECT * FROM catalog_products";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int baskShoeId = resultSet.getInt(BASK_SHOE_ID);
            int shopId = resultSet.getInt(SHOP_ID);

            logger.log(Level.INFO, BASK_SHOE_ID_ZERO, baskShoeId);
            logger.log(Level.INFO, SHOP_ID_ZERO, shopId);

        }

    }

    public void getAllFromOrderApp() throws SQLException {
        query = "SELECT * FROM order_app";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int shopId = resultSet.getInt(SHOP_ID);
            int courierId = resultSet.getInt("courier_id");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, SHOP_ID_ZERO, shopId);
            logger.log(Level.INFO, "courier_id : {0}", courierId);

        }

    }

    public void getAllFromOrderDescription() throws SQLException {
        query = "SELECT * FROM order_description";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int orderId = resultSet.getInt("order_id");
            int statusListId = resultSet.getInt("status_list_id");

            logger.log(Level.INFO, "order_id : {0}", orderId);
            logger.log(Level.INFO, "status_list_id : {0}", statusListId);

        }

    }

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

    public void getAllFromShoppingCart() throws SQLException {
        query = "SELECT * FROM shopping_cart";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int customerId = resultSet.getInt("customer_id");

            logger.log(Level.INFO, "id: {0}",  id);
            logger.log(Level.INFO, "customer_id: {0}", customerId);

        }

    }

    public void getAllFromStatusList() throws SQLException {
        query = "SELECT * FROM status_list";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String statusName = resultSet.getString("status_name");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, "status_name : {0}", statusName);

        }

    }

    public void getAllFromSupply() throws SQLException {
        query = "SELECT * FROM supply";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int providerId = resultSet.getInt("provider_id");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, "provider_id : {0}", providerId);

        }

    }

    public void getAllFromSupplyLog() throws SQLException {
        query = "SELECT * FROM supply_log";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int baskShoeId = resultSet.getInt(BASK_SHOE_ID);
            int supplyId = resultSet.getInt("supply_id");

            logger.log(Level.INFO, BASK_SHOE_ID_ZERO, baskShoeId);
            logger.log(Level.INFO, "supply_id : {0}", supplyId);

        }

    }

}
