package Database;

import Logic.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private static final String JDBC_URL = "jdbc:h2:.data/rental_app";

    public void addCar(Car car){
        String sql = """
                INSERT INTO cars (id, make, model, category, status, year_of_production, mileage, transmission, horse_power, daily_rate)
                VALUES (?,?,?,?,?,?,?,?,?,?)
                """;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, "sa", "");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, car.getMake());
            pstmt.setString(2, car.getModel());
            pstmt.setString(3, car.getCarCategory().toString());
            pstmt.setString(4, car.getCarStatus().toString());
            pstmt.setInt(5, car.getYearOfProduction());
            pstmt.setInt(6, car.getMileage());
            pstmt.setString(7, car.getTransmission().toString());
            pstmt.setInt(8, car.getHorsePower());
            pstmt.setDouble(9, car.getDailyRate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
        }
    }
}
