package com.example.bikefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Bundle;

import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements SensorEventListener{

    Sensor sensor;
    TextView text;
    SensorManager sensorManager;
    SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        text = findViewById(R.id.hi);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        text.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
