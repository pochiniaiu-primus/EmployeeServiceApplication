package com.serhiihonchar.luxcampus;

import java.util.Random;

public class EmployeeFactory {
    int number;

    Employee[] generateEmployees(int size) {
        this.number = size;
        Employee[] employees = new Employee[size];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }
        return employees;
    }

    String gender = generateGender();

    public String generateGender() {
        String[] genders = {"Male", "Female"};
        Random random = new Random();
        int index = random.nextInt(2);
        return genders[index];
    }

    public String generateName(String gender) {
        String[] manNames = {"Serhii", "Petr", "Tolik", "Ivan", "Kolya", "Andrii", "Roman"};
        String[] womanNames = {"Sveta", "Anya", "Mariya", "Lisa", "Daryna", "Katya", "Vika"};
        Random random = new Random();
        int index = random.nextInt(7);
        String name = "";
        if (gender.equals("Male")) {
            name = manNames[index];
        } else {
            name = womanNames[index];
        }
        return name;
    }

    Employee generateEmployee() {
        int random = (new Random()).nextInt(3);
        switch (random) {
            case 0:
                return new Developer(generateId(), generateName(gender), generateAge(), generateSalary(), gender, generateFixedBugs());
            case 1:
                return new Manager(generateId(), generateName(gender), generateAge(), generateSalary(), gender);
            case 2:
                return new Designer(generateId(), generateName(gender), generateAge(), generateSalary(), gender, generateRate(), generateWorkedDays());
        }
        return null;
    }

    static private long id = 1;

    long generateId() {
        return id++;
    }

    int generateAge() {
        return new Random().nextInt(30) + 18;
    }

    int generateSalary() {
        return new Random().nextInt(1000) + 200;
    }

    int generateFixedBugs() {
        return new Random().nextInt(10) + 10;
    }

    int generateRate() {
        return new Random().nextInt(100) + 1;
    }

    int generateWorkedDays() {
        return new Random().nextInt(22) + 22;
    }
}