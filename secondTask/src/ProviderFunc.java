import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ProviderFunc {

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

    public void add_bask_shoes(int id_bask_shoes, String title, String description,
                               int price, String manufacturer, String brand, int size) throws SQLException {

        query = "INSERT INTO bask_shoe"
                + "VALUES"
                + "(" + id_bask_shoes + ", '" + title + "', '" + description + "', " + price + ", '" +
                manufacturer + "', '" + brand + "', " + size + ");";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_bask_shoes(int id_bask_shoes) throws SQLException {

        query = "DELETE FROM bask_shoe WHERE id = " + id_bask_shoes + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from bask_shoe table!");

    }

    public void update_bask_shoes(int id_bask_shoes, String data, String field) throws SQLException {

        query = "UPDATE bask_shoe SET " + field + " = " + data + " WHERE id = " + id_bask_shoes + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to bask_shoe table!");

    }

    public void update_bask_shoes(int id_bask_shoes, int data, String field) throws SQLException {

        query = "UPDATE bask_shoe SET " + field + " = " + data + " WHERE id = " + id_bask_shoes + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to bask_shoe table!");

    }

    public void add_supply(int id_supply, int id_provider) throws SQLException {

        query = "INSERT INTO supply"
                + "(id, provider_id) " + "VALUES"
                + "(" + id_supply + "," + id_provider + ");";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_supply(int id_supply) throws SQLException {

        query = "DELETE FROM supply WHERE id = " + id_supply + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from supply table!");

    }

    public void update_supply(int id_supply, String data, String field) throws SQLException {

        query = "UPDATE supply SET " + field + " = " + data + " WHERE id = " + id_supply + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to supply table!");

    }

    public void update_supply(int id_supply, int data, String field) throws SQLException {

        query = "UPDATE supply SET " + field + " = " + data + " WHERE id = " + id_supply + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to supply table!");

    }

    public void add_supply_log(int id_bask_shoe, int supply_id) throws SQLException {

        query = "INSERT INTO supply_log"
                + "VALUES"
                + "(" + id_bask_shoe + "," + supply_id + ");";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_supply_log(int id_bask_shoe, int supply_id) throws SQLException {

        query = "DELETE supply_log WHERE bask_shoe_id = " + id_bask_shoe +
                " AND " + "supply_id = " + supply_id + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from supply_log table!");

    }

}
