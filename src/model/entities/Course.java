package model.entities;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private String name;
    private Set<Integer> students = new HashSet<>();

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Integer studentId) {
        students.add(studentId);
    }

    
}
