package org.sda.javagdy4.petapp.model;

public enum Race {
    LABRADOR("Labi"),
    HUSKY("Niby wilk"),
    GOLDEN_RETREVER("Goldenek"),
    PUG("Mops"),
    JAMNIK("Jamnik"),
    CHIUHAUAHUA("Cziłałą");

    private final String commonName;

    Race(String commonName) {
        this.commonName = commonName;
    }

    public String getCommonName() {
        return commonName;
    }
}
