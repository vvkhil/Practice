package users;

import app.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Admin {

    static Logger logger = Logger.getLogger(Admin.class.getName());

    private static final Properties properties = new Properties();

    static {
        try{
            properties.load(Main.class.getClassLoader().getResourceAsStream("db.properties"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    String query = null;
    Connection connection;

    public Admin() {
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
