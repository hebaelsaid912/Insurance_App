package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Company_1 extends AppCompatActivity {
    LinearLayout carpolicies_Ahlia;
    LinearLayout healthpolicies_Ahlia;
    LinearLayout travelpolicies_Ahlia;
    LinearLayout firepolicies_Ahlia;
public static int compID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_1);
        carpolicies_Ahlia = (LinearLayout) findViewById(R.id.carpolicies_Ahlia) ;
        carpolicies_Ahlia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car_Details car = new Car_Details();
                car.setFlagCar(1);
                Intent intent = new Intent(Company_1.this,Car_Details.class);
                startActivity(intent);
            }
        });
        healthpolicies_Ahlia = (LinearLayout) findViewById(R.id.healthpolicies_Ahlia) ;
        healthpolicies_Ahlia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Health_Details health = new Health_Details();
                health.setFlagHealth(1);
                Intent intent = new Intent(Company_1.this,Health_Details.class);
                startActivity(intent);
            }
        });
        travelpolicies_Ahlia = (LinearLayout) findViewById(R.id.travelpolicies_Ahlia) ;
        travelpolicies_Ahlia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Travel_Details travel = new Travel_Details();
                travel.setFlagTravel(1);
                Intent intent = new Intent(Company_1.this,Travel_Details.class);
                startActivity(intent);
            }
        });
        firepolicies_Ahlia = (LinearLayout) findViewById(R.id.firepolicies_Ahlia) ;
        firepolicies_Ahlia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fire_Details fire = new Fire_Details();
                fire.setFlagFire(1);
                Intent intent = new Intent(Company_1.this,Fire_Details.class);
                startActivity(intent);
            }
        });





    }
}