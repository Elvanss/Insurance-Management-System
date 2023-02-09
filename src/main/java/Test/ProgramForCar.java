package Test;


import java.io.IOException;

public class ProgramForCar {

    public static void main(String [] args) throws IOException {
            InsuranceCompany insuranceCompany = new InsuranceCompany("InsuranceCarCompany", "admin", "dpit121", 30);
        Car brand1 = new Car("Porsche Panamera", carType.HATCH, 2021, 353000);
        Car brand2 = new Car("Tesla Model 3", carType.LUX, 2022, 77000);
        Car brand3 = new Car("Toyota Supra", carType.SED, 2019, 125000);
        Car brand4 = new Car("Aston Martin DBX", carType.SUV, 2010, 456999);

        // create the address objects
        Address address1 = new Address(12, "Killian St", "Alexander Heights", "Perth");
        Address address2 = new Address(24, "Willam St", "RingWood", "Melbourne");
        Address address3 = new Address(48, "Brightmore St", "Cremorne", "Sydney");

        // create MyDate objects
        MyDate ExpiryDate1 = new MyDate(2024, 2, 12);
        MyDate ExpiryDate2 = new MyDate(2024, 3, 13);
        MyDate ExpiryDate3 = new MyDate(2024, 4, 14);

        // create 1 user that was based on lab2 requirement--> creating more user for lab3,assignment1
        User user1 = new User("Justin", 1101, address1, "justin01");
        User user2 = new User("Henry", 1102, address2, "henry01");
        User user3 = new User("Shawn", 1103, address3, "shawn01");

        // create ThirdPartyPolicy & ComprehensivePolicy objects
        ThirdPartyPolicy TPP1 = new ThirdPartyPolicy("Evan", 1, brand1, 6, ExpiryDate1, "Be careful with this car!");
        ThirdPartyPolicy TPP2 = new ThirdPartyPolicy("Andrew", 3, brand3, 4, ExpiryDate3, "Drive or die");
        ThirdPartyPolicy TPP3 = new ThirdPartyPolicy("William", 137, brand2, 1, ExpiryDate2, "Good");
        ComprehensivePolicy CP1 = new ComprehensivePolicy("Peter", 2, brand2, 1, ExpiryDate2, 29, 7);
        ComprehensivePolicy CP2 = new ComprehensivePolicy("David", 4, brand4, 2, ExpiryDate3, 30, 6);
        ComprehensivePolicy CP3 = new ComprehensivePolicy("Zoe", 110, brand3, 5, ExpiryDate1, 26, 12);

        // add user
        insuranceCompany.addUser(user1);
        insuranceCompany.addUser(user2);
        insuranceCompany.addUser(user3);

        //add policy
        insuranceCompany.addPolicy(1101,TPP1);
        insuranceCompany.addPolicy(1101,TPP2);
        insuranceCompany.addPolicy(1101,CP2);
        insuranceCompany.addPolicy(1101,CP3);   
        insuranceCompany.addPolicy(1102,TPP2);
        insuranceCompany.addPolicy(1102,TPP3);
        insuranceCompany.addPolicy(1102,CP1);       
        insuranceCompany.addPolicy(1103,TPP1);
        insuranceCompany.addPolicy(1103,TPP2);
        insuranceCompany.addPolicy(1103,CP1);
        insuranceCompany.addPolicy(1103,CP2);
        insuranceCompany.addPolicy(1103,CP3);


        //call interface(do all the functions)
            Interface.MainMenuLogin(insuranceCompany);
            insuranceCompany.saveDatabase();
            insuranceCompany.loadDatabase();
    }
}






























