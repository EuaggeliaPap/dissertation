package com.appcook.user.letscookapp.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class AppInfo extends Info{

    private double version;

    public AppInfo() {
        super();
        version = 0.0;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @Override
    public String toString() {
        String s = super.toString() +" : "+ "AppInfo{" +
                "version=" + version +
                '}';
        return s;
    }
}
