import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestMain {
    public static void main(String[] args) {

        // Prepare data
        University u = new University();
        Set<Department> departs = new HashSet<>();

        for (int i = 0; i <2 ; i++) {
            departs.add(new Department());
        }
        u.setDepartments(departs);

        u.getDepartments().forEach(department -> {
            Set<Student> stds = new HashSet<>();
            for (int i = 0; i < 5; i++) {
                int age = new Random().nextInt(10) + 15;
                stds.add(new Student(age));
            }
            department.setStudents(stds);
        });

        // Get nbr of students older than 18yo
        System.out.println(u.getStudentsOlderThanAge(18).size());
        System.out.println(u.getStudentsOlderThanAgeUsingStream(18).size());
    }
}

