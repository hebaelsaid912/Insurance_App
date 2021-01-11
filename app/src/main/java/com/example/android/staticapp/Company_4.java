package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Company_4 extends AppCompatActivity {
    LinearLayout carpolicies_Gulf;
    LinearLayout healthpolicies_Gulf;
    LinearLayout travelpolicies_Gulf;
    LinearLayout firepolicies_Gulf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_4);
        carpolicies_Gulf = (LinearLayout) findViewById(R.id.carpolicies_Gulf) ;
        carpolicies_Gulf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car_Details car = new Car_Details();
                car.setFlagCar(4);
                Intent intent = new Intent(Company_4.this,Car_Details.class);
                startActivity(intent);
            }
        });
        healthpolicies_Gulf = (LinearLayout) findViewById(R.id.healthpolicies_Gulf) ;
        healthpolicies_Gulf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Health_Details health = new Health_Details();
                health.setFlagHealth(4);
                Intent intent = new Intent(Company_4.this,Health_Details.class);
                startActivity(intent);
            }
        });
        travelpolicies_Gulf = (LinearLayout) findViewById(R.id.travelpolicies_Gulf) ;
        travelpolicies_Gulf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Travel_Details travel = new Travel_Details();
                travel.setFlagTravel(4);
                Intent intent = new Intent(Company_4.this,Travel_Details.class);
                startActivity(intent);
            }
        });
        firepolicies_Gulf = (LinearLayout) findViewById(R.id.firepolicies_Gulf) ;
        firepolicies_Gulf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fire_Details fire = new Fire_Details();
                fire.setFlagFire(4);
                Intent intent = new Intent(Company_4.this,Fire_Details.class);
                startActivity(intent);
            }
        });
    }
}