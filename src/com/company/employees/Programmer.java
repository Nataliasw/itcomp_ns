package com.company.employees;

import com.company.ProjectGenerator;

import java.util.LinkedList;

public class Programmer extends Employee{

    public LinkedList<String> skills;
    public boolean alreadyWorkedToday;


    public Programmer(String typeOfEmployee, Double salary) {
        super(typeOfEmployee, salary);
    this.alreadyWorkedToday = false;

    }




}
