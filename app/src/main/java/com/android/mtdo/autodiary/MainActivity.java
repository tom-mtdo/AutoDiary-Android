package com.android.mtdo.autodiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.mtdo.autodiary.controllers.DiaryService;

public class MainActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startDiaryService(View view){
        Log.i(TAG,"Start diary service");
        startService(new Intent(this, DiaryService.class));
    }

    public void stopDiaryService(View view){
        Log.i(TAG,"Stop diary service");
        stopService(new Intent(this, DiaryService.class));
    }
}
