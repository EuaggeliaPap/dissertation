package com.appcook.user.letscookapp.Controllers;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;
import android.widget.TextView;

import com.appcook.user.letscookapp.Model.SubCategory;
import com.appcook.user.letscookapp.R;
import com.bumptech.glide.Glide;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import static com.appcook.user.letscookapp.Controllers.MainActivity.glApp;

public class RecipeActivity extends Activity {

    int positionC;
    int positionS;
    int positionR;

    private TextView title;
    private ImageView image;
    private HtmlTextView mdesc;
    private HtmlTextView steps;

    private void initXml(){
        image = (ImageView) findViewById(R.id.ivRimpath);
        title = (TextView) findViewById(R.id.tvRtitle);
        mdesc = (HtmlTextView) findViewById(R.id.html_textRmdesc);
        steps = (HtmlTextView) findViewById(R.id.html_textRsteps);
        image = (ImageView) findViewById(R.id.ivRimpath);

        positionC = getIntent().getIntExtra("C_POSITION", 0);
        positionS = getIntent().getIntExtra("S_POSITION", 0);
        positionR = getIntent().getIntExtra("R_POSITION", 0);

        title.setText(((SubCategory)glApp.simpleUser.getCategory().get(positionC).getSubcategory().get(positionS)).getRecipe().get(positionR).getRtitle());
        mdesc.setHtml(((SubCategory)glApp.simpleUser.getCategory().get(positionC).getSubcategory().get(positionS)).getRecipe().get(positionR).getMdesc());
        steps.setHtml(((SubCategory)glApp.simpleUser.getCategory().get(positionC).getSubcategory().get(positionS)).getRecipe().get(positionR).getSteps());
        Glide.with(RecipeActivity.this).load(((SubCategory)glApp.simpleUser.getCategory().get(positionC).getSubcategory().get(positionS)).getRecipe().get(positionR).getRimpath()).into(image);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        initXml();
    }
}
