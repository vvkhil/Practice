package repositories;

import app.Main;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProviderRepository {

    static final String USER_ID = "user_id";

    static final String ID = "id : {0}";

    static final String USER_ID_ZERO = "user_id : {0}";

    static Logger logger = Logger.getLogger(ProviderRepository.class.getName());

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

    public ProviderRepository() {
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

    public void addProvider(int idProvider, int idUserApp) throws SQLException {

        query = "INSERT INTO provider"
                + "VALUES"
                + "(" + idProvider + ", "  + idUserApp + ");";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteProvider(int idProvider) throws SQLException {

        query = "DELETE FROM provider WHERE id = " + idProvider + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from provider table!");

    }

    public void updateProvider(int idProvider, String data, String field) throws SQLException {

        query = "UPDATE provider SET " + field + " = " + data + " WHERE id = " + idProvider + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to provider table!");

    }

    public void updateProvider(int idProvider, int data, String field) throws SQLException {

        query = "UPDATE provider SET " + field + " = " + data + " WHERE id = " + idProvider + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to provider table!");

    }

}
