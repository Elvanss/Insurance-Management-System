package Test;

import java.io.Serializable;
enum carType implements Cloneable, Serializable {
    SUV,
    SED,
    LUX,
    HATCH,
}
public class Car {
    protected String model;
    carType type;
    protected int manufacturingYear;
    protected double price;

    //constructor
    public Car (String model, carType type, int manufacturingYear, double price){
        this.model=model;
        this.type=type;
        this.manufacturingYear=manufacturingYear;
        this.price=price;
    }
    
 // copy constructor
    public Car(Car car) {
        this.model = car.model;
        this.type = car.type;
        this.manufacturingYear = car.manufacturingYear;
        this.price = car.price;
    }

    protected Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
    
    //getter and setter
    public String getModel() { return model; }
    public void setModel (String model) { this.model = model; }
    public carType getType() { return type; }
    public void setType (carType type) { this.type = type; }
    public int getManufacturingYear() { return manufacturingYear; }
    public void setManufacturingYear(int manufacturingYear) { this.manufacturingYear = manufacturingYear;}
    public double getPrice() { return price; }
    public void setPrice (double price) { this.price = price; }

    //toString() method
    public String toString() {
        return " |Model:" + model + " |Car Type: " +type + " |Manufacturing Year: " + manufacturingYear + " |price: " + price;
    }

    public void priceRise(double rise) {
        price =price * (1+rise);
    }
    public String toDelimitedString ()
    {
        return model + "," +type + "," + manufacturingYear + "," + price;
    }
}

