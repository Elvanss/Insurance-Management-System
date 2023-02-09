package Test;



public class ComprehensivePolicy extends InsurancePolicy {
    int driverAge;
    int level;

    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
        super(policyHolderName, id, car, numberOfClaims, expiryDate);
        this.driverAge = driverAge;
        this.level = level;
    }
    
  //copy constructor
    public ComprehensivePolicy(InsurancePolicy insurancePolicy) {
        super(insurancePolicy);
        this.driverAge = driverAge;
        this.level = level;
    }
    
    public int getDriverAge()
    {
        return driverAge;
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public void setDriverAge(int age)
    {
        this.driverAge = age;
    }
    
    public void setLevel(int level)
    {
        this.level = level;
    }

    public void print(){
        super.print();
        System.out.println("Driver Age : "+this.driverAge);
        System.out.println("Level : "+this.level);
    }

    public String toString() {
        return super.toString() + " |Driver Age: " + this.driverAge + " |Level: " + level;
    }

    public double calcPremium(int flatRate){
        double cost = car.price/50+numberOfClaims*200+flatRate;
        if (driverAge < 30){
            cost = cost + (30 - driverAge)*50;
        }
        return cost;
    }

    public String toDelimitedString() {
        return "CP" + "," + policyHolderName + "," + id + "," + car.toDelimitedString() + "," + numberOfClaims + "," + expiryDate.toDelimitedString() + "," + driverAge + "," + level;
    }
}


