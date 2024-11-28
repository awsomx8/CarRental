package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize(){

        String jdbcUrl = "jdbc:h2:./data/rental_app";

        try(Connection conn = DriverManager.getConnection(jdbcUrl, "admin", "password")){
            if (conn != null) {
                System.out.println("Connection to the database is successful!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
            Statement statement = conn.createStatement();
            String createCarsTable = """
                CREATE TABLE IF NOT EXISTS cars (
                id INT AUTO_INCREMENT PRIMARY KEY,
                make VARCHAR(255),
                model VARCHAR(255),
                carCategory VARCHAR(50),
                carStatus VARCHAR(50),
                year_of_production INT,
                mileage INT,
                transmission VARCHAR(50),
                horse_power INT,
                daily_rate DOUBLE
                )
                """;

            statement.execute(createCarsTable);

            String createCustomersTable = """
                    CREATE TABLE IF NOT EXISTS customers (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255),
                    surname VARCHAR(255),
                    age INT,
                    total_income DOUBLE,
                    rental_history TEXT
                    )
                    """;
            statement.execute(createCustomersTable);

            String createBillingsTable = """
                    CREATE TABLE IF NOT EXISTS billings (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    monthly_rate DOUBLE,
                    car_id INT,
                    payments_left_total DOUBLE,
                    months_left INT,
                    FOREIGN KEY (car_id) REFERENCES cars(id)
                    )
                    """;
            statement.execute(createBillingsTable);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database.");
        }
    }

    public static void testDatabase() {
        String jdbcUrl = "jdbc:h2:./data/rental_app";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, "admin", "password")) {
            Statement statement = conn.createStatement();
            String sql = "SELECT COUNT(*) FROM cars";
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("There are " + count + " cars in the database.");
            } else {
                System.out.println("No data found in the 'cars' table.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
