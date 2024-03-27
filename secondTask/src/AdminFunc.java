import java.sql.*;

public class AdminFunc {

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

    public void add_bask_shoes_shop(int id_shoes_shop, String title, int rating) throws SQLException {

        query = "INSERT INTO bask_shop"
                + "(id, title, rating) " + "VALUES"
                + "(" + id_shoes_shop + "," + "'" + title + "', " + rating + ");";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_shoes_shop(int id_shoes_shop) throws SQLException {

        query = "DELETE FROM bask_shop WHERE id = " + id_shoes_shop + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from bask_shop table!");

    }

    public void update_shoes_shop(int id_shoes_shop, String data, String field) throws SQLException {

        query = "UPDATE bask_shop SET " + field + " = '" + data + "' WHERE id = " + id_shoes_shop + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to bask_shop table!");

    }

    public void update_shoes_shop(int id_shoes_shop, int data, String field) throws SQLException {

        query = "UPDATE bask_shop SET " + field + " = " + data + " WHERE id = " + id_shoes_shop + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to bask_shop table!");

    }

    public void add_catalog_shoes(int id_shoes, int shoes_shop_id) throws SQLException {

        query = "INSERT INTO catalog_products"
                + "VALUES"
                + "(" + id_shoes + "," + shoes_shop_id + ");";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_catalog_shoes(int id_shoes_shop, int id_bask_shoes) throws SQLException {

        query = "DELETE FROM catalog_products WHERE bask_shoe_id = " + id_bask_shoes +
                " AND " + "shop_id = " + id_shoes_shop + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from catalog_shoes table!");

    }

    public void add_user(int id_user_app, String login, String email, String password) throws SQLException {

        query = "INSERT INTO user_app"
                + "(user_app_id, login, email, password) " + "VALUES"
                + "(" + id_user_app + ", '" + login + "', '" + email + "', '" + password + "');";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_user(int id_user_app) throws SQLException {

        query = "DELETE FROM user_app WHERE user_app_id = " + id_user_app + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from user table!");

    }

    public void update_user(int id_user_app, String data, String field) throws SQLException {

        query = "UPDATE user_app SET " + field + " = " + data + " WHERE id = " + id_user_app + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to user table!");

    }

    public void update_user(int id_user_app, int data, String field) throws SQLException {

        query = "UPDATE user_app SET " + field + " = " + data + " WHERE id = " + id_user_app + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to user table!");

    }

    public void add_admin(int id_admin, int id_user_app, int id_shop) throws SQLException {

        query = "INSERT INTO admin_shop"
                + "VALUES"
                + "(" + id_admin + ", "  + id_user_app + ", " + id_shop + ");";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_admin(int id_admin) throws SQLException {

        query = "DELETE FROM admin_shop WHERE id = " + id_admin + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from admin table!");

    }

    public void update_admin(int id_admin, String data, String field) throws SQLException {

        query = "UPDATE admin_shop SET " + field + " = " + data + " WHERE id = " + id_admin + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to admin table!");

    }

    public void update_admin(int id_admin, int data, String field) throws SQLException {

        query = "UPDATE admin_shop SET " + field + " = " + data + " WHERE id = " + id_admin + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to admin table!");

    }

    public void add_customer(int id_customer, int id_user_app, int money,  int id_address) throws SQLException {

        query = "INSERT INTO customer"
                + "VALUES"
                + "(" + id_customer + ", "  + id_user_app + ", " + money + ", " + id_address + ");";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_customer(int id_customer) throws SQLException {

        query = "DELETE FROM courier WHERE id = " + id_customer + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from customer table!");

    }

    public void update_customer(int id_customer, String data, String field) throws SQLException {

        query = "UPDATE customer SET " + field + " = " + data + " WHERE id = " + id_customer + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to customer table!");

    }

    public void update_customer(int id_customer, int data, String field) throws SQLException {

        query = "UPDATE customer SET " + field + " = " + data + " WHERE id = " + id_customer + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to customer table!");

    }

    public void add_provider(int id_provider, int id_user_app) throws SQLException {

        query = "INSERT INTO provider"
                + "VALUES"
                + "(" + id_provider + ", "  + id_user_app + ");";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_provider(int id_provider) throws SQLException {

        query = "DELETE FROM provider WHERE id = " + id_provider + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from provider table!");

    }

    public void update_provider(int id_provider, String data, String field) throws SQLException {

        query = "UPDATE provider SET " + field + " = " + data + " WHERE id = " + id_provider + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to provider table!");

    }

    public void update_provider(int id_provider, int data, String field) throws SQLException {

        query = "UPDATE provider SET " + field + " = " + data + " WHERE id = " + id_provider + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to provider table!");

    }

}
