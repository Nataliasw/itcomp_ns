package com.company.employees;

import com.company.Project;
import com.company.ProjectGenerator;

import java.util.LinkedList;

public class Sales extends Employee {
    public int daysOfSeekingCustomers;
    public LinkedList<Project> listOfProjectsFound;

    public Sales(String typeOfEmployee, Double salary) {

        super(typeOfEmployee, salary);
        this.listOfProjectsFound = new LinkedList<Project>();
    }

    @Override
    public String toString() {
        return "Sales{" +
                "typeOfEmployee='" + typeOfEmployee + '\'' +
                ", salary=" + salary +
                ", isEmployed=" + isEmployed +
                ", skills=" + skills +
                ", daysOfSeekingCustomers=" + daysOfSeekingCustomers +
                ", listOfProjectsFound=" + listOfProjectsFound +
                '}';
    }

    @Override
    public void customerSeeking(ProjectGenerator projects) {
        if (daysOfSeekingCustomers == 5) {
            daysOfSeekingCustomers = 0;

            projects.addProjectToList(this);

        } else {
            daysOfSeekingCustomers += 1;
            System.out.println("Your salesman spent the day looking for potential projects");
        }

    }
}
