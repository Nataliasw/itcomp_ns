package com.company.employees;

import com.company.ProjectGenerator;

import java.util.HashMap;
import java.util.LinkedList;

public class Freelancer extends Employee {
    public String name;
    public int number;
    public LinkedList<String> skills;
    public String freelancerType;
    public boolean alreadyWorkedToday;
    public int daysWorked;



    public Freelancer(int number,String typeOfEmployee,  Double salary, String freelancerType,String name) {
        super(typeOfEmployee, salary);
        this.number = number;
        this.freelancerType = freelancerType;
        this.name = name;
        this.alreadyWorkedToday = false;

    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "typeOfEmployee='" + typeOfEmployee + '\'' +
                ", salary=" + salary +
                ", isEmployed=" + isEmployed +
                ", skills=" + skills +
                ", daysEmployeeIsEmployed=" + daysEmployeeIsEmployed +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", skills=" + skills +
                ", freelancerType='" + freelancerType + '\'' +
                ", alreadyWorkedToday=" + alreadyWorkedToday +
                ", daysWorked=" + daysWorked +
                '}';
    }
}

