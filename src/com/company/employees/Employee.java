package com.company.employees;

import com.company.ProjectGenerator;

import java.util.LinkedList;

public abstract class Employee {
    public String typeOfEmployee;
    public Double salary;
    public boolean isEmployed;
    public LinkedList<String> skills;

    public Employee(String typeOfEmployee, Double salary) {
        this.typeOfEmployee = typeOfEmployee;
        this.salary = salary;
        this.isEmployed = false;
    }

    public void generateSkills(){
        if(typeOfEmployee.equals("freelancer") || typeOfEmployee.equals("programmer")) {
            String[] skillsPack = {"frontend", "backend", "db", "mobile", "wordpress", "prestashop"};
            this.skills = new LinkedList<String>();
            while (skills.size() < 4) {
                int random = (int) (Math.random() * 6);
                if (!skills.contains(skillsPack[random])) {
                    skills.add(skillsPack[random]);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "typeOfEmployee='" + typeOfEmployee + '\'' +
                ", salary=" + salary +
                ", isEmployed=" + isEmployed +
                ", skills=" + skills +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee emp = (Employee) o;
        return typeOfEmployee.equals(emp.typeOfEmployee);

    }

    public abstract void customerSeeking(ProjectGenerator projects);

}
