package com.serhiihonchar.luxcampus;

import java.util.Random;

public class Developer extends Employee {
    private int fixedBugs;

    public Developer(long id, String name, int age, int salary, String gender, int fixedBugs) {
        super(id,name,age,salary,gender);
        this.fixedBugs = fixedBugs;
    }

    @Override
    public int fullSalaryForOneMonth() {//(ставка + fixedBugs * коэффициент) * (randomBoolean ? 2 : 0)
        return (this.salary + this.fixedBugs * 20) *
                (new Random().nextBoolean() ? 2 : 0);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", fixedBugs=" + fixedBugs +
                '}';
    }
}
