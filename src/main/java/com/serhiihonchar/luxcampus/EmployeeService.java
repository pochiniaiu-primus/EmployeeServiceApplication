package com.serhiihonchar.luxcampus;

public class EmployeeService {
    Employee[] employees;

    public EmployeeService(Employee[] employees) {
        this.employees = employees;
    }

    void printEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    double calculateSalaryAndBonus() {
        int sumSalaryAndBonus = 0;
        for (Employee employee : employees) {
            sumSalaryAndBonus += employee.fullSalaryForOneMonth();
        }
        return sumSalaryAndBonus;
    }

    Employee getById(long id) {
        for (Employee employee : employees) {
            if (employee.id == id) return employee;
        }
        return null;
    }

    Employee[] getByName(String name) {
        Employee[] newArrayWithEmployees =
                new Employee[employees.length];
        int count = 0;
        for (Employee employee : employees) {
            if (employee.name.equals(name)) newArrayWithEmployees[count] = employee;
            count++;
        }
        Employee[] resultArray = new Employee[count];

        for (int i = 0; i < count; i++) {
            resultArray[i] = newArrayWithEmployees[i];
        }
        return resultArray;
    }

    Employee[] sortByName() {
        Employee[] emp = this.employees.clone();

        for (int i = 0; i < emp.length; i++) {
            for (int j = 0; j < emp.length; j++) {
                Employee temp = emp[i];
                if (temp.name.compareTo(emp[j].name) < 0) {
                    emp[i] = emp[j];
                    emp[j] = temp;
                }
            }
        }
        System.out.println();
        return emp;
    }

    public Employee[] sortByNameAndSalary() {
        EmployeeService empService = new EmployeeService(employees);
        Employee[] employee = empService.sortByName();
        Employee temp;
        boolean counter = true;
        while (counter) {
            counter = false;
            for (int i = 0; i < employee.length - 1; i++) {
                if (employee[i].name.equals(employee[i + 1].name) && employee[i].salary > employee[i + 1].salary) {
                    counter = true;
                    temp = employee[i];
                    employee[i] = employee[i + 1];
                    employee[i + 1] = temp;
                }
            }
        }
        return employee;
    }


    Employee edit(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].id == newEmployee.id) {
                Employee temp = employees[i];
                employees[i] = newEmployee;
                return temp;
            }
        }
        return null;
    }

    Employee remove(long id) {
        int indexToRemove = -1;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee.id == id) {
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove == -1) {
            return null;
        }
        //[emp1, emp2, emp3, emp4, emp5] remove(id=3)
        //[emp1, emp2, emp4, emp5]
        Employee[] newEmployeesArray = new Employee[employees.length - 1];
        int newArrayCounter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (i != indexToRemove) {
                newEmployeesArray[newArrayCounter] = employees[i];
                newArrayCounter++;
            }

        }
        Employee removedEmployee = employees[indexToRemove];
        employees = newEmployeesArray;
        return removedEmployee;
    }

    void add(Employee employee) {
        int lengthOldArrays = this.employees.length;
        employee.id = this.employees.length + 1;
        Employee[] newEmployeeArray = new Employee[lengthOldArrays + 1];

        for (int i = 0; i < lengthOldArrays; i++) {
            newEmployeeArray[i] = this.employees[i];
        }

        newEmployeeArray[lengthOldArrays] = employee;

        this.employees = newEmployeeArray;
    }
}
