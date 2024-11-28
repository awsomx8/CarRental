package Logic;

public class Car {
    private int ID;
    private String make;
    private String model;
    private CarCategory carCategory;
    private CarStatus carStatus;
    private int yearOfProduction;
    private int mileage;
    private Transmission transmission;
    private int horsePower;
    private double dailyRate;

    public Car(int ID, String make, String model, CarCategory carCategory, int yearOfProduction,
               int mileage, Transmission transmission, int horsePower, double dailyRate){
        this.ID = ID;
        this.make = make;
        this.model = model;
        this.carCategory = carCategory;
        this.carStatus = CarStatus.AVAILABLE;
        this.yearOfProduction = yearOfProduction;
        this.mileage = mileage;
        this.transmission = transmission;
        this.horsePower = horsePower;
        this.dailyRate = dailyRate;
    }
}
