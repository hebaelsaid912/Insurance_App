package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AboutCompany_4 extends AppCompatActivity {
    LinearLayout AboutGulf;
    LinearLayout ContactGulf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_company_4);
        AboutGulf = (LinearLayout) findViewById(R.id.About_Gulf);
        ContactGulf = (LinearLayout) findViewById(R.id.Contact_Gulf);
        AboutGulf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutCompanies.setFlag(4);
                ContactCompanies.setFlag(4);
                Intent intent = new Intent(AboutCompany_4.this,AboutCompanies.class);
                startActivity(intent);
            }
        });
        ContactGulf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutCompanies.setFlag(4);
                ContactCompanies.setFlag(4);
                Intent intent = new Intent(AboutCompany_4.this,ContactCompanies.class);
                startActivity(intent);
            }
        });
    }
}