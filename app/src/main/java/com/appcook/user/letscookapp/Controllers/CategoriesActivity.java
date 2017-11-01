package com.appcook.user.letscookapp.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.appcook.user.letscookapp.R;

import static com.appcook.user.letscookapp.Controllers.MainActivity.glApp;

public class CategoriesActivity extends AppCompatActivity {

    private ListView list;
    private CustomListAdapter adapter;

    private void initXml(){
        list = (ListView) findViewById(R.id.LVcategories);
        adapter = new CustomListAdapter(CategoriesActivity.this, R.layout.item_of_list, glApp.simpleUser.getCategory());
        list.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        initXml();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3) {
                Intent intent = new Intent(CategoriesActivity.this, SubCategoriesActivity.class);
                intent.putExtra("CATEGORY_POSITION", position);
                startActivity(intent);
            }
        });
    }
}
