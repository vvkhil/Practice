import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Selects {

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

    public void getAllFromUserApp() throws SQLException {
        query = "SELECT * FROM user_app";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int userId = resultSet.getInt("user_app_id");
            String login = resultSet.getString("login");

            logger.log(Level.INFO, "Successfully append");

            System.out.println("userid : " + userId);
            System.out.println("login : " + login);
            System.out.println();
        }

    }

    public void getAllFromAdminShop() throws SQLException {
        query = "SELECT * FROM admin_shop";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt("user_id");
            int shopId = resultSet.getInt("shop_id");

            System.out.println("id : " + id);
            System.out.println("user_id : " + userId);
            System.out.println("shop_id : " + shopId);
        }

    }

    public void getAllFromCourier() throws SQLException {
        query = "SELECT * FROM courier";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt("user_id");
            int rating = resultSet.getInt("rating");

            System.out.println("id : " + id);
            System.out.println("user_id : " + userId);
            System.out.println("rating : " + rating);
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

            System.out.println("id : " + id);
            System.out.println("address_id : " + addressId);
            System.out.println("money_user : " + moneyUser);
        }

    }

    public void getAllFromProvider() throws SQLException {
        query = "SELECT * FROM provider";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt("user_id");

            System.out.println("id : " + id);
            System.out.println("user_id : " + userId);
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

            System.out.println("id : " + id);
            System.out.println("city : " + city);
            System.out.println("street : " + street);
            System.out.println("house : " + house);
            System.out.println("flat : " + flat);

        }

    }

    public void getAllFromBaskCart() throws SQLException {
        query = "SELECT * FROM bask_cart";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int baskShoeId = resultSet.getInt("bask_shoe_id");
            int shoppingCartId = resultSet.getInt("shopping_cart_id");

            System.out.println("bask_shoe_id : " + baskShoeId);
            System.out.println("shopping_cart_id : " + shoppingCartId);
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

            System.out.println("id : " + id);
            System.out.println("title : " + title);
            System.out.println("description : " + description);
            System.out.println("brand : " + brand);
            System.out.println("manufacturer : " + manufacturer);
        }

    }

    public void getAllFromCatalogProducts() throws SQLException {
        query = "SELECT * FROM catalog_products";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int baskShoeId = resultSet.getInt("bask_shoe_id");
            int shopId = resultSet.getInt("shop_id");

            System.out.println("bask_shoe_id : " + baskShoeId);
            System.out.println("shop_id : " + shopId);

        }

    }

    public void getAllFromOrderApp() throws SQLException {
        query = "SELECT * FROM order_app";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int shopId = resultSet.getInt("shop_id");
            int courierId = resultSet.getInt("courier_id");

            System.out.println("id : " + id);
            System.out.println("shop_id : " + shopId);
            System.out.println("courier_id : " + courierId);

        }

    }

    public void getAllFromOrderDescription() throws SQLException {
        query = "SELECT * FROM order_description";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int orderId = resultSet.getInt("order_id");
            int statusListId = resultSet.getInt("status_list_id");

            System.out.println("order_id : " + orderId);
            System.out.println("status_list_id : " + statusListId);

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

            System.out.println("id : " + id);
            System.out.println("title : " + title);
            System.out.println("rating: " + rating);

        }

    }

    public void getAllFromShoppingCart() throws SQLException {
        query = "SELECT * FROM shopping_cart";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int customerId = resultSet.getInt("customer_id");

            System.out.println("id : " + id);
            System.out.println("customer_id : " + customerId);

        }

    }

    public void getAllFromStatusList() throws SQLException {
        query = "SELECT * FROM status_list";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String statusName = resultSet.getString("status_name");

            System.out.println("id : " + id);
            System.out.println("status_name : " + statusName);

        }

    }

    public void getAllFromSupply() throws SQLException {
        query = "SELECT * FROM supply";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int providerId = resultSet.getInt("provider_id");

            System.out.println("id : " + id);
            System.out.println("provider_id : " + providerId);

        }

    }

    public void getAllFromSupplyLog() throws SQLException {
        query = "SELECT * FROM supply_log";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int baskShoeId = resultSet.getInt("bask_shoe_id");
            int supplyId = resultSet.getInt("supply_id");

            System.out.println("bask_shoe_id : " + baskShoeId);
            System.out.println("supply_id : " + supplyId);

        }

    }

}
