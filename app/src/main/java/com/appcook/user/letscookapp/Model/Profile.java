package com.appcook.user.letscookapp.Model;

public class Profile {

    private String fname;
    private String lname;
    private String email;
    //private String icon;


    public Profile() {
        this.fname = "";
        this.lname = "";
        this.email = "";
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
