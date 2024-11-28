package Database;

import Logic.Car;
import Logic.CarCategory;
import Logic.CarStatus;
import Logic.Transmission;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private static final String JDBC_URL = "jdbc:h2:C:/Users/Kamil/Desktop/Java Projects/CarRental/CarRental/Data/rental_app";

    public void addCar(Car car){
        String sql = """
                INSERT INTO cars (make, model, carcategory, carstatus, year_of_production, mileage, transmission, horse_power, daily_rate)
                VALUES (?,?,?,?,?,?,?,?,?)
                """;

        try (Connection conn = DriverManager.getConnection(JDBC_URL, "admin", "password");
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, car.getMake());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getCarCategory().toString());
            preparedStatement.setString(4, car.getCarStatus().toString());
            preparedStatement.setInt(5, car.getYearOfProduction());
            preparedStatement.setInt(6, car.getMileage());
            preparedStatement.setString(7, car.getTransmission().toString());
            preparedStatement.setInt(8, car.getHorsePower());
            preparedStatement.setDouble(9, car.getDailyRate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println();
            System.out.println("Error while adding car: " + e.getMessage());
        }
    }

    public List<Car> getAllCars() {
        String sql = "SELECT * FROM cars";
        List<Car> cars = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(JDBC_URL, "sa", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Car car = new Car(
                        rs.getInt("id"),
                        rs.getString("make"),
                        rs.getString("model"),
                        CarCategory.valueOf(rs.getString("category")),
                        rs.getInt("year_of_production"),
                        rs.getInt("mileage"),
                        Transmission.valueOf(rs.getString("transmission")),
                        rs.getInt("horse_power"),
                        rs.getDouble("daily_rate")
                );
                car.setCarStatus(CarStatus.valueOf(rs.getString("status")));
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public void updateCarMileage(int carId, int newMileage) {
        String sql = "UPDATE cars SET mileage = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, "sa", "");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newMileage);
            pstmt.setInt(2, carId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(int carId) {
        String sql = "DELETE FROM cars WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, "sa", "");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, carId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
