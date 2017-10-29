package com.ambulance;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.ambulance.volley.DataCallback;
import com.ambulance.volley.DataManager;

import org.json.JSONObject;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        final Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {
                    Intent intent;
                    PrefManager manager=new PrefManager(getApplicationContext());
                    if (DBHandler.isLoggedIn(getApplicationContext())) {
                        intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else {

                        intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);

                    }


                }
            }

        };
        timer.start();
    }

   /* private void setUpLocale() {
        Locale locale = new Locale(PrefManager.getLanguage(SplashActivity.this));
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

    }*/

    private void getUserType() {
        DataManager dataManager = new DataManager(this);
        DataCallback callback = new DataCallback() {
            @Override
            public void onError(String message, Integer... statuscode) {
                super.onError(message, statuscode);

            }

            @Override
            public void onError(String message) {
                super.onError(message);
            }

            @Override
            public void onResponse(JSONObject response) {
                super.onResponse(response);
                Log.d("ResponseType", response.toString());

            }
        };
        dataManager.getResults(callback);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
