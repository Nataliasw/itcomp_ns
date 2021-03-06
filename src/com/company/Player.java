package com.company;


import com.company.employees.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Player {
    static final Double DEFAULT_MONEY = 20000.0;
    static final int DEFAULT_DAYS_SPENT = 0;
    static final int DEFAULT_MONTH = 0;
    public Double money;
    public LinkedList<Project> fullyDoneAndPaidProjects;
    public LinkedList<Project> fullyDoneNotPaidProjects;
    public LinkedList<Sales> listOfSalesEmp;
    public LinkedList<Programmer> listOfProgrammerEmp;
    public LinkedList<Tester> listOfTesterEmp;
    private int daysSpentOnZus;
    private int currentMonth;
    private int moneyEarnedThisMonth;
    public LinkedList<Project> ongoingProjects;
    public int daysOfSeekingCustomers;
    public LinkedList<Employee> listOfAvailableEmployees;
    public LinkedList<Freelancer> listOfFreelancerEmp;

    public Player() {
        this.money = DEFAULT_MONEY;
        this.fullyDoneAndPaidProjects = new LinkedList<Project>();
        this.listOfSalesEmp = new LinkedList<Sales>();
        this.daysSpentOnZus = DEFAULT_DAYS_SPENT;
        this.currentMonth = DEFAULT_MONTH;
        this.ongoingProjects = new LinkedList<Project>();
        this.daysOfSeekingCustomers = 0;
        this.listOfProgrammerEmp = new LinkedList<Programmer>();
        this.listOfTesterEmp = new LinkedList<Tester>();
        this.listOfAvailableEmployees = new LinkedList<Employee>();
        this.listOfFreelancerEmp = new LinkedList<Freelancer>();
        this.fullyDoneNotPaidProjects = new LinkedList<Project>();
    }

    public Double getDefaultMoneyValue() {
        return DEFAULT_MONEY;
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

    public void resetNextMonth(DateCalendar date){

        if(this.currentMonth != date.getMonth()){
            System.out.println("Its new month, remember to spent at least 2 days on accounting!");
            this.currentMonth = date.getMonth();
            this.daysSpentOnZus = 0;
            System.out.println("It next month, you have to pay your taxes!");
            System.out.println(this.money);
            System.out.println("- " + this.moneyEarnedThisMonth);
            this.money -= this.moneyEarnedThisMonth;
            this.moneyEarnedThisMonth =0;
            System.out.println(this.money);

        }
    }


    public void checkStats(ProjectGenerator projects) {
        System.out.println("Days spent on accounting this month: " + this.daysSpentOnZus);
        System.out.println("List of Fully Done and Paid Projects: " + this.fullyDoneAndPaidProjects);
        System.out.println("List of Sales employees: " + this.listOfSalesEmp);
        System.out.println("Amount of money available: " + this.money);
        System.out.println("Ongoing projects: " + this.ongoingProjects);
        System.out.println("Days spent looking for new projects: " + this.daysOfSeekingCustomers);
        System.out.println("Available projects:");
        for (Project p : projects.projectListCurrent) {
            System.out.println(p);

        }
        System.out.println("Fully done not paid projects:");
        for(Project p: this.fullyDoneNotPaidProjects){
            System.out.println(p);
        }
        System.out.println("Fully done paid projects:");
        for(Project p: this.fullyDoneAndPaidProjects){
            System.out.println(p);
        }
        System.out.println("List of available employees:");
        for(Employee e: this.listOfAvailableEmployees){
            System.out.println(e);
        }
        System.out.println("Sales employees:");
        for(Sales s: this.listOfSalesEmp){
            System.out.println(s);
        }
        System.out.println("Programmers:");
        for(Programmer p: this.listOfProgrammerEmp){
            System.out.println(p);
        }
        System.out.println("Testers:");
        for(Tester t: this.listOfTesterEmp){
            System.out.println(t);
        }
        System.out.println("Freelancers:");
        for(Freelancer f: this.listOfFreelancerEmp){
            System.out.println(f);
        }
    }

    public void signProject(ProjectGenerator projects, int projectNumber, DateCalendar date) {
        if (projectNumber <= projects.projectListCurrent.size()) {
            Project projectToAdd = projects.projectListCurrent.get(projectNumber - 1);
            ongoingProjects.add(projectToAdd);
            projectToAdd.isAssigned = true;
            projectToAdd.timeRemaining = projectToAdd.getTimeRequired();
            projectToAdd.setReturnDate(date);
            System.out.println("Successfully added the project " + projectToAdd +
                    " to your ongoing projects.");
        }
    }

    public void customerSeeking(ProjectGenerator projects) {
        if (daysOfSeekingCustomers == 5) {
            daysOfSeekingCustomers = 0;
            projects.addProjectToList();
        } else {
            daysOfSeekingCustomers += 1;
            System.out.println("You have spent your day seeking for new project.");
        }

    }

    public void programming(ProjectGenerator projects, int projectNumber) {
        Project projectWorkedOn = projects.projectListCurrent.get(projectNumber - 1);
        projectWorkedOn.timeRemaining -= 1;
        System.out.println("You were programming all day!");


    }

    public void spendDayForAccounting() {

        this.daysSpentOnZus += 1;
        System.out.println("You have spend now " + this.daysSpentOnZus + " on accounting");

    }

    public void testCode(Project project) {

        System.out.println("You spend the day on testing your code for project \t" + project);

    }

    public String giveBackFinishedProject(Project project, Date today, Customer customer) {
        boolean cannotBeBroken = listOfTesterEmp.size() >= 1 && listOfProgrammerEmp.size() >= 3;
        if(customer.customerName.equals("test")){
            System.out.println("Customer name is not correct");
            return "Aborting";
        }

        if (project.timeRemaining > 0) {
            System.out.println("Project is not finished yet");
        } else {
            project.isFinished = true;
            double pentaltyPoss = Math.random();
            double chanceToDaleyPayment = Math.random();
            double chanceProjectIsNotWorking = Math.random();
            long diffInMillies = Math.abs(today.getTime() - project.returnDate.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);


            switch (customer.getCustomerType()) {

                case "Chill" -> {
                    project.willReceiveMoney = true;
                    fullyDoneNotPaidProjects.add(project);
                    if (project.returnDate.before(today)) {

                        if (diff > 0 && diff <= 7) {
                            if (pentaltyPoss < 0.2) {
                                System.out.println("You gave back the project late but there will be not penalty for delay this time!");
                            } else {
                                System.out.println("You gave back the project late, you will pay penalty");

                                System.out.println(this.money + " - " + project.penalty);
                                this.money -= project.penalty;
                                System.out.println(this.money);
                            }
                        }
                    }
                    if (chanceToDaleyPayment < 0.3) {
                        project.daysToPay = 7;
                    } else {
                        project.daysToPay = 1;
                    }


                }
                case "Demanding" -> {

                    project.daysToPay = 1;
                    this.fullyDoneNotPaidProjects.add(project);

                    if (project.returnDate.before(today)) {
                        System.out.println("You gave back the project late, you will pay penalty");
                        System.out.println(this.money + " - " + project.penalty);
                        this.money -= project.penalty;
                        System.out.println(this.money);
                    }
                    if(!cannotBeBroken) {
                        if (chanceProjectIsNotWorking < 0.95) {
                            System.out.println("You gave back working project");
                            project.willReceiveMoney = true;
                        } else {

                            System.out.println("You gave back project that doesn't work!");
                            double chanceToLoseContract = Math.random();
                            if (chanceToLoseContract < 0.5) {
                                System.out.println("You've lost your contract and will not receive any money!");
                                project.willReceiveMoney = false;
                            } else {
                                System.out.println("You will get your money anyway");
                                project.willReceiveMoney = true;
                            }
                        }
                    }

                }
                case "Skrwl" -> {
                    this.fullyDoneNotPaidProjects.add(project);
                    if (project.returnDate.before(today)) {
                        System.out.println("You gave back the project late, you will pay penalty");
                        System.out.println(this.money + " - " + project.penalty);
                        this.money -= project.penalty;
                        System.out.println(this.money);
                    }
                    if (chanceToDaleyPayment < 0.3) {
                        project.daysToPay = 7;
                        project.willReceiveMoney = true;
                    } else if (chanceToDaleyPayment < 0.35) {
                        project.daysToPay = 30;
                        project.willReceiveMoney = true;
                    } else if (chanceToDaleyPayment < 0.36) {
                        project.willReceiveMoney = false;
                    } else {
                        project.daysToPay = 1;
                        project.willReceiveMoney = true;
                    }
                    if(!cannotBeBroken) {
                        if (chanceProjectIsNotWorking < 0.95) {
                            System.out.println("You gave back working project");
                            project.willReceiveMoney = true;
                        } else {
                            System.out.println("You gave back project that doesn't work!");

                            System.out.println("You've lost your contract and will not receive any money!");
                            project.willReceiveMoney = false;

                        }
                    }
                }
            }


        }
        return "That is it for today!";
    }

    public void hireEmployee(Employee emp){
        emp.isEmployed = true;
        if(Objects.equals(emp.typeOfEmployee, "Programmer")){
            System.out.println("You hired a programmer.");
            this.listOfProgrammerEmp.add((Programmer) emp);
        } else if(Objects.equals(emp.typeOfEmployee, "Tester")){
            System.out.println("You hired a tester.");
            this.listOfTesterEmp.add((Tester) emp);
        } else if(Objects.equals(emp.typeOfEmployee, "Sales")){
            System.out.println("You hired a salesperson.");
            this.listOfSalesEmp.add((Sales) emp);
        } else if(Objects.equals(emp.typeOfEmployee, "Freelancer")){
            this.listOfFreelancerEmp.add((Freelancer) emp);
            System.out.println("You hired a Freelancer. They will only work for you for 30 days, then you gonna pay them and will have to rehire them.");
        }
        else {
            System.out.println("not correct employee type.");
        }

    }
    public void getRidOf(Employee emp){
        emp.isEmployed = false;
        if(Objects.equals(emp.typeOfEmployee, "Programmer")){
            this.listOfProgrammerEmp.remove((Programmer) emp);
        } else if(Objects.equals(emp.typeOfEmployee, "Tester")){
            this.listOfTesterEmp.remove((Tester) emp);
        } else if(Objects.equals(emp.typeOfEmployee, "Sales")){
            this.listOfSalesEmp.remove((Sales) emp);
        } else if(Objects.equals(emp.typeOfEmployee, "Freelancer")){
            this.listOfFreelancerEmp.remove((Freelancer) emp);

        }
        else {
            System.out.println("uncorrect employee type.");
        }

    }

    public void receiveMoney(){
        for(Project p : this.fullyDoneNotPaidProjects){
            if(p.willReceiveMoney && p.daysToPay <= 0){
                this.fullyDoneNotPaidProjects.remove(p);
                System.out.println("You just got paid! +"+ p.value );

                this.money += p.value;
                this.fullyDoneAndPaidProjects.add(p);
            }
        }
    }


}

