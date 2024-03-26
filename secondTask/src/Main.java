import java.sql.*;

import java.util.Scanner;

public class Main {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://localhost/practice";
    static final String USER = "postgres";
    static final String PASS = "vvkhil682423";

    public static void main(String[] argv) {

        Scanner in = new Scanner(System.in);
        String query = null;

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

//        String insertTableSQL = "INSERT INTO user_app"
//                + "(login, email, password) " + "VALUES"
//                + "('ya','ya@mail.ru','123456')";
//

        String login = "";
        String email = "";
        String password = "";

        String role_user = "";

        while(true) {

            System.out.println("Enter your login please");
            login = in.nextLine();
            System.out.println("Enter your email please");
            email = in.nextLine();
            System.out.println("Enter your password please");
            password = in.nextLine();


            query = "SELECT user_app_id FROM user_app WHERE login = '" + login + "' AND email = '"
                    + email + "' AND password= '" + password + "'";

            try {

                statement = connection.createStatement();

                // выполнить SQL запрос
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next() == false) {
                    System.out.println("Your user isn't in database.\nPlease enter again.\n");
                    continue;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }

            break;

        }

        while(true) {

            System.out.println("Enter your role(admin, customer, courier, provider):");
            role_user = in.nextLine();

            if (role_user.equals("admin")) {

                query = "SELECT * FROM admin_shop WHERE user_id = (SELECT user_app_id FROM user_app " +
                        "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                        password + "')" ;

                try {

                    statement = connection.createStatement();

                    // выполнить SQL запрос
                    ResultSet resultSet = statement.executeQuery(query);

                    if (resultSet.next() == false) {
                        System.out.println("Your user isn't an admin.\nPlease enter your role again.\n");
                        continue;
                    }

                    String query_id = "SELECT id FROM admin_shop WHERE user_id = (SELECT user_app_id FROM user_app " +
                            "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                            password + "')" ;

                    resultSet = statement.executeQuery(query_id);

                    resultSet.next();
                    int admin_id = resultSet.getInt("id");
                    System.out.println("id admin:" + admin_id);
                    System.out.println("Hello admin");

                } catch (SQLException e) {
                    System.out.println(e.getMessage());

                }

                break;

            }

            else if (role_user.equals("customer")) {

                query = "SELECT * FROM admin_shop WHERE user_id = (SELECT user_app_id FROM user_app " +
                        "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                        password + "')" ;

                try {

                    statement = connection.createStatement();

                    // выполнить SQL запрос
                    ResultSet resultSet = statement.executeQuery(query);

                    if (resultSet.next() == false) {
                        System.out.println("Your user isn't an admin.\nPlease enter your role again.\n");
                        continue;
                    }

                    String query_id = "SELECT id FROM admin_shop WHERE user_id = (SELECT user_app_id FROM user_app " +
                            "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                            password + "')" ;

                    resultSet = statement.executeQuery(query_id);

                    resultSet.next();
                    int admin_id = resultSet.getInt("id");
                    System.out.println("id admin:" + admin_id);
                    System.out.println("Hello admin");

                } catch (SQLException e) {
                    System.out.println(e.getMessage());

                }

                break;

            }

        }
    }
}
