package Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static Test.TestCase.flatRate;

public class Interface {

    public static void mainMenu() {
        System.out.println("<> WELCOME TO INSURANCE CAR COMPANY <>");
        System.out.println("-Main menu-");
        System.out.println("Choose options from 1 to 3:");
        System.out.println("(1): Admin Login");
        System.out.println("(2): User Login");
        System.out.println("(3): Quit");
    }

    public static void MainMenuLogin(InsuranceCompany insuranceCompany) throws IOException {
        mainMenu();
        Scanner info = new Scanner(System.in);
        int type = info.nextInt();
        switch (type) {
            case 1:
                adminLogin(insuranceCompany);
                break;
            case 2:
                userLogin(insuranceCompany);
                break;
            case 3:
                System.out.println("Exit successfully!");
                mainMenu();
                break;
            default:
                System.out.println("Wrong option! Please choose again");
                mainMenu();

        }

    }

    public static void adminLogin(InsuranceCompany insuranceCompany) throws IOException {
        System.out.println("!!!Admin Login Launcher!!!");
        Scanner info = new Scanner(System.in);
        System.out.println("Enter the username: ");
        String username = info.nextLine();
        System.out.println("Enter the password: ");
        String password = info.nextLine();
        if (!insuranceCompany.validateAdmin(username, password)) {
            System.out.println("Login UnSuccessful");
        } else {
            System.out.println("Login Successful");
            adminMenuOption(insuranceCompany);
        }


    }

    public static void userLogin(InsuranceCompany insuranceCompany) {
        System.out.println("!!!Admin Login Launcher!!!");
        Scanner info = new Scanner(System.in);
        System.out.println("Enter the userID (Changed to username): ");
        String userID = info.nextLine();
        info.nextLine();
        System.out.println("Enter the password: ");
        String password = info.nextLine();
        User userLogin = insuranceCompany.validateUser(userID, password);
        if (userLogin == null) {
            System.out.println("Login Unsuccessful");
        } else {
            System.out.println("Login Successful");
            UserMenuOption(userLogin);
        }
    }


    public static void adminMenu() {
        System.out.println("Admin option:");
        System.out.println("(1): Test Code");
        System.out.println("(2): Create User");
        System.out.println("(3): Create Third Party Policy");
        System.out.println("(4): Create Comprehensive Policy");
        System.out.println("(5) Print User Information");
        System.out.println("(6) Filter By Car Model");
        System.out.println("(7) Filter By Expiry Date");
        System.out.println("(8) Update Address");
        System.out.println("(9) Log Out");
        System.out.println("\nSelect from 1 to 9:");
    }

    public static void adminMenuOption(InsuranceCompany insuranceCompany) throws IOException {
        adminMenu();
        Scanner info = new Scanner(System.in);
        int option = info.nextInt();
        switch (option) {
            case 1:
                // 1st function
                TestCase.testCode();
                break;
            case 2:
                createUser(insuranceCompany);
                break;
            case 3:
                createThirdPartyPolicy(insuranceCompany);
                break;
            case 4:
                createComprehensivePolicy(insuranceCompany);
                break;
            case 5:
                printUserInformation(insuranceCompany);
                break;
            case 6:
                FilterByCarModel(insuranceCompany);
                break;
            case 7:
                FilterByExpiryDate(insuranceCompany);
                break;
            case 8:
                updateAddress(insuranceCompany);
                break;
            case 9:
                System.out.println("Log out!");
                MainMenuLogin(insuranceCompany);
                break;
            default:
                System.out.println("Wrong option!!");
        }
        exit();
    }

    //admin functions
    // 2nd function
    public static void createUser(InsuranceCompany insuranceCompany) {
        Scanner sc = new Scanner(System.in);
        System.out.println("|-Create User-|");
        System.out.println("Enter User ID:");
            int userID = sc.nextInt();
            sc.nextLine();
        System.out.println("Enter Name:");
            String name = sc.nextLine();
        System.out.println("Enter Password:");
            String password = sc.nextLine();
        System.out.println("Address:");
        System.out.println("Enter Street Number:");
            int streetNumber = sc.nextInt();
            sc.nextLine();
        System.out.println("Enter Street Name:");
            String streetName = sc.nextLine();
        System.out.println("Enter Suburb:");
            String suburb = sc.nextLine();
        System.out.println("Enter City:");
            String city = sc.nextLine();
        Address address = new Address(streetNumber, streetName, suburb, city);
        addUser(insuranceCompany,name,userID, address, password);
    }

