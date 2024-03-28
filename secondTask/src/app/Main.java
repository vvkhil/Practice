package app;

import admin.CatalogShoes;
import admin.ShoesShop;
import customer.Address;
import provider.BaskShoes;
import provider.Supply;
import select.Selects;

import java.sql.*;
import java.util.Scanner;

import static cred.Credentials.DB_URL;
import static cred.Credentials.USER;
import static cred.Credentials.PASS;

public class Main {

    public static void main(String[] argv) {

        Scanner in = new Scanner(System.in);
        String query;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            return;
        }

        Connection connection;
        Statement statement;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            return;
        }

        String login;
        String email;
        String password;

        String roleUser;

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

                ResultSet resultSet = statement.executeQuery(query);

                if (!resultSet.next()) {
                    System.out.println("Your user isn't in database.\nPlease enter again.\n");
                    continue;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());

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


            System.out.println("Enter your role(admin, customer, provider):");
            roleUser = in.nextLine();

            switch (roleUser) {
                case "admin" -> {

                    query = "SELECT * FROM admin_shop WHERE user_id = (SELECT user_app_id FROM user_app " +
                            "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                            password + "')";

                    try {

                        statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery(query);

                        if (!resultSet.next()) {
                            System.out.println("""
                                    Your user isn't an admin.
                                    Please enter your role again.
                                    """);
                            continue;
                        }

                        String query_id = "SELECT id FROM admin_shop WHERE user_id = (SELECT user_app_id FROM user_app " +
                                "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                                password + "')";

                        resultSet = statement.executeQuery(query_id);

                        resultSet.next();
                        int adminId = resultSet.getInt("id");
                        System.out.println("id admin:" + adminId);
                        System.out.println("Hello admin");

                        while (true) {
                            System.out.println("Select action");
                            System.out.println("""
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
                                System.out.println("Enter id bask shop please");
                                int idShoesShop = in.nextInt();
                                System.out.println("Enter title bask shop please");
                                in.nextLine();
                                String titleBaskShop = in.nextLine();
                                System.out.println("Enter rating bask shop please");
                                int rating = in.nextInt();
                                shoesShop.addBaskShoesShop(idShoesShop, titleBaskShop, rating);
                            } else if (choice == 3) {
                                selects.getAllFromBaskShop();
                                System.out.println("Enter id bask shop please");
                                int idShoesShop = in.nextInt();
                                shoesShop.deleteShoesShop(idShoesShop);
                            } else if (choice == 4) {
                                selects.getAllFromBaskShop();
                                while (true) {
                                    System.out.println("Select field");
                                    System.out.println("1) Title\n2) Rating\n");
                                    int choiceField = in.nextInt();

                                    if (choiceField == 1) {
                                        System.out.println("Enter title bask shop:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "title";
                                        System.out.println("Enter id bask shop:");
                                        int idShoesShop = in.nextInt();
                                        shoesShop.updateShoesShop(idShoesShop, data, field);
                                        break;
                                    } else if (choiceField == 2) {
                                        System.out.println("Enter rating bask shop:");
                                        int data = in.nextInt();
                                        String field = "rating";
                                        System.out.println("Enter id bask shop:");
                                        int idShoesShop = in.nextInt();
                                        shoesShop.updateShoesShop(idShoesShop, data, field);
                                        break;
                                    } else {
                                        System.out.println("Choice correct index!");
                                    }

                                }

                            } else if (choice == 5) {
                                selects.getAllFromCatalogProducts();
                            } else if (choice == 6) {
                                selects.getAllFromBaskShoes();
                                System.out.println("Enter id shoes:");
                                int id_shoes = in.nextInt();
                                selects.getAllFromBaskShop();
                                System.out.println("Enter id bask shop:");
                                int id_bask_shop = in.nextInt();
                                catalogShoes.addCatalogShoes(id_shoes, id_bask_shop);
                            } else if (choice == 7) {
                                selects.getAllFromCatalogProducts();
                                System.out.println("Enter id shoes:");
                                int idShoes = in.nextInt();
                                System.out.println("Enter id bask shop:");
                                int idBaskShop = in.nextInt();
                                catalogShoes.deleteCatalogShoes(idShoes, idBaskShop);
                            } else if (choice == 8) {
                                System.out.println("Bye");
                                break;
                            } else {
                                System.out.println("You enter incorrect index.\n Please try again.\n");
                            }

                        }

                    } catch (SQLException e) {
                        System.out.println(e.getMessage());

                    }
                }
                case "customer" -> {

                    query = "SELECT * FROM customer WHERE user_id = (SELECT user_app_id FROM user_app " +
                            "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                            password + "')";

                    try {

                        statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery(query);

                        if (!resultSet.next()) {
                            System.out.println("Your user isn't an customer.\nPlease enter your role again.\n");
                            continue;
                        }

                        String queryId = "SELECT id FROM customer WHERE user_id = (SELECT user_app_id FROM user_app " +
                                "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                                password + "')";

                        resultSet = statement.executeQuery(queryId);

                        resultSet.next();
                        int customerId = resultSet.getInt("id");
                        System.out.println("id customer:" + customerId);
                        System.out.println("Hello customer");

                        while (true) {
                            System.out.println("Select action");
                            System.out.println("""
                                    1) Show all addresses
                                    2) Add new address
                                    3) Delete address
                                    4) Update address
                                    5)Exit""");
                            int choice = in.nextInt();

                            if (choice == 1) {
                                selects.getAllFromAddress();
                            } else if (choice == 2) {
                                System.out.println("Enter id address");
                                int idAddress = in.nextInt();
                                System.out.println("Enter city");
                                in.nextLine();
                                String city = in.nextLine();
                                System.out.println("Enter street");
                                in.nextLine();
                                String street = in.nextLine();
                                System.out.println("Enter house");
                                in.nextLine();
                                String house = in.nextLine();
                                System.out.println("Enter flat");
                                in.nextLine();
                                String flat = in.nextLine();
                                address.addAddress(idAddress, city, street, house, flat);
                            } else if (choice == 3) {
                                selects.getAllFromAddress();
                                System.out.println("Enter id address");
                                int idAddress = in.nextInt();
                                address.deleteAddress(idAddress);
                            } else if (choice == 4) {
                                selects.getAllFromAddress();

                                String data;
                                String field;

                                while (true) {
                                    System.out.println("Select field");
                                    System.out.println("""
                                            1) City
                                            2) Street
                                            3) House
                                            4) Flat
                                            """);
                                    int choiceField = in.nextInt();

                                    if (choiceField == 1) {
                                        System.out.println("Enter city:");
                                        in.nextLine();
                                        data = in.nextLine();
                                        field = "city";
                                        break;
                                    } else if (choiceField == 2) {
                                        System.out.println("Enter street:");
                                        in.nextLine();
                                        data = in.nextLine();
                                        field = "street";
                                        break;
                                    } else if (choiceField == 3) {
                                        System.out.println("Enter house:");
                                        in.nextLine();
                                        data = in.nextLine();
                                        field = "house";
                                        break;
                                    } else if (choiceField == 4) {
                                        System.out.println("Enter flat:");
                                        in.nextLine();
                                        data = in.nextLine();
                                        field = "flat";
                                        break;
                                    } else {
                                        System.out.println("Choice correct index!");
                                    }

                                }

                                System.out.println("Enter id address:");
                                int idAddress = in.nextInt();
                                address.updateAddress(idAddress, data, field);

                            } else if (choice == 5) {
                                System.out.println("Bye");
                                break;
                            } else {
                                System.out.println("You enter incorrect index.\n Please try again.\n");
                            }

                        }


                    } catch (SQLException e) {
                        System.out.println(e.getMessage());

                    }
                }
                case "provider" -> {

                    query = "SELECT * FROM provider WHERE user_id = (SELECT user_app_id FROM user_app " +
                            "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                            password + "')";

                    try {

                        statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery(query);

                        if (!resultSet.next()) {
                            System.out.println("""
                                    Your user isn't an provider.
                                    Please enter your role again.
                                    """);
                            continue;
                        }

                        String queryId = "SELECT id FROM provider WHERE user_id = (SELECT user_app_id FROM user_app " +
                                "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                                password + "')";

                        resultSet = statement.executeQuery(queryId);

                        resultSet.next();
                        int providerId = resultSet.getInt("id");
                        System.out.println("id provider:" + providerId);
                        System.out.println("Hello provider");

                        while (true) {
                            System.out.println("Select action");
                            System.out.println("""
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
                                System.out.println("Enter id shoes");
                                int idAddress = in.nextInt();
                                System.out.println("Enter title");
                                in.nextLine();
                                String title = in.nextLine();
                                System.out.println("Enter description");
                                String description = in.nextLine();
                                System.out.println("Enter price");
                                int price = in.nextInt();
                                System.out.println("Enter manufacturer");
                                in.nextLine();
                                String manufacturer = in.nextLine();
                                System.out.println("Enter brand");
                                String brand = in.nextLine();
                                System.out.println("Enter size");
                                int size = in.nextInt();
                                baskShoes.addBaskShoes(idAddress, title, description, price, manufacturer, brand, size);
                            } else if (choice == 3) {
                                selects.getAllFromBaskShoes();
                                System.out.println("Enter id shoes");
                                int id_shoes = in.nextInt();
                                baskShoes.deleteBaskShoes(id_shoes);
                            } else if (choice == 4) {
                                selects.getAllFromBaskShoes();
                                while (true) {
                                    System.out.println("Select field");
                                    System.out.println("""
                                            1) Title
                                            2) Description
                                            3) Price
                                            4) Manufacturer
                                            5)Brand
                                            6) Size
                                            """);
                                    int choiceField = in.nextInt();

                                    if (choiceField == 1) {
                                        System.out.println("Enter title shoe:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "title";
                                        System.out.println("Enter id shoe:");
                                        int id_shoes = in.nextInt();
                                        baskShoes.updateBaskShoes(id_shoes, data, field);
                                        break;
                                    } else if (choiceField == 2) {
                                        System.out.println("Enter description shoe:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "description";
                                        System.out.println("Enter id shoe:");
                                        int id_shoes = in.nextInt();
                                        baskShoes.updateBaskShoes(id_shoes, data, field);
                                    } else if (choiceField == 3) {
                                        System.out.println("Enter price shoe:");
                                        int data = in.nextInt();
                                        String field = "price";
                                        System.out.println("Enter id shoe:");
                                        int id_shoes = in.nextInt();
                                        baskShoes.updateBaskShoes(id_shoes, data, field);
                                        break;
                                    } else if (choiceField == 4) {
                                        System.out.println("Enter manufacturer shoe:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "manufacturer";
                                        System.out.println("Enter id shoe:");
                                        int id_shoes = in.nextInt();
                                        baskShoes.updateBaskShoes(id_shoes, data, field);
                                    } else if (choiceField == 5) {
                                        System.out.println("Enter brand shoe:");
                                        in.nextLine();
                                        String data = in.nextLine();
                                        String field = "brand";
                                        System.out.println("Enter id shoe:");
                                        int id_shoes = in.nextInt();
                                        baskShoes.updateBaskShoes(id_shoes, data, field);
                                    } else if (choiceField == 6) {
                                        System.out.println("Enter size shoe:");
                                        int data = in.nextInt();
                                        String field = "size";
                                        System.out.println("Enter id shoe:");
                                        int id_shoes = in.nextInt();
                                        baskShoes.updateBaskShoes(id_shoes, data, field);
                                        break;
                                    } else {
                                        System.out.println("Choice correct index!");
                                    }

                                }

                            } else if (choice == 5) {
                                selects.getAllFromSupply();
                            } else if (choice == 6) {
                                System.out.println("Enter id supply:");
                                int idSupply = in.nextInt();
                                supply.addSupply(idSupply, providerId);
                            } else if (choice == 7) {
                                selects.getAllFromSupply();
                                System.out.println("Enter id supply:");
                                int idSupply = in.nextInt();
                                supply.deleteSupply(idSupply);
                            } else if (choice == 8) {
                                System.out.println("Bye");
                                break;
                            } else {
                                System.out.println("You enter incorrect index.\n Please try again.\n");
                            }

                        }


                    } catch (SQLException e) {
                        System.out.println(e.getMessage());

                    }
                }

                default -> {
                    System.out.println("You enter incorrect role.\n Please enter again.\n");
                    continue;
                }
            }
            break;
        }
    }
}
