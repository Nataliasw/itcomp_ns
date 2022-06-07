package com.company;

import java.util.LinkedList;

public class Player {
    static final Double DEFAULT_MONEY = 2000.0;
    static final int DEFAULT_DAYS_SPENT = 0;
    public Double money;
    public LinkedList<Project> fullyDoneAndPaidProjects;
    public LinkedList<Employee> listOfEmployees;
    public int daysSpentOnZus;
    public String currentMonth;


  //  Uzyskanie pełnej zapłaty za 3 duże projekty w ramach których właściciel
    //  firmy nie wykonał żadnych prac programistycznych,
    //  ani testerskich, z których co najmniej 1 został pozyskany
    //  przez zatrudnionego sprzedawcę
    //  i posiadanie na koncie środków wyższych od kapitału początkowego.
    public void spendDayForAccounting(){
        this.daysSpentOnZus +=1;
        System.out.println("You have spend now " + this.daysSpentOnZus + " on accounting");

    }
    public void checkStats(){
        System.out.println("Days spent on accounting this month: " + this.daysSpentOnZus);
        System.out.println("List of Fully Done and Paid Projects: " + this.fullyDoneAndPaidProjects);
        System.out.println("List of Employees: " + this.listOfEmployees);
        System.out.println("Amount of money available: " +this.money);
    }

}

