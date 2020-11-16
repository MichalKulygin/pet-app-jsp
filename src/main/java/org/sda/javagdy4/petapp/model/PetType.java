package org.sda.javagdy4.petapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PetType {
    CAT("pussy"),
    DOG("dog");

    private final String displayName;

    PetType(String petType) {
        this.displayName = petType;
    }

    public String getDisplayName() {
        return displayName;
    }
}
