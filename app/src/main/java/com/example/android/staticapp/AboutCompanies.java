package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AboutCompanies extends AppCompatActivity {
    private static int Flag=0;

    public static int getFlag() {
        return Flag;
    }
    public static void setFlag(int flag) {
        Flag = flag;
    }
    TextView company;
    TextView mail;
    TextView website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_companies);
        company = (TextView) findViewById(R.id.CompanyNameAbout);
        if (getFlag() == 1) {
            company.setText("Al Ahlia Insurance");
        } else if (getFlag() == 2) {
            company.setText("AXA Insurance");
        } else if (getFlag() == 3) {
            company.setText("Takaful Insurance");
        } else if (getFlag() == 4) {
            company.setText("Gulf Union Insurance");
        } else {
            Toast.makeText(AboutCompanies.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
}