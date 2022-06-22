package com.company.employees;

import com.company.ProjectGenerator;

import java.util.HashMap;
import java.util.LinkedList;

public class Freelancer extends Employee {
    public String name;
    public LinkedList<String> skills;
    public String freelancerType;
    public boolean alreadyWorkedToday;
    public int daysWorked;



    public Freelancer(String typeOfEmployee, Double salary, String freelancerType,String name) {
        super(typeOfEmployee, salary);
        this.freelancerType = freelancerType;
        this.name = name;
        this.alreadyWorkedToday = false;

    }

}

