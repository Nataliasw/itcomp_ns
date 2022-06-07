package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        //new SimpleDateFormat("dd/MM/yyyy").parse("01/30/2020")
    DateCalendar date = new DateCalendar();
    date.getDayOfWeek();
    date.changeDate();
    Project p1 = new Project("ProjectX","Azurro",120.0,1000.0,30);
    p1.addTimeToParts(2,3,0,0,0,0);
    System.out.println(p1.getTimeRequired());


    for(int i =0; i < 5; i++){
        System.out.println("Welcome to IT company game. Today is " +". What do you want to do today?");
        Scanner myObj = new Scanner(System.in);
        String[] activities = {"contract","customerseeking","programming","testing","giveProjectToCust",
        "hireEmp","layOffEmp","zus"};

        String activity = myObj.nextLine();
    }

//        1podpisać umowę na realizację jednego z dostępnych projektów
//        2przeznaczyć dzień na szukanie klientów (każde 5 dni to jeden nowy dostępny projekt)
//        3przeznaczyć dzień na programowanie
//        4przeznaczyć dzień na testowanie (możesz testować własny kod, kod podwykonawców i kod pracowników)
//        5oddać gotowy projekt klientowi
//        6zatrudnić nowego pracownika
//        7zwolnić pracownika
//        8przeznaczyć dzień na rozliczenia z urzędami (jeśli nie poświęcisz na to 2 dni w miesiącu ZUS wjeżdża z taką kontrolą, że zamykasz firmę z długami)



    }
}
