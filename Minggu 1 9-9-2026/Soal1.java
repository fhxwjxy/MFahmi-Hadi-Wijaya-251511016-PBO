import java.util.Scanner;
import java.math.BigInteger;

public class Soal1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah case: ");
        int t = Integer.parseInt(scanner.nextLine().trim());

        BigInteger shortMin = BigInteger.valueOf(Short.MIN_VALUE);
        BigInteger shortMax = BigInteger.valueOf(Short.MAX_VALUE);
        BigInteger intMin = BigInteger.valueOf(Integer.MIN_VALUE);
        BigInteger intMax = BigInteger.valueOf(Integer.MAX_VALUE);
        BigInteger longMin = BigInteger.valueOf(Long.MIN_VALUE);
        BigInteger longMax = BigInteger.valueOf(Long.MAX_VALUE);

        for (int i = 0; i < t; i++) {
            System.out.println();
            System.out.print("Masukkan angka ke-" + (i + 1) + ": ");
            String line = scanner.nextLine().trim();
            BigInteger n = new BigInteger(line);

            StringBuilder result = new StringBuilder();
            boolean fits = false;

            if (n.compareTo(shortMin) >= 0 && n.compareTo(shortMax) <= 0) {
                result.append("* short\n");
                fits = true;
            }
            if (n.compareTo(intMin) >= 0 && n.compareTo(intMax) <= 0) {
                result.append("* int\n");
                fits = true;
            }
            if (n.compareTo(longMin) >= 0 && n.compareTo(longMax) <= 0) {
                result.append("* long\n");
                fits = true;
            }

            if (fits) {
                System.out.println(n + " can be fitted in:");
                System.out.print(result);
            } else {
                System.out.println(n + " can't be fitted anywhere.");
            }
        }
        scanner.close();
    }
}