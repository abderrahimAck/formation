import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class University {

    private Set<Department> departments;


    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Student> getStudentsOlderThanAge(int age)
    {
        Set<Student> students = new HashSet<>();

        departments.forEach(depart -> {
            depart.getStudents().forEach(std -> {
                if (std.getAge() > age) {
                    students.add(std);
                }
            });
        });

        return students;
    }

    public Set<Student> getStudentsOlderThanAgeUsingStream(int age)
    {
        return departments.stream().flatMap(dep -> dep.getStudents().stream())
                .filter(std -> std.getAge() > age).collect(Collectors.toSet());
    }
}

