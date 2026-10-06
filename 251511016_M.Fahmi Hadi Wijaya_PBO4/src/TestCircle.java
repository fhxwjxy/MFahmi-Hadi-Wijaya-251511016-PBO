public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(2.5);

        System.out.println("c1");
        System.out.println("radius = " + c1.getRadius());
        System.out.println("area   = " + c1.getArea());
        System.out.println(c1);
        System.out.println();

        System.out.println("c2");
        System.out.println("radius = " + c2.getRadius());
        System.out.println("area   = " + c2.getArea());
        System.out.println(c2);
    }
}
