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

    public int getID() { return this.ID; }
    public void setID(int newID) { this.ID = newID; }

    public String getMake() { return this.make; }
    public void setMake(String newMake){ this.make = newMake; }

    public String getModel() { return this.model; }
    public void setModel(String newModel) { this.model = newModel; }

    public CarCategory getCarCategory() { return this.carCategory; }
    public void setCarCategory(CarCategory newCarCategory) {this.carCategory = newCarCategory;}

    public CarStatus getCarStatus() { return carStatus; }
    public void setCarStatus(CarStatus newCarStatus) { this.carStatus = newCarStatus; }

    public int getYearOfProduction() { return yearOfProduction; }
    public void setYearOfProduction(int newYearOfProduction) { this.yearOfProduction = newYearOfProduction; }

    public int getMileage(){ return this.mileage; }
    public void setMileage(int newMileage) { this.mileage = newMileage; }

    public Transmission getTransmission() { return transmission; }
    public void setTransmission(Transmission newTransmission) { this.transmission = newTransmission; }

    public int getHorsePower() { return horsePower; }
    public void setHorsePower(int newHorsePower) { this.horsePower = newHorsePower; }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double newDailyRate) { this.dailyRate = newDailyRate; }
}