    public static void addUser(InsuranceCompany insuranceCompany, String name, int id, Address address, String password) {
        if(insuranceCompany.addUser(name, id, address, password)) {
            System.out.println("The user has been added successfully");
        } else {
            System.out.println("The user can't be added ID already exists");
        }
    }
    // 3rd function
    public static void createThirdPartyPolicy(InsuranceCompany insuranceCompany) {
        Scanner info = new Scanner(System.in);
        System.out.println("|-Create Third Party Policy-|");
        System.out.print("Enter the user ID: ");
            int userID = info.nextInt();
            info.nextLine();
        System.out.print("Enter Policy Holder Name: ");
            String policyHolderName = info.nextLine();
        System.out.print("Enter policy ID: ");
            int policyID = info.nextInt();
        System.out.print("Please enter car model: ");
            String carModel = info.next();
        System.out.print("Please enter manufacturing year: ");
            int manufacturingYear = info.nextInt();
        System.out.print("Please enter price: ");
            double price = info.nextDouble();
        System.out.print("Choose car type(SUV,SED,LUX,HATCH,UTE): ");
            carType type = carType.valueOf(info.next());
        Car car = new Car(carModel,type, manufacturingYear,price);
        System.out.println("Enter Number of Claims: ");
            int numberOfClaims = info.nextInt();
        System.out.print("Enter year: ");
            int policyYear = info.nextInt();
        System.out.print("Enter month: ");
            int policyMonth = info.nextInt();
        System.out.print("Enter day: ");
            int policyDay = info.nextInt();
            MyDate policyDate = new MyDate(policyYear, policyMonth, policyDay);
        System.out.println("Enter Comments: ");
            String comments = info.nextLine();
        addThirdPartyPolicy(insuranceCompany, userID, policyHolderName, policyID, car, numberOfClaims, policyDate, comments);
    }

    public static void addThirdPartyPolicy(InsuranceCompany insuranceCompany, int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
        if(insuranceCompany.createThirdPartyPolicy(userID, policyHolderName, id, car, numberOfClaims, expiryDate, comments)) {
            System.out.println("The policy was added successfully");
        } else {
            System.out.println("The policy can't be added because this ID is existed");
        }
    }
    // 4th function
    public static void createComprehensivePolicy(InsuranceCompany insuranceCompany) {
        Scanner info = new Scanner(System.in);
        System.out.println("|-Create Third Party Policy-|");
        System.out.print("Enter the user ID: ");
            int userID = info.nextInt();
            info.nextLine();
        System.out.print("Enter Policy Holder Name: ");
            String policyHolderName = info.nextLine();
        System.out.print("Enter policy ID: ");
            int policyID = info.nextInt();
        System.out.print("Please enter car model: ");
            String carModel = info.next();
        System.out.print("Please enter manufacturing year: ");
            int manufacturingYear = info.nextInt();
        System.out.print("Please enter price: ");
            double price = info.nextDouble();
        System.out.print("Choose car type(SUV,SED,LUX,HATCH,UTE): ");
            carType type = carType.valueOf(info.next());
        Car car = new Car(carModel,type, manufacturingYear,price);
        System.out.println("Enter Number of Claims: ");
            int numberOfClaims = info.nextInt();
        System.out.print("Enter year: ");
            int policyYear = info.nextInt();
        System.out.print("Enter month: ");
            int policyMonth = info.nextInt();
        System.out.print("Enter day: ");
            int policyDay = info.nextInt();
        MyDate policyDate = new MyDate(policyYear, policyMonth, policyDay);
        System.out.print("Enter the driver age: ");
            int driverAge = info.nextInt();
        System.out.println("Enter the level: ");
            int level = info.nextInt();
        addComprehensivePolicy(insuranceCompany, userID, policyHolderName, policyID, car, numberOfClaims, policyDate, driverAge, level);
    }

