package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class ProjectGenerator {
    public LinkedList<Project> projectListAll;
    public LinkedList<Project> projectListCurrent;
    public int numberOfProjects;

    public ProjectGenerator() {
        this.projectListAll = new LinkedList<Project>();
        this.projectListCurrent = new LinkedList<Project>();

    }

    public void getAllProjects(){
//Easy Projects;
        Project p1 = new Project(1,"ProjectX","Azurro",3000.0,10000.0,30,"easy");
        p1.addTimeToParts(2,3,0,0,0,0);
        projectListAll.add(p1);

        Project p2 = new Project(2,"Twitter","Fernweh",300.0,10000.0,15,"easy");
        p2.addTimeToParts(0,3,0,0,0,0);
        projectListAll.add(p2);
        Project p3 = new Project(3,"TuttiSanti","Azurro",500.0,14000.0,10,"easy");
        p3.addTimeToParts(0,3,0,0,0,0);
        projectListAll.add(p3);

        Project p4 = new Project(4,"BoboWozki","Karmelkowo",1000.0,1000.0,15,"easy");
        p4.addTimeToParts(0,0,6,0,0,0);
        projectListAll.add(p4);
//Medium Projects
        Project p5 = new Project(5,"Karmelki","Karmelkowo",2000.0,20000.0,30,"medium");
        p5.addTimeToParts(2,3,0,0,0,0);
        projectListAll.add(p5);

        Project p6 = new Project(6,"Pauschalreisen.com","Fernweh",2000.0,23000.0,15,"medium");
        p6.addTimeToParts(0,3,0,4,0,0);
        projectListAll.add(p6);

        Project p7 = new Project(7,"ReisewelleCo","Fernweh",1000.0,23000.0,15,"medium");
        p7.addTimeToParts(2,3,0,0,3,0);
        projectListAll.add(p7);

        Project p8 = new Project(8,"MarineroSosse","Azurro",2000.0,23000.0,15,"medium");
        p8.addTimeToParts(0,3,0,0,0,2);
        projectListAll.add(p8);
//Hard Projects
        Project p9 = new Project(9,"Cukierki","Karmelkowo",4000.0,31000.0,15,"hard");
        p9.addTimeToParts(2,3,0,2,0,0);
        projectListAll.add(p9);

        Project p10 = new Project(10,"Lubisie","Karmelkowo",4000.0,40000.0,15,"hard");
        p10.addTimeToParts(3,3,1,4,0,0);
        projectListAll.add(p10);

        Project p11 = new Project(11,"AbgelegenesGebiet.com","Fernweh",4000.0,41000.0,15,"hard");
        p11.addTimeToParts(0,3,2,5,0,2);
        projectListAll.add(p11);

        Project p12 = new Project(12,"CarbonerroXXL","Azurro",4000.0,40000.0,15,"hard");
        p12.addTimeToParts(4,2,4,0,1,2);
        projectListAll.add(p12);

        //System.out.println(projectListAll);

    }


    public void generateStartingProjects(){
        Random rand = new Random();
        int upperbound = 12;
        for(int i = 0; projectListCurrent.size() <= 3 ; i++){
            int int_random = rand.nextInt(upperbound);
            Project projectToAdd = projectListAll.get(int_random);
            if(projectToAdd.level.equals("medium") || projectToAdd.level.equals("easy")) {
                projectListCurrent.add(projectToAdd);
            }
        }
        //System.out.println(projectListCurrent);
    }

    public void addProjectToList(){
        Random rand = new Random();
        int upperbound = 12;
        int int_random = rand.nextInt(upperbound);
        Project project = projectListAll.get(int_random);
        boolean isAdded = false;
        while(!isAdded) if (!projectListCurrent.contains(project)) {
            projectListCurrent.add(project);
            isAdded = true;
            System.out.println("New Project added to available projects list.");
        }


    }
}