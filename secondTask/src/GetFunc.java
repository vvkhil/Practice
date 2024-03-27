import java.sql.*;

public class GetFunc {

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

    public void get_all_from_user_app() throws SQLException {
        query = "SELECT * FROM user_app";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int user_id = resultSet.getInt("user_app_id");
            String login = resultSet.getString("login");

            System.out.println("userid : " + user_id);
            System.out.println("login : " + login);
            System.out.println();
        }

    }

    public void get_all_from_admin_shop() throws SQLException {
        query = "SELECT * FROM admin_shop";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int user_id = resultSet.getInt("user_id");
            int shop_id = resultSet.getInt("shop_id");

            System.out.println("id : " + id);
            System.out.println("user_id : " + user_id);
            System.out.println("shop_id : " + shop_id);
        }

    }

    public void get_all_from_courier() throws SQLException {
        query = "SELECT * FROM courier";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int user_id = resultSet.getInt("user_id");
            int rating = resultSet.getInt("rating");

            System.out.println("id : " + id);
            System.out.println("user_id : " + user_id);
            System.out.println("rating : " + rating);
        }

    }

    public void get_all_from_customer() throws SQLException {
        query = "SELECT * FROM customer";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int address_id = resultSet.getInt("address_id");
            int money_user = resultSet.getInt("money_user");

            System.out.println("id : " + id);
            System.out.println("address_id : " + address_id);
            System.out.println("money_user : " + money_user);
        }

    }

    public void get_all_from_provider() throws SQLException {
        query = "SELECT * FROM provider";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int user_id = resultSet.getInt("user_id");

            System.out.println("id : " + id);
            System.out.println("user_id : " + user_id);
        }

    }

    public void get_all_from_address() throws SQLException {
        query = "SELECT * FROM address";

        statement = connection.createStatement();

        // выполнить SQL запрос
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

    public void get_all_from_bask_cart() throws SQLException {
        query = "SELECT * FROM bask_cart";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int bask_shoe_id = resultSet.getInt("bask_shoe_id");
            int shopping_cart_id = resultSet.getInt("shopping_cart_id");

            System.out.println("bask_shoe_id : " + bask_shoe_id);
            System.out.println("shopping_cart_id : " + shopping_cart_id);
        }

    }

    public void get_all_from_bask_shoes() throws SQLException {
        query = "SELECT * FROM bask_shoe";

        statement = connection.createStatement();

        // выполнить SQL запрос
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

    public void get_all_from_catalog_products() throws SQLException {
        query = "SELECT * FROM catalog_products";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int bask_shoe_id = resultSet.getInt("bask_shoe_id");
            int shop_id = resultSet.getInt("shop_id");

            System.out.println("bask_shoe_id : " + bask_shoe_id);
            System.out.println("shop_id : " + shop_id);

        }

    }

    public void get_all_from_order_app() throws SQLException {
        query = "SELECT * FROM order_app";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int shop_id = resultSet.getInt("shop_id");
            int courier_id = resultSet.getInt("courier_id");

            System.out.println("id : " + id);
            System.out.println("shop_id : " + shop_id);
            System.out.println("courier_id : " + courier_id);

        }

    }

    public void get_all_from_order_description() throws SQLException {
        query = "SELECT * FROM order_description";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int order_id = resultSet.getInt("order_id");
            int status_list_id = resultSet.getInt("status_list_id");

            System.out.println("order_id : " + order_id);
            System.out.println("status_list_id : " + status_list_id);

        }

    }

    public void get_all_from_bask_shop() throws SQLException {
        query = "SELECT * FROM bask_shop";

        statement = connection.createStatement();

        // выполнить SQL запрос
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

    public void get_all_from_shopping_cart() throws SQLException {
        query = "SELECT * FROM shopping_cart";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int customer_id = resultSet.getInt("customer_id");

            System.out.println("id : " + id);
            System.out.println("customer_id : " + customer_id);

        }

    }

    public void get_all_from_status_list() throws SQLException {
        query = "SELECT * FROM status_list";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String status_name = resultSet.getString("status_name");

            System.out.println("id : " + id);
            System.out.println("status_name : " + status_name);

        }

    }

    public void get_all_from_supply() throws SQLException {
        query = "SELECT * FROM supply";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int provider_id = resultSet.getInt("provider_id");

            System.out.println("id : " + id);
            System.out.println("provider_id : " + provider_id);

        }

    }

    public void get_all_from_supply_log() throws SQLException {
        query = "SELECT * FROM supply_log";

        statement = connection.createStatement();

        // выполнить SQL запрос
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int bask_shoe_id = resultSet.getInt("bask_shoe_id");
            int supply_id = resultSet.getInt("supply_id");

            System.out.println("bask_shoe_id : " + bask_shoe_id);
            System.out.println("supply_id : " + supply_id);

        }

    }

}
