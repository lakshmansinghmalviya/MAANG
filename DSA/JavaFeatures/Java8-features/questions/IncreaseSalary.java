
import java.util.*;
import java.util.stream.Collectors;

//Increase the salary by 10% of the employee which is taking the salary less than 50k and whose 
// name start with s
// using the java 8 
class Employee {

    private String name;
    private Integer salary;
    private String designation;

    public Employee(String name, Integer salary, String designation) {
        this.designation = designation;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}

public class IncreaseSalary {

    public static void main(String[] a) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Sumit", 40000, "Software Engineer"));
        list.add(new Employee("Sam", 30000, "Software Engineer"));
        list.add(new Employee("Saloni", 60000, "Doctor"));
        list.add(new Employee("Lakshman", 50000, "Software Developer"));
        list.add(new Employee("Jyoti", 90000, "Senior Software Engineer"));

      List<Employee> employeesWithHike=  list.stream().filter((emp) -> {
            if (emp.getSalary() < 50000 && emp.getName().startsWith("S")) {
                return true; 
            }else {
                return false;
            }
        }).map((emp) -> {
            Integer increment = emp.getSalary() + ((emp.getSalary() * 10) / 100);
            emp.setSalary(increment);
            return emp;
        }).collect(Collectors.toList());

        employeesWithHike.stream().forEach(emp->{
            System.out.println(emp.getSalary()+"  "+emp.getName());
        });
    }
}
