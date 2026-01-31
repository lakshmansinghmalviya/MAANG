import java.util.*;
import java.util.stream.Collectors;

public class GroupEmployeeByDepartment {

  public static void main(String[] args) {
    List<Employee> emps = new ArrayList<>();
    emps.add(new Employee("A", 200, "SSE", "IT"));
    emps.add(new Employee("B", 400, "SE", "IT"));
    emps.add(new Employee("C", 800, "HR", "HR"));
    emps.add(new Employee("D", 500, "HR", "HR"));
    emps.add(new Employee("E", 500, "BDE", "Sales"));

    Map<String, List<Employee>> list = emps.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    System.out.println(list);
  }
}