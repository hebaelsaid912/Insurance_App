package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Recent extends AppCompatActivity {
    LinearLayout carpolicies;
    LinearLayout healthpolicies;
    LinearLayout travelpolicies;
    LinearLayout firepolicies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        carpolicies = (LinearLayout) findViewById(R.id.carpolicies);
        healthpolicies = (LinearLayout) findViewById(R.id.healthpolicies);
        travelpolicies = (LinearLayout) findViewById(R.id.travelpolicies);
        firepolicies = (LinearLayout) findViewById(R.id.firepolicies);
        carpolicies.setOnClickListener(v -> {
            Intent intent = new Intent(Recent.this,CarPolicies.class);
            startActivity(intent);
        });
        healthpolicies.setOnClickListener(v -> {
            Intent intent = new Intent(Recent.this,HealthPolicies.class);
            startActivity(intent);
        });
        travelpolicies.setOnClickListener(v -> {
            Intent intent = new Intent(Recent.this,TravelPolicies.class);
            startActivity(intent);
        });
        firepolicies.setOnClickListener(v -> {
            Intent intent = new Intent(Recent.this,FirePolicies.class);
            startActivity(intent);
        });

    }
}