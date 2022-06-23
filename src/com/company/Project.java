package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Project {
    public int projectNumber;
    public String name;
    public HashMap<String, Integer> timePerProjectPart;
    public String companyName;
    public Date returnDate;
    public Double penalty;
    public Double value;
    public int daysToPay;
    public boolean willReceiveMoney;
    public String level;
    public int daysSpentTesting;
    public boolean isFinished;
    public boolean isAssigned;
    public boolean isPaidfor;
    public int timeRemaining;
    public int daysAggreedToFinish;

    public Project(int projectNumber, String name,
                   String companyName, Double penalty, Double value, String level, int daysAggreedToFinish) {
        this.projectNumber = projectNumber;
        this.name = name;
        this.companyName = companyName;
        this.level = level;
        this.penalty = penalty;
        this.value = value;
        this.isFinished = false;
        this.timePerProjectPart = new HashMap<>();
        this.isAssigned = false;
        this.daysSpentTesting = 0;
        this.daysAggreedToFinish = daysAggreedToFinish;
        this.isPaidfor = false;


    }

    @Override
    public String toString() {
        return "Project{" +
                "projectNumber=" + projectNumber +
                ", name='" + name + '\'' +
                ", timePerProjectPart=" + timePerProjectPart +
                ", companyName='" + companyName + '\'' +
                ", returnDate=" + returnDate +
                ", penalty=" + penalty +
                ", value=" + value +
                ", daysToPay=" + daysToPay +
                ", willReceiveMoney=" + willReceiveMoney +
                ", level='" + level + '\'' +
                ", daysSpentTesting=" + daysSpentTesting +
                ", isFinished=" + isFinished +
                ", isAssigned=" + isAssigned +
                ", timeRemaining=" + timeRemaining +
                ", daysAggreedToFinish=" + daysAggreedToFinish +
                '}' + "\n";
    }

    public String getCompleteness() {
        String complete = " ";
        if (!isAssigned) {
            return "This project is not assigned to your company.";
        }
        if (timeRemaining == getTimeRequired()) {
            return " 0% | You need to work on this project for " + timeRemaining + " more days yet.";
        }
        if(timeRemaining ==0){
            return "100% | Your project is finished!";
        }
        else {
            double time = timeRemaining;
            String percentage =  Double.toString(time/getTimeRequired() *100);


            return percentage + " | You need to work on this project for " + timeRemaining + " more days yet.";
        }


    }

    ;


    public void addTimeToParts(int front, int back, int db, int mobile, int wp, int presta) {
        timePerProjectPart.clear();
        timePerProjectPart.put("frontend", front);
        timePerProjectPart.put("backend", back);
        timePerProjectPart.put("db", db);
        timePerProjectPart.put("mobile", mobile);
        timePerProjectPart.put("wordpress", wp);
        timePerProjectPart.put("prestashop", presta);
        // System.out.println("Time added successfully.");
    }

    public int getTimeRequired() {
        int timeReq = 0;
        for (String s : timePerProjectPart.keySet()) {
            timeReq += timePerProjectPart.get(s);
        }
        return timeReq;
    }

    public void setReturnDate(DateCalendar dateCalendar) {
        int days = this.daysAggreedToFinish;
        Date today = dateCalendar.getDate();
        Calendar temp = Calendar.getInstance();
        temp.setTime(today);
        temp.add(Calendar.DATE, days);
        this.returnDate = temp.getTime();

    }



}
