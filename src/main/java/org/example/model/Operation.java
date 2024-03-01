package org.example.model;

public enum Operation {

    G("Rotate Left"),
    D("Rotate Right"),
    A("Move in current direction");
    private String desc;

    Operation(String desc) {
        this.desc=desc;
    }
}
