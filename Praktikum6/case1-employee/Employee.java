public class Employee extends StaffMember {
    protected String socialSecurityNumber;
    protected double payRate;

    public Employee(String name, String address, String phone,
            String socSecNumber, double rate) {
        super(name, address, phone);
        socialSecurityNumber = socSecNumber;
        payRate = rate;
    }

    @Override
    public String toString() {
        String result = super.toString();
        result += "\nSocial Security Number: " + socialSecurityNumber;
        return result;
    }

    @Override
    public double pay() {
        return payRate;
    }
}