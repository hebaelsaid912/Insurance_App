package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AboutCompany_3 extends AppCompatActivity {
    LinearLayout AboutTakaful;
    LinearLayout ContactTakaful;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_company_3);
        AboutTakaful = (LinearLayout) findViewById(R.id.About_Takaful);
        ContactTakaful = (LinearLayout) findViewById(R.id.Contact_Takaful);
        AboutTakaful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutCompanies.setFlag(3);
                ContactCompanies.setFlag(3);
                Intent intent = new Intent(AboutCompany_3.this,AboutCompanies.class);
                startActivity(intent);
            }
        });
        ContactTakaful.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutCompanies.setFlag(3);
                ContactCompanies.setFlag(3);
                Intent intent = new Intent(AboutCompany_3.this,ContactCompanies.class);
                startActivity(intent);
            }
        });
    }
}