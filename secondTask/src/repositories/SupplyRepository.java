package repositories;

import app.Main;
import entities.Supply;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupplyRepository {

    static final String ID = "id : {0}";

    static final String INSERT_INTO = "INSERT INTO supply_log VALUES ";

    static final String D_D = "(%d, %d), ";

    static Logger logger = Logger.getLogger(SupplyRepository.class.getName());

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

    public SupplyRepository() {
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

    public void getAllFromSupply() throws SQLException {
        query = "SELECT * FROM supply";

        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt("user_id");

            logger.log(Level.INFO, ID, id);
            logger.log(Level.INFO, "userId : {0}", userId);

        }

    }

    public void addSupply(Supply supply) throws SQLException {

        int idSupply = supply.getId();
        int idUser = supply.getUserId();

        query = "INSERT INTO supply"
                + "(id, user_id) " + "VALUES"
                + "(" + idSupply + "," + idUser + ");";

        StringBuilder secondQuery = new StringBuilder(INSERT_INTO);
        for (Integer baskShoesId : supply.getBaskShoes()) {
            secondQuery.append(String.format(D_D, baskShoesId, idSupply));
        }
        secondQuery = new StringBuilder(secondQuery.substring(0, secondQuery.length() - 2));
        try (Statement stat = connection.createStatement()) {
            stat.executeUpdate(query);
            stat.executeUpdate(secondQuery.toString());
        } catch (SQLException e) {
            logger.info(e.toString());
        }

        logger.log(Level.INFO, "Successfully append");

    }

    public void deleteSupply(Supply supply) throws SQLException {

        int idSupply = supply.getId();

        query = "DELETE FROM supply_log WHERE supply_id = " + idSupply + ";";
        String secondQuery = "DELETE FROM supply WHERE id = " + idSupply + ";";

        statement = connection.createStatement();

        statement.execute(query);
        statement.execute(secondQuery);
        logger.log(Level.INFO, "Record is deleted from supply table!");

    }

    public void updateSupply(Supply supply, String data, String field) throws SQLException {

        int idSupply = supply.getId();

        query = "UPDATE supply SET " + field + " = " + data + " WHERE id = " + idSupply + ";";
        String secondQuery = String.format("DELETE FROM supply_log WHERE supply_id = %d", idSupply);
        StringBuilder thirdQuery = new StringBuilder(INSERT_INTO);
        for (Integer baskShoesId : supply.getBaskShoes()) {
            thirdQuery.append(String.format(D_D, baskShoesId, idSupply));
        }
        thirdQuery = new StringBuilder(thirdQuery.substring(0, thirdQuery.length() - 2));
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
            stmt.executeUpdate(secondQuery);
            stmt.executeUpdate(thirdQuery.toString());
        } catch (SQLException e) {
            logger.info(e.toString());
        }

        logger.log(Level.INFO, "Record is updated to supply table!");

    }

    public void updateSupply(Supply supply, int data, String field) throws SQLException {

        int idSupply = supply.getId();

        query = "UPDATE supply SET " + field + " = " + data + " WHERE id = " + idSupply + ";";
        String secondQuery = String.format("DELETE FROM supply_log WHERE supply_id = %d", idSupply);
        StringBuilder thirdQuery = new StringBuilder(INSERT_INTO);
        for (Integer baskShoesId : supply.getBaskShoes()) {
            thirdQuery.append(String.format(D_D, baskShoesId, idSupply));
        }
        thirdQuery = new StringBuilder(thirdQuery.substring(0, thirdQuery.length() - 2));
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
            stmt.executeUpdate(secondQuery);
            stmt.executeUpdate(thirdQuery.toString());
        } catch (SQLException e) {
            logger.info(e.toString());
        }

        logger.log(Level.INFO, "Record is updated to supply table!");

    }

}
