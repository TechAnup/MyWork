package com.interview.programs.java8;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StreamAPIWIthEmployee {
    private static List<Employee> emploees = Arrays.asList(
            new Employee(1, "Anup", 30, 180000000, "IT"),
            new Employee(2, "Deepa", 25, 11000000, "HR"),
            new Employee(3, "Adi", 1, 10000, "RD"),
            new Employee(4, "Varsha", 30, 100000, "IT"),
            new Employee(5, "Vaishali", 25, 100, "HR")
    );

    public static void main(String[] args) {

        // employee details working in each department.
        employeeDetailsWorkingInEachDepartment(emploees);

        // count of employees department wise
        departmentWiseCountOfEmployees(emploees);

        // find max and min salary
        findMaxSalary(emploees);
    }

    private static void findMaxSalary(final List<Employee> list) {
        System.out.println("Max Salary: " + list.stream().max(Comparator.comparing(Employee::getSalary)));
        System.out.println("Min Salary: " + list.stream().min(Comparator.comparing(Employee::getSalary)));


        System.out.println(list.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.reducing(
                        BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))))));
    }

    private static void employeeDetailsWorkingInEachDepartment(List<Employee> listOfEmployees) {
        Map<Integer, List<Employee>> ageWiseEmployees = listOfEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.toList()));
        ageWiseEmployees.entrySet().forEach(e -> System.out.println(e.getKey() + "---" + e.getValue()));
    }

    private static void departmentWiseCountOfEmployees(List<Employee> listOfEmployees) {
        Map<String, Long> ageWiseEmployees = listOfEmployees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        ageWiseEmployees.entrySet().forEach(e -> System.out.println(e.getKey() + "---" + e.getValue()));
    }
}


class Employee {
    private int employeeId;
    private String name;
    private int age;
    private double salary;
    private String department;

    public String getDepartment() {
        return department;
    }

    public Employee(int employeeId, String name, int age, double salary, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * get field
     *
     * @return employeeId
     */
    public int getEmployeeId() {
        return this.employeeId;
    }

    /**
     * set field
     *
     * @param employeeId
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * get field
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set field
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get field
     *
     * @return age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * set field
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * get field
     *
     * @return salary
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * set field
     *
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

}
