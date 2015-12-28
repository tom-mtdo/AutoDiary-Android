package com.android.mtdo.autodiary.controllers;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import com.android.mtdo.autodiary.models.Accelerometer;

/**
 * Created by thangdo on 26/12/2015.
 *
 * Collect acce data and put in db
 *
 */
public class ControllerAccelerometer implements SensorEventListener{
    private final String    TAG = this.getClass().getName();
    private final Sensor    mAcce;
    private Accelerometer   mData = new Accelerometer();
    private SensorEvent     sensorEvent;
    private Thread          mCurrentThread;

    private Runnable dataProcessor = new Runnable(){
        @Override
        public void run() {
            // Moves the current Thread into the background
            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

            storeData();
            Log.i(TAG, "Data: " + mData.toString());

            processData();
            // Thread.currentThread();
        }
    };

    public void processData() {
        Log.i(TAG,"Data processed");
    }

    public void storeData(){
        mData.setAcceX(sensorEvent.values[0]);
        mData.setAcceY(sensorEvent.values[1]);
        mData.setAcceZ(sensorEvent.values[2]);
        mData.setSensorTimeStamp(sensorEvent.timestamp);
        mData.setCpuTimeStamp(System.currentTimeMillis());

        Log.i(TAG,"Data stored");
    }

    public ControllerAccelerometer(SensorManager sensorManager) {
        mAcce = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void registerListener(SensorManager sensorManager){
        sensorManager.registerListener(this, mAcce, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregisterListener(SensorManager sensorManager){
        sensorManager.unregisterListener(this, mAcce);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        sensorEvent = event;
        dataProcessor.run();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public Thread getmCurrentThread() {
        return mCurrentThread;
    }

    public void setmCurrentThread(Thread mCurrentThread) {
        this.mCurrentThread = mCurrentThread;
    }
}
