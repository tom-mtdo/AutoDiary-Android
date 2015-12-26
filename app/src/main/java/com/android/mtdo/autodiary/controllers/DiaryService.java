package com.android.mtdo.autodiary.controllers;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class DiaryService extends Service {

    private final String    TAG = this.getClass().getName();
    private Timer           timer;
    private final String    timerName="DiaryTimer";

    private TimerTask       timerTask = new TimerTask() {
        @Override
        public void run() {
            doService();
        }
    };

    public DiaryService() {
    }

    public void doService(){
        Log.i(TAG, "DiaryService is working");
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
        Log.i(TAG, "Service started");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroying...");
        timer.cancel();
        timer = null;
        Log.i(TAG, "Service destroyed");
    }
}
