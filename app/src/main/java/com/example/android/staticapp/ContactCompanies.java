package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ContactCompanies extends AppCompatActivity {
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
        setContentView(R.layout.activity_contact_companies);
        company = (TextView) findViewById(R.id.CompanyName);
        mail = (TextView) findViewById(R.id.Email);
        company = (TextView) findViewById(R.id.website);
        if (getFlag() == 1) {
            company.setText("Al Ahlia Insurance");
            mail.setText("ahlia@ahlia.com");
            company.setText("https://www.ahlia.com");
        } else if (getFlag() == 2) {
            company.setText("AXA Insurance");
            mail.setText("axa@axa.com");
            company.setText("https://www.axa.com");
        } else if (getFlag() == 3) {
            company.setText("Takaful Insurance");
            mail.setText("takaful@takaful.com");
            company.setText("https://www.takaful.com");
        } else if (getFlag() == 4) {
            company.setText("Gulf Union Insurance");
            mail.setText("gulf@gulf.com");
            company.setText("https://www.gulf.com");
        } else {
            Toast.makeText(ContactCompanies.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
}