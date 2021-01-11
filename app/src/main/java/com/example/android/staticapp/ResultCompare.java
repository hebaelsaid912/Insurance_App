package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class ResultCompare extends AppCompatActivity {
    LinearLayout CarCompareAction;
    LinearLayout HealthCompareAction;
    LinearLayout TravelCompareAction;
    LinearLayout FireCompareAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_compare);
        CarCompareAction = (LinearLayout) findViewById(R.id.carCompareAction);
        HealthCompareAction = (LinearLayout) findViewById(R.id.healthCompareAction);
        TravelCompareAction = (LinearLayout) findViewById(R.id.travelCompareAction);
        FireCompareAction = (LinearLayout) findViewById(R.id.fireCompareAction);
        CarCompareAction.setOnClickListener(v -> {
            Intent intent = new Intent(ResultCompare.this,Compare_Car.class);
            startActivity(intent);
        });
        HealthCompareAction.setOnClickListener(v -> {
            Intent intent = new Intent(ResultCompare.this,Compare_Health.class);
            startActivity(intent);
        });
        TravelCompareAction.setOnClickListener(v -> {
            Intent intent = new Intent(ResultCompare.this,Compare_Travel.class);
            startActivity(intent);
        });
        FireCompareAction.setOnClickListener(v -> {
            Intent intent = new Intent(ResultCompare.this,Compare_Fire.class);
            startActivity(intent);
        });
    }
}