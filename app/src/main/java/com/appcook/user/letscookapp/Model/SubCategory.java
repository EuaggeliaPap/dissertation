package com.appcook.user.letscookapp.Model;

import java.util.ArrayList;
import java.util.List;

public class SubCategory extends Category{
    private List<Recipe> recipe;

    public SubCategory() {
        super();
        this.recipe = new ArrayList<>();
    }

    public List<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Recipe> recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
         String s= super.toString() +" \n "+ "SubCategory{" +
                "recipe=" + recipe +
                '}';
        return s;
    }
}
