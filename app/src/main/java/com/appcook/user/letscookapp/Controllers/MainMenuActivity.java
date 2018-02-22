package com.appcook.user.letscookapp.Controllers;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import com.appcook.user.letscookapp.Model.Recipe;
import com.appcook.user.letscookapp.Model.SubCategory;
import com.appcook.user.letscookapp.R;
import com.bumptech.glide.Glide;

import static com.appcook.user.letscookapp.Controllers.MainActivity.glApp;

public class MainMenuActivity extends AppCompatActivity {

    private Button bcategories;
    private Button bfaqs;
    private Button binfo;
    private Button bprofile;
    private RelativeLayout llrecipe;
    private ImageView ivthisRec;
    private TextView tvthisRec;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        bcategories = (Button) findViewById(R.id.bcategoriesmma);
        bfaqs = (Button) findViewById(R.id.bfaqsmma);
        binfo = (Button) findViewById(R.id.binfomma);
        bprofile = (Button) findViewById(R.id.bprofilemma);
        llrecipe = (RelativeLayout) findViewById (R.id.Llayoutrecipemma);
        ivthisRec = (ImageView) findViewById (R.id.ivthisrec);
        tvthisRec = (TextView) findViewById (R.id.tvthisrecipe);


        bcategories.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        bfaqs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, FaqsActivity.class);
                startActivity(intent);
            }
        });

        binfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        bprofile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        Random rand = new Random();
        final int  randcat = rand.nextInt(4) + 0;
        final int randsub = rand.nextInt(glApp.user.getCategory().get(randcat).getSubcategory().size())+0;
        final int randrec = rand.nextInt(((SubCategory)glApp.user.getCategory().get(randcat).getSubcategory().get(randsub)).getRecipe().size())+0;

        Recipe thisrec = ((SubCategory)glApp.user.getCategory().get(randcat).getSubcategory().get(randsub)).getRecipe().get(randrec);

        String thisRecTitle = ((SubCategory)glApp.user.getCategory().get(randcat).getSubcategory().get(randsub)).getRecipe().get(randrec).getRtitle();
        String thisRecImage = ((SubCategory)glApp.user.getCategory().get(randcat).getSubcategory().get(randsub)).getRecipe().get(randrec).getRimpath();

        tvthisRec.append("\n"+ thisRecTitle);
        Glide.with(this)
                .load(thisRecImage)
                .into(ivthisRec);
        llrecipe.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, RecipeActivity.class);
                intent.putExtra("C_POSITION", randcat);
                intent.putExtra("S_POSITION", randsub);
                intent.putExtra("R_POSITION", randrec);
                startActivity(intent);
            }
        });


    }

}
