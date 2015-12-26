package com.android.mtdo.autodiary.controllers;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class ServiceDiary extends Service {

    private final String    TAG = this.getClass().getName();
    private Timer           timer;
    private final String    timerName="DiaryTimer";

    private SensorManager   sensorManager;
    private ControllerAccelerometer cAccelerometer;

    private TimerTask       timerTask = new TimerTask() {
        @Override
        public void run() {
            doService();
        }
    };

    public void doService(){
        Log.i(TAG, "ServiceDiary is working");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service starting...");
        timer = new Timer(timerName);
        timer.schedule(timerTask, 1000L, 30 * 1000L);
        startAutoDiary();
        Log.i(TAG, "Service started");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroying...");
        timer.cancel();
        timer = null;
        stopAutoDiary();
        Log.i(TAG, "Service destroyed");
    }

    private void stopAutoDiary() {
        cAccelerometer.unregisterListener(sensorManager);
    }

    public void startAutoDiary(){

        sensorManager  = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        cAccelerometer = new ControllerAccelerometer(sensorManager);
        //  thread here
        cAccelerometer.registerListener(sensorManager);
    }
}
