interface Employee {
    public void showEmployeeDetails();
}

class Developer implements Employee {
    private String name;
    private long empId;
    private String position;

    public Developer(long empId, String name, String position)  {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails()   {
        System.out.println(empId+" " +name+ " " + position);
    }
}

-----------------------------------------------------------------------------------

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Manager implements Employee{
    private List<Employee> employeeList = new ArrayList<Employee>();

    private String name;
    private double salary;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("-------------");
        System.out.println("Name ="+getName());
        System.out.println("Salary ="+getSalary());
        System.out.println("-------------");

        Iterator<Employee> employeeIterator = employeeList.iterator();
        while(employeeIterator.hasNext()){
            Employee employee = employeeIterator.next();
            employee.showEmployeeDetails();
        }
    }

    public Employee getChild(int i) {
        return employeeList.get(i);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }
}

----------------------------------------------------------------------------------
public class Company {
    public static void main(String[] args) {
        Employee dev1 = new Developer(100, "Jason Fedin", "Pro Developer");
        Employee dev2 = new Developer(101, "Myra Fedin", "Entry level Developer");

        Manager engManager = new Manager("Mike", 25000);
        engManager.addEmployee(dev1);
        engManager.addEmployee(dev2);

        Employee dev3 = new Developer(102,"Tom", "Developer");

        Manager generalManager = new Manager ("Mark", 50000);
        generalManager.addEmployee(dev3);
        generalManager.addEmployee(engManager);
        generalManager.showEmployeeDetails();
    }
}
