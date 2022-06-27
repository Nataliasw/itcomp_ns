package com.company.employees;

import com.company.ProjectGenerator;

import java.util.LinkedList;

public class Employee {
    public String typeOfEmployee;
    public Double salary;
    public boolean isEmployed;
    public LinkedList<String> skills;
    public int daysEmployeeIsEmployed;

    public Employee(String typeOfEmployee, Double salary) {
        this.typeOfEmployee = typeOfEmployee;
        this.salary = salary;
        this.isEmployed = false;


    }

    public void generateSkills(){
        if(typeOfEmployee.equals("Freelancer") || typeOfEmployee.equals("Programmer")) {
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

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Employee emp = (Employee) o;
//        return typeOfEmployee.equals(emp.typeOfEmployee);
//
//    }

    public void customerSeeking(ProjectGenerator projects){

    };

    public void updateEmployedDays(){
        this.daysEmployeeIsEmployed += 1;
    }

}
