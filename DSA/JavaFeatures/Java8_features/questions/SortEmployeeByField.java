import java.util.*;
import java.util.stream.Collectors;

public class SortEmployeeByField {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("A", 200, "SDE"));
        emps.add(new Employee("B", 400, "SDE-I"));
        emps.add(new Employee("C", 800, "SDE-II"));
        emps.add(new Employee("D", 800, "SDE-III"));

        // List<Employee> list = emps.stream().sorted((e1, e2) -> e2.getName().compareTo(e1.getName())).toList();

    List<Employee> list2 = emps.stream().sorted(Comparator.comparing(Employee::getName)).toList();
        // System.out.println("value is " + list);
        System.out.println("value is " + list2);
        
    }
}
