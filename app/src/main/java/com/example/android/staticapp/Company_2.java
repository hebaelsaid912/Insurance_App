package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Company_2 extends AppCompatActivity {
    LinearLayout carpolicies_AXA;
    LinearLayout healthpolicies_AXA;
    LinearLayout travelpolicies_AXA;
    LinearLayout firepolicies_AXA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_2);
        carpolicies_AXA = (LinearLayout) findViewById(R.id.carpolicies_AXA) ;
        carpolicies_AXA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car_Details car = new Car_Details();
                car.setFlagCar(2);
                Intent intent = new Intent(Company_2.this,Car_Details.class);
                startActivity(intent);
            }
        });
        healthpolicies_AXA = (LinearLayout) findViewById(R.id.healthpolicies_AXA) ;
        healthpolicies_AXA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Health_Details health = new Health_Details();
                health.setFlagHealth(2);
                Intent intent = new Intent(Company_2.this,Health_Details.class);
                startActivity(intent);
            }
        });
        travelpolicies_AXA = (LinearLayout) findViewById(R.id.travelpolicies_AXA) ;
        travelpolicies_AXA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Travel_Details travel = new Travel_Details();
                travel.setFlagTravel(2);
                Intent intent = new Intent(Company_2.this,Travel_Details.class);
                startActivity(intent);
            }
        });
        firepolicies_AXA = (LinearLayout) findViewById(R.id.firepolicies_AXA) ;
        firepolicies_AXA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fire_Details fire = new Fire_Details();
                fire.setFlagFire(2);
                Intent intent = new Intent(Company_2.this,Fire_Details.class);
                startActivity(intent);
            }
        });
    }
}