    public static void addComprehensivePolicy(InsuranceCompany insuranceCompany, int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
        if (insuranceCompany.createComprehensivePolicy(userID, policyHolderName, id, car, numberOfClaims, expiryDate,driverAge, level)) {
            System.out.println("The policy was added successfully");
        } else {
            System.out.println("The policy can't be added because this ID is existed");
        }
    }
    // 5th function
    public static void printUserInformation(InsuranceCompany insuranceCompany) {
        Scanner info = new Scanner(System.in);
        System.out.println("---Print User Information---");
        System.out.println("Enter User ID:");
            int userID = info.nextInt();
        insuranceCompany.userInfo(userID);

    }
    // 6th function
    public static void FilterByCarModel (InsuranceCompany insuranceCompany) {
        Scanner info = new Scanner(System.in);
        System.out.println("Enter car model: ");
            String model = info.nextLine();
        ArrayList<InsurancePolicy> filteredByCarPolicies = insuranceCompany.filteredByCarModel(model);
            insuranceCompany.filteredByCarModel(model);
                double premiumTotal = InsurancePolicy.calcTotalPayments(filteredByCarPolicies, insuranceCompany.getFlatRate());
            System.out.println("Total Payment: $" + premiumTotal);
    }
    // 7th function
    public static void FilterByExpiryDate(InsuranceCompany insuranceCompany) {
        Scanner info = new Scanner(System.in);
        System.out.println("Enter User ID:");
            int userID = info.nextInt();
        System.out.println("Enter year: ");
            int yearExpiry = info.nextInt();
        System.out.println("Enter month: ");
            int monthExpiry = info.nextInt();
        System.out.println("Enter day: ");
            int dayExpiry = info.nextInt();
            MyDate FilterDate = new MyDate(yearExpiry,monthExpiry, dayExpiry);
     ArrayList<InsurancePolicy> filterByDatePolicies = insuranceCompany.filterByExpiryDate(userID, FilterDate);
     InsurancePolicy.printPolicies(filterByDatePolicies);
    }

    public static void updateAddress(InsuranceCompany insuranceCompany) {
        Scanner info = new Scanner(System.in);
        System.out.print("Enter User ID: ");
            int userID = info.nextInt();
        User user = insuranceCompany.findUser(userID);
        if (user == null) {
            System.out.println("The user is not found!!");
        }else {
            System.out.println("User has found: " + userID);
            System.out.print("Enter Street Number: ");
                int StreetNum = info.nextInt();
            System.out.print("Enter street: ");
                String StreetName = info.nextLine();
            System.out.print("Enter Suburb: ");
                String Suburb = info.nextLine();
            System.out.print("Enter City: ");
                String City = info.nextLine();
            Address address = new Address(StreetNum, StreetName, Suburb, City);
                user.setAddress(address);
                user.print();
        }
    }

    public static void userMenu() {
        System.out.println("User option:");
        System.out.println("(1): Print User Information and Policy");
        System.out.println("(2): Print All Policy");
        System.out.println("(3): Print Total Payment");
        System.out.println("(4): Print Total Payment after rising");
        System.out.println("(5): Create Third Party Policy");
        System.out.println("(6): Create Comprehensive Policy");
        System.out.println("(7) Update Address");
        System.out.println("(8) Log Out");
        System.out.println("\nSelect from 1 to 6:");
    }
    public static void UserMenuOption(User user) {
        userMenu();
        Scanner info = new Scanner(System.in);
        int option1 = info.nextInt();
        switch (option1) {
            case 1:
                userInfo(user);
                break;
            case 2:
                policyInfo(user);
                break;
            case 3:
                PaymentInfo(user);
                break;
            case 4:
                PaymentRise(user);
                break;
            case 5:
                createThirdPartyPolicy(user);
                break;
            case 6:
                createComprehensivePolicy(user);
                break;
            case 7:
                updateAddress(user);
            case 8:
                System.out.println("Log out");
                break;
        }
        exit();
    }
    // user functions
    public static void userInfo(User user) {
        user.print();
    }

    public static void policyInfo (User user) {
        user.printPolicies(user.getUserID());
    }

    public static void PaymentInfo (User user) {
        System.out.printf("The total premium payment: $%.0f\n", user.calcTotalPremium(flatRate));
    }

