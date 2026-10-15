public class Square extends Rectangle {
    public Square() {
        super(1.0, 1.0);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Square[side=" + getSide() + ", " + super.toString() + "]";
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    public static void main(String[] args) {
        Square s = new Square(5.0);
        System.out.println("awal : " + s);
        System.out.println("area : " + s.getArea());

        s.setWidth(8.0);
        System.out.println("sesudah setWidth(8): " + s);
        System.out.println("area : " + s.getArea());
        System.out.println("width=" + s.getWidth() + ", length=" + s.getLength());
    }

}