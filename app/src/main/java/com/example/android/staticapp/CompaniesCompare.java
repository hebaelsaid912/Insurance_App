package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CompaniesCompare extends AppCompatActivity {
    LinearLayout Ahlia;
    LinearLayout AXA;
    LinearLayout takaful;
    LinearLayout Gulf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies_compare);
        Ahlia = (LinearLayout) findViewById(R.id.AlAhliaProfile);
        AXA = (LinearLayout) findViewById(R.id.AXAProfile);
        takaful = (LinearLayout) findViewById(R.id.TakafulProfile);
        Gulf = (LinearLayout) findViewById(R.id.GulfProfile);
        Ahlia.setOnClickListener(v -> {
            Intent intent = new Intent(CompaniesCompare.this, Company_1.class);
            startActivity(intent);
        });
        AXA.setOnClickListener(v -> {
            Intent intent = new Intent(CompaniesCompare.this, Company_2.class);
            startActivity(intent);
        });
        takaful.setOnClickListener(v -> {
            Intent intent = new Intent(CompaniesCompare.this, Company_3.class);
            startActivity(intent);
        });
        Gulf.setOnClickListener(v -> {
            Intent intent = new Intent(CompaniesCompare.this, Company_4.class);
            startActivity(intent);
        });
    }

}