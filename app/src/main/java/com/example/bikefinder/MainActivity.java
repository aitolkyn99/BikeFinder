package com.example.bikefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Bundle;

import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements SensorEventListener{

    Sensor sensor;
    TextView text;
    SensorManager sensorManager;
    SensorEventListener sensorEventListener;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1st location");
        arrayList.add("2nd location");
        arrayList.add("3rd location");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), MapsActivity.class);
                    startActivityForResult(intent,0);
                }
                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), MapsActivity2.class);
                    startActivityForResult(intent,1);
                }
                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), MapsActivity.class);
                    startActivityForResult(intent,2);
                }
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        text.setText("X: " + event.values[0] + "\nY: " + event.values[1] + "\nZ: " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
