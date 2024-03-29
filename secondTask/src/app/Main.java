package app;

import admin.CatalogShoes;
import admin.ShoesShop;
import customer.Address;
import provider.BaskShoes;
import provider.Supply;
import select.Selects;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static final String AND_EMAIL = "' AND email = '";
    static final String AND_PASSWORD = "' AND password= '";
    static final String WHERE_LOGIN = "WHERE login = '";
    static final String SELECT_ACTION = "Select action";
    static final String SELECT_FIELD = "Select field";
    static final String ENTER_ID_BASK_SHOP = "Enter id bask shop:";
    static final String INCORRECT_INDEX = "You enter incorrect index.\n Please try again.\n";
    static final String ENTER_ID_SHOE = "Enter id shoe:";
    static final String CHOICE_CORRECT_INDEX = "Choice correct index!";

    static Logger logger;

    private static final Properties properties = new Properties();

    static {
        try{
            properties.load(Main.class.getClassLoader().getResourceAsStream("db.properties"));
        }catch(Exception e){
            logger.warning(e.getMessage());
        }
    }

    public static void main(String[] argv) throws SQLException {

        Scanner in = new Scanner(System.in);
        String query;

        Connection connection;
        Statement statement;

        try {
            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password"));

        } catch (SQLException e) {
            logger.log(Level.INFO, "Connection Failed");
            return;
        }

        String login;
        String email;
        String password;

        String roleUser;

        while(true) {

            logger.log(Level.INFO, "Enter your login please");
            login = in.nextLine();
            logger.log(Level.INFO, "Enter your email please");
            email = in.nextLine();
            logger.log(Level.INFO, "Enter your password please");
            password = in.nextLine();


            query = "SELECT user_app_id FROM user_app WHERE login = '" + login + AND_EMAIL
                    + email + AND_PASSWORD + password + "'";

            try {

                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery(query);

                if (!resultSet.next()) {
                    logger.log(Level.INFO, "Your user isn't in database.\nPlease enter again.\n");
                    continue;
                }

            } catch (SQLException e) {
                logger.log(Level.INFO, e.getMessage());

            }

            break;

        }

        while (true) {

            ShoesShop shoesShop = new ShoesShop();
            CatalogShoes catalogShoes = new CatalogShoes();
            Address address = new Address();
            BaskShoes baskShoes = new BaskShoes();
            Supply supply = new Supply();

            Selects selects = new Selects();


            logger.log(Level.INFO, "Enter your role(admin, customer, provider):");
            roleUser = in.nextLine();

            switch (roleUser) {
                case "admin" -> {

                    query = "SELECT * FROM admin_shop WHERE user_id = (SELECT user_app_id FROM user_app " +
                            WHERE_LOGIN + login + AND_EMAIL + email + AND_PASSWORD +
                            password + "')";

                    try {

                        statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery(query);

                        if (!resultSet.next()) {
                            logger.log(Level.INFO, """
                                    Your user isn't an admin.
                                    Please enter your role again.
                                    """);
                            continue;
                        }

                        String queryId = "SELECT id FROM admin_shop WHERE user_id = (SELECT user_app_id FROM user_app " +
                                WHERE_LOGIN + login + AND_EMAIL + email + AND_PASSWORD +
                                password + "')";

                        resultSet = statement.executeQuery(queryId);

                        resultSet.next();
                        int adminId = resultSet.getInt("id");
                        logger.log(Level.INFO, "id admin: {0}", adminId);
                        logger.log(Level.INFO, "Hello admin");

                        while (true) {
                            logger.log(Level.INFO, SELECT_ACTION);
                            logger.log(Level.INFO, """
                                    1) Show all shoes_shop
                                    2) Add new shoes_shop
                                    3) Delete shoes_shop
                                    4) Update shoes_shop
                                    5) Show all catalog_shoes
                                    6) Add new catalog_shoes
                                    7) Delete catalog_shoes
                                    8) Exit
                                    """);
                            int choice = in.nextInt();

                            if (choice == 1) {
                                selects.getAllFromBaskShop();
                            } else if (choice == 2) {
                                logger.log(Level.INFO, "Enter id bask shop please");
                                int idShoesShop = in.nextInt();
                                logger.log(Level.INFO, "Enter title bask shop please");
                                in.nextLine();
                                String titleBaskShop = in.nextLine();
                                logger.log(Level.INFO, "Enter rating bask shop please");
                                int rating = in.nextInt();
                                shoesShop.addBaskShoesShop(idShoesShop, titleBaskShop, rating);
                            } else if (choice == 3) {
                                selects.getAllFromBaskShop();
                                logger.log(Level.INFO, "Enter id bask shop please");
                                int idShoesShop = in.nextInt();
                                shoesShop.deleteShoesShop(idShoesShop);
                            } else if (choice == 4) {
                                selects.getAllFromBaskShop();
                                while (true) {
                                    logger.log(Level.INFO, SELECT_FIELD);
                                    logger.log(Level.INFO, "1) Title\n2) Rating\n");
                                    int choiceField = in.nextInt();

                                    if (choiceField == 1) {
                                        logger.log(Level.INFO, "Enter title bask shop:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "title";
                                        logger.log(Level.INFO, ENTER_ID_BASK_SHOP);
                                        int idShoesShop = in.nextInt();
                                        shoesShop.updateShoesShop(idShoesShop, data, field);
                                        break;
                                    } else if (choiceField == 2) {
                                        logger.log(Level.INFO, "Enter rating bask shop:");
                                        int data = in.nextInt();
                                        String field = "rating";
                                        logger.log(Level.INFO, ENTER_ID_BASK_SHOP);
                                        int idShoesShop = in.nextInt();
                                        shoesShop.updateShoesShop(idShoesShop, data, field);
                                        break;
                                    } else {
                                        logger.log(Level.INFO, CHOICE_CORRECT_INDEX);
                                    }

                                }

                            } else if (choice == 5) {
                                selects.getAllFromCatalogProducts();
                            } else if (choice == 6) {
                                selects.getAllFromBaskShoes();
                                logger.log(Level.INFO, "Enter id shoes:");
                                int idShoes = in.nextInt();
                                selects.getAllFromBaskShop();
                                logger.log(Level.INFO, ENTER_ID_BASK_SHOP);
                                int idBaskShop = in.nextInt();
                                catalogShoes.addCatalogShoes(idShoes, idBaskShop);
                            } else if (choice == 7) {
                                selects.getAllFromCatalogProducts();
                                logger.log(Level.INFO, "Enter id shoes:");
                                int idShoes = in.nextInt();
                                logger.log(Level.INFO, ENTER_ID_BASK_SHOP);
                                int idBaskShop = in.nextInt();
                                catalogShoes.deleteCatalogShoes(idShoes, idBaskShop);
                            } else if (choice == 8) {
                                logger.log(Level.INFO, "Bye");
                                break;
                            } else {
                                logger.log(Level.INFO, INCORRECT_INDEX);
                            }

                        }

                    } catch (SQLException e) {
                        logger.log(Level.INFO, e.getMessage());

                    }
                }
                case "customer" -> {

                    query = "SELECT * FROM customer WHERE user_id = (SELECT user_app_id FROM user_app " +
                            WHERE_LOGIN + login + AND_EMAIL + email + AND_PASSWORD +
                            password + "')";

                    try {

                        statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery(query);

                        if (!resultSet.next()) {
                            logger.log(Level.INFO, "Your user isn't an customer.\nPlease enter your role again.\n");
                            continue;
                        }

                        String queryId = "SELECT id FROM customer WHERE user_id = (SELECT user_app_id FROM user_app " +
                                WHERE_LOGIN + login + AND_EMAIL + email + AND_PASSWORD +
                                password + "')";

                        resultSet = statement.executeQuery(queryId);

                        resultSet.next();
                        int customerId = resultSet.getInt("id");
                        logger.log(Level.INFO, "id customer: {0}", customerId);
                        logger.log(Level.INFO, "Hello customer");

                        while (true) {
                            logger.log(Level.INFO, SELECT_ACTION);
                            logger.log(Level.INFO, """
                                    1) Show all addresses
                                    2) Add new address
                                    3) Delete address
                                    4) Update address
                                    5)Exit""");
                            int choice = in.nextInt();

                            if (choice == 1) {
                                selects.getAllFromAddress();
                            } else if (choice == 2) {
                                logger.log(Level.INFO, "Enter id address");
                                int idAddress = in.nextInt();
                                logger.log(Level.INFO, "Enter city");
                                in.nextLine();
                                String city = in.nextLine();
                                logger.log(Level.INFO, "Enter street");
                                in.nextLine();
                                String street = in.nextLine();
                                logger.log(Level.INFO, "Enter house");
                                in.nextLine();
                                String house = in.nextLine();
                                logger.log(Level.INFO, "Enter flat");
                                in.nextLine();
                                String flat = in.nextLine();
                                address.addAddress(idAddress, city, street, house, flat);
                            } else if (choice == 3) {
                                selects.getAllFromAddress();
                                logger.log(Level.INFO, "Enter id address");
                                int idAddress = in.nextInt();
                                address.deleteAddress(idAddress);
                            } else if (choice == 4) {
                                selects.getAllFromAddress();

                                String data;
                                String field;

                                while (true) {
                                    logger.log(Level.INFO, SELECT_FIELD);
                                    logger.log(Level.INFO, """
                                            1) City
                                            2) Street
                                            3) House
                                            4) Flat
                                            """);
                                    int choiceField = in.nextInt();

                                    if (choiceField == 1) {
                                        logger.log(Level.INFO, "Enter city:");
                                        in.nextLine();
                                        data = in.nextLine();
                                        field = "city";
                                        break;
                                    } else if (choiceField == 2) {
                                        logger.log(Level.INFO, "Enter street:");
                                        in.nextLine();
                                        data = in.nextLine();
                                        field = "street";
                                        break;
                                    } else if (choiceField == 3) {
                                        logger.log(Level.INFO, "Enter house:");
                                        in.nextLine();
                                        data = in.nextLine();
                                        field = "house";
                                        break;
                                    } else if (choiceField == 4) {
                                        logger.log(Level.INFO, "Enter flat:");
                                        in.nextLine();
                                        data = in.nextLine();
                                        field = "flat";
                                        break;
                                    } else {
                                        logger.log(Level.INFO, CHOICE_CORRECT_INDEX);
                                    }

                                }

                                logger.log(Level.INFO, "Enter id address:");
                                int idAddress = in.nextInt();
                                address.updateAddress(idAddress, data, field);

                            } else if (choice == 5) {
                                logger.log(Level.INFO, "Bye");
                                break;
                            } else {
                                logger.log(Level.INFO, INCORRECT_INDEX);
                            }

                        }


                    } catch (SQLException e) {
                        logger.log(Level.INFO, e.getMessage());

                    }
                }
                case "provider" -> {

                    query = "SELECT * FROM provider WHERE user_id = (SELECT user_app_id FROM user_app " +
                            WHERE_LOGIN + login + AND_EMAIL + email + AND_PASSWORD +
                            password + "')";

                    try {

                        statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery(query);

                        if (!resultSet.next()) {
                            logger.log(Level.INFO, """
                                    Your user isn't an provider.
                                    Please enter your role again.
                                    """);
                            continue;
                        }

                        String queryId = "SELECT id FROM provider WHERE user_id = (SELECT user_app_id FROM user_app " +
                                WHERE_LOGIN + login + AND_EMAIL + email + AND_PASSWORD +
                                password + "')";

                        resultSet = statement.executeQuery(queryId);

                        resultSet.next();
                        int providerId = resultSet.getInt("id");
                        logger.log(Level.INFO, "id provider: {0}", providerId);
                        logger.log(Level.INFO, "Hello provider");

                        while (true) {
                            logger.log(Level.INFO, SELECT_ACTION);
                            logger.log(Level.INFO, """
                                    1) Show all shoes
                                    2) Add new shoes
                                    3) Delete shoes
                                    4) Update shoes
                                    5) Show all supplies
                                    6) Add new supply
                                    7) Delete supply
                                    8) Exit
                                    """);
                            int choice = in.nextInt();

                            if (choice == 1) {
                                selects.getAllFromBaskShoes();
                            } else if (choice == 2) {
                                logger.log(Level.INFO, "Enter id shoes");
                                int idAddress = in.nextInt();
                                logger.log(Level.INFO, "Enter title");
                                in.nextLine();
                                String title = in.nextLine();
                                logger.log(Level.INFO, "Enter description");
                                String description = in.nextLine();
                                logger.log(Level.INFO, "Enter price");
                                int price = in.nextInt();
                                logger.log(Level.INFO, "Enter manufacturer");
                                in.nextLine();
                                String manufacturer = in.nextLine();
                                logger.log(Level.INFO, "Enter brand");
                                String brand = in.nextLine();
                                logger.log(Level.INFO, "Enter size");
                                int size = in.nextInt();
                                baskShoes.addBaskShoes(idAddress, title, description, price, manufacturer, brand, size);
                            } else if (choice == 3) {
                                selects.getAllFromBaskShoes();
                                logger.log(Level.INFO, "Enter id shoes");
                                int idShoes = in.nextInt();
                                baskShoes.deleteBaskShoes(idShoes);
                            } else if (choice == 4) {
                                selects.getAllFromBaskShoes();
                                while (true) {
                                    logger.log(Level.INFO, SELECT_FIELD);
                                    logger.log(Level.INFO, """
                                            1) Title
                                            2) Description
                                            3) Price
                                            4) Manufacturer
                                            5)Brand
                                            6) Size
                                            """);
                                    int choiceField = in.nextInt();

                                    if (choiceField == 1) {
                                        logger.log(Level.INFO, "Enter title shoe:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "title";
                                        logger.log(Level.INFO, ENTER_ID_SHOE);
                                        int idShoes = in.nextInt();
                                        baskShoes.updateBaskShoes(idShoes, data, field);
                                        break;
                                    } else if (choiceField == 2) {
                                        logger.log(Level.INFO, "Enter description shoe:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "description";
                                        logger.log(Level.INFO, ENTER_ID_SHOE);
                                        int idShoes = in.nextInt();
                                        baskShoes.updateBaskShoes(idShoes, data, field);
                                    } else if (choiceField == 3) {
                                        logger.log(Level.INFO, "Enter price shoe:");
                                        int data = in.nextInt();
                                        String field = "price";
                                        logger.log(Level.INFO, ENTER_ID_SHOE);
                                        int idShoes = in.nextInt();
                                        baskShoes.updateBaskShoes(idShoes, data, field);
                                        break;
                                    } else if (choiceField == 4) {
                                        logger.log(Level.INFO, "Enter manufacturer shoe:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "manufacturer";
                                        logger.log(Level.INFO, ENTER_ID_SHOE);
                                        int idShoes = in.nextInt();
                                        baskShoes.updateBaskShoes(idShoes, data, field);
                                    } else if (choiceField == 5) {
                                        logger.log(Level.INFO, "Enter brand shoe:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "brand";
                                        logger.log(Level.INFO, ENTER_ID_SHOE);
                                        int idShoes = in.nextInt();
                                        baskShoes.updateBaskShoes(idShoes, data, field);
                                    } else if (choiceField == 6) {
                                        logger.log(Level.INFO, "Enter size shoe:");
                                        int data = in.nextInt();
                                        String field = "size";
                                        logger.log(Level.INFO, ENTER_ID_SHOE);
                                        int idShoes = in.nextInt();
                                        baskShoes.updateBaskShoes(idShoes, data, field);
                                        break;
                                    } else {
                                        logger.log(Level.INFO, CHOICE_CORRECT_INDEX);
                                    }

                                }

                            } else if (choice == 5) {
                                selects.getAllFromSupply();
                            } else if (choice == 6) {
                                logger.log(Level.INFO, "Enter id supply:");
                                int idSupply = in.nextInt();
                                supply.addSupply(idSupply, providerId);
                            } else if (choice == 7) {
                                selects.getAllFromSupply();
                                logger.log(Level.INFO, "Enter id supply:");
                                int idSupply = in.nextInt();
                                supply.deleteSupply(idSupply);
                            } else if (choice == 8) {
                                logger.log(Level.INFO, "Bye");
                                break;
                            } else {
                                logger.log(Level.INFO, INCORRECT_INDEX);
                            }

                        }


                    } catch (SQLException e) {
                        logger.log(Level.INFO, e.getMessage());

                    }
                }

                default -> {
                    logger.log(Level.INFO, "You enter incorrect role.\n Please enter again.\n");
                    continue;
                }
            }
            break;
        }

        connection.close();

    }
}
