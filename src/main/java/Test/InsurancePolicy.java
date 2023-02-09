package Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class InsurancePolicy implements Cloneable, Comparable<InsurancePolicy>, Serializable {
    private static final long serialVersionUID = 1L;
	protected String policyHolderName;
    protected int id;
    protected Car car;
    protected int numberOfClaims;
    protected MyDate expiryDate;
    protected  int count = 0;

    //constructor
    public InsurancePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate) {
        this.policyHolderName = policyHolderName;
        this.id = id;
        this.car = car;
        this.numberOfClaims = numberOfClaims;
        this.expiryDate = expiryDate;
    }

    public InsurancePolicy(String policyHolderName, int id, Car car, int numberOfClaims, int count, MyDate expiryDate) {
        this.policyHolderName = policyHolderName;
        this.id = id;
        this.car = car;
        this.numberOfClaims = numberOfClaims;
        this.count = count+1;
        this.expiryDate = expiryDate;
    }
    
    public InsurancePolicy(String policyHolderName, int id, int numberOfClaims) {
        this.policyHolderName = policyHolderName;
        this.id = id;       
        this.numberOfClaims = numberOfClaims;
    }
    
  //copy constructor
    public InsurancePolicy(InsurancePolicy insurancePolicy) {
        this.policyHolderName = insurancePolicy.policyHolderName;
        this.id = insurancePolicy.id;
        this.car = insurancePolicy.car; //it will only copy a car object reference
        this.numberOfClaims = insurancePolicy.numberOfClaims;
        this.expiryDate = insurancePolicy.expiryDate;
    }

    public String toDelimitedString() {
        return  policyHolderName + "," + id +"," + car.toDelimitedString() + "," + numberOfClaims + "," + expiryDate.toDelimitedString();
    }

    protected InsurancePolicy clone() throws CloneNotSupportedException {
        InsurancePolicy clonedPolicy = (InsurancePolicy) super.clone();
        clonedPolicy.car = car.clone();
        clonedPolicy.expiryDate = expiryDate.clone();
        return clonedPolicy;
    }

    //autoID (Lab7)
    public int autoID() {
        ArrayList<InsurancePolicy> policies = new ArrayList();
        for (int i = 0; i<= policies.size(); i++) {
            count += count;
        }
        return count;
    }

    //getter and setter
    public String getPolicyHolderName() {
        return policyHolderName;
    }
    
    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public Car getCar() {
        return car;
    }
    
    public String getCarModel() { 
    	return car.getModel(); 
    	}
    
    public void setCarModel(String model) { 
    	car.setModel(model); 
    	}
    
    public void setCar(Car car) {
        this.car = car;
    }
  //optional method I created to get the same manufacturing year with the changed car name
    public void setCarManufacturingYear(int manufacturingYear) {
        car.setManufacturingYear(manufacturingYear);
    }
    
    public int getNumberOfClaims() {
        return numberOfClaims;
    }
    
    public void setNumberOfClaims (int numberOfClaims) {
        this.numberOfClaims = numberOfClaims;
    }
    
    public MyDate getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(MyDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void print() {
        System.out.println("Policy Holder name: " + policyHolderName);
        System.out.println("Id: " + id);
        System.out.println("Car Model: " + car.model);
        System.out.println("Car Manufacturing Year: " + car.manufacturingYear);
        System.out.printf("Car Price: $%.0f\n", car.price);
        System.out.println("Number of Claims: " + numberOfClaims);
        System.out.println("The Expiry Date: " + expiryDate);
    }

    //toString() method
    public String toString() {
        return " |Policy Holder Name: " + policyHolderName + " |Id: " + id + car.toString() + " |Number Of Claims: " + numberOfClaims + " |The Expiry Date: " + expiryDate;
    }

    public abstract double calcPremium(int flatRate);

    public static void printPolicies(ArrayList<InsurancePolicy> policies) {
        policies.forEach(System.out::println);
    }

    public static void printPolicies(HashMap<Integer, InsurancePolicy> policies)
    {
        policies.values().forEach(policy -> {policy.print();});
    }

    public static double calcTotalPayments(ArrayList<InsurancePolicy> policies, int flatRate) {
        return policies.stream()
                .map(x->x.calcPremium(flatRate))
                .reduce(0.0,(x,y)->x+y);
    }

    public static double calcTotalPayments(HashMap<Integer, InsurancePolicy> policies, int flatRate)
    {
        return policies.values().stream()
                .mapToDouble(x -> x.calcPremium(flatRate))
                .sum();
    }

    public void carPriceRise(double risePercent) {
        car.priceRise(risePercent);
    }

    public static void carPriceRiseAll (ArrayList<InsurancePolicy> policies, double risePercent) {
        policies.forEach(policy -> policy.carPriceRise(risePercent));
    }

    public static void carPriceRiseAll(HashMap<Integer, InsurancePolicy> policies, double risePercent)
    {
        policies.values().forEach(policy -> policy.carPriceRise(risePercent));
    }

    public static ArrayList<InsurancePolicy> filterByCarModel (ArrayList<InsurancePolicy> policies, String carModel) {
        return (ArrayList<InsurancePolicy>)(policies.stream()
                .filter(x->x.getCarModel().contains(carModel))
                .collect(Collectors.toList()));
    }

    public static HashMap<Integer, InsurancePolicy> filterByCarModel(HashMap<Integer, InsurancePolicy> policies, String carModel)
    {
        HashMap<Integer, InsurancePolicy> filteredPolicies = new HashMap<>();
        policies.values().stream()
                .filter(policy -> (policy.car.getModel().contains(carModel)))
                .forEachOrdered(policy -> {filteredPolicies.put(policy.id, policy);
                });
        return filteredPolicies;
    }

    public static ArrayList<InsurancePolicy> filterByExpiryDate (ArrayList<InsurancePolicy> policies, MyDate date) {
        return (ArrayList<InsurancePolicy>) (policies.stream()
                .filter(x->x.getExpiryDate().isExpired(date))
                .collect(Collectors.toList()));
    }

    public static ArrayList<InsurancePolicy> filterByExpiryDate (HashMap<Integer, InsurancePolicy> policies, MyDate date)
    {
        return (ArrayList<InsurancePolicy>) policies.values().stream()
                .filter(x->x.getExpiryDate().isExpired(date))
                .collect(Collectors.toList());
    }

    public static ArrayList<InsurancePolicy> shallowCopy (ArrayList<InsurancePolicy> policies) {
        return (ArrayList<InsurancePolicy>) policies.stream()
                .collect(Collectors.toList());
    }

    public static ArrayList< InsurancePolicy> shallowCopy(HashMap<Integer, InsurancePolicy> policies) {
        return (ArrayList<InsurancePolicy>) policies.values().stream()
                .collect(Collectors.toList());
    }

    public static HashMap<Integer, InsurancePolicy> shallowCopyHashMap(HashMap< Integer, InsurancePolicy> policies)
    {
        HashMap<Integer, InsurancePolicy> shallowCopy = new HashMap<>();
        policies.values().stream()
                .forEachOrdered(policy -> {shallowCopy.put(policy.id, policy);});
        return shallowCopy;
    }

    public static ArrayList<InsurancePolicy> deepCopy(ArrayList<InsurancePolicy> policies) {
        return policies.stream()
                .map(policy -> {
                    try {
                        return (InsurancePolicy) policy.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<InsurancePolicy> deepCopy(HashMap<Integer, InsurancePolicy> policies) throws CloneNotSupportedException {
        return (ArrayList<InsurancePolicy>) policies.values().stream()
                .map(policy -> {
                    try {
                        return policy.clone();
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }

    public static HashMap<Integer, InsurancePolicy> deepCopyHashMap(HashMap<Integer, InsurancePolicy> policies) throws CloneNotSupportedException {
        HashMap<Integer, InsurancePolicy> deepCopy = new HashMap<>();
        for (InsurancePolicy policy : policies.values()) //Deep copy by using copy constructor
        {
            InsurancePolicy copyPolicy = policy.clone();
            deepCopy.put(copyPolicy.id, copyPolicy);
        }
        return deepCopy;
    }

        public int compareTo(InsurancePolicy dateCheck) {
            return expiryDate.compareTo(dateCheck.expiryDate);
    }

    public static HashMap<Integer, InsurancePolicy> load(String fileName) throws IOException
    {
        ObjectInputStream inputStream = null; //declare input object to open file
        HashMap<Integer, InsurancePolicy> output = new HashMap<>();

        // attempt to open file
        try
        {
            inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
        }
        catch (IOException ioException)
        {
            System.out.println("Error opening file.");
            System.exit(1);
        }

        // attempt to read from file and store in HashMap to return results
        try
        {
            while (true)
            {
                InsurancePolicy policy = (InsurancePolicy) inputStream.readObject();
                output.put(policy.id, policy);
            }
        }
        catch (EOFException endOfFile)
        {
            System.out.println("Policy Load Complete.\n");
        }
        catch (ClassNotFoundException classNotFound)
        {
            System.out.println("Invalid object type. Terminating.");
            System.exit(1);
        }
        catch (IOException inputOutputError)
        {
            System.out.println("Error reading from file. Terminating.");
            System.exit(1);
        }

        // close the file
        try
        {
            if (inputStream!=null)
                inputStream.close();
        }
        catch (IOException inputOutputError)
        {
            System.out.println("Error closing file. Terminating.");
            System.exit(1);
        }

        return output;
    }

    // write data from Hash Map to external file (SERIALIZATION)
    public static boolean save(HashMap<Integer, InsurancePolicy> policies, String fileName) throws IOException {
        ObjectOutputStream outputStream = null; //declare output stream to open file
        boolean value = false;

        try //open file
        {
            outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println("Error opening file. Terminating.");
            System.exit(1);
        }
        try // write to file
        {
            for (InsurancePolicy policy : policies.values()) {
                outputStream.writeObject(policy);
            }
            value = true;
        } catch (IOException e) {
            System.out.println("Error in writing to file. Terminating.");
            System.exit(1);
        }
        try
        {
            if (outputStream != null)
                outputStream.close();
        } catch (IOException inputOutputX) {
            System.out.println("Error closing file. Terminating.");
            System.exit(1);
        }
        return value;
    }

    public static HashMap<Integer, InsurancePolicy> loadTextFile(String fileName) throws IOException {
        HashMap<Integer, InsurancePolicy> output = new HashMap<>();
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        String line = input.readLine();
        while(line!=null) {
            line = line.trim();
            String[] field = line.split(",");
            switch (field[0])
            {
                case "TP":
                    String policyHolderName = field[1];
                    int id = Integer.parseInt(field[2]);
                    carType type = carType.valueOf(field[3]);
                    String model = field[4];
                    int manufacturingYear = Integer.parseInt(field[5]);
                    double price = Double.parseDouble(field[6]);
                    int numberOfClaims = Integer.parseInt(field[7]);
                    int year = Integer.parseInt(field[8]);
                    int month = Integer.parseInt(field[9]);
                    int day = Integer.parseInt(field[10]);
                    String comments = field[11];
                    Car car = new Car( model, type, manufacturingYear, price);
                    MyDate date = new MyDate(year, month, day);
                    output.put(id, new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, date, comments));
                    break;
                case "CP":
                    policyHolderName = field[1];
                    id = Integer.parseInt(field[2]);
                    type = carType.valueOf(field[3]);
                    model = field[4];
                    manufacturingYear = Integer.parseInt(field[5]);
                    price = Double.parseDouble(field[6]);
                    numberOfClaims = Integer.parseInt(field[7]);
                    year = Integer.parseInt(field[8]);
                    month = Integer.parseInt(field[9]);
                    day = Integer.parseInt(field[10]);
                    int driverAge = Integer.parseInt(field[11]);
                    int level = Integer.parseInt(field[12]);

                    car = new Car( model, type, manufacturingYear, price);
                    date = new MyDate(year, month, day);
                    output.put(id, new ComprehensivePolicy(policyHolderName, id, car, numberOfClaims, date, driverAge, level));
                    break;
            }
            line = input.readLine();
        }
        input.close();
        return output;
    }

    public static Boolean saveTextFile(HashMap<Integer, InsurancePolicy> policies, String fileName) throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter(fileName)); // create object to write data to file
        for (InsurancePolicy policy : policies.values()) // go through policies in policies hash map
        {
            output.write(policy.toDelimitedString() + "\n"); // write each policy to text file using delimited string method
        }
        output.close();
        return true;
    }

    public static ArrayList<InsurancePolicy> filterPolicies(ArrayList<InsurancePolicy> policies, Predicate<InsurancePolicy> criteria) {
        return policies.stream()
                .filter(criteria)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
















