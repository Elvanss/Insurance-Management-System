package Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Test.TestCase.flatRate;

public class InsuranceCompany implements Cloneable, Serializable {
	private String name;
	private HashMap <Integer, User> users;
        private HashMap <Integer, InsurancePolicy> policies;
	String adminUsername;
	private String adminPassword;
	private int flatRate;
        private Connection connection = null;
        private Statement statement = null;
        private ResultSet resultSet = null;

	public InsuranceCompany (String name, String adminUsername, String adminPassword, int flatRate ) {
		this.name = name;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
		this.flatRate = flatRate;
		this.users = new HashMap <>();
                this.policies = new HashMap<>();
	}

	//	copy constructor
	public InsuranceCompany(InsuranceCompany insuranceCompany) {
		this.name = insuranceCompany.name;
		this.adminUsername = insuranceCompany.adminUsername;
		this.adminPassword = insuranceCompany.adminPassword;
		this.flatRate = insuranceCompany.flatRate;
		this.users = insuranceCompany.users;

	}

	//constructor with no parameter
	public InsuranceCompany() {
	}

	protected InsuranceCompany clone() throws CloneNotSupportedException {
		return (InsuranceCompany) super.clone();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Integer, User> getUsers() {
		return users;
	}

	public void setUsers(HashMap<Integer, User> users) {
		this.users = users;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public int getFlatRate() {
		return flatRate;
	}

	public void setFlatRate(int flatRate) {
		this.flatRate = flatRate;
	}

	public boolean validateAdmin(String username, String password) {
		if (adminUsername.equals(username) && adminPassword.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

//	public User validateUser (int userID, String password) {
//		User user=findUser(userID);
//		if ((user!= null) && user.validateUser(userID, password)) {
//			return user;
//		} else {
//			return null;
//		}
//	}

	public User validateUser(String name, String password) {
		for ( User user : this.users.values()) {
			if (user.validateUser(name, password)) {
				return user;
			}
		}
		return null;
	}

//	public User validateUser1(String name, String password) {
//
//        for (User user : users) //
//        {
//            if (user.validateUserName(name, password)) {
//                return user;
//            }
//        }
//        return null;
//    }

	public User findUser(int userID) {
		for(User user : users.values()) {
			if(user.getUserID() == userID) {
				return user;
			}
		}
		return null;
	}
	public boolean addUser(User user) {
		if(findUser(user.getUserID()) == null) {
			users.put(user.getUserID(), user);
			return true;
		} else {
			return false;
		}
	}

	public boolean addUser(String name, int userID, Address address, String password) {
		User user = new User(name, userID, address, password);
		return addUser(user);
	}



	public boolean addPolicy (int userID, InsurancePolicy policy) {
		User user = findUser(userID);
		if (user == null) {
			return false;
		}
		return user.addPolicy(policy);
	}

	public InsurancePolicy findPolicy(int userID, int policyID) {
		User user = findUser(userID);
		if(user!= null) {
			return user.findPolicy(policyID);
		}
		return null;
	}

	public void printPolicies(int userID) {
		User user = findUser(userID);
		if(user != null) {
			user.printPolicies(flatRate);
		}
	}
	//create for 5th function (Interface)
	public void userInfo(int userID) {
		User user = findUser(userID);
		if(user != null) {
			user.print();
		} else {
			System.out.println("The user is not found! Try again...");
		}
	}

	public void print() {
		System.out.println("Company name: "+name+" Username: " + adminUsername+ " Password: "+ adminPassword + " Flat Rate: "+flatRate);
		for (User user: users.values()) {
			user.printPolicies(flatRate);
		}
	}

	public String toString() {
		String printUser = "Company name: "+name+" Username: " + adminUsername+ " Password: "+ adminPassword + " Flat Rate: "+flatRate;
		for (User StringUser: users.values()) {
			printUser = printUser + StringUser.toString();
		}
		return printUser;
	}

	public boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
		User user = findUser(userID);
		if (user != null) {
			return user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
		}
		return false;
	}

	public boolean createComprehensivePolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
		User user = findUser(userID);
		if(user != null) {
			return user.createComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
		}
		return false;
	}

	public static void userPrint(User user) {
		user.print();
	}

	public double calcTotalPayments(int userID) {
		User user = findUser(userID);
		if (user != null) {
			return user.calcTotalPremium(userID);
		}
		return 0;
	}

	public double calcTotalPayments() {
		return users.values().stream()
				.mapToDouble(user -> user.calcTotalPremium(flatRate))
				.sum();
	}

	public boolean carPriceRise(int userID, double risePercent) {
		User user = findUser(userID);
		if (user != null) {
			user.carPriceRiseAll(risePercent);
			return true;
		}
		return false;
	}

	public void carPriceRise (double risePercent) {
		users.values().forEach (user ->user.carPriceRiseAll(risePercent));
	}

	public ArrayList<InsurancePolicy> allPolicies() {
		ArrayList<InsurancePolicy> policiesAll = new ArrayList();
		for(User user: users.values()) {
			for(InsurancePolicy policy: user.getPolicies().values()) {
				policiesAll.add(policy);
			}
		}
		return policiesAll;
	}

	public HashMap<Integer, InsurancePolicy> filteredByCarModel(int userID, String carModel) {
		User user = findUser(userID);
		if (user !=null) {
			return user.filterByCarModel(carModel);

		}
		return new HashMap<Integer, InsurancePolicy>();
	}

	public ArrayList<InsurancePolicy> filterByExpiryDate(int userID, MyDate date) {
		User user = findUser(userID);
		if (user != null) {
			return user.filterByExpiryDate(date);
		}
		return new ArrayList<InsurancePolicy>();
	}

	public ArrayList<InsurancePolicy> filteredByCarModel(String carModel) {
		return users.values().stream()
				.map(user -> user.filterByCarModel(carModel))
				.flatMap(policies -> policies.values().stream())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date)
	{
		ArrayList<InsurancePolicy> filterByExpiryDate = new ArrayList<InsurancePolicy>();
		for (User user : users.values())
		{
			for (InsurancePolicy policy: user.filterByExpiryDate(date))
			{
				filterByExpiryDate.add(policy);
			}
		}
		return filterByExpiryDate;
	}

	//-----Standard_Level-------
	public ArrayList<String> populateDistinctCityNames() {
		ArrayList<String> cities =new ArrayList<String>();
		for (User user:users.values()) {
			boolean cityCheck= false;
			for (String city:cities) {
				if (user.getCity().equals(city)) {
					cityCheck = true;
					break;
				}
			}
			if (!cityCheck) {
				cities.add(user.getCity());
			}
		}
		return cities;
	}

	public double getTotalPaymentForCity(String city) {
		double totalForCity =0;
		for (User user: users.values()) {
			if (user.getCity().equals(city)) {
				totalForCity = totalForCity + user.calcTotalPremium(flatRate);
			}
		}
		return totalForCity;
	}

	public ArrayList<Double> getTotalPaymentPerCity(ArrayList<String> cities) {
		ArrayList <Double> cityPayment = new ArrayList<Double>();
		for (String city: cities) {
			cityPayment.add(getTotalPaymentForCity(city));
		}
		return cityPayment;
	}

	public void reportPaymentPerCity( ArrayList<String> cities, ArrayList<Double> payments) {
		System.out.println("City Name     " + "     Total Premium Payment");
		for (int i =0; i<cities.size(); i++){
			System.out.printf("%10s %30s \n",cities.get(i), payments.get(i));
		}
	}

	public ArrayList<String> populateDistinctCarModels() {
		ArrayList<String> Models = new ArrayList<String>();
		for (User user : users.values()) {
			ArrayList<String> carModel = user.populateDistinctCarModels();
			for (String carCategory : carModel) {
				boolean modelCheck = false;
				for (String model : Models) {
					if (model.equals(carCategory)) {
						modelCheck = true;
						break;
					}
				}
				if (!modelCheck) {
					Models.add(carCategory);
				}
			}
		}
		return Models;
	}

	public ArrayList<Integer> getTotalCountPerCarModel (ArrayList<String> carModels) {
		ArrayList<Integer> totalCounts=new ArrayList<Integer>();
		int amount=0; //set the amount = 0;
		for (String model:carModels) {
			for (User user:users.values()) {
				amount = amount + user.getTotalCountForCarModel(model);
			}
			totalCounts.add(amount);
		}
		return totalCounts;
	}

	public ArrayList<Double> getTotalPaymentPerCarModel (ArrayList<String> carModels) {
		ArrayList<Double> total=new ArrayList<Double>();
		double countPay = 0;

		for (String model:carModels) {
			total.add((double)0);
		}
		for (User user:users.values()) {
			ArrayList<Double> TotalPayment=user.getTotalPaymentPerCarModel(carModels,flatRate);
			for(int i=0; i<TotalPayment.size(); i++) {
				total.set(i, total.get(i) + TotalPayment.get(i));
			}
		}
		return total;
	}

	public void reportPaymentsPerCarModel (ArrayList<String> carModels, ArrayList<Integer>counts, ArrayList<Double> payments) {
		System.out.println("Model" +"      "+ "Payments" +"     "+ "Payment");
		for (int i=0;i<counts.size();i++)
			System.out.println(carModels.get(i) +"     "+ payments.get(i) +"      "+ (double)(payments.get(i)/counts.get(i)));
	}

	public ArrayList<User> deepCopyUser() throws CloneNotSupportedException {
		return User.deepCopy(users);
	}

//	public ArrayList<User> shallowCopyUser() {
//		return User.shallowCopy(users);
//		}

	public HashMap<Integer, User> shallowCopyUser(){
		HashMap<Integer, User> shallowCopy = users;
		return shallowCopy;
	}

	/*public HashMap<String, Double> getTotalPremiumPerCity() {
		HashMap<String, Double> cityTotal = new HashMap<>();
		for (User user : users) {
			Double cityPr = cityTotal.get(user.getCity());
			if (cityPr != null) {
				cityTotal.put(user.getCity(), cityPr.doubleValue() + user.calcTotalPremium(flatRate));
			} else {
				cityTotal.put(user.getCity(), user.calcTotalPremium(flatRate));
			}
		}
		return cityTotal;
	}

	public HashMap<String, Integer> getTotalCountPerCarModel() {
		HashMap<String, Integer> allCarModels = new HashMap<>(); //for insuranceCompany
		for (User user : users) {
			HashMap<String, Integer> userCarModels = user.getTotalCountPerCarModel(); //for each user
			for (String modelName : userCarModels.keySet()) {
				if (allCarModels.get(modelName) == null) {
					allCarModels.put(modelName, userCarModels.get(modelName)); //add key and value into allCarModels
				} else {
					allCarModels.put(modelName, allCarModels.get(modelName) + userCarModels.get(modelName)); //add
				}
			}
		}

		return allCarModels;
	}

	public HashMap<String, Double> getTotalPremiumCarModel() {
		HashMap<String, Double> allCarPremiums = new HashMap<>(); //for insuranceCompany
		for (User user : users) {
			Map<String, Double> userCarPremiums = user.getTotalPremiumPerCarModel(); //for each user
			for (String modelName : userCarPremiums.keySet()) {
				if (allCarPremiums.get(modelName) == null) {
					allCarPremiums.put(modelName, userCarPremiums.get(modelName)); //add key and value into allCarModels
				} else {
					allCarPremiums.put(modelName, userCarPremiums.get(modelName) + userCarPremiums.get(modelName)); //add
				}
			}
		}
		return allCarPremiums;
	} */

	public Map<String, Double> getTotalPremiumPerCity() {
		return users.values().stream()
				.collect(Collectors.groupingBy(User::getCity,
						Collectors.reducing(0.0, user -> user.calcTotalPremium(flatRate), Double::sum)));
	}

	public HashMap<String, Integer> getTotalCountPerCarModel() {
		HashMap<String, Integer> allCarModels = new HashMap<>();
		users.values().stream()
				.map(User::getTotalCountPerCarModel)
				.forEach(userCarModels -> userCarModels.forEach((modelName, count) ->
						allCarModels.merge(modelName, count, Integer::sum))); //merging two hashmaps
		return allCarModels;
	}

	public HashMap<String, Double> getTotalPremiumCarModel() {
		HashMap<String, Double> allCarPremiums = new HashMap();
		users.values().stream()
				.map(User::getTotalPremiumPerCarModel)
				.forEach(userCarPremiums -> userCarPremiums.forEach((modelName, count) ->
						allCarPremiums.merge(modelName, count, Double::sum)));
		return allCarPremiums;
	}

	public String companyReport1(Map<String, Double> totalPremiumForCity) {
		StringBuilder report = new StringBuilder();
		report.append("\n----------------------------");
		report.append(String.format("\n| %-20s | $%-20s ", "City Name", "Total Premium Payment"));
		report.append("\n----------------------------");
		for (String cityName : totalPremiumForCity.keySet()) {
			report.append(String.format("\n| %-20s | $%-20s ", cityName, totalPremiumForCity.get(cityName)));
		}
		report.append("\n----------------------------");
		return report.toString();
	}

	public String companyReport2(HashMap<String, Double> totalUserPremium, HashMap<String, Integer> count) {
		StringBuilder report = new StringBuilder();
		report.append("\n----------------------------");
		report.append(String.format("\n| %-20s | $%-20s | $%-20s |", "Car Model", "Total Premium Payment", "Average Premium Payment"));
		report.append("\n----------------------------");
		for (String carTotal : totalUserPremium.keySet()) {
			report.append(String.format("\n| %-20s | $%-20s | $%-20s |", carTotal, totalUserPremium.get(carTotal), totalUserPremium.get(carTotal) / (count.get(carTotal))));
		}
		report.append("\n----------------------------");
		return report.toString();
	}


	public boolean load(String fileName) {
		ObjectInputStream inputStream = null;
		boolean value = false;
		try {
			inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
		}
		catch (IOException e) {
			System.out.println("Error opening file. Terminating.");
			return false;
		}
		try {
			InsuranceCompany insuranceCompany = (InsuranceCompany)inputStream.readObject();
			name = insuranceCompany.name;
			adminUsername = insuranceCompany.adminUsername;
			adminPassword = insuranceCompany.adminPassword;
			flatRate = insuranceCompany.flatRate;
			users = insuranceCompany.users;
		}
		catch (IOException e) {
			System.out.println("Error reading from file. Terminating.");
			return false;
		}
		catch (ClassNotFoundException e) {
			System.out.println("Error, class not found. Terminating.");
			return false;
		}
		try {
			inputStream.close();
			value = true;
		}
		catch (IOException e) {
			System.out.println("Error closing file. Terminating.");
			return false;
		}
		return value;
	}

	public boolean save(String fileName) {
		ObjectOutputStream output = null;
		boolean value = false;
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
		} catch (IOException e) {
			System.out.println("Error in opening file!");
			return false;
		}
		try {
			output.writeObject(this);
			value = true;
		} catch (IOException e) {
			System.out.println("Error in writing to file!");
			return false;
		}
		try {
			output.close();
		}
		catch (IOException e) {
			System.err.println("Error closing file. Terminating.");
			return false;
		}
		return value;
	}

	public String toDelimitedString() {
		String output = name + "," + adminUsername + "," + adminPassword + "," + flatRate;
		for (User user : users.values()) {
			output += "\n" + user.toDelimitedString() + ",";
		}
		return output;
	}

	public boolean saveTextFile(String fileName) throws IOException {
		BufferedWriter output = new BufferedWriter(new FileWriter(fileName));
		output.write(toDelimitedString() + "\n");
		output.close();
		return true;
	}

	public boolean loadTextFile(String fileName) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(fileName));

