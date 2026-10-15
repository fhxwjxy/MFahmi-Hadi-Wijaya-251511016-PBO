public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        height = 1.0;
    }

    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        System.out.println("Cylinder(double, double) dipanggil");
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * height + 2 * Math.PI * getRadius() * getRadius();
    }

    @Override
    public String toString() {
        return "Cylinder: subclass of " + super.toString() + ", height=" + height;
    }

    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println(c1);

        Cylinder c2 = new Cylinder(2.0, 3.0);
        System.out.println(c2);
    }
}
