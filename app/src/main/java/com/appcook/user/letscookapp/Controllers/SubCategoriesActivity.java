package com.appcook.user.letscookapp.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.appcook.user.letscookapp.Model.Category;
import com.appcook.user.letscookapp.R;

import java.util.ArrayList;

import static com.appcook.user.letscookapp.Controllers.MainActivity.glApp;

public class SubCategoriesActivity extends AppCompatActivity {

    private ListView list;
    private CustomListAdapter adapter;
    private ArrayList<Category> subCategories;
    int positionC;

    private void initXml(){
        list = (ListView) findViewById(R.id.LVScategories);
        positionC = getIntent().getIntExtra("CATEGORY_POSITION", 0);

        subCategories = glApp.user.getCategory().get(positionC).getSubcategory();//----
        adapter = new CustomListAdapter(SubCategoriesActivity.this, R.layout.item_of_list, subCategories);
        list.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categories);

        initXml();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                Intent intent = new Intent(SubCategoriesActivity.this, ListOfRecipesActivity.class);
                intent.putExtra("CATEGORY_POSITION", positionC);
                intent.putExtra("SCATEGORY_POSITION", position);
                startActivity(intent);
            }
        });
    }
}
