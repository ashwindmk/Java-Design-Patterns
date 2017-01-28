package structural_design_patterns.composite_pattern;

import java.util.ArrayList;

/**
 * Created by ashwin on 24/1/17.
 */

public class CompositePattern
{
    public static void main(String[] args)
    {
        Employee techHead = new Employee("John", "Technical Head", "$30,000");

        Employee webDev = new Employee("Prat", "ROR", "$25,000");

        Employee androidDev = new Employee("Ash", "Android", "$20,000");
        Employee iosDev = new Employee("Athish", "IOS", "$20,000");

        techHead.addWebMember(webDev);
        techHead.addAppMember(androidDev);
        techHead.addAppMember(iosDev);

        System.out.println(techHead);

        ArrayList<Employee> appTeam = techHead.getAppTeam();
        for(Employee e : appTeam)
        {
            System.out.println(e);
        }

        ArrayList<Employee> webTeam = techHead.getWebTeam();
        for(Employee e : webTeam)
        {
            System.out.println(e);
        }
    }
}

class Employee
{
    private String name = "", department = "", salary = "";
    private ArrayList<Employee> webTeam;
    private ArrayList<Employee> appTeam;

    public Employee(String n, String d, String s)
    {
        name = n;
        department = d;
        salary = s;
        webTeam = new ArrayList<>();
        appTeam = new ArrayList<>();
    }

    public void addWebMember(Employee e)
    {
        webTeam.add(e);
    }

    public ArrayList<Employee> getWebTeam()
    {
        return webTeam;
    }

    public void addAppMember(Employee e)
    {
        appTeam.add(e);
    }

    public ArrayList<Employee> getAppTeam()
    {
        return appTeam;
    }

    @Override
    public String toString()
    {
        return "Name : " + name + ", department : " + department + ", salary : " + salary;
    }
}