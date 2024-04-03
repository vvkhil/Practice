package repositories;

import app.Main;
import entities.Role;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoleRepository {

    static final String USER_ID = "user_id";

    static final String ID = "id : {0}";

    static final String USER_ID_ZERO = "user_id : {0}";

    static Logger logger = Logger.getLogger(RoleRepository.class.getName());

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

    public RoleRepository() {
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

    public void getAllFromRoles() throws SQLException {
        query = "SELECT * FROM role";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, "name : {0}", name);
        }

    }

    public void addRole(Role role) throws SQLException {

        int idRole = role.getId();
        String name = role.getName();

        query = "INSERT INTO role"
                + "VALUES"
                + "(" + idRole + ", "  + name + ");";

        statement = connection.createStatement();

        statement.executeUpdate(query);
        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteRole(Role role) throws SQLException {

        int idRole = role.getId();

        query = "DELETE FROM role WHERE id = " + idRole + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is deleted from provider table!");

    }

    public void updateRole(Role role, String data, String field) throws SQLException {

        int idRole = role.getId();

        query = "UPDATE role SET " + field + " = " + data + " WHERE id = " + idRole + ";";

        statement = connection.createStatement();

        statement.execute(query);
        logger.log(Level.INFO, "Record is updated to provider table!");

    }

}
