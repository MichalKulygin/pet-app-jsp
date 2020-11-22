package org.sda.javagdy4.petapp.model;

public enum Race {
    LABRADOR("Labrador"),
    HUSKY("Haski"),
    GOLDEN_RETREVER("Goldie"),
    PUG("Mops"),
    JAMNIK("Jamnik"),
    CHIUHAUAHUA("Cziłała");

    private final String commonName;

    Race(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}
