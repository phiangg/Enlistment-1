package com.orangeandbronze.enlistment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

class Student {

    private final int studentNumber;
    //Collection represent one is to many
    private final Collection<Section> sections;

    //Constructor
    Student(int studentNumber, Collection<Section> sections) {
        if (studentNumber < 0){
            throw new IllegalArgumentException("Student Number must be non-negative, was: " + studentNumber);
        }
        if (sections == null){
            throw new NullPointerException("Sections cannot be null");
        }
        this.studentNumber = studentNumber;
        this.sections = new ArrayList<>(sections);
        this.sections.removeIf(Objects::isNull); //remove any nulls in the collection
    }
    //Enlist the student in the section
    void enlist(Section section){
        if (section == null){
            throw new NullPointerException("Section cannot be null");
        }
        sections.add(section);
    }

    @Override
    public String toString(){
        return "Student Number " + studentNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber);
    }
}
