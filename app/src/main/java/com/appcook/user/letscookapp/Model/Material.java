package com.appcook.user.letscookapp.Model;

public class Material {
    private String name;

    public Material(){
        this.name= "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                '}';
    }
}
