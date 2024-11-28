package Database;

import Logic.Car;

import java.sql.*;

public class CarDAO {
    private static final String JDBC_URL = "jdbc:h2:.data/rental_app";

    public void addCar(Car car){
        String sql = """
                INSERT INTO cars (id, make, model, category, status, year_of_production, mileage, transmission, horse_power, daily_rate)
                VALUES (?,?,?,?,?,?,?,?,?,?)
                """;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, "sa", "");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, car.getID());
            preparedStatement.setString(2, car.getMake());
            preparedStatement.setString(3, car.getModel());
            preparedStatement.setString(4, car.getCarCategory().toString());
            preparedStatement.setString(5, car.getCarStatus().toString());
            preparedStatement.setInt(6, car.getYearOfProduction());
            preparedStatement.setInt(7, car.getMileage());
            preparedStatement.setString(8, car.getTransmission().toString());
            preparedStatement.setInt(9, car.getHorsePower());
            preparedStatement.setDouble(10, car.getDailyRate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        }
    }
}
