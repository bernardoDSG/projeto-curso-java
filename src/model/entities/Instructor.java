package model.entities;


import java.util.HashSet;
import java.util.Set;

public class Instructor {
    private String name;
    private Course[] courses = new Course[3];

    public Instructor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCourse(Course course, int index) {
        courses[index] = course;
    }

    public Integer getTotalStudents() {
        Set<Student> union = new HashSet<>();
        for(int i = 0; i < courses.length - 1; i++) {
           union.addAll(courses[i].getUnionStudents(courses[i + 1]));
        }
        return union.size();
    }
}
