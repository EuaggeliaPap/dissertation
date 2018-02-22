package com.appcook.user.letscookapp.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class SignUpActivity extends AppCompatActivity {

    private Button bsin;
    private EditText fname;
    private EditText lname;
    private EditText email;
    private EditText password;
    private String sfname;
    private String slname;
    private String semail;
    private String spassword;
    private Info appInfo;
    private Info cookerInfo;
    private boolean dataRetrived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bsin = (Button) findViewById(R.id.btnsin);
        fname = (EditText) findViewById(R.id.etfnamesin);
        lname = (EditText) findViewById(R.id.etlnamesin);
        email = (EditText) findViewById(R.id.etemailsin);
        password = (EditText) findViewById(R.id.etpasssin);

        cookerInfo = new CookerInfo();
        cookerInfo.setDescription("I am  .......");
        cookerInfo.setEmail("You can send us email for questions or anything else in aaaa@aaa.com");
        ((CookerInfo)cookerInfo).setFname("cdcds");
        ((CookerInfo)cookerInfo).setLname("cdccdcdsds");

        appInfo = new AppInfo();
        appInfo.setDescription("This Application .......");
        appInfo.setEmail("You can send us email for bugs or anything else in eua@mariou.com");
        ((AppInfo)appInfo).setVersion(1.0);


        bsin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        try {

                            sfname = fname.getText().toString();
                            slname = lname.getText().toString();
                            semail = email.getText().toString();
                            spassword = password.getText().toString();

                            Map<String, String> myMap = new HashMap<>();
                            myMap.put("fname", sfname);
                            myMap.put("lname", slname);
                            myMap.put("email", semail);
                            myMap.put("password", spassword);

//                            Map<String, String> myMap = new HashMap<>();
//                            myMap.put("fname", "e");
//                            myMap.put("lname", "m");
//                            myMap.put("email", "e@m.com");
//                            myMap.put("password", "m123");

                            JSONObject obj = new JSONObject(myMap);
                            ObjectMapper mapper = new ObjectMapper();
                            GetJson jsonGetter = new GetJson("http://192.168.17.156:8081/signup");
                            String jstrForMapping = jsonGetter.useJsonString(obj.toString());
                            System.out.println(jstrForMapping);
                            if(jstrForMapping.equals("1")){
                                Map<String, String> myMap2 = new HashMap<>();
                                myMap2.put("email", semail.toString());
                                myMap2.put("password", spassword.toString());


                                JSONObject obj2 = new JSONObject(myMap2);
                                ObjectMapper mapper2 = new ObjectMapper();
                                GetJson jsonGetter2 = new GetJson("http://192.168.17.156:8081/login");
                                String jstrForMapping2 = jsonGetter2.useJsonString(obj2.toString());

                                dataRetrived = false;
                                if(!(jstrForMapping2.equals("null"))) {
                                    glApp.user = new AuthenticUser();
                                    glApp.user = mapper2.readValue(jstrForMapping2, User.class);
                                    ((AuthenticUser) glApp.user).setAppInf((AppInfo) appInfo);
                                    ((AuthenticUser) glApp.user).setCookInf((CookerInfo) cookerInfo);
                                    dataRetrived = true;
                                }
                            }else if(jstrForMapping.equals("-1")){

                            }else{

                            }


                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }finally {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(dataRetrived){
                                        Intent intent = new Intent(SignUpActivity.this, MainMenuActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(SignUpActivity.this, "This email exists", Toast.LENGTH_LONG).show();
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
