package com.android.mtdo.autodiary.controllers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by thangdo on 26/12/2015.
 */
public class BootReceiver extends BroadcastReceiver {
    private final String TAG = this.getClass().getName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Start diary service");
        context.startService(new Intent(context, DiaryService.class));
    }
}
