package com.appcook.user.letscookapp.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Category.class, name = "CategoryTypeId"),
        @JsonSubTypes.Type(value = SubCategory.class, name = "SubcategoryTypeId"),
})
public class Category {

    private int catid;
    private String cattitle;
    private String catimpath;
    private ArrayList<Category> subcategory;

    public Category() {
        this.catid = 0;
        this.cattitle = "";
        this.catimpath = "";
        this.subcategory = new ArrayList<>();
    }


    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getCattitle() {
        return cattitle;
    }

    public void setCattitle(String cattitle) {
        this.cattitle = cattitle;
    }

    public String getCatimpath() {
        return catimpath;
    }

    public void setCatimpath(String catimpath) {
        this.catimpath = catimpath;
    }

    public ArrayList<Category> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(ArrayList<Category> subcategory) { this.subcategory = subcategory; }

    @Override
    public String toString() {
        return "Category{" +
                "cattitle='" + cattitle + '\'' +
                ", catimpath='" + catimpath + '\'' +
                ", subcategory=" + subcategory +
                '}';
    }
}
