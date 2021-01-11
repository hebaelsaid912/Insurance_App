package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Health_Details extends AppCompatActivity {
    private static int FlagHealth=0;

    public static int getFlagHealth() {
        return FlagHealth;
    }

    public static void setFlagHealth(int flagHealth) {
        FlagHealth = flagHealth;
    }
    TextView Party_Normal;
    TextView Party_Silver;
    TextView Party_Gold;
    TextView Full_Normal;
    TextView Full_Silver;
    TextView Full_Gold;
    TextView Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health__details);
        Party_Normal = (TextView) findViewById(R.id.HealthNormalParty);
        Party_Silver = (TextView) findViewById(R.id.HealthSilverParty);
        Party_Gold = (TextView) findViewById(R.id.HealthGoldParty);
        Full_Normal = (TextView) findViewById(R.id.HealthNormalFull);
        Full_Silver = (TextView) findViewById(R.id.HealthSilverFull);
        Full_Gold = (TextView) findViewById(R.id.HealthGoldFull);
        Title = (TextView) findViewById(R.id.TitleCompareCompanyHealth);
        if (getFlagHealth() == 1) {
            Party_Normal.setText(200 + " BD");
            Party_Silver.setText(245 + " BD");
            Party_Gold.setText(480 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("Al Ahlia Insurance, Health");
        } else if (getFlagHealth() == 2) {
            Party_Normal.setText(420 + " BD");
            Party_Silver.setText(480 + " BD");
            Party_Gold.setText(510 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("AXA Insurance, Health");
        } else if (getFlagHealth() == 3) {
            Party_Normal.setText(240 + " BD");
            Party_Silver.setText(420 + " BD");
            Party_Gold.setText(610 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("Takaful Insurance, Health");

        } else if (getFlagHealth() == 4) {
            Party_Normal.setText(200 + " BD");
            Party_Silver.setText(300 + " BD");
            Party_Gold.setText(400 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("Gulf Union Insurance, Health");

        } else {
            Toast.makeText(Health_Details.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
    public void BackAgain_Health(View view){
        Intent intent = new Intent(Health_Details.this,MainActivity.class);
        startActivity(intent);
    }

}