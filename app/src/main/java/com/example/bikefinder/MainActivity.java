package com.example.bikefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.hardware.SensorManager;
import android.hardware.SensorEventListener;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