		String line = input.readLine();
		line = line.trim();
		String[] field = line.split(",");
		this.name = field[0];
		this.adminUsername = field[1];
		this.adminPassword = field[2];
		this.flatRate = Integer.parseInt(field[3]);

		this.users = new HashMap<>(); // create hash map to store loaded users

		line = input.readLine();
		while (line!=null)
		{
			line = line.trim();
			field = line.split(",");
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

			users.put(userID, user); // add user to insurance company

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

					user.addPolicy(username, password, new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, date, comments));
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
					user.addPolicy(username, password, new ComprehensivePolicy(policyHolderName, id, car, numberOfClaims, date, driverAge, level));
					index+=13;
				}
			}
			line = input.readLine();
		}
		input.close();
		return true;
	}

	public ArrayList<User> sortUsers()
	{
		ArrayList<User> output = new ArrayList<>();
		//convert hash map to array list for sorting
		for (User user : users.values())
		{
			output.add(user);
		}
		Collections.sort(output);

		return output;
	}


	// STANDARD LEVEL (A2)
	public ArrayList<User> sortUsersByPremium()
	{
		ArrayList<User> output = new ArrayList<>();

		//sort HashMap to array
		for (User user : users.values())
		{
			output.add(user);
		}
		// use comparator to sort by premium
		Collections.sort(output, new UserComparator());
		return output;
	}

	public HashMap<String, ArrayList<User>> getUsersPerCity() {
		HashMap<String, ArrayList<User>> output = new HashMap<>();
		for (User user : users.values()) {
			String city = user.getAddress().getCity();
			if (!output.containsKey(city)) {
				output.put(city, new ArrayList<>());
				output.get(city).add(user);
			} else {
				output.get(city).add(user);
			}
		}
		return output;
	}

	public HashMap<String, ArrayList<InsurancePolicy>> filterPoliciesByExpiryDate(MyDate expiryDate) {
		HashMap<String, ArrayList<InsurancePolicy>> filteredPolicies = new HashMap<>();
		HashMap<Integer, InsurancePolicy> policies =new HashMap<>();
		for (InsurancePolicy policy : policies.values()) {
			if (policy.getExpiryDate().compareTo(expiryDate) <= 0) {
				String policyHolderName = policy.getPolicyHolderName();
				if (!filteredPolicies.containsKey(policyHolderName)) {
					filteredPolicies.put(policyHolderName, new ArrayList<>());
				}
				filteredPolicies.get(policyHolderName).add(policy);
			}
		}
		return filteredPolicies;
	}

	public static class UserComparator implements Comparator<User> {
		@Override
		public int compare(User user1, User user2) {
			int flatRate = 100;
			double thisTotal = user1.calcTotalPremium(flatRate);
			double thatTotal = user2.calcTotalPremium(flatRate);
			if (thisTotal==thatTotal)
				return 0;
			if (thisTotal > thatTotal)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}

	}


	public boolean addPolicy(String adminUsername, String adminPassword, int userID, InsurancePolicy policies) {
		User user=null;
		if (validateAdmin(adminUsername, adminPassword))
		{
			user = users.get(userID);
			if (user==null)
			{
				System.out.println("Failed to add policy, user does not exist!");
				return false;
			}
			HashMap<Integer, InsurancePolicy> userPolicies = user.getPolicies();
			if (userPolicies.get(policies.id)!=null)
			{
				System.out.println("Failed to add policy, duplicate policy ID!");
				return false;
			}
		}
		return user.addPolicy(user.getName(), user.getPassword(), policies);
	}

	public double calcTotalPayment(String adminUsername, String adminPassword, int userID) {
		User userObj = findUser(userID);
		if (userObj == null) {
			return 0;
		}
		return userObj.calcTotalPayment(adminUsername, adminPassword);
	}
        
        public InsurancePolicy findPolicy (String adminName, String adminPassword, int userID ,int policyID){
        User user = users.get(userID);
        if (user==null)
        {
            return null;
        }
        
        return user.getPolicies(user.getName(), user.getPassword()).get(policyID);
    }

	// ASSIGNMENT 2_ADVANCED
	public int[] policyCount(String adminUsername, String adminPassword, int[] ranges) {
    if (!validateAdmin(adminUsername, adminPassword)) {
        System.out.println("Invalid Admin");
        return null;
    }
    int[] counts = new int[ranges.length];
    users.values().stream()
            .flatMap(user -> user.getPolicies().values().stream())
            .forEach(policy -> {
                int premium = (int) policy.calcPremium(30);
                for (int i = 0; i < ranges.length; i++) {
                    if (premium > ranges[i]) {
                        counts[i]++;
                    }
                }
            });
    return counts;
}

	public HashMap<String, Integer[]> policyCityCount(String adminUsername, String adminPassword, int[] ranges) {
		// Validate the admin username and password
		if (!validateAdmin(adminUsername, adminPassword)) {
			System.out.println("Invalid Admin");
			return null;
		}

		HashMap<String, Integer[]> counts = new HashMap<>();

		// Iterate through the users and their policies, counting the number of policies in each city within the given range
		for (User user : users.values()) {
			String city = user.getAddress().getCity();
			for (InsurancePolicy policy : user.getPolicies().values()) {
				int premium = (int) policy.calcPremium(30);
				if (premium > ranges[0] && premium < ranges[1]) {
					if (counts.containsKey(city)) {
						counts.put(city, new Integer[] { counts.get(city)[0] + 1 });
					} else {
						counts.put(city, new Integer[] { 1 });
					}
				}
			}
		}

		return counts;
	}

	public int[] userCount(String adminUsername, String adminPassword, int[] ranges) {
            if (!validateAdmin(adminUsername, adminPassword)) {
                System.out.println("Invalid Admin");
                return null;
        }
            int[] counts = new int[ranges.length];
        users.values().stream()
            .filter(user -> user.getPolicies().values().stream().anyMatch(policy -> (int) policy.calcPremium(30) > ranges[0]))
            .forEach(user -> counts[0]++);
    return counts;
}


	public Map<String, Integer[]> userCarModelCount(String adminUsername, String adminPassword, int[] ranges) {
            if (!validateAdmin(adminUsername, adminPassword)) {
        System.out.println("Invalid Admin");
        return null;
        }
            Map<String, Integer[]> counts = new HashMap<>();
                users.values().stream()
                    .forEach(user -> counts.put(user.getName(), new Integer[] {(int) user.getPolicies().values().stream()
                        .filter(policy -> (int) policy.calcPremium(30) > ranges[0] && (int) policy.calcPremium(30) < ranges[1])
                        .count()}));
            return counts;
        }


	public HashMap<String, Integer[]> policyCarModelCount(String adminName, String adminPassword, int[] ranges)
	{
		HashMap<String, Integer[]> output = new HashMap<>();
		if (validateAdmin(adminName, adminPassword))
		{
			for (User user : users.values())
			{
				HashMap<String, Integer[]> userPolicyCarCount = user.policyCarModelCount(user.getName(), user.getPassword(), ranges);
				for (String car : userPolicyCarCount.keySet())
				{
					if (output.containsKey(car))
					{
						for (int i = 0 ; i < userPolicyCarCount.get(car).length ; i++)
						{
							output.get(car)[i] += userPolicyCarCount.get(car)[i];
						}
					}
					else
					{
						output.put(car, userPolicyCarCount.get(car));
					}
				}
			}
		}
		return output;
	}
        
        public void saveDatabase() {
           try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Problem in saving Access ");
            e.printStackTrace();
        }
            try {
                String dataUrl = "jdbc:ucanaccess://CarInsurance.accdb";
                connection = DriverManager.getConnection(dataUrl);
                statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM User");
                statement.executeUpdate("DELETE FROM InsurancePolicy");
                
                for (User user: users.values()) {
                    String query = "INSERT INTO User (Name, userID, Address, password) VALUES('"+user.getName()+"','"+user.getUserID()+"', '"+user.getAddress()+"','"+user.getPassword()+"')";
                    statement = connection.createStatement();
                    statement.executeUpdate(query);
                }             
                for (User user: users.values()) {
                    for (InsurancePolicy policy: policies.values())  {
                        String query = "INSERT INTO InsurancePolicy (userID, policyHolderName, policyID, numberOfClaims) VALUES('"+user.getUserID()+"','"+policy.getPolicyHolderName()+"','"+policy.getId()+"','"+policy.getNumberOfClaims()+"')";
                        statement = connection.createStatement();
                        statement.executeUpdate(query);
                    }   
                }
            }
            catch(SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection !=null) {
                    try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
                    try { if (statement != null) statement.close(); } catch (Exception e) {};
                    try { if (connection != null) connection.close(); } catch (Exception e) {}
                }
            }
            System.out.println("Data was saved by database!");
        }
        
    public void loadDatabase() {
         try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Problem in loading Access ");
            e.printStackTrace();
        }
         try {
         String dataUrl = "jdbc:ucanaccess://UniversityDatabase.accdb" ;
            connection = DriverManager.getConnection(dataUrl);
            statement = connection.createStatement();
            users.clear();
            policies.clear();
            
            resultSet = statement.executeQuery("SELECT * FROM User");
             while(resultSet.next())
            {
                String name = resultSet.getString(1);
                int userID = resultSet.getInt(2);
                int streetNum = resultSet.getInt(3);
                String street = resultSet.getString(4);
                String suburb = resultSet.getString(5);
                String city = resultSet.getString(6);
                String password = resultSet.getString(7);
                
                Address newAdd = new Address(streetNum, street, suburb, city);
                try 
                {
                    User userNew = new User( name, userID, newAdd, password);
                    this.addUser( userNew);
//                    if(this.addSubject(adminUsername, adminPassword, subject))
//                    {
//                        System.out.println(subject);
//                    } else System.out.println("error") ;
                } catch (Exception ex) 
                {
                    Logger.getLogger(InsuranceCompany.class.getName()).log(Level.SEVERE, null, ex);
                }     
            }
            
//-------------------------------------------------------------------------------------------  
//userID, policyHolderName, policyID, numberOfClaims
            resultSet = statement.executeQuery("SELECT * FROM InsurancePolicy");
             while(resultSet.next())
            {   
                int userID = resultSet.getInt(1);
                String policyHolderName = resultSet.getString(2);
                int policyID = resultSet.getInt(3);
                int numberOfClaims = resultSet.getInt(4);
                try 
                {
                    InsurancePolicy policyData = new InsurancePolicy (policyHolderName, policyID, numberOfClaims) {
                        @Override
                        public double calcPremium(int flatRate) {
                            throw new UnsupportedOperationException("Not supported yet."); 
                        }
                    };
                    this.addPolicy( userID,policyData);
                    if(this.addPolicy(userID, policyData))
                    {
                        System.out.println(policyData);
                    } else System.out.println("error") ;
                } catch (Exception ex) 
                {
                    Logger.getLogger(InsuranceCompany.class.getName()).log(Level.SEVERE, null, ex);
                }     
            }

         } catch (SQLException e) {
             e.printStackTrace();
         } 
         if(connection != null) {
             try { if (resultSet != null) resultSet.close(); } catch (Exception e) {};
             try { if (statement != null) statement.close(); } catch (Exception e) {};
             try { if (connection != null) connection.close(); } catch (Exception e) {}
         }
        System.out.println("Data was Loaded from database");
    }    
}


