package com.appcook.user.letscookapp.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleUser.class, name = "SimpleUserTypeId"),
        @JsonSubTypes.Type(value = AuthenticUser.class, name = "AuthenticUserTypeId")
})
public abstract class User {

    private String uemail;
    private List<Category> category;

    public User() {
        this.uemail = "";
        this.category = new ArrayList<>();
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "User{" +
                "uemail='" + uemail + '\'' +
                ", category=" + category +
                '}';
    }
}
