package org.demo.seminar03_20240529.code.enums;

// Season currentSeason = Season.SUMMER;
public enum Day {
    MONDAY("Work day"),
    TUESDAY("Work day"),
    WEDNESDAY("Work day"),
    THURSDAY("Work day"),
    FRIDAY("Weekend is coming!"),
    SATURDAY("Weekend"),
    SUNDAY("Weekend");

    private final String description;

    Day(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}