package com.appcook.user.letscookapp.Model;

public abstract class Info {
    private String description;
    private String email;


    public Info() {
        this.description = "";
        this.email = "";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Info{" +
                "description='" + description + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
