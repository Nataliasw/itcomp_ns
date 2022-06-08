package com.company;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Project {
    public int projectNumber;
    public String name;
    private final HashMap<String, Integer> timePerProjectPart;
    public String companyName;
    public Date returnDate;
    public Double penalty;
    public Double value;
    public int daysToPay;
    public boolean isObtainedByEmployee;
    public String level;

    public Project(int projectNumber,String name,
                   String companyName, Double penalty, Double value, int daysToPay, String level) {
        this.projectNumber = projectNumber;
        this.name = name;
        this.companyName = companyName;
        this.level = level;
        this.penalty = penalty;
        this.value = value;
        this.daysToPay = daysToPay;
        this.timePerProjectPart  = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", timePerProjectPart=" + timePerProjectPart +
                ", companyName='" + companyName + '\'' +
                ", returnDate=" + returnDate +
                ", penalty=" + penalty +
                ", value=" + value +
                ", daysToPay=" + daysToPay +
                ", isObtainedByEmployee=" + isObtainedByEmployee +
                ", level='" + level + '\'' +
                '}';
    }

    public void addTimeToParts(int front, int back, int db, int mobile, int wp, int presta){
            timePerProjectPart.clear();
            timePerProjectPart.put("frontend", front);
            timePerProjectPart.put("backend",back);
            timePerProjectPart.put("db", db);
            timePerProjectPart.put("mobile",mobile);
            timePerProjectPart.put("wordpress", wp);
            timePerProjectPart.put("prestashop", presta);
           // System.out.println("Time added successfully.");
        }

        public int getTimeRequired(){
        int timeReq = 0;
            for(String s: timePerProjectPart.keySet()){
                timeReq += timePerProjectPart.get(s);
            }
            return timeReq;
        }
        public void setReturnDate(DateCalendar dateCalendar){
            int days = this.getTimeRequired();
            Date today = dateCalendar.getDate();
            Calendar temp = Calendar.getInstance();
            temp.setTime(today);
            temp.add(Calendar.DATE,days);
            this.returnDate = temp.getTime();

        }

}
