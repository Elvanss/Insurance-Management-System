package Test;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static Test.TestCase.flatRate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;

public class User implements Cloneable, Comparable<User>, Serializable{
    private String name;
    private int userID;
    private Address address;
    private String password;
   // ArrayList<InsurancePolicy> policies;
   private HashMap<Integer, InsurancePolicy> policies;

  public User(String name, int userID, Address address, String password) {
        this.name = name;
        this.userID = userID;
        this.address = address;
        this.password = password;
        this.policies = new HashMap<>();
    }
    
  //copy constructor
    public User(User user) {
        this.name = user.name;
        this.userID = user.userID;
        this.address = user.address;
        this.password = user.password;
    }

    public User() {
    }
    
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public void setCity(String city) { 
    	address.setCity(city); 
    	}
    
    public String getCity() { 
    	return address.getCity(); 
    	}

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public HashMap<Integer, InsurancePolicy> getPolicies() {
        return policies;
    }
    
    public void setPolicies(HashMap<Integer, InsurancePolicy> policies) {
        this.policies = policies;
    }

        boolean addPolicy(InsurancePolicy policy) {
            for (InsurancePolicy AddPolicy : policies.values()) {
                if (AddPolicy.getId() == policy.getId()) {
                    return false;
                }
            }
            policies.put(policy.id, policy);
            return true;
        }

        public InsurancePolicy findPolicy(int policyID) {
        for (InsurancePolicy FindPolicy: policies.values()) {
            if (FindPolicy.getId() == policyID)
                return FindPolicy;
        }
        return null;
    }

    public void print() {
            System.out.println("Name: " + name);
            System.out.println("User ID: " + userID);
            System.out.println("Address: ");
            System.out.println("- Street Nụmber: " + address.streetNum);
            System.out.println("- Street Name: " + address.street);
            System.out.println("- Suburb: " + address.suburb);
            System.out.println("- City: " + address.city);
            System.out.println("<----------------------------------->");
            InsurancePolicy.printPolicies(policies);
            System.out.println();
        }

    public String toString() {
         String PolicyUser = " |User ID: " + userID + " |Name:" + name + " |Address:" + address + "\n";
        for(InsurancePolicy user : policies.values()) {
            PolicyUser = PolicyUser + user.toString()+ "\n";
            }
        return PolicyUser;
        }
    
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }


    public void printPolicies ( int flatRate) {
        InsurancePolicy.printPolicies(policies);
    }

    public double calcTotalPremium(int flatRate) {
        return InsurancePolicy.calcTotalPayments(policies, flatRate);
    }

    public void carPriceRiseAll (double risePercent) {
        InsurancePolicy.carPriceRiseAll(policies, risePercent);
    }

//    public ArrayList<InsurancePolicy> filterByCarModel (String carModel) {
//        return InsurancePolicy.filterByCarModel(policies, carModel);
//    }
    public HashMap<Integer, InsurancePolicy > filterByCarModel (String carModel) {
        return InsurancePolicy.filterByCarModel(policies, carModel);
}

    boolean createThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
    	return addPolicy(new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate,comments));
    	
    }
    
    public boolean createComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level)
    {
    	return addPolicy(new ComprehensivePolicy(policyHolderName,  id,  car,  numberOfClaims,  expiryDate,  driverAge,  level));
    }
    
    public ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date) {
    	return InsurancePolicy.filterByExpiryDate(policies, date);
    }


    public boolean validateUser(String username, String password) {
        return this.name.equals(username) && this.password.equals(password);
    }
    
