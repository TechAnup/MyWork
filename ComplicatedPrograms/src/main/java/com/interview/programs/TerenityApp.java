package com.interview.programs;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.*;

// Find the largest common substring
public class TerenityApp {
    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(new Employee(25, "B", "B"));
        emp.add(new Employee(30, "A", "A"));
        emp.add(new Employee(28, "D", "D"));
        emp.add(new Employee(23, "C", "F"));
        emp.add(new Employee(35, "E", "C"));

        // using method reference
        emp.stream().filter(e -> e.getAge() > 20).sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName))
                .forEach(System.out::println);
    }
}

// Employee class
class Employee {
    int age;
    String firstName;
    String lastName;

    public Employee(int age, String firstName, String lastName) {
        super();
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee [age=" + age + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}