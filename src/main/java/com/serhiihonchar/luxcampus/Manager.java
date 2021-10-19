package com.serhiihonchar.luxcampus;

public class Manager extends Employee {
    public Manager(long id, String name, int age, int salary, String gender) {
        super(id, name, age, salary, gender);
    }

    @Override
    public int fullSalaryForOneMonth() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}
