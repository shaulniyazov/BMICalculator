package com.example.bmi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import lib.Utils;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        PreferenceManager.setDefaultValues(this, R.xml.root_preferences, false);
//        Utils.setNightModeOnOffFromPreferenceValue(getApplicationContext(), getString(R.string.night_mode_key));

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}
