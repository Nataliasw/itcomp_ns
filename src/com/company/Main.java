package com.company;

import java.text.ParseException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        //new SimpleDateFormat("dd/MM/yyyy").parse("01/30/2020")
        DateCalendar date = new DateCalendar();
        date.getDayOfWeek();

        //date.changeDate();
//Projects generator
        ProjectGenerator projects = new ProjectGenerator();
        projects.getAllProjects();
        projects.generateStartingProjects();
//Create our Player
        Player player = new Player();


//Game on!
        while (player.money <= 2500.0) {

            Scanner myObj = new Scanner(System.in);
            System.out.println("Welcome to IT company game. Today is " + date.getDate() + ". What do you want to do today?");
            player.whatToDo();

            String activity = myObj.nextLine();
            if (activity.equals("2")) {
                player.customerSeeking(projects);
            }
            player.money += 1000.0;
        }

//GARBAGE

//        1podpisać umowę na realizację jednego z dostępnych projektów
//        2przeznaczyć dzień na szukanie klientów (każde 5 dni to jeden nowy dostępny projekt)
//        3przeznaczyć dzień na programowanie
//        4przeznaczyć dzień na testowanie (możesz testować własny kod, kod podwykonawców i kod pracowników)
//        5oddać gotowy projekt klientowi
//        6zatrudnić nowego pracownika
//        7zwolnić pracownika
//        8przeznaczyć dzień na rozliczenia z urzędami (jeśli nie poświęcisz na to 2 dni w miesiącu ZUS wjeżdża z taką kontrolą, że zamykasz firmę z długami)

// String[] activities = {"contract","customerseeking","programming","testing","giveProjectToCust",
//    "hireEmp","layOffEmp","zus"};
    }
}
