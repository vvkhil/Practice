import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerFunc {

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

    public void add_address(int id_address, String city, String street,
                               String house, String flat) throws SQLException {

        query = "INSERT INTO address"
                + "VALUES"
                + "(" + id_address + ", '" + city + "', '" + street + "', '" +
                house + "', '" + flat + "');";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.executeUpdate(query);
        System.out.println("Successfully append");

    }

    public void delete_address(int id_address) throws SQLException {

        query = "DELETE FROM address WHERE id = " + id_address + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is deleted from address table!");

    }

    public void update_address(int id_address, String data, String field) throws SQLException {

        query = "UPDATE address SET " + field + " = " + data + " WHERE id = " + id_address + ";";

        statement = connection.createStatement();

        // выполнить SQL запрос
        statement.execute(query);
        System.out.println("Record is updated to address table!");

    }

}