//    public boolean validateUserName(String name, String password) // and not username as username might not be unique as we didn't check it
//    {
//        if ((this.name==name) && this.password.equals(password))
//        {
//            return true;
//        }
//        return false;
//    }

    public ArrayList<String> populateDistinctCarModels() {
        ArrayList<String> models =new ArrayList<String>();
        for (InsurancePolicy policy: policies.values()) {
            boolean userCarCheck = false;
            for (String disModel: models) {
                if (policy.getCarModel().equals(disModel)) {
                    userCarCheck = true;
                    break;
                }
            }
            if (!userCarCheck) {
                models.add(policy.getCarModel());
            }
        }
        return models;
    }

    public int getTotalCountForCarModel(String carModel) {
        int totalCount=0;
        for(InsurancePolicy policy:policies.values()) {
            if(policy.getCarModel().equals(carModel))
                totalCount = totalCount +1;
        }
        return totalCount;
    }

    public double getTotalPaymentForCarModel(String carModel, int flatRate) {
        double total=0;
        for( InsurancePolicy policy:policies.values()) {
            if(policy.getCarModel().equals(carModel)) {
                total += policy.calcPremium(flatRate);
            }
        }
        return total;
    }

    public ArrayList<Integer> getTotalCountPerCarModel (ArrayList<String> carModels) {
        ArrayList<Integer> totalCounts=new ArrayList<Integer>();
        for (String model:carModels) {
            totalCounts.add(getTotalCountForCarModel(model));
        }
        return totalCounts;
    }

    public ArrayList<Double> getTotalPaymentPerCarModel (ArrayList<String> carModels,int flatRate) {
        ArrayList<Double> totalPayments=new ArrayList<Double>();
        for (String model:carModels) {
            totalPayments.add(getTotalPaymentForCarModel(model,flatRate));
        }
        return totalPayments;
    }

    public void reportPaymentsPerCarModel (ArrayList<String> carModels, ArrayList<Integer>counts, ArrayList<Double> premiums) {
        System.out.println("Model" +"                 "+ "Total" +"                 "+ "Average");
        for (int i=0;i<counts.size();i++)
            System.out.println(carModels.get(i)+ "    "+ premiums.get(i) +"    "+ (double)(premiums.get(i)/counts.get(i)));
        System.out.println();
    }

    public static ArrayList<User> shallowCopy (ArrayList<User> users) {
        return new ArrayList<>(users);
    }

    public static ArrayList<User> shallowCopy(HashMap<Integer, User> users) {
        ArrayList<User>shallowCopy = new ArrayList<>();
        for (User user : users.values())
        {
            shallowCopy.add(user); // just assign same value (reference) for shallow copy
        }
        return shallowCopy;
    }

    public static HashMap<Integer, User> shallowCopyHashMap(HashMap<Integer, User> users) {
        HashMap<Integer, User>shallowCopy = users;
        return shallowCopy;
    }

    public static ArrayList<User> deepCopy (ArrayList<User> users) {
        return users.stream()
                .map(user -> {
                    try {
                        return (User) user.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<User> deepCopy(HashMap<Integer, User> users) throws CloneNotSupportedException
    {
        ArrayList<User>deepCopy = new ArrayList<>();
        for (User user : users.values())
        {
            User copyUser = new User(user); //Deep copy by using copy constructor
            deepCopy.add(copyUser.getUserID(), copyUser);
        }
        return deepCopy;
    }

    public static HashMap<Integer, User> deepCopyHashMap(HashMap<Integer, User> users) throws CloneNotSupportedException
    {
        HashMap<Integer, User> deepCopy = new HashMap<>();
        for (User user : users.values())
        {
            User copyUser = new User(user); //Deep copy by using copy constructor
            deepCopy.put(copyUser.getUserID(), copyUser);
        }
        return deepCopy;
    }

    public HashMap<Integer, InsurancePolicy> shallowCopyPoliciesHashMap()
    {
        HashMap<Integer, InsurancePolicy> shallowCopy = policies;
        return shallowCopy;
    }


    public HashMap<Integer, InsurancePolicy> deepCopyPoliciesHashMap() {
        HashMap<Integer, InsurancePolicy> deepCopy = new HashMap<>();
        for (InsurancePolicy policy : policies.values()) {
            if (policy instanceof ThirdPartyPolicy) {
                ThirdPartyPolicy copy = new ThirdPartyPolicy((ThirdPartyPolicy)policy);
                deepCopy.put( copy.id, copy);
            } else {
                ComprehensivePolicy copy = new ComprehensivePolicy((ComprehensivePolicy)policy);
                deepCopy.put(copy.id, copy);
            }
        }
        return deepCopy;
    }


    public ArrayList<InsurancePolicy> deepCopyPolicies() throws CloneNotSupportedException  {
    	return InsurancePolicy.deepCopy(policies);
    }

    public ArrayList<InsurancePolicy>  shallowCopyPolicies() {
    	return InsurancePolicy.shallowCopy(policies);
    }  
    
    public ArrayList<InsurancePolicy> sortPoliciesByDate() {
        ArrayList<InsurancePolicy> output = new ArrayList<>();

        for (InsurancePolicy policy : policies.values()) {
            output.add(policy);
        }
        Collections.sort(output);
        return output;
    }
  /*  public HashMap<String, Integer> getTotalCountPerCarModel() {
        HashMap<String, Integer> carTotal = new HashMap<>();
        for (InsurancePolicy carModel: policies.values())
        {
            Integer count = carTotal.get(carModel.getCarModel());
            if(count!=null)
            {
                carTotal.put(carModel.getCarModel(), count+1);
            }
            else
            {
                carTotal.put(carModel.getCarModel(), 1);
            }
        }
        return carTotal;
    } */

    public static void printUsers(HashMap<Integer, User> users)
    {
        for (User user : users.values())
        {
            System.out.println("Name: "+user.getName() +" User ID: "+user.getUserID()+" Address: "+user.getAddress());
        }
    }

   public HashMap<String, Double> getTotalPremiumPerCarModel() {
        HashMap<String, Double> models = new HashMap<> ();
        for (InsurancePolicy policy: policies.values()) {
            Double price = models.get(policy.getCarModel());
            if (price != null) {
                models.put(policy.getCarModel(), price.doubleValue() + policy.getCar().getPrice());
            } else {
                models.put(policy.getCarModel(), policy.getCar().getPrice());
            }
        }
        return models;
    }

    public HashMap<String, Integer> getTotalCountPerCarModel()
    {
        HashMap<String, Integer> totalCarCount = new HashMap<>();

        for (InsurancePolicy policy : policies.values())
        {
            String carModel = policy.car.getModel(); //
            if (!totalCarCount.containsKey(carModel))
            {
                HashMap<Integer, InsurancePolicy> carModelPolicies = filterByCarModel(carModel);
                totalCarCount.put(carModel, carModelPolicies.size());
            }
        }
        return totalCarCount;
    }

//    public HashMap<String, Double> getTotalPremiumPerCarModel() {
//        HashMap<String, Double> models = new HashMap<>();
//        policies.values().stream()
//                .collect(Collectors.groupingBy(InsurancePolicy::getCarModel,
//                        Collectors.summingDouble(p -> p.getCar().getPrice())));
//        return models;
//    }

    public void reportPayments (Map<String, Double> reportCar, HashMap<String, Integer> premiumPrice) {
        System.out.printf("%-20s $%-20s $%-20s \n","Car Model","Total Premium Payment", "Average Premium Payment");
        for (String carReport: reportCar.keySet()) {
            System.out.printf("%-20s $%-20s $%-20s \n", carReport, reportCar.get(carReport), reportCar.get(carReport)/premiumPrice.get(carReport));
        }
        System.out.println();
    }

    public static boolean save(HashMap<Integer, User> users, String fileName) throws IOException
    {
        ObjectOutputStream outputStream = null; //declare output stream to open file
        boolean value = false;

        try //open file
        {
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        }
        catch (IOException inputOutputX)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        try // write to file
        {
            for (User user : users.values())
            {
                outputStream.writeObject(user);
            }
        }
        catch (IOException inputOutputX)
        {
            System.err.println("Error in writing to file. Terminating.");
            System.exit(1);
        }
        try //close file
        {
            if (outputStream!=null)
                outputStream.close();
            value = true;
        }
        catch (IOException inputOutputX)
        {
            System.err.println("Error closing file. Terminating.");
            System.exit(1);
        }
        return value;
    }

    public static HashMap<Integer, User> load(String fileName) throws IOException
    {
        ObjectInputStream inputStream = null; //declare input object to open file
        HashMap<Integer, User> output = new HashMap<>();

        // attempt to open file
        try
        {
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }

        try
        {
            while (true)
            {
                User user = (User) inputStream.readObject();
                output.put(user.getUserID(), user);
            }
        }
        catch (EOFException endOfFile)
        {
            System.out.println("\nUser Load Complete.\n");
        }
        catch (ClassNotFoundException classNotFound)
        {
            System.err.println("Invalid object type. Terminating.");
        }
        catch (IOException inputOutputError)
        {
            System.err.println("Error reading from file. Terminating.");
        }

        // close the file
        try
        {
            if (inputStream!=null)
                inputStream.close();
        }
        catch (IOException inputOutputError)
        {
            System.err.println("Error closing file. Terminating.");
        }

        return output;
    }

    public String toDelimitedString()
    {
        String output = name + "," + userID + "," + address.toDelimitedString() + "," + password + "," + policies.size();
        for (InsurancePolicy policy : policies.values())
        {
            output+= "," + policy.toDelimitedString();
        }

        return output;
    }

    // save write data to file from hash map

    public static boolean saveTextFile(HashMap<Integer, User> users, String fileName) throws IOException
    {
        BufferedWriter output = new BufferedWriter(new FileWriter(fileName)); // create object to write data to file

        for (User user : users.values())
        {
            output.write(user.toDelimitedString() + "\n");
        }
        output.close();
        return true;
    }

    public static HashMap<Integer, User> loadTextFile(String fileName) throws IOException {
        HashMap<Integer, User> output = new HashMap<>(); // create new hash map to store and return loaded data

        BufferedReader input = new BufferedReader(new FileReader(fileName)); // create object to read in data
        String line = input.readLine(); // read in first line
        while(line!=null)
        {
            line = line.trim(); // trim white space from either end of string
            String[] field = line.split(","); // split string into array using comma seperators

            // store values from field array
            String userName = field[0];
            int userID = Integer.parseInt(field[1]);
            int streetNum = Integer.parseInt(field[2]);
            String street = field[3];
            String suburb = field[4];
            String city = field[5];
            String username = field[6];
            String password = field[7];
            int numPolicies = Integer.parseInt(field[8]);

            Address address = new Address(streetNum, street, suburb, city); // create address object
            User user = new User(userName, userID, address, password); // create user object
            user.setUserID(userID); // set user ID from file

            int index = 9;
            for (int i=0 ; i<numPolicies; i++)
            {
                if(field[index].equals("TP"))
                {
                    String policyHolderName = field[index+1];
                    int id = Integer.parseInt(field[index+2]);
                    carType type = carType.valueOf(field[index+3]);
                    String model = field[index+4];
                    int manufacturingYear = Integer.parseInt(field[index+5]);
                    double price = Double.parseDouble(field[index+6]);
                    int numberOfClaims = Integer.parseInt(field[index+7]);
                    int year = Integer.parseInt(field[index+8]);
                    int month = Integer.parseInt(field[index+9]);
                    int day = Integer.parseInt(field[index+10]);
                    String comments = field[index+11];

                    Car car = new Car( model, type, manufacturingYear, price);
                    MyDate date = new MyDate(year, month, day);

                    user.addPolicy(user.getName(), user.getPassword(), new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, date, comments));
                    index+=12;
                }
                else
                {
                    String policyHolderName = field[index+1];
                    int id = Integer.parseInt(field[index+2]);
                    carType type = carType.valueOf(field[index+3]);
                    String model = field[index+4];
                    int manufacturingYear = Integer.parseInt(field[index+5]);
                    double price = Double.parseDouble(field[index+6]);
                    int numberOfClaims = Integer.parseInt(field[index+7]);
                    int year = Integer.parseInt(field[index+8]);
                    int month = Integer.parseInt(field[index+9]);
                    int day = Integer.parseInt(field[index+10]);
                    int driverAge = Integer.parseInt(field[index+11]);
                    int level = Integer.parseInt(field[index+12]);

                    Car car = new Car( model, type, manufacturingYear, price);
                    MyDate date = new MyDate(year, month, day);

                    user.addPolicy(user.getName(), user.getPassword(), new ComprehensivePolicy(policyHolderName, id, car, numberOfClaims, date, driverAge, level));
                    index+=13;
                }
            }
            output.put(user.getUserID(), user);
            line = input.readLine();
        }
        input.close();
        return output;
    }

    // ASSIGNMENT 2_STANDARD
    boolean addPolicy (String userName, String password, InsurancePolicy policy) {
        if (!validateUser(userName, password)) {
            System.out.println("Access False!");
            return false;
        }
        if (findPolicy(policy.getId()) == null) {
            getPolicies().put(policy.id, policy);
            return true;
        }
        return false;
    }
    
    public HashMap<Integer, InsurancePolicy> getPolicies(String username, String password)
    {
        HashMap<Integer, InsurancePolicy> output = new HashMap<>();
        if (validateUser(username, password))
        {
            output = policies;
        }
        return output;
    }

    double calcTotalPayment (String userName, String password) {
        if (!validateUser(userName, password)) {
            System.out.println("Access False!");
            return 0;
        }
        return InsurancePolicy.calcTotalPayments(getPolicies(), flatRate);
    }

    //ASSIGNMENT 2_ADVANCED
    public  int[] policyCount(String username, String password, int[] ranges) {
        if (!validateUser(username, password)) {
            System.out.println("Invalid login!");
            return null;
        }
        int[] counts = new int[ranges.length];
        for (InsurancePolicy entry : policies.values()) {
            InsurancePolicy policy = entry;
            int premium = (int) policy.calcPremium(30);
            for (int i = 0; i < ranges.length; i++) {
                if (premium > ranges[i]) {
                    counts[i]++;
                }
            }
        }
        return counts;
    }

    public HashMap<String, Integer[]> policyCarModelCount(String username, String password, int[] ranges) {
        if (!validateUser(username, password)) {
            System.out.println("Invalid login!");
            return null;
        }
        HashMap<String, Integer[]> modelCounts = new HashMap<>();
        for (InsurancePolicy policy : getPolicies().values()) {
            String model = policy.getCar().getModel();
            int premium = (int) policy.calcPremium(30);
            if (premium > ranges[0] && premium < ranges[1]) {
                Integer[] counts = modelCounts.get(model);
                if (counts == null) {
                    counts = new Integer[ranges.length];
                    for (int i = 0; i < ranges.length; i++) {
                        counts[i] = 0;
                    }
                }
                counts[1]++;
                modelCounts.put(model, counts);
            }
        }
        return modelCounts;
    }
}










