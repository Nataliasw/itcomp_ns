package com.company;

import com.company.employees.*;

import java.text.ParseException;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class ItGame {
    boolean gameOver;

    public ItGame() {
        this.gameOver = false;
    }

    public DateCalendar generateDate() throws ParseException {
        DateCalendar date = new DateCalendar();

        return date;
    }

    public ProjectGenerator generateProjects() {
        ProjectGenerator projects = new ProjectGenerator();
        projects.getAllProjects();
        projects.generateStartingProjects();
        return projects;
    }

    public Customer generateCustomer(String name, String type) {
        Customer customer = new Customer(name, type);
        return customer;
    }

    public LinkedList<String> generateSkills() {
        String[] skillsPack = {"frontend", "backend", "db", "mobile", "wordpress", "prestashop"};
        LinkedList<String> skills = new LinkedList<String>();
        while (skills.size() < 4) {
            int random = (int) (Math.random() * 6);
            if (!skills.contains(skillsPack[random])) {
                skills.add(skillsPack[random]);
            }
        }
        return skills;
    }

    public Freelancer generateFreelancer(int number, String name, Double salary, String type) {

        Freelancer freelancer = new Freelancer(number, "Freelancer", salary, type, name);
        freelancer.generateSkills();
        return freelancer;
    }

    public LinkedList<Employee> generateListOfEmployees() {
        LinkedList<Employee> employeeList = new LinkedList<Employee>();
        Tester mark = new Tester("Tester", 1500.0);
        mark.generateSkills();
        employeeList.add(mark);

        Tester micheal = new Tester("Tester", 2000.0);
        micheal.generateSkills();
        employeeList.add(micheal);

        Tester madaline = new Tester("Tester", 2000.0);
        madaline.generateSkills();
        employeeList.add(madaline);
        Tester kate = new Tester("Tester", 2000.0);
        kate.generateSkills();
        employeeList.add(kate);
        Programmer mauritz = new Programmer("Programmer", 3000.0);
        mauritz.generateSkills();
        employeeList.add(mauritz);
        Programmer henry = new Programmer("Programmer", 2500.0);
        henry.generateSkills();
        employeeList.add(henry);
        Programmer alex = new Programmer("Programmer", 3000.0);
        employeeList.add(alex);
        alex.generateSkills();
        Programmer paula = new Programmer("Programmer", 2500.0);
        paula.generateSkills();
        employeeList.add(paula);
        Sales paw = new Sales("Sales", 1000.0);
        paw.generateSkills();
        employeeList.add(paw);
        Sales dominika = new Sales("Sales", 1000.0);
        dominika.generateSkills();
        employeeList.add(dominika);
        Sales george = new Sales("Sales", 1000.0);
        george.generateSkills();
        employeeList.add(george);
        Sales micah = new Sales("Sales", 1000.0);
        micah.generateSkills();
        employeeList.add(micah);
        return employeeList;

    }

    public void checkIfAddNewEmployeeToList(Player player, DateCalendar date, LinkedList<Employee> listOfEmployees) {
        if (date.tour % 3 == 0 && player.listOfAvailableEmployees.size() < 12) {
            System.out.println("You spent some money on Employeeseeking");
            player.money -= 100.0;
            Random rand = new Random();
            int upperbound = 12;

            boolean isAdded = false;
            while (!isAdded) {

                int int_random = rand.nextInt(upperbound);
                Employee emp = listOfEmployees.get(int_random);
                if (!player.listOfAvailableEmployees.contains(emp)) {
                    player.listOfAvailableEmployees.add(emp);
                    isAdded = true;
                    System.out.println("New Employee added to available employee list.");
                }
            }
        }
    }

    public String programmersAreWorking(Player player, DateCalendar date) {
        if (date.getDayOfWeek() >= 5) {
            return "Its weekend";
        }
        if (player.listOfProgrammerEmp.size() == 0) {
            return "there are no programmers working for you.";
        }
        LinkedList<Project> projects = player.ongoingProjects;
        for (Project project : projects) {
            for (String skill : project.timePerProjectPart.keySet()) {

                for (Programmer prog : player.listOfProgrammerEmp) {
                    if (prog.skills.contains(skill) && !prog.alreadyWorkedToday) {
                        int day = project.timePerProjectPart.get(skill);
                        if (day != 0) {
                            double risk = Math.random();
                            if (risk < 0.02) {
                                System.out.println("One of your programmers call in sick!");
                            } else {
                                project.timePerProjectPart.put(skill, day - 1);
                            }
                            prog.alreadyWorkedToday = true;
                        }
                    }


                }


            }
        }


        return "Programmers did some work done";
    }

    public String freelancersWorking(Player player, DateCalendar date) {


        if (date.getDayOfWeek() > 5) {
            return "Its weekend";
        }
        if (player.listOfFreelancerEmp.size() == 0) {
            return "there are no freelancers working for you.";
        }
        LinkedList<Project> projects = player.ongoingProjects;
        for (Project project : projects) {
            for (String skill : project.timePerProjectPart.keySet()) {

                for (Freelancer free : player.listOfFreelancerEmp) {
                    if (free.skills.contains(skill) && !free.alreadyWorkedToday) {
                        int day = project.timePerProjectPart.get(skill);
                        if (day != 0) {
                            double risk = Math.random();
                            if (free.freelancerType.equals("Good")) {
                                if (risk < 0.1) {
                                    System.out.println("Freelancer did bad job and you have to correct the code.");
                                } else {
                                    project.timePerProjectPart.put(skill, day - 1);

                                }
                                free.alreadyWorkedToday = true;
                            }
                            if (free.freelancerType.equals("Meh")) {
                                if (risk < 0.2) {
                                    System.out.println("Freelancer did bad job/is late and you have to correct the code/help him write code.");
                                } else {
                                    project.timePerProjectPart.put(skill, day - 1);

                                }
                                free.alreadyWorkedToday = true;
                            }

                        }
                    }


                }


            }
        }
        return "all done.";
    }


    public boolean endTheGame(Player player) {
        boolean isObtainedBySales = false;
        for (Sales sale : player.listOfSalesEmp) {
            for (Project project : sale.listOfProjectsFound) {
                if (player.fullyDoneAndPaidProjects.contains(project)) {
                    isObtainedBySales = true;
                }
            }
        }

        if (player.listOfSalesEmp.size() <= 0) {
            return this.gameOver;
        }

        if (!isObtainedBySales) {
            return this.gameOver;
        }
        if (player.fullyDoneAndPaidProjects.size() < 3) {
            return this.gameOver;
        }
        if (player.money <= 0.0) {
            this.gameOver = true;
            System.out.println("You have no money! You lost!");
        }

        if (player.money > player.getDefaultMoneyValue()) {
            this.gameOver = true;
        }

        return this.gameOver;

    }

    public void startGame() throws ParseException, InterruptedException {
        DateCalendar date = generateDate();
        ProjectGenerator projects = generateProjects();
//Generate Customers
        Customer azurro = generateCustomer("Azurro", "Chill");
        Customer fernweh = generateCustomer("Fernweh", "Demandig");
        Customer karmelkowo = generateCustomer("Karmelkowo", "Skrwl");
        LinkedList<Customer> customers = new LinkedList<>();
        customers.add(azurro);
        customers.add(fernweh);
        customers.add(karmelkowo);
//Generate freelancers
        Freelancer adam = generateFreelancer(1, "Adam", 1500.0, "Best");
        Freelancer betty = generateFreelancer(2, "Betty", 1000.0, "Good");
        Freelancer jack = generateFreelancer(3, "Jack", 1000.0, "Meh");
        LinkedList<Freelancer> freelancers = new LinkedList<Freelancer>();
        freelancers.add(adam);
        freelancers.add(betty);
        freelancers.add(jack);


//Create our Player
        Player player = new Player();
//Genereate available Employees
        LinkedList<Employee> listOfEmployees = generateListOfEmployees();
        Random rand = new Random();
        int upperbound = 12;
        for (int i = 0; player.listOfAvailableEmployees.size() == 3; i++) {
            int int_random = rand.nextInt(upperbound);
            Employee emp = listOfEmployees.get(int_random);
            if (!player.listOfAvailableEmployees.contains(emp)) {
                player.listOfAvailableEmployees.add(emp);
            }
        }


//Game on!

        while (!gameOver) {
//Updates
            player.resetNextMonth(date);

            if (player.fullyDoneNotPaidProjects.size() > 0) {
                for (Project p : player.fullyDoneNotPaidProjects) {
                    if (p.daysToPay > 0) {
                        p.daysToPay -= 1;
                    }
                }
            }
            player.receiveMoney();
            checkIfAddNewEmployeeToList(player, date, listOfEmployees);
            if (player.listOfProgrammerEmp.size() > 0) {
                for (Programmer p : player.listOfProgrammerEmp) {
                    p.updateEmployedDays();
                }
            }
            if (player.listOfSalesEmp.size() > 0) {
                for (Sales s : player.listOfSalesEmp) {
                    s.updateEmployedDays();
                }
            }
            if (player.listOfTesterEmp.size() > 0) {
                for (Tester t : player.listOfTesterEmp) {
                    t.updateEmployedDays();
                }
            }
//Updates for sales
            if (player.listOfSalesEmp.size() > 0 && date.getDayOfWeek() < 5) {
                for (Sales sale : player.listOfSalesEmp) {

                    sale.updateEmployedDays();
                    if (sale.daysEmployeeIsEmployed / 30.0 == 0) {
                        player.money -= sale.salary;
                        System.out.println("You just paid salary to one of your salesperson");
                        player.money -= 300;
                        System.out.println("You just paid vacancy costs, insurance and tax");

                    }
                }
            }
//Update for freelancers
            freelancersWorking(player, date);
            if (player.listOfFreelancerEmp.size() > 0) {

                player.listOfFreelancerEmp.removeIf(f -> f.daysWorked > 30);
                for (Freelancer f : player.listOfFreelancerEmp) {
                    f.daysWorked += 1;
                    if (f.daysWorked == 30) {
                        player.money -= f.salary;
                        player.money -= 300;
                        System.out.println("You just paid vacancy costs, insurance and tax");
                    }
                }
            }
//Updated for programmers
            for (Programmer programmer : player.listOfProgrammerEmp) {
                programmer.alreadyWorkedToday = false;
            }
            String progs = programmersAreWorking(player, date);
            System.out.println(progs);
            if (player.listOfProgrammerEmp.size() > 0) {
                for (Programmer prog : player.listOfProgrammerEmp) {
                    prog.customerSeeking(projects);
                    if (prog.daysEmployeeIsEmployed / 30.0 == 0) {
                        player.money -= prog.salary;
                        System.out.println("You just paid salary to one of your programmer");
                        player.money -= 300;
                        System.out.println("You just paid vacancy costs, insurance and tax");

                    }
                }
            }
//Update for Testers
            if (player.listOfTesterEmp.size() > 0) {
                for (Tester tester : player.listOfTesterEmp) {
                    tester.customerSeeking(projects);
                    if (tester.daysEmployeeIsEmployed / 30.0 == 0) {
                        player.money -= tester.salary;
                        System.out.println("You just paid salary to one of your tester");
                        player.money -= 300;
                        System.out.println("You just paid vacancy costs, insurance and tax");

                    }
                }
            }


            Thread.sleep(1000);

            if (date.tour == 1) {
                System.out.println("Welcome to IT company game! Good Luck!");
                Thread.sleep(1000);
            }
            //New day
            Thread.sleep(1000);
            System.out.println("Today is " + date.getDate() + "\n");
            Thread.sleep(1000);
            player.whatToDo();
            Thread.sleep(1000);
            Scanner myObj = new Scanner(System.in);
            System.out.println("What do you want to do? ");
            String activity = myObj.nextLine();

            switch (activity) {
                case "9" -> {
                    player.checkStats(projects);
                    continue;
                }
                case "1" -> {
                    Thread.sleep(1000);
                    System.out.println("Which project would you like to sign? \n" +
                            projects.printCurrentProjects());
                    int projectNumber = Integer.parseInt(myObj.nextLine());

                    player.signProject(projects,projectNumber , date);

                }
                case "2" -> player.customerSeeking(projects);
                case "3" -> {
                    Thread.sleep(1000);
                    System.out.println("Which project would you like to work on? \n" +
                            projects.printCurrentProjects());
                    String projectNumber = myObj.nextLine();
                    player.programming(projects, Integer.parseInt(projectNumber));
                }
                case "4" -> {
                    Thread.sleep(1000);
                    System.out.println("Which project would you like to work on? \n" +
                            projects.printCurrentProjects());

                    int projectNumber = Integer.parseInt(myObj.nextLine());
                    Project project = projects.projectListCurrent.get(projectNumber - 1);
                    player.testCode(project);
                }
                case "5" -> {
                    Thread.sleep(1000);
                    System.out.println("Which project would you like to give back? \n" +
                            projects.printCurrentProjects());

                    int projectNumber = Integer.parseInt(myObj.nextLine());
                    Project project = projects.projectListCurrent.get(projectNumber - 1);
                    Customer customerOfTheProject = new Customer("test", "test");
                    for (Customer customer : customers) {
                        if (customer.customerName.equals(project.companyName)) {
                            customerOfTheProject = customer;
                        }
                    }

                    System.out.println(player.giveBackFinishedProject(project, date.getDate(), customerOfTheProject));

                }
                case "6" -> {
                    Thread.sleep(1000);
                    System.out.println("Which project would you like to give back? \n" +
                            player.listOfAvailableEmployees);

                    int empNumber = Integer.parseInt(myObj.nextLine());
                    player.hireEmployee(player.listOfAvailableEmployees.get(empNumber - 1));

                }
                case "7" -> {

                    System.out.println("Who you want ot laid off?");
                    switch (myObj.nextLine()) {
                        case "programmer" -> {
                            System.out.println("Which programmer? " + player.listOfProgrammerEmp);
                            int empNumber = Integer.parseInt(myObj.nextLine());
                            player.getRidOf(player.listOfProgrammerEmp.get(empNumber - 1));
                        }
                        case "sales" -> {
                            System.out.println("Which salesperson? " + player.listOfSalesEmp);
                            int empNumber = Integer.parseInt(myObj.nextLine());
                            player.getRidOf(player.listOfSalesEmp.get(empNumber - 1));
                        }
                        case "tester" -> {
                            System.out.println("Which tester? " + player.listOfTesterEmp);
                            int empNumber = Integer.parseInt(myObj.nextLine());
                            player.getRidOf(player.listOfTesterEmp.get(empNumber - 1));
                        }
                        case "freelancer" -> {
                            System.out.println("Which freelancer? " + player.listOfFreelancerEmp);
                            int empNumber = Integer.parseInt(myObj.nextLine());
                            player.getRidOf(player.listOfFreelancerEmp.get(empNumber - 1));
                        }


                    }
                    player.money -= 200;
                    System.out.println("You laid off an employee but it also costs, you paid 200 for that.");

                }
                case "8" -> {
                    Thread.sleep(1000);
                    player.spendDayForAccounting();
                }
            }


            date.changeDate();
            endTheGame(player);

        }
    }

}
