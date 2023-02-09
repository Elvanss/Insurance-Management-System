package Test;

import java.io.Serializable;
public class Address implements Cloneable, Comparable<Address>, Serializable {

    int streetNum;
    String street;
    String suburb;
    String city;

    //constructor
    public Address(int streetNum, String street, String suburb, String city) {
        this.streetNum = streetNum;
        this.street = street;
        this.suburb = suburb;
        this.city = city;
    }
    
    //copy constructor
    public Address (Address address) {
        this.streetNum = address.streetNum;
        this.street = address.street;
        this.suburb = address.suburb;
        this.city = address.city;
    }

    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
    //getter and setter
    public int getStreetNum() { return streetNum; }
    public void setStreetNum(int streetNum) { this.streetNum = streetNum; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getSuburb() { return suburb; }
    public void setSuburb(String suburb) { this.suburb = suburb; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    //toString() method
    public String toString() {
        return " |Street Num" + streetNum + " |Street: " + street + " Suburb: " + suburb + " |City: " + city;
    }

    public int compareTo(Address other) {
        return this.city.compareTo(other.city);
    }

    public String toDelimitedString() {
        return streetNum + "," + street + "," + suburb + "," + city;
    }
}
