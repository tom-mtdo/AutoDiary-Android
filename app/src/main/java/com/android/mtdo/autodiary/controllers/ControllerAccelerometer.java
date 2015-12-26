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
    private final String TAG = this.getClass().getName();
    private final Sensor mAcce;
    private Accelerometer mData;

    public ControllerAccelerometer(SensorManager sensorManager) {
        mAcce = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void registerListener(SensorManager sensorManager){
        sensorManager.registerListener(this,mAcce,SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void unregisterListener(SensorManager sensorManager){
        sensorManager.unregisterListener(this, mAcce);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        mData = new Accelerometer();
        mData.setAcceX(event.values[0]);
        mData.setAcceY(event.values[1]);
        mData.setAcceZ(event.values[2]);
        mData.setSensorTimeStamp(event.timestamp);
        mData.setCpuTimeStamp(System.currentTimeMillis());

        storeData();
    }

    public void storeData(){
        Log.i(TAG,"Data: " + mData.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
