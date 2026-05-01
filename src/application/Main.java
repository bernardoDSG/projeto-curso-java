package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Course;
import model.entities.Instructor;
import model.entities.Student;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Instructor instructor = new Instructor("Alex");
        Course courseA = new Course("A");
        Course courseB = new Course("B");
        Course courseC = new Course("C");
        instructor.addCourse(courseA, 0);
        instructor.addCourse(courseB, 1);
        instructor.addCourse(courseC, 2);
        addStudents(courseA, sc);
        addStudents(courseB, sc);
        addStudents(courseC, sc);
        System.out.println("Total students: " + 
        instructor.getTotalStudents());
        sc.close();    
    }

    public static void addStudents(Course course, Scanner sc) {
        System.out.print("How many students for course " + course.getName() + "? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            course.addStudent(new Student(sc.nextInt()));
        }
    }
}
