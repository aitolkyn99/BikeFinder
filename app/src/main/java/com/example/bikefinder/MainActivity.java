package com.example.bikefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
=======
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
>>>>>>> 6612ed6a6e8cbf7cb2ce6e09bec3a537f7b1cf1f
import android.os.Bundle;
import android.util.Log;

<<<<<<< HEAD
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
=======
>>>>>>> 6612ed6a6e8cbf7cb2ce6e09bec3a537f7b1cf1f
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;




<<<<<<< HEAD
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
=======



public class MainActivity extends AppCompatActivity{
    LocationManager locationManager;
    LocationListener locationListener;
>>>>>>> 6612ed6a6e8cbf7cb2ce6e09bec3a537f7b1cf1f

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                Log.i("location manager set", "yes");
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,  10000, 0, locationListener);
            }
            else{
                Log.i("Location pERmission", "denied");
            }
        }
    }
    
   ListView listView;
  
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler myDb;
        myDb = new DatabaseHandler(this);

        locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                 Log.i("Location", location.toString());
                 Log.i("Speed", "" + location.getSpeed());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
          
          
          listView = (ListView)findViewById(R.id.listview);

          ArrayList<String> arrayList = new ArrayList<>();

          arrayList.add("1st location");
          arrayList.add("2nd location");
          arrayList.add("3rd location");

          ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

          listView.setAdapter(arrayAdapter);
          
          
          
        };
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            Log.i("Location Permission", "Requested");
        }else{
            Log.i("Location Permission", "Already Granted");
        }
    }

}

