package org.sda.javagdy4.petapp.model;

public enum OwnerSex {
    MALE ("facecik"),
    FEMALE ("babeczka");

    private final String commonName;

    OwnerSex(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}
