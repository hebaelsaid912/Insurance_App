package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AboutCompany_2 extends AppCompatActivity {
    LinearLayout AboutAXA;
    LinearLayout ContactAXA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_company_2);
        AboutAXA = (LinearLayout) findViewById(R.id.About_AXA);
        ContactAXA = (LinearLayout) findViewById(R.id.Contact_AXA);
        AboutAXA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutCompanies.setFlag(2);
                ContactCompanies.setFlag(2);
                Intent intent = new Intent(AboutCompany_2.this,AboutCompanies.class);
                startActivity(intent);
            }
        });
        ContactAXA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutCompanies.setFlag(2);
                ContactCompanies.setFlag(2);
                Intent intent = new Intent(AboutCompany_2.this,ContactCompanies.class);
                startActivity(intent);
            }
        });
    }
}