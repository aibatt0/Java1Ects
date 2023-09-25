import java.io.*;
import java.util.*;

class Car {
    private int id;
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String make, String model, int year, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year +
               ", color=" + color + ", price=" + price + ", registrationNumber=" + registrationNumber + "]";
    }
}

public class CarManagement {
    public static void main(String[] args) {
        // Create an array of Car objects
        Car[] cars = {
            new Car(1, "Toyota", "Camry", 2018, "Blue", 20000.0, "AB123"),
            new Car(2, "Honda", "Civic", 2017, "Red", 18000.0, "CD456"),
            new Car(3, "Ford", "Focus", 2015, "Silver", 15000.0, "EF789"),
            new Car(4, "Toyota", "Corolla", 2020, "White", 22000.0, "GH012"),
           
        };

    
        saveCarsByBrand(cars, "Toyota");

      
        saveCarsByModelAndAge(cars, "Civic", 3);

      
        saveCarsByYearAndPrice(cars, 2015, 16000.0);
    }

   
    public static void saveCarsByBrand(Car[] cars, String brand) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(brand)) {
                filteredCars.add(car);
            }
        }
        saveCarsToFile(filteredCars, "brand_" + brand + "_cars.txt");
    }


    public static void saveCarsByModelAndAge(Car[] cars, String model, int years) {
        List<Car> filteredCars = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYear()) > years) {
                filteredCars.add(car);
            }
        }
        saveCarsToFile(filteredCars, "model_" + model + "_age_" + years + "_cars.txt");
    }

  
    public static void saveCarsByYearAndPrice(Car[] cars, int year, double minPrice) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > minPrice) {
                filteredCars.add(car);
            }
        }
        saveCarsToFile(filteredCars, "year_" + year + "_price_" + minPrice + "_cars.txt");
    }


    public static void saveCarsToFile(List<Car> cars, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Car car : cars) {
                writer.println(car);
            }
            System.out.println("Saved " + cars.size() + " cars to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
