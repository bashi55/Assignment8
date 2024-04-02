import java.util.*;

class Project {
    private String name;
    private int daysTaken;

    public Project(String name, int daysTaken) {
        this.name = name;
        this.daysTaken = daysTaken;
    }

    public String getName() {
        return name;
    }

    public int getDaysTaken() {
        return daysTaken;
    }
}

class Student {
    private String name;
    private List<Project> projects;

    public Student(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public int getCompletedOnTimeCount() {
        int count = 0;
        for (Project project : projects) {
            if (project.getDaysTaken() <= 0) {
                count++;
            }
        }
        return count;
    }

    public int getCompletedLateCount() {
        int count = 0;
        for (Project project : projects) {
            if (project.getDaysTaken() > 0) {
                count++;
            }
        }
        return count;
    }

    public int getCompletedEarlyCount() {
        int count = 0;
        for (Project project : projects) {
            if (project.getDaysTaken() < 0) {
                count++;
            }
        }
        return count;
    }

    public double getAverageDaysTaken() {
        int totalDaysTaken = 0;
        for (Project project : projects) {
            totalDaysTaken += project.getDaysTaken();
        }
        return (double) totalDaysTaken / projects.size();
    }
}

public class Main {
    public static void main(String[] args) {
        List<Project> projects1 = Arrays.asList(
                new Project("Project1", 0),
                new Project("Project2", 5),
                new Project("Project3", -2)
        );
        List<Project> projects2 = Arrays.asList(
                new Project("Project4", 2),
                new Project("Project5", -3),
                new Project("Project6", -1)
        );

        Student student1 = new Student("Alice", projects1);
        Student student2 = new Student("Bob", projects2);

        System.out.println("Student: " + student1.getName());
        System.out.println("Projects completed on time: " + student1.getCompletedOnTimeCount());
        System.out.println("Projects completed late: " + student1.getCompletedLateCount());
        System.out.println("Projects completed early: " + student1.getCompletedEarlyCount());
        System.out.println("Average days taken per project: " + student1.getAverageDaysTaken());

        System.out.println("\nStudent: " + student2.getName());
        System.out.println("Projects completed on time: " + student2.getCompletedOnTimeCount());
        System.out.println("Projects completed late: " + student2.getCompletedLateCount());
        System.out.println("Projects completed early: " + student2.getCompletedEarlyCount());
        System.out.println("Average days taken per project: " + student2.getAverageDaysTaken());
    }
}
