import java.util.Scanner;

public class soal5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();

        int sum = A.length() + B.length();
        System.out.println(sum);

        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        String capA = Character.toUpperCase(A.charAt(0)) + A.substring(1);
        String capB = Character.toUpperCase(B.charAt(0)) + B.substring(1);
        System.out.println(capA + " " + capB);

        scanner.close();
    }
}