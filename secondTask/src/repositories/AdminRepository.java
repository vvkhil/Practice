package repositories;

import app.Main;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminRepository {

    static final String USER_ID = "user_id";
    static final String SHOP_ID = "shop_id";
    static final String USER_ID_ZERO = "user_id : {0}";
    static final String SHOP_ID_ZERO = "shop_id : {0}";


    static Logger logger = Logger.getLogger(AdminRepository.class.getName());

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

    public AdminRepository() {
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

    public void getAllFromAdminShop() throws SQLException {
        query = "SELECT * FROM admin_shop";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt(USER_ID);
            int shopId = resultSet.getInt(SHOP_ID);

            logger.log(Level.INFO, "id: {0}", id);
            logger.log(Level.INFO, USER_ID_ZERO, userId);
            logger.log(Level.INFO, SHOP_ID_ZERO, shopId);
        }

    }

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
