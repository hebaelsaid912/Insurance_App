package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Fire_Details extends AppCompatActivity {
    private static int FlagFire=0;

    public static int getFlagFire() {
        return FlagFire;
    }

    public static void setFlagFire(int flagFire) {
        FlagFire = flagFire;
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
        setContentView(R.layout.activity_fire__details);
        Party_Normal = (TextView) findViewById(R.id.FireNormalParty);
        Party_Silver = (TextView) findViewById(R.id.FireSilverParty);
        Party_Gold = (TextView) findViewById(R.id.FireGoldParty);
        Full_Normal = (TextView) findViewById(R.id.FireNormalFull);
        Full_Silver = (TextView) findViewById(R.id.FireSilverFull);
        Full_Gold = (TextView) findViewById(R.id.FireGoldFull);
        Title = (TextView) findViewById(R.id.TitleCompareCompanyFire);
        if (getFlagFire() == 1) {
            Party_Normal.setText(600 + " BD");
            Party_Silver.setText(800 + " BD");
            Party_Gold.setText(1700 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("Al Ahlia Insurance, Fire");
        } else if (getFlagFire() == 2) {
            Party_Normal.setText(200 + " BD");
            Party_Silver.setText(400 + " BD");
            Party_Gold.setText(900 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("AXA Insurance, Fire");
        } else if (getFlagFire() == 3) {
            Party_Normal.setText(120 + " BD");
            Party_Silver.setText(160 + " BD");
            Party_Gold.setText(250 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("Takaful Insurance, Fire");
        } else if (getFlagFire() == 4) {
            Party_Normal.setText(400 + " BD");
            Party_Silver.setText(890 + " BD");
            Party_Gold.setText(956 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("Gulf Union Insurance, Fire");
        } else {
            Toast.makeText(Fire_Details.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
    public void BackAgain_Fire(View view){
        Intent intent = new Intent(Fire_Details.this,MainActivity.class);
        startActivity(intent);
    }

}