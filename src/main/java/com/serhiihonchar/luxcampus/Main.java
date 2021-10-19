package com.serhiihonchar.luxcampus;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();
        EmployeeService employeeService = new EmployeeService(employeeFactory.generateEmployees(10));

        System.out.println("*****void printEmployees()*****");
        employeeService.printEmployees();
        System.out.println();
        System.out.println("=======================================");

        System.out.println("*****double calculateSalaryAndBonus()*****");
        System.out.println(employeeService.calculateSalaryAndBonus());
        System.out.println("=======================================");

        System.out.println("*****Employee getById(long)*****");
        System.out.println(employeeService.getById(1));
        System.out.println("=======================================");

        System.out.println("*****Employee[] getByName(String)*****");
        Employee[] employeeByName = employeeService.getByName("Serhii");
        System.out.println(Arrays.toString(employeeByName));
        System.out.println("=======================================");

        System.out.println("*****Employee[] sortByName()*****");
        Employee[] sortByName = employeeService.sortByName();
        System.out.println(Arrays.toString(sortByName));
        System.out.println("=======================================");

        System.out.println("*****Employee[] sortByNameAndSalary()*****");
        Employee[] sortByNameAndSalary = employeeService.sortByNameAndSalary();
        System.out.println(Arrays.toString(sortByNameAndSalary));
        System.out.println("=======================================");

        System.out.println("*****Employee edit(Employee)*****");
        Employee employeeNew = new Manager(1, "Ibrahim", 21, 3000, "Male");
        employeeService.edit(employeeNew);
        employeeService.printEmployees();
        System.out.println("=======================================");

        System.out.println("*****Employee remove(long id)*****");
        System.out.println("removed employee: " + employeeService.remove(1));
        System.out.println("***************************************");
        System.out.println("employees after removing: ");
        employeeService.printEmployees();
        System.out.println("=======================================");

        System.out.println("*****void add(Employee)*****");
        Developer dev = new Developer(3, "Serhii Honchar", 27, 550, "Male", 100);
        employeeService.add(dev);
        employeeService.printEmployees();
        System.out.println();
    }
}
