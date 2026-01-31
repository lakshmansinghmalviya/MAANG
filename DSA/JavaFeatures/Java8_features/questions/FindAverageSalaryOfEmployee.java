import java.util.*;
import java.util.stream.Collectors;

public class FindAverageSalaryOfEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("A", 200, "SDE"));
        emps.add(new Employee("B", 400, "SDE-I"));
        emps.add(new Employee("C", 800, "SDE-II"));
        emps.add(new Employee("D", 800, "SDE-III"));

        double average = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary)).doubleValue();
        System.out.println("Average value is "+average);
    }
}
