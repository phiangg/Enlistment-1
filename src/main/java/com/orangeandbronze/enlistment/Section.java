package com.orangeandbronze.enlistment;

import org.apache.commons.lang3.*;
import static org.apache.commons.lang3.Validate.*;

import java.util.Objects;




class Section {

    private final String sectionId;
    private final Schedule schedule;

    Section(String sectionId, Schedule schedule) {

        //validation
        notBlank(sectionId,"Section ID cannot be empty or whitespace");
        isTrue(StringUtils.isAlphanumeric(sectionId),
                "Section ID must be alphanumeric, was: " + sectionId);
        notNull(schedule);
        /*if (sectionId == null){
            throw new NullPointerException("Section ID cannot be null");
        }
        if (sectionId.trim().equals("")){
            throw new IllegalArgumentException("Section ID was empty or whitespace");
        }
        if (!StringUtils.isAlphanumeric(sectionId)){
            throw new IllegalArgumentException("Section ID must be alphanumeric, was: " + sectionId);
        }*/
        this.sectionId = sectionId;
        this.schedule = schedule;
    }

    boolean hasConflict(Section other){
        return this.schedule.equals(other.schedule);
    }

    void checkForConflict(Section other){
        notNull(other);
        if(this.schedule.equals(other.schedule)){
            throw new ScheduleConflictException("Section conflict between " + this + " and "
                    + other + " at schedule " + schedule);
        }
    }

    Schedule getSchedule(){
        return schedule;
    }

    @Override
    public String toString(){
        return sectionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(sectionId, section.sectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionId);
    }
}
