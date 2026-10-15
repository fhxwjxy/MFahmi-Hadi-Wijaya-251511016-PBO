public class Hourly extends Employee {
    private int hoursWorked;

    public Hourly(String name, String address, String phone,
            String socSecNumber, double rate) {
        super(name, address, phone, socSecNumber, rate);
        hoursWorked = 0;
    }

    public void addHours(int moreHours) {
        hoursWorked += moreHours;
    }

    @Override
    public double pay() {
        double payment = payRate * hoursWorked;
        hoursWorked = 0;
        return payment;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "\nCurrent hours: " + hoursWorked;
        return result;
    }
}