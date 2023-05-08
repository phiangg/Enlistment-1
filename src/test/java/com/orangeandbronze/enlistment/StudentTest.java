package com.orangeandbronze.enlistment;

import org.junit.jupiter.api.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static com.orangeandbronze.enlistment.Period.*;
import static com.orangeandbronze.enlistment.Days.*;

public class StudentTest {

    final Schedule MTH_0830 = new Schedule(MTH, H0830);

    @Test
    void enlist_1_student_in_2_sections_no_conflict(){
        //Given 1 student with no sections & 2 sections w/ no conflict
        Student student = new Student(1);
        Section section1 = new Section("A", new Schedule(MTH, H0830));
        Section section2 = new Section("B", new Schedule(TF, H1300));
        //When the student enlists in both sections
        student.enlist(section1);
        student.enlist(section2);
        //the both sections should be part of the student's sections and no other sections
        Collection<Section> sections = student.getSections();
        assertAll(
                () -> assertTrue(sections.containsAll(List.of(section1, section2))), //check if the sections contains the section 1 & 2
                () -> assertEquals(2, sections.size())//the size is just 2
        );
    }
    @Test
    void enlist_1_student_in_2_sections_same_schedule(){
        //Given 1 student with no section & 2 sections with conflict (same sched)
        Student student = new Student(1);
        Section section1 = new Section("A", new Schedule(MTH, H0830));
        Section section2 = new Section("B", new Schedule(MTH, H0830));
        //When student enlists in both
        student.enlist(section1);
        //Then at the 2nd enlistment and exception will be thrown
        assertThrows(Exception.class, () -> student.enlist(section2));
    }
}
