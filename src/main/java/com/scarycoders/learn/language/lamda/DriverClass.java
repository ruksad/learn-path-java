package com.scarycoders.learn.language.lamda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DriverClass {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 35700.50));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.00));

        //How many male and female employees are there in the organization
        final Map<String, Long> groupByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Males =" + groupByGender.get("Male") + " Female =" + groupByGender.get("Female"));

        // print all the departments in the list
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        //average age of male and female
        final Map<String, Double> averageAgeGroup = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
        System.out.println(
                "Males avg age =" + averageAgeGroup.get("Male") + " Female avg age=" + averageAgeGroup.get("Female"));

        //details of highest paid employee in the org
        final Optional<Employee> employee = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Max salary employee" + employee);

        final Optional<Employee> oldestEmployee = employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)));

        System.out.println("Oldest employee " + oldestEmployee);

        // print all names of employee joined after 2015
        System.out.println("Name of all employees joined after 2015 ========= ");
        employeeList.stream().filter(x -> x.getYearOfJoining() > 2015).map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("====================================== ");

        //Count the number of employees in each department
        final Map<String, Long> departmentEmployeeCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Department employee count " + departmentEmployeeCount);

        System.out.print("Iterating the older way ==================== \n");
        final Set<Map.Entry<String, Long>> entries = departmentEmployeeCount.entrySet();
        for (Map.Entry<String, Long> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("====================================== ");

        //what is the average salary of each department

        final Map<String, Double> noOfEmployeesInDept = employeeList.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average salary of each department " + noOfEmployeesInDept);

        //get the details of youngest male employee in product development department

        final Optional<Employee> youngestPdEmployee = employeeList.stream()
                .filter(emp -> (emp.getDepartment().equals("Product Development") && emp.getGender().equals("Male")))
                .min(Comparator.comparingInt(Employee::getAge));
        System.out.println("youngest employee in product development department ============");
        youngestPdEmployee.ifPresentOrElse(System.out::println, () -> {
            System.out.println("no youngest");
        });
        System.out.println("====================================== ");

        //has the most working experience in the organization
        Optional<Employee> seniorMostEmployee = employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining));

        System.out.println("senior most employee in Org ");
        seniorMostEmployee.ifPresentOrElse(System.out::println,()->{
            System.out.println("No senior most employee");
        });
        // or you can use
        seniorMostEmployee= employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
        System.out.println("====================================== ");

        //How many male and female employees are there in the sales and marketing team?

        final Map<String, Long> sales_and_marketing = employeeList.stream()
                .filter(emp -> emp.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        final Set<Map.Entry<String, Long>> entries1 = sales_and_marketing.entrySet();
        System.out.println("Males and females in sales and marketing department ");
        for(Map.Entry<String ,Long> entry:entries1){
            System.out.println(entry.getKey() + " = "+entry.getValue());
        }

        System.out.println("====================================== ");

        //What is the average salary of male and female employees

        final Map<String, Double> averageSalByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average salary by gender ");
        System.out.println(averageSalByGender);
        System.out.println("====================================== ");

        // List down the names of all employees in each department

        final Map<String, List<String>> deptToEmployeeName = employeeList.stream().collect(Collectors
                .groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Employee name by dept");
        System.out.println(deptToEmployeeName);
        System.out.println("====================================== ");

        // What is the average salary and total salary of the whole organization

        final DoubleSummaryStatistics stats = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Total employees = "+ stats.getCount());
        System.out.println("Total salary sum = "+ stats.getSum());
        System.out.println("Total Average salary = "+ stats.getAverage());
        System.out.println("Total max salary = "+ stats.getMax());
        System.out.println("Total min salary = "+ stats.getMin());
        System.out.println("====================================== ");

        //Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.

        final Map<Boolean, List<String>> agePartitionAt25 = employeeList.stream().collect(Collectors
                .partitioningBy(emp -> emp.getAge() <= 25, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(agePartitionAt25);

        System.out.println("====================================== ");
        //Who is the oldest employee in the organization? What is his age and which department he belongs to

        employeeList.stream().max(Comparator.comparingInt(Employee::getAge))
                .ifPresentOrElse(x->{
                    System.out.println("Oldest employee name= "+x.getName());
                    System.out.println("Oldest employee department name= "+x.getDepartment());
                },()->{

                });

        employeeList.stream().filter(x-> x.getSalary() <=20000).map(x-> (x.getSalary()) + (x.getSalary()/10)).forEach(System.out::println);
    }
}
