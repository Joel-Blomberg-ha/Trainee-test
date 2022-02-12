package trainee_test;

public class Customer {
    String Name;
    double Total;
    double Interest;
    double Years;

    public String getName() {
        return Name;
    }

    public double getTotal() {
        return Total;
    }

    public double getInterest() {
        return Interest;
    }

    public double getYears() {
        return Years;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public void setInterest(int interest) {
        Interest = interest;
    }

    public void setYears(int years) {
        Years = years;
    }
}
