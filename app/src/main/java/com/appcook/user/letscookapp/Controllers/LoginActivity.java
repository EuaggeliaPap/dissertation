package com.appcook.user.letscookapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appcook.user.letscookapp.Model.AppInfo;
import com.appcook.user.letscookapp.Model.AuthenticUser;
import com.appcook.user.letscookapp.Model.CookerInfo;
import com.appcook.user.letscookapp.Model.Info;
import com.appcook.user.letscookapp.Model.User;
import com.appcook.user.letscookapp.R;
import com.appcook.user.letscookapp.Services.GetJson;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.appcook.user.letscookapp.Controllers.MainActivity.glApp;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private Editable gemail;
    private Editable gpassword;
    private Button forgotPassword;
    private Button signin;
    private Info appInfo;
    private Info cookerInfo;
    private boolean dataRetrived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.ETusername);
        password = (EditText) findViewById(R.id.ETpassword);
        login = (Button) findViewById(R.id.Blogin);
        forgotPassword = (Button) findViewById(R.id.btnforgotPassword);
        signin = (Button) findViewById(R.id.btnsignin);

        appInfo = new AppInfo();
        appInfo.setDescription("This Application .......");
        appInfo.setEmail("You can send us email for bugs or anything else in eua@mariou.com");
        ((AppInfo)appInfo).setVersion(1.0);

        cookerInfo = new CookerInfo();
        cookerInfo.setDescription("I am  .......");
        cookerInfo.setEmail("You can send us email for questions or anything else in aaaa@aaa.com");
        ((CookerInfo)cookerInfo).setFname("cdcds");
        ((CookerInfo)cookerInfo).setLname("cdccdcdsds");

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, getString(R.string.Under_Construction), Toast.LENGTH_LONG).show();
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        try {

                            gemail = email.getText();
                            gpassword = password.getText();

//                            Map<String, String> myMap = new HashMap<>();
//                            myMap.put("email", gemail.toString());
//                            myMap.put("password", gpassword.toString());

                            Map<String, String> myMap = new HashMap<>();
                            myMap.put("email", "eua@mariou.com");
                            myMap.put("password", "marios123");

                            JSONObject obj = new JSONObject(myMap);
                            ObjectMapper mapper = new ObjectMapper();
                            GetJson jsonGetter = new GetJson("http://192.168.17.156:8081/login");
                            //String ap = jsonGetter.useJsonString(obj.toString());
                            String jstrForMapping = jsonGetter.useJsonString(obj.toString());

                            dataRetrived = false;
                            if(!(jstrForMapping.equals("null"))) {
                                glApp.user = new AuthenticUser();
                                glApp.user = mapper.readValue(jstrForMapping, User.class);
                                ((AuthenticUser) glApp.user).setAppInf((AppInfo) appInfo);
                                ((AuthenticUser) glApp.user).setCookInf((CookerInfo) cookerInfo);
                                dataRetrived = true;
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }finally {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(dataRetrived){
                                        Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(LoginActivity.this, "Incorrect credentials", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                        }
                    }
                }).start();
            }
        });



    }
}