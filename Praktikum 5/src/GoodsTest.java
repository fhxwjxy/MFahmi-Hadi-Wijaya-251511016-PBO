public class GoodsTest {
    public static void main(String[] args) {
        Food food = new Food("Bread", 15000, 250);
        Toy toy = new Toy("Robot", 120000, 8);
        Book book = new Book("Java Basics", 90000, "A. Programmer");

        food.display();
        System.out.println();
        toy.display();
        System.out.println();
        book.display();
        System.out.println();

        Taxable taxableToy = toy;
        Taxable taxableBook = book;
        System.out.println("Toy tax : " + taxableToy.calculateTax());
        System.out.println("Book tax : " + taxableBook.calculateTax());
    }
}