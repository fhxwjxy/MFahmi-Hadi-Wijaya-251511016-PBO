public class Toy extends Goods implements Taxable {
    private int minimumAge;

    public Toy(String description, double price, int minimumAge) {
        super(description, price);
        this.minimumAge = minimumAge;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Minimum age : " + minimumAge);
        System.out.println("Tax : " + calculateTax());
    }

    public static void main(String[] args) {
        Toy toy = new Toy("Robot", 120000, 8);
        toy.display();

        System.out.println();
        System.out.println("Minimum age (getter) : " + toy.getMinimumAge());
        System.out.println("Tax (calculateTax)   : " + toy.calculateTax());

        Taxable t = toy;
        System.out.println("Tax via Taxable      : " + t.calculateTax());
    }
}