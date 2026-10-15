public class Commission extends Hourly {
    private double totalSales;
    private double commissionRate;

    public Commission(String name, String address, String phone,
            String ssn, double rate, double commissionRate) {
        super(name, address, phone, ssn, rate);
        this.commissionRate = commissionRate;
        this.totalSales = 0;
    }

    public void addSales(double sales) {
        totalSales += sales;
    }

    @Override
    public double pay() {
        double payment = super.pay();
        payment += totalSales * commissionRate;
        totalSales = 0;
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTotal sales: " + totalSales;
    }
}