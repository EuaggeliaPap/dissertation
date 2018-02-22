package com.appcook.user.letscookapp.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.appcook.user.letscookapp.Model.AuthenticUser;
import com.appcook.user.letscookapp.R;

import static com.appcook.user.letscookapp.Controllers.MainActivity.glApp;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ((AuthenticUser)glApp.user).getAppInf().getDescription();
        ((AuthenticUser)glApp.user).getCookInf();
    }
}
