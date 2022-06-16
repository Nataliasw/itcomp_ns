package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCalendar {
    static final String DEFAULT_STARTING_DATE = "01/01/2020";
    public int tour;
    private String startingDate;
    public Calendar dateCalendar;
    public Date date1;




    public DateCalendar() throws ParseException {
        this.startingDate = DEFAULT_STARTING_DATE;
        this.tour = 0;
        this.date1= new SimpleDateFormat("dd/MM/yyyy").parse(this.startingDate);
        this.dateCalendar= Calendar.getInstance();
        this.dateCalendar.setTime(date1);
        this.tour = 1;

    }

    public void getDayOfWeek() {
        int day = dateCalendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
    }
    public void changeDate(){
        dateCalendar.add(Calendar.DATE, 1);
        tour += 1;

    }
    public Date getDate(){
        return dateCalendar.getTime();
    }



}
