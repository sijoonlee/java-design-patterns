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

class Manager implements Employee {
    private String name;
    private long empId;
    private String position;

    public Manager(long empId, String name, String position)  {
        this.empId = empId;
        this.name = name;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails()   {
        System.out.println(empId+" " +name+ " " + position);
    }
}
----------------------------------------------------------------------------------------------
import java.util.ArrayList;
import java.util.List;

class Directory implements Employee{
    private List<Employee> employeeList = new ArrayList<Employee>();

    @Override
    public void showEmployeeDetails() {
        for (Employee emp:employeeList) {
            emp.showEmployeeDetails();
        }
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }
}


------------------------------------------------------------------------------------------
public class Company {
    public static void main(String[] args) {
        Employee dev1 = new Developer(100, "Jason Fedin", "Pro Developer");
        Employee dev2 = new Developer(101, "Myra Fedin", "Entry level Developer");

        Directory engDirectory = new Directory();
        engDirectory.addEmployee(dev1);
        engDirectory.addEmployee(dev2);

        Employee man1 = new Manager(200, "Jennifer Fedin", "SEO Manager");
        Employee man2 = new Manager(201, "Ian Fedin", "Myra's Manager");

        Directory accDirectory = new Directory();
        accDirectory.addEmployee(man1);
        accDirectory.addEmployee(man2);

        Directory companyDirectory = new Directory();
        companyDirectory.addEmployee(engDirectory);
        companyDirectory.addEmployee(accDirectory);
        companyDirectory.showEmployeeDetails();
    }
}
