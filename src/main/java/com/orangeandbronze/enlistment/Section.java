package com.orangeandbronze.enlistment;

import java.util.Objects;

class Section {

    private final String sectionId;

    Section(String sectionId) {
        if (sectionId == null){ //validation
            throw new NullPointerException("Section ID cannot be null");
        }
        if (sectionId.trim().equals("")){ //avoid empty string, whitespace/blank
            throw new IllegalArgumentException("Section ID was empty or whitespace");
        }
        if (sectionId.matches("regex")){ //make sure that student ID is alphanumeric
            throw new IllegalArgumentException("Section ID must be alphanumeric, was: " + sectionId);
        }
        this.sectionId = sectionId;
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
