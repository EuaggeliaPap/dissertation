package com.appcook.user.letscookapp.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CookerInfo extends Info {

    private String fname;
    private String lname;

    public CookerInfo() {
        super();
        fname = "";
        lname = "";
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

    @Override
    public String toString() {
        String s = super.toString() +" : "+ "CookerInfo{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
        return s;
    }
}
