package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class AboutCompany extends AppCompatActivity {
    LinearLayout Ahlia;
    LinearLayout AXA;
    LinearLayout takaful;
    LinearLayout Gulf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_company);
        Ahlia = (LinearLayout) findViewById(R.id.AlAhliaProfileAbout);
        AXA = (LinearLayout) findViewById(R.id.AXAProfileAbout);
        takaful = (LinearLayout) findViewById(R.id.TakafulProfileAbout);
        Gulf = (LinearLayout) findViewById(R.id.GulfProfileAbout);
        Ahlia.setOnClickListener(v -> {
            Intent intent = new Intent(AboutCompany.this, AboutCompany_1.class);
            startActivity(intent);
        });
        AXA.setOnClickListener(v -> {
            Intent intent = new Intent(AboutCompany.this, AboutCompany_2.class);
            startActivity(intent);
        });
        takaful.setOnClickListener(v -> {
            Intent intent = new Intent(AboutCompany.this, AboutCompany_3.class);
            startActivity(intent);
        });
        Gulf.setOnClickListener(v -> {
            Intent intent = new Intent(AboutCompany.this, AboutCompany_4.class);
            startActivity(intent);
        });
    }
}