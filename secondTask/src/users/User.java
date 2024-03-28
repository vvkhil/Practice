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

public class User {

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

    public void addUser(int idUserApp, String login, String email, String password) throws SQLException {

        query = "INSERT INTO user_app"
                + "(user_app_id, login, email, password) " + "VALUES"
                + "(" + idUserApp + ", '" + login + "', '" + email + "', '" + password + "');";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteUser(int idUserApp) throws SQLException {

        query = "DELETE FROM user_app WHERE user_app_id = " + idUserApp + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from user table!");

    }

    public void updateUser(int idUserApp, String data, String field) throws SQLException {

        query = "UPDATE user_app SET " + field + " = " + data + " WHERE id = " + idUserApp + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to user table!");

    }

    public void updateUser(int idUserApp, int data, String field) throws SQLException {

        query = "UPDATE user_app SET " + field + " = " + data + " WHERE id = " + idUserApp + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to user table!");

    }

}
