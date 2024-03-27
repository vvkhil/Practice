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

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        String insertTableSQL = "INSERT INTO user_app"
                + "(login, email, password) " + "VALUES"
                + "('ya','ya@mail.ru','123456')";


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

                if (!resultSet.next()) {
                    System.out.println("Your user isn't in database.\nPlease enter again.\n");
                    continue;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }

            break;

        }

        while(true) {

            GetFunc getFunc = new GetFunc();
            AdminFunc adminFunc = new AdminFunc();
            ProviderFunc providerFunc = new ProviderFunc();
            CustomerFunc customerFunc = new CustomerFunc();

            System.out.println("Enter your role(admin, customer, provider):");
            role_user = in.nextLine();

            if (role_user.equals("admin")) {

                query = "SELECT * FROM admin_shop WHERE user_id = (SELECT user_app_id FROM user_app " +
                        "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                        password + "')" ;

                try {

                    statement = connection.createStatement();

                    // выполнить SQL запрос
                    ResultSet resultSet = statement.executeQuery(query);

                    if (!resultSet.next()) {
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

                    while (true) {
                        System.out.println("Select action");
                        System.out.println("1) Show all shoes_shop\n2) Add new shoes_shop\n3) Delete shoes_shop\n4) Update shoes_shop\n" +
                                "5) Show all catalog_shoes\n6) Add new catalog_shoes\n7) Delete catalog_shoes\n" +
                                "8) Exit\n");
                        int choice = in.nextInt();

                        if (choice == 1) {
                            getFunc.get_all_from_bask_shop();
                        } else if (choice == 2) {
                            System.out.println("Enter id bask shop please");
                            int id_shoes_shop = in.nextInt();
                            System.out.println("Enter title bask shop please");
                            in.nextLine();
                            String title_bask_shop = in.nextLine();
                            System.out.println("Enter rating bask shop please");
                            int rating = in.nextInt();
                            adminFunc.add_bask_shoes_shop(id_shoes_shop, title_bask_shop, rating);
                        } else if (choice == 3) {
                            getFunc.get_all_from_bask_shop();
                            System.out.println("Enter id bask shop please");
                            int id_shoes_shop = in.nextInt();
                            adminFunc.delete_shoes_shop(id_shoes_shop);
                        } else if (choice == 4) {
                            getFunc.get_all_from_bask_shop();
                            while (true) {
                                System.out.println("Select field");
                                System.out.println("1) Title\n2) Rating\n");
                                int choice_field = in.nextInt();

                                if (choice_field == 1) {
                                    System.out.println("Enter title bask shop:");
                                    in.nextLine();
                                    String data = in.nextLine();
                                    String field = "title";
                                    System.out.println("Enter id bask shop:");
                                    int id_shoes_shop = in.nextInt();
                                    adminFunc.update_shoes_shop(id_shoes_shop, data, field);
                                    break;
                                } else if (choice_field == 2) {
                                    System.out.println("Enter rating bask shop:");
                                    int data = in.nextInt();
                                    String field = "rating";
                                    System.out.println("Enter id bask shop:");
                                    int id_shoes_shop = in.nextInt();
                                    adminFunc.update_shoes_shop(id_shoes_shop, data, field);
                                    break;
                                } else {
                                    System.out.println("Choice correct index!");
                                    continue;
                                }

                            }
                            
                        } else if (choice == 5) {
                            getFunc.get_all_from_catalog_products();
                        } else if (choice == 6) {
                            getFunc.get_all_from_bask_shoes();
                            System.out.println("Enter id shoes:");
                            int id_shoes = in.nextInt();
                            getFunc.get_all_from_bask_shop();
                            System.out.println("Enter id bask shop:");
                            int id_bask_shop = in.nextInt();
                            adminFunc.add_catalog_shoes(id_shoes, id_bask_shop);
                        } else if (choice == 7) {
                            getFunc.get_all_from_catalog_products();
                            System.out.println("Enter id shoes:");
                            int id_shoes = in.nextInt();
                            System.out.println("Enter id bask shop:");
                            int id_bask_shop = in.nextInt();
                            adminFunc.delete_catalog_shoes(id_shoes, id_bask_shop);
                        } else if (choice == 8) {
                            System.out.println("Bye");
                            break;
                        } else {
                            System.out.println("You enter incorrect index.\n Please try again.\n");
                            continue;
                        }

                    }

                } catch (SQLException e) {
                    System.out.println(e.getMessage());

                }

            }

            else if (role_user.equals("customer")) {

                query = "SELECT * FROM customer WHERE user_id = (SELECT user_app_id FROM user_app " +
                        "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                        password + "')" ;

                try {

                    statement = connection.createStatement();

                    // выполнить SQL запрос
                    ResultSet resultSet = statement.executeQuery(query);

                    if (!resultSet.next()) {
                        System.out.println("Your user isn't an customer.\nPlease enter your role again.\n");
                        continue;
                    }

                    String query_id = "SELECT id FROM customer WHERE user_id = (SELECT user_app_id FROM user_app " +
                            "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                            password + "')" ;

                    resultSet = statement.executeQuery(query_id);

                    resultSet.next();
                    int customer_id = resultSet.getInt("id");
                    System.out.println("id customer:" + customer_id);
                    System.out.println("Hello customer");

                    while (true) {
                        System.out.println("Select action");
                        System.out.println("1) Show all addresses\n2) Add new address\n3) Delete address\n4) Update address\n5)Exit");
                        int choice = in.nextInt();

                        if (choice == 1) {
                            getFunc.get_all_from_address();
                        } else if (choice == 2) {
                            System.out.println("Enter id address");
                            int id_address = in.nextInt();
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
                            customerFunc.add_address(id_address, city, street, house, flat);
                        } else if (choice == 3) {
                            getFunc.get_all_from_address();
                            System.out.println("Enter id address");
                            int id_address = in.nextInt();
                            customerFunc.delete_address(id_address);
                        } else if (choice == 4) {
                            getFunc.get_all_from_bask_shoes();
                            while (true) {
                                System.out.println("Select field");
                                System.out.println("1) Title\n2) Description\n3) Price\n4) Manufacturer\n" +
                                        "5)Brand\n6) Size\n");
                                int choice_field = in.nextInt();

                                if (choice_field == 1) {
                                    System.out.println("Enter title shoe:");
                                    in.nextLine();
                                    String data = in.nextLine();
                                    String field = "title";
                                    System.out.println("Enter id shoe:");
                                    int id_shoes = in.nextInt();
                                    providerFunc.update_bask_shoes(id_shoes, data, field);
                                    break;
                                } else if (choice_field == 2) {
                                    System.out.println("Enter description shoe:");
                                    in.nextLine();
                                    String data = in.nextLine();
                                    String field = "description";
                                    System.out.println("Enter id shoe:");
                                    int id_shoes = in.nextInt();
                                    providerFunc.update_bask_shoes(id_shoes, data, field);
                                } else if (choice_field == 3) {
                                    System.out.println("Enter price shoe:");
                                    int data = in.nextInt();
                                    String field = "price";
                                    System.out.println("Enter id shoe:");
                                    int id_shoes = in.nextInt();
                                    providerFunc.update_bask_shoes(id_shoes, data, field);
                                    break;
                                } else if (choice_field == 4) {
                                    System.out.println("Enter manufacturer shoe:");
                                    in.nextLine();
                                    String data = in.nextLine();
                                    String field = "manufacturer";
                                    System.out.println("Enter id shoe:");
                                    int id_shoes = in.nextInt();
                                    providerFunc.update_bask_shoes(id_shoes, data, field);
                                } else if (choice_field == 5) {
                                    System.out.println("Enter brand shoe:");
                                    in.nextLine();
                                    String data = in.nextLine();
                                    String field = "brand";
                                    System.out.println("Enter id shoe:");
                                    int id_shoes = in.nextInt();
                                    providerFunc.update_bask_shoes(id_shoes, data, field);
                                } else if (choice_field == 6) {
                                    System.out.println("Enter size shoe:");
                                    int data = in.nextInt();
                                    String field = "size";
                                    System.out.println("Enter id shoe:");
                                    int id_shoes = in.nextInt();
                                    providerFunc.update_bask_shoes(id_shoes, data, field);
                                    break;
                                } else {
                                    System.out.println("Choice correct index!");
                                    continue;
                                }

                            }

                        } else if (choice == 5) {
                            System.out.println("Bye");
                            break;
                        } else {
                            System.out.println("You enter incorrect index.\n Please try again.\n");
                            continue;
                        }

                    }



                } catch (SQLException e) {
                    System.out.println(e.getMessage());

                }

            }

            else if (role_user.equals("provider")) {

                query = "SELECT * FROM provider WHERE user_id = (SELECT user_app_id FROM user_app " +
                        "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                        password + "')" ;

                try {

                    statement = connection.createStatement();

                    // выполнить SQL запрос
                    ResultSet resultSet = statement.executeQuery(query);

                    if (!resultSet.next()) {
                        System.out.println("Your user isn't an provider.\nPlease enter your role again.\n");
                        continue;
                    }

                    String query_id = "SELECT id FROM provider WHERE user_id = (SELECT user_app_id FROM user_app " +
                            "WHERE login = '" + login + "' AND email = '" + email + "' AND password= '" +
                            password + "')" ;

                    resultSet = statement.executeQuery(query_id);

                    resultSet.next();
                    int customer_id = resultSet.getInt("id");
                    System.out.println("id provider:" + customer_id);
                    System.out.println("Hello customer");

                    while (true) {
                        System.out.println("Select action");
                        System.out.println("1) Show all shoes\n2) Add new shoes\n3) Delete shoes\n4) Update shoes\n"+
                                "5) Show all supplies\n6) Add new supply\n7) Delete supply\n"+
                                "8) Show all supplies_log\n9) Add new supply_log\n10) Delete supply_log\n"+
                                "\n11) Exit\n");
                        int choice = in.nextInt();

                        if (choice == 1) {
                            getFunc.get_all_from_bask_shoes();
                        } else if (choice == 2) {
                            System.out.println("Enter id shoes");
                            int id_address = in.nextInt();
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
                            providerFunc.add_bask_shoes(id_address, title, description, price, manufacturer, brand, size);
                        } else if (choice == 3) {
                            getFunc.get_all_from_bask_shoes();
                            System.out.println("Enter id shoes");
                            int id_shoes = in.nextInt();
                            providerFunc.delete_bask_shoes(id_shoes);
                        } else if (choice == 4) {
                            getFunc.get_all_from_address();

                            String data = "";
                            String field = "";

                            while (true) {
                                System.out.println("Select field");
                                System.out.println("1) City\n2) Street\n3) House\n4) Flat\n");
                                int choice_field = in.nextInt();

                                if (choice_field == 1) {
                                    System.out.println("Enter city:");
                                    in.nextLine();
                                    data = in.nextLine();
                                    field = "city";
                                    break;
                                } else if (choice_field == 2) {
                                    System.out.println("Enter street:");
                                    in.nextLine();
                                    data = in.nextLine();
                                    field = "street";
                                    break;
                                } else if (choice_field == 3) {
                                    System.out.println("Enter house:");
                                    in.nextLine();
                                    data = in.nextLine();
                                    field = "house";
                                    break;
                                } else if (choice_field == 4) {
                                    System.out.println("Enter flat:");
                                    in.nextLine();
                                    data = in.nextLine();
                                    field = "flat";
                                    break;
                                } else {
                                    System.out.println("Choice correct index!");
                                    continue;
                                }

                            }

                            System.out.println("Enter id address:");
                            int id_address = in.nextInt();
                            customerFunc.update_address(id_address, data, field);

                        } else if (choice == 5) {
                            System.out.println("Bye");
                            break;
                        } else {
                            System.out.println("You enter incorrect index.\n Please try again.\n");
                            continue;
                        }

                    }



                } catch (SQLException e) {
                    System.out.println(e.getMessage());

                }

            }

        }
    }
}
