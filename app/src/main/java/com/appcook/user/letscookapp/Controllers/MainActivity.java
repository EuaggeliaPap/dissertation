package com.appcook.user.letscookapp.Controllers;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.appcook.user.letscookapp.Model.User;
import com.appcook.user.letscookapp.R;
import com.appcook.user.letscookapp.Services.GetJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.rahatarmanahmed.cpv.CircularProgressView;

public class MainActivity extends AppCompatActivity {

    private Button butuser;
    private Button butguest;
    private ViewFlipper viewFlipper;
    private Animation fadeIn, fadeOut;
    public static UserGlobalApplication glApp;

    private void initGlApp(){
        glApp.progressView = (CircularProgressView) findViewById(R.id.progress_view);
        glApp.overlayDialog = new Dialog(MainActivity.this , android.R.style.Theme_Panel);
        glApp.overlayDialog.setCancelable(false);
    }

    private void initXml(){
        butuser = (Button) findViewById(R.id.blogin);
        butguest = (Button) findViewById(R.id.bguest);

        //---------------------------------- Initialize SlideShow ----------------------------------
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setInAnimation(fadeIn);
        viewFlipper.setOutAnimation(fadeOut);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getApplicationContext().getString(R.string.mainA_model).startsWith(Build.MODEL.toString())) {
            setContentView(R.layout.activity_main);
            glApp = ((UserGlobalApplication) getApplicationContext());
            initGlApp();

            initXml();

            butuser.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, getString(R.string.Under_Construction), Toast.LENGTH_LONG).show();
                }
            });

            butguest.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(glApp.isNetworkAvailable()) {
                        glApp.progressView.setVisibility(View.VISIBLE);
                        glApp.progressView.startAnimation();
                        updateUserGlobalApplication(false);
                    }else{
                        Toast.makeText(MainActivity.this, getString(R.string.Network_Connection_Problem), Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            setContentView(R.layout.activity_main_no_play);
        }
    }
    public void updateUserGlobalApplication(final boolean isForTest){
        new Thread(new Runnable() {
            public void run() {
                try {
                    String jstrForMapping;
                    ObjectMapper mapper = new ObjectMapper();
                    GetJson jsonGetter = new GetJson("http://192.168.1.3:8081/allforguest");
                    jstrForMapping = jsonGetter.useJsonString("");

                    glApp.simpleUser = mapper.readValue(jstrForMapping, User.class);
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, getString(R.string.Fetc_Data_Problem), Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            glApp.progressView.setVisibility(View.GONE);
                            glApp.overlayDialog.cancel();
                            if(!isForTest){
                                Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        }).start();
    }
}