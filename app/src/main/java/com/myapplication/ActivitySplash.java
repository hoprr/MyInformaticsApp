package com.myapplication;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.myapplication.Model.User_Accounts;
import com.myapplication.Utility.PrefManager;
import com.google.gson.Gson;


public class ActivitySplash extends AppCompatActivity {
    private static final String TAG = "Splash Screen";
    PrefManager pref;
    String userDataString = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        pref = new PrefManager(this);
        userDataString = pref.getUserData();




        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    pref= new PrefManager(ActivitySplash.this);
                    if (pref.isFirstTimeLaunch()) {
                        startActivity(new Intent(ActivitySplash.this, ActivityWelcome.class));
                        Log.d("#11", "first time launch");

                    }
                    //else if (Co_Name.equals(""))
                    else if  (userDataString.equals("")){
                        Intent intent = new Intent(ActivitySplash.this, DashboardActivity.class);
                        Log.d("#11", "value: username:: password and username  is empty");
                        startActivity(intent);
                    }

                  /*  else {
                        startActivity(new Intent(ActivitySplash.this, ActivityCategory.class));
                        Log.d("#11", "value: username:: password and username  is  NOT empty");


                    }*/


                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause () {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}