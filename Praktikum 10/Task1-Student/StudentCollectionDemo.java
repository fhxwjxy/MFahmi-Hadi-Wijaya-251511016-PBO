import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class StudentCollectionDemo {
        public static void main(String[] args) {

                System.out.println("===== ARRAYLIST =====");
                ArrayList<Student> students = new ArrayList<>();
                students.add(new Student("S001", "Rina",
                                "Computer Science", "Bandung"));
                students.add(new Student("S002", "Andi", 10, "Cimahi"));
                students.add(new Student("S003", "Dewi",
                                "Information Systems", "Garut"));
                students.add(new Student("S004", "Budi",
                                "Computer Science", "Bandung"));
                students.add(new Student("S005", "Citra", 20, "Sumedang"));

                System.out.println("Ukuran ArrayList = " + students.size());
                System.out.println("\nSebelum sort:");
                for (Student s : students)
                        System.out.println(s);

                Collections.sort(students, Comparator.comparing(Student::getName));

                System.out.println("\nSetelah sort by name:");
                for (Student s : students)
                        System.out.println(s);

                System.out.println("\n--- Eksperimen Step 5 ---");
                students.add(new Student("S006", "Eko", "Accounting", "Bogor"));
                System.out.println("Setelah add Eko (apakah tetap terurut?):");
                for (Student s : students)
                        System.out.println(s);

                System.out.println("\nget(0) = " + students.get(0));

                System.out.println("Size sebelum remove = " + students.size());
                students.remove(0);
                System.out.println("Size sesudah remove = " + students.size());

                System.out.println("\n===== VECTOR =====");
                Vector<Student> vector = new Vector<>();
                vector.add(new Student("V001", "Alya",
                                "Computer Science", "Bandung"));
                vector.add(new Student("V002", "Raka",
                                "Accounting", "Cimahi"));
                vector.add(new Student("V003", "Sinta",
                                "Computer Science", "Bandung"));
                vector.add(new Student("V004", "Dimas",
                                "Mechanical Engineering", "Garut"));
                vector.add(new Student("V005", "Nadia",
                                "Computer Science", "Sumedang"));

                System.out.println("Semua data Vector:");
                for (Student s : vector)
                        System.out.println(s);

                System.out.println("\nComputer Science:");
                for (Student s : vector) {
                        if (s.getDepartment() instanceof String
                                        && ((String) s.getDepartment())
                                                        .equalsIgnoreCase("Computer Science")) {
                                System.out.println(s);
                        }
                }
        }
}