package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Company_3 extends AppCompatActivity {
    LinearLayout carpolicies_Takaful;
    LinearLayout healthpolicies_Takaful;
    LinearLayout travelpolicies_Takaful;
    LinearLayout firepolicies_Takaful;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_3);
        carpolicies_Takaful = (LinearLayout) findViewById(R.id.carpolicies_takaful) ;
        carpolicies_Takaful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car_Details car = new Car_Details();
                car.setFlagCar(3);
                Intent intent = new Intent(Company_3.this,Car_Details.class);
                startActivity(intent);
            }
        });
        healthpolicies_Takaful = (LinearLayout) findViewById(R.id.healthpolicies_takaful) ;
        healthpolicies_Takaful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Health_Details health = new Health_Details();
                health.setFlagHealth(3);
                Intent intent = new Intent(Company_3.this,Health_Details.class);
                startActivity(intent);
            }
        });
        travelpolicies_Takaful = (LinearLayout) findViewById(R.id.travelpolicies_takaful) ;
        travelpolicies_Takaful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Travel_Details travel = new Travel_Details();
                travel.setFlagTravel(3);
                Intent intent = new Intent(Company_3.this,Travel_Details.class);
                startActivity(intent);
            }
        });
        firepolicies_Takaful = (LinearLayout) findViewById(R.id.firepolicies_takaful) ;
        firepolicies_Takaful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fire_Details fire = new Fire_Details();
                fire.setFlagFire(3);
                Intent intent = new Intent(Company_3.this,Fire_Details.class);
                startActivity(intent);
            }
        });

    }
}