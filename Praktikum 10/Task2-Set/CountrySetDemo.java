import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CountrySetDemo {
    public static void main(String[] args) {

        System.out.println("===== STEP 10 =====");
        HashSet<String> countries = new HashSet<>();
        countries.add("Indonesia");
        countries.add("Japan");
        countries.add("Malaysia");
        countries.add("Singapore");
        countries.add("Thailand");
        countries.add("Indonesia");

        System.out.println(countries);
        System.out.println("Jumlah elemen = " + countries.size());

        System.out.println("\n===== STEP 11 =====");
        System.out.println("contains Indonesia? "
                + countries.contains("Indonesia"));
        countries.remove("Japan");
        System.out.println(countries);
        System.out.println("Jumlah elemen = " + countries.size());

        System.out.println("\n===== STEP 12 =====");
        HashSet<String> countriesSet = new HashSet<String>();
        // Aktifkan baris berikut dan compile (lihat petunjuk di bawah):
        // Collections.sort(countriesSet);

        ArrayList<String> countriesList = new ArrayList<String>();
        countriesList.add("Japan");
        countriesList.add("Indonesia");
        countriesList.add("Malaysia");
        Collections.sort(countriesList);
        System.out.println(countriesList);

        System.out.println("\n===== STEP 13 =====");
        ArrayList<String> sortedCountries = new ArrayList<>(countries);
        Collections.sort(sortedCountries);
        System.out.println(sortedCountries);
    }
}