import java.util.*;
import java.util.stream.Collectors;

public class FlattenEmps {
    public static void main(String[] args) {
        List<List<Employee>> emps = new ArrayList<>();
        emps.add(List.of(new Employee("A", 200, "SSE", "IT"), new Employee("C", 800, "HR", "HR")));
        emps.add(List.of(new Employee("D", 200, "SSE", "IT"), new Employee("E", 800, "HR", "HR")));

        List<Employee> list = emps.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(list);
    }
}
