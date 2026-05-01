package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Course;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Course courseA = new Course("A");
        Course courseB = new Course("B");
        Course courseC = new Course("C");
        fillCourse(courseA, sc);
        fillCourse(courseB, sc);
        fillCourse(courseC, sc);
        
        
        sc.close();
    }

    public static void fillCourse(Course course, Scanner sc) {
        System.out.print("How many students for course " + course.getName() + "? ");
        int students = sc.nextInt();
        for (int i = 0; i < students; i++) {
            int studentId = sc.nextInt();
            course.addStudent(studentId);
        }
    }

}
