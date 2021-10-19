package com.serhiihonchar.luxcampus;

public class Designer extends Employee {
    private int rate;
    private int workedDays;

    public Designer(long id, String name, int age, int salary, String gender, int rate, int workedDays) {
        super(id, name, age, salary,gender);
        this.rate = rate;
        this.workedDays = workedDays;
    }

    @Override
    public int fullSalaryForOneMonth() {
        return this.salary + this.rate * this.workedDays;//ставка + rate * workedDays
    }

    @Override
    public String toString() {
        return "Designer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", rate=" + rate +
                ", workedDays=" + workedDays +
                '}';
    }

}
