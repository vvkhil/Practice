package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static cred.Credentials.DB_URL;
import static cred.Credentials.USER;
import static cred.Credentials.PASS;

public class Admin {

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

    public void addAdmin(int idAdmin, int idUserApp, int idShop) throws SQLException {

        query = "INSERT INTO admin_shop"
                + "VALUES"
                + "(" + idAdmin + ", "  + idUserApp + ", " + idShop + ");";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteAdmin(int idAdmin) throws SQLException {

        query = "DELETE FROM admin_shop WHERE id = " + idAdmin + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from admin table!");

    }

    public void updateAdmin(int idAdmin, String data, String field) throws SQLException {

        query = "UPDATE admin_shop SET " + field + " = " + data + " WHERE id = " + idAdmin + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to admin table!");

    }

    public void updateAdmin(int idAdmin, int data, String field) throws SQLException {

        query = "UPDATE admin_shop SET " + field + " = " + data + " WHERE id = " + idAdmin + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to admin table!");

    }

}
