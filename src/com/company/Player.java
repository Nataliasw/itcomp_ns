package com.company;

import java.util.LinkedList;

public class Player {
    static final Double DEFAULT_MONEY = 2000.0;
    static final int DEFAULT_DAYS_SPENT = 0;
    static final String DEFAULT_MONTH = "01";
    public Double money;
    public LinkedList<Project> fullyDoneAndPaidProjects;
    public LinkedList<Employee> listOfEmployees;
    public int daysSpentOnZus;
    public String currentMonth;
    public LinkedList<Project> ongoingProjects;
    public int daysOfSeekingCustomers;

    public Player() {
        this.money = DEFAULT_MONEY;
        this.fullyDoneAndPaidProjects = new LinkedList<Project>();
        this.listOfEmployees = new LinkedList<Employee>();
        this.daysSpentOnZus = DEFAULT_DAYS_SPENT;
        this.currentMonth = DEFAULT_MONTH;
        this.ongoingProjects = new LinkedList<Project>();
        this.daysOfSeekingCustomers = 5;
    }

    //  Uzyskanie pełnej zapłaty za 3 duże projekty w ramach których właściciel
    //  firmy nie wykonał żadnych prac programistycznych,
    //  ani testerskich, z których co najmniej 1 został pozyskany
    //  przez zatrudnionego sprzedawcę
    //  i posiadanie na koncie środków wyższych od kapitału początkowego.
    public void spendDayForAccounting() {
        this.daysSpentOnZus += 1;
        System.out.println("You have spend now " + this.daysSpentOnZus + " on accounting");

    }

    public void whatToDo() {
        System.out.println("\n" + "You can " + "\n" +
                "1 - sign contract to make a project \n" +
                "2 - look for new projects \n" +
                "3 - program all day \n" +
                "4 - test code you wrote all day \n" +
                "5 - give finished project to your customer \n" +
                "6 - hire new employee \n" +
                "7 - lay off employee \n" +
                "8 - spend your day doing accounting \n" +
                "9 - check your stats");
    }

    public void checkStats() {
        System.out.println("Days spent on accounting this month: " + this.daysSpentOnZus);
        System.out.println("List of Fully Done and Paid Projects: " + this.fullyDoneAndPaidProjects);
        System.out.println("List of Employees: " + this.listOfEmployees);
        System.out.println("Amount of money available: " + this.money);
        System.out.println("Ongoing projects: " + this.ongoingProjects);
        System.out.println("Days spent looking for new projects: " + this.daysOfSeekingCustomers);
    }

    public void signProject(ProjectGenerator projects, int projectNumber) {
        if (projectNumber <= projects.projectListCurrent.size()) {
            ongoingProjects.add(projects.projectListCurrent.get(projectNumber + 1));
            System.out.println("Successfully added the project " + projects.projectListCurrent.get(projectNumber + 1) +
                    " to your ongoing projects.");
        }
    }

    public void customerSeeking(ProjectGenerator projects) {
        if (daysOfSeekingCustomers == 5) {
            daysOfSeekingCustomers = 0;
            projects.addProjectToList();
        } else {
            daysOfSeekingCustomers +=1;
            System.out.println("You have spent you day seeking for new project.");
        }

    }

    // 1podpisać umowę na realizację jednego z dostępnych projektów - DONE
//        2przeznaczyć dzień na szukanie klientów (każde 5 dni to jeden nowy dostępny projekt)
//        3przeznaczyć dzień na programowanie
//        4przeznaczyć dzień na testowanie (możesz testować własny kod, kod podwykonawców i kod pracowników)
//        5oddać gotowy projekt klientowi
//        6zatrudnić nowego pracownika
//        7zwolnić pracownika
//        8przeznaczyć dzień na rozliczenia z urzędami (jeśli nie poświęcisz na to 2 dni w miesiącu ZUS wjeżdża
}

