package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AboutCompany_1 extends AppCompatActivity {
    LinearLayout AboutAhlia;
    LinearLayout ContactAhlia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_company_1);
        AboutAhlia = (LinearLayout) findViewById(R.id.About_Ahlia);
        ContactAhlia = (LinearLayout) findViewById(R.id.Contact_Ahlia);
        AboutAhlia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutCompanies.setFlag(1);
                ContactCompanies.setFlag(1);
                Intent intent = new Intent(AboutCompany_1.this,AboutCompanies.class);
                startActivity(intent);
            }
        });
        ContactAhlia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutCompanies.setFlag(1);
                ContactCompanies.setFlag(1);
                Intent intent = new Intent(AboutCompany_1.this,ContactCompanies.class);
                startActivity(intent);
            }
        });
    }
}