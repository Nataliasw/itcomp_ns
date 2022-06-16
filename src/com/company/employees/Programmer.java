package com.company.employees;

import com.company.ProjectGenerator;

import java.util.LinkedList;

public class Programmer extends Employee{

    public LinkedList<String> skills;


    public Programmer(String typeOfEmployee, Double salary) {
        super(typeOfEmployee, salary);


    }

    @Override
    public void customerSeeking(ProjectGenerator projects) {

    }


}
