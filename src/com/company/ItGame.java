package com.company;

import com.company.employees.Employee;
import com.company.employees.Freelancer;
import com.company.employees.Sales;

import java.text.ParseException;

import java.util.LinkedList;
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

    public Freelancer generateFreelancer(String name, Double salary, String type) {

        Freelancer freelancer = new Freelancer("freelancer", salary, type, name);
        freelancer.generateSkills();
        return freelancer;
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
        Freelancer adam = generateFreelancer("Adam", 1500.0, "Best");
        Freelancer betty = generateFreelancer("Betty", 1000.0, "Good");
        Freelancer jack = generateFreelancer("Jack", 1000.0, "Meh");


//Create our Player
        Player player = new Player();

//Game on!

        while (!gameOver) {
//Updates
            if (player.listOfSalesEmp.size() > 0) {
                for (Sales sale : player.listOfSalesEmp) {
                    sale.customerSeeking(projects);
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
                    String projectNumber = myObj.nextLine();
                    player.signProject(projects, Integer.parseInt(projectNumber),date);

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

                    int projectNumber =  Integer.parseInt(myObj.nextLine());
                    Project project = projects.projectListCurrent.get(projectNumber-1);
                    player.testCode(project);
                }
                case "5" -> {
                    System.out.println("Which project would you like to give back? \n" +
                            projects.printCurrentProjects());

                    int projectNumber =  Integer.parseInt(myObj.nextLine());
                    Project project = projects.projectListCurrent.get(projectNumber-1);
                    Customer customerOfTheProject = new Customer("test","test");
                    for(Customer customer : customers){
                        if(customer.customerName.equals(project.companyName)){
                           customerOfTheProject = customer;
                        }
                    }

                    System.out.println(player.giveBackFinishedProject(project,date.getDate(), customerOfTheProject));

                }
                case "6" -> {

                }
                case "7" -> {

                }
                case "8" -> {
                    player.spendDayForAccounting();
                }
            }

            player.money += 1000.0;
            date.changeDate();

        }
    }

}
