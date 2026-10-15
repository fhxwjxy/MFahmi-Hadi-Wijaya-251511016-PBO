public class Salesperson implements Comparable {
    private String firstName, lastName;
    private int totalSales;

    public Salesperson(String first, String last, int sales) {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + ": " + totalSales;
    }

    @Override
    public boolean equals(Object other) {
        return lastName.equals(((Salesperson) other).getLastName())
                && firstName.equals(((Salesperson) other).getFirstName());
    }

    @Override
    public int compareTo(Object other) {
        Salesperson otherSales = (Salesperson) other;

        if (totalSales != otherSales.totalSales) {
            return Integer.compare(totalSales, otherSales.totalSales);
        }

        int result = lastName.compareTo(otherSales.lastName);
        if (result == 0) {
            result = firstName.compareTo(otherSales.firstName);
        }
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSales() {
        return totalSales;
    }
}