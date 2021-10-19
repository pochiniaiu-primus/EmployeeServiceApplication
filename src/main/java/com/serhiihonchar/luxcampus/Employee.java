package com.serhiihonchar.luxcampus;

public abstract class Employee  {
    public long id;
    public String name;
    public int age;
    public int salary;
    public String gender;

    public Employee(long id, String name, int age, int salary, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }

    public abstract int fullSalaryForOneMonth();
}
