package com.appcook.user.letscookapp.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.appcook.user.letscookapp.Model.Recipe;
import com.appcook.user.letscookapp.Model.SubCategory;
import com.appcook.user.letscookapp.R;

import java.util.List;

import static com.appcook.user.letscookapp.Controllers.MainActivity.glApp;

public class ListOfRecipesActivity extends AppCompatActivity {

    private ListView list;
    private RecipeAdapter adapter;
    private List<Recipe> recipes;
    private int positionC;
    private int positionS;

    private void initXml(){
        list = (ListView) findViewById(R.id.LVRecipes);

        positionC = getIntent().getIntExtra("CATEGORY_POSITION", 0);
        positionS = getIntent().getIntExtra("SCATEGORY_POSITION", 0);

        recipes = ((SubCategory)glApp.user.getCategory().get(positionC).getSubcategory().get(positionS)).getRecipe();//----
        adapter = new RecipeAdapter(ListOfRecipesActivity.this, R.layout.item_of_list, recipes);
        list.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_recipes);

        initXml();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int positionR, long arg3) {
                Intent intent = new Intent(ListOfRecipesActivity.this, RecipeActivity.class);
                intent.putExtra("C_POSITION", positionC);
                intent.putExtra("S_POSITION", positionS);
                intent.putExtra("R_POSITION", positionR);
                startActivity(intent);
            }
        });
    }
}