    public static void PaymentRise (User user) {
        System.out.printf("The total premium payment before: $%.0f\n", user.calcTotalPremium(flatRate));
        Scanner info = new Scanner(System.in);
        System.out.print("Enter the risePrecent: ");
            double rise = info.nextDouble();
// add 10% to the price of cars for all the policies this user owns
        user.carPriceRiseAll(rise);
        System.out.printf("The total premium payment after: $%.0f\n", user.calcTotalPremium(flatRate));
    }
    public static void createThirdPartyPolicy(User user) {
        Scanner info = new Scanner(System.in);
        System.out.println("|-Create Third Party Policy-|");
        System.out.print("Enter Policy Holder Name: ");
            String policyHolderName = info.nextLine();
        System.out.print("Enter policy ID: ");
            int policyID = info.nextInt();
        System.out.print("Please enter car model: ");
            String carModel = info.next();
        System.out.print("Please enter manufacturing year: ");
            int manufacturingYear = info.nextInt();
        System.out.print("Please enter price: ");
            double price = info.nextDouble();
        System.out.print("Choose car type(SUV,SED,LUX,HATCH,UTE): ");
            carType type = carType.valueOf(info.next());
            Car car = new Car(carModel,type, manufacturingYear,price);
        System.out.println("Enter Number of Claims: ");
            int numberOfClaims = info.nextInt();
        System.out.print("Enter year: ");
            int policyYear = info.nextInt();
        System.out.print("Enter month: ");
            int policyMonth = info.nextInt();
        System.out.print("Enter day: ");
            int policyDay = info.nextInt();
        MyDate policyDate = new MyDate(policyYear, policyMonth, policyDay);
        System.out.println("Enter Comments: ");
            String comments = info.nextLine();
        addUserPartyPolicy(user,policyHolderName, policyID, car, numberOfClaims, policyDate, comments);
    }

    public static void addUserPartyPolicy(User user, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
        if(user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments)) {
            System.out.println("The policy was added successfully");
        } else {
            System.out.println("The policy can't be added because this ID is existed");
        }
    }

    public static void createComprehensivePolicy(User user) {
        Scanner info = new Scanner(System.in);
        System.out.println("|-Create Third Party Policy-|");
        System.out.print("Enter Policy Holder Name: ");
            String policyHolderName = info.nextLine();
        System.out.print("Enter policy ID: ");
            int policyID = info.nextInt();
        System.out.print("Please enter car model: ");
            String carModel = info.next();
        System.out.print("Please enter manufacturing year: ");
            int manufacturingYear = info.nextInt();
        System.out.print("Please enter price: ");
            double price = info.nextDouble();
        System.out.print("Choose car type(SUV,SED,LUX,HATCH,UTE): ");
            carType type = carType.valueOf(info.next());
            Car car = new Car(carModel,type, manufacturingYear,price);
        System.out.println("Enter Number of Claims: ");
            int numberOfClaims = info.nextInt();
        System.out.print("Enter year: ");
            int policyYear = info.nextInt();
        System.out.print("Enter month: ");
            int policyMonth = info.nextInt();
        System.out.print("Enter day: ");
            int policyDay = info.nextInt();
            MyDate policyDate = new MyDate(policyYear, policyMonth, policyDay);
        System.out.print("Enter the driver age: ");
            int driverAge = info.nextInt();
        System.out.println("Enter the level: ");
            int level = info.nextInt();
        addUserComprePolicy(user, policyHolderName, policyID, car, numberOfClaims, policyDate, driverAge, level);
    }

    public static void addUserComprePolicy(User user, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
        if(user.createComprehensivePolicy( policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level)) {
            System.out.println("The policy was added successfully");
        } else {
            System.out.println("The policy can't be added because this policy ID is existed");
        }
    }

    public static void updateAddress(User user) {
        Scanner info = new Scanner(System.in);
            System.out.print("Enter Street Number: ");
                int StreetNum = info.nextInt();
            System.out.print("Enter street: ");
                String StreetName = info.nextLine();
            System.out.print("Enter Suburb: ");
                String Suburb = info.nextLine();
            System.out.print("Enter City: ");
                String City = info.nextLine();
            Address address = new Address(StreetNum, StreetName, Suburb, City);
                user.setAddress(address);
                user.print();
    }

    public static void exit() {
        System.out.println("Press Enter Key to Continue.");
        try {
            System.in.read();
        } catch (Exception e)
        {}
    }
}







