package com.orangeandbronze.enlistment;

import org.apache.commons.lang3.*;
import static org.apache.commons.lang3.Validate.*;

import java.util.Objects;




class Section {

    private final String sectionId;

    Section(String sectionId) {
        //validation
        notBlank(sectionId,"Section ID cannot be empty or whitespace");
        isTrue(StringUtils.isAlphanumeric(sectionId),
                "Section ID must be alphanumeric, was: " + sectionId);
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
