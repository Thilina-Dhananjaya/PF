abstract class Car {
    protected double price;
    protected int year;

    public Car(double price, int year) {
        this.price = price;
        this.year = year;
    }

    public abstract double calculateSalePrice();
}

class ClassicCar extends Car {
    public ClassicCar(double price, int year) {
        super(price, year);
    }

    @Override
    public double calculateSalePrice() {
        return 1.0 * price; // Return the sale price for ClassicCar (e.g., 100% of the original price)
    }
}

class SportCar extends Car {
    public SportCar(double price, int year) {
        super(price, year);
    }

    @Override
    public double calculateSalePrice() {
        if (year > 2015) {
            return 1.75 * price; // 75% higher than the original price
        } else if (year > 2005) {
            return 1.5 * price;  // 50% higher than the original price
        } else {
            return 1.25 * price; // 25% higher than the original price
        }
    }
}

class CarExhibition {
    private Car[] cars;
    private int numberOfCars;

    public CarExhibition() {
        cars = new Car[100]; // Assuming a maximum of 100 cars in the exhibition
        numberOfCars = 0;
    }

    public void addCar(double price, int year) {
        cars[numberOfCars++] = new Car(price, year) {
            @Override
            public double calculateSalePrice() {
                // Abstract method implementation for the generic Car class
                return 0.0; // Default implementation, not specified in the prompt
            }
        };
    }

    public void addSportCar(double price, int year) {
        cars[numberOfCars++] = new SportCar(price, year);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (int i = 0; i < numberOfCars; i++) {
            total += cars[i].calculateSalePrice();
        }
        return total;
    }
}

public class CarExivition {
    public static void main(String[] args) {
        CarExhibition exhibition = new CarExhibition();

        exhibition.addCar(50000, 2010);
        exhibition.addSportCar(60000, 2018);
        

        double totalPrice = exhibition.getTotalPrice();
        System.out.println("Total Price of Cars in Exhibition: $" + totalPrice);
    }
}