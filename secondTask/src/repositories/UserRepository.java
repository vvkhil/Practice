package repositories;

import app.Main;
import entities.User;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository {

    static Logger logger = Logger.getLogger(UserRepository.class.getName());

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

    public UserRepository() {
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

    public void addUser(User user) throws SQLException {

        int idUserApp = user.getId();
        String login = user.getLogin();
        String email = user.getEmail();
        String password = user.getPassword();

        query = "INSERT INTO user_app"
                + "(user_app_id, login, email, password) " + "VALUES"
                + "(" + idUserApp + ", '" + login + "', '" + email + "', '" + password + "');";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteUser(User user) throws SQLException {

        int idUserApp = user.getId();

        query = "DELETE FROM user_app WHERE user_app_id = " + idUserApp + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from user table!");

    }

    public void updateUser(User user, String data, String field) throws SQLException {

        int idUserApp = user.getId();

        query = "UPDATE user_app SET " + field + " = " + data + " WHERE id = " + idUserApp + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to user table!");

    }

    public void updateUser(User user, int data, String field) throws SQLException {

        int idUserApp = user.getId();

        query = "UPDATE user_app SET " + field + " = " + data + " WHERE id = " + idUserApp + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to user table!");

    }

}
