package com.daraa.androidwarner;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    static boolean status;
    static TextView mSpeed;

    Location mLastLocation;
    LocationManager mLocationManager;

    static long startTime, endTime;
    static ProgressDialog mProgressDialog;
    static int p=0;

    LocationService mService;

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LocationService.LocalBinder binder  = (LocationService.LocalBinder) service;
            mService = binder.getService();
            status = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            status = false;
        }
    };

    @Override
    protected void onDestroy() {
        if(status){
        unbindService();
        }
        super.onDestroy();
    }

    public void unbindService() {
        if(!status){
            Intent i = new Intent(getApplicationContext(),LocationService.class);
            unbindService(sc);
            status = false;
        }
    }

    @Override
    public void onBackPressed() {
        if(!status){
            super.onBackPressed();
        }
        else{
            moveTaskToBack(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mSpeed = (TextView)findViewById(R.id.display_speed);

        
    }
}
