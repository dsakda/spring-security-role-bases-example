package com.example.model;

public enum CustomerRole {

    ADMIN("ADMIN"),
    USER("USER"),
    CREATOR("CREATOR"),
    EDITOR("EDITOR");

    private String role;

    CustomerRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

