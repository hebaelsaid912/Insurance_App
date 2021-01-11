package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Travel_Details extends AppCompatActivity {
    private static int FlagTravel=0;

    public static int getFlagTravel() {
        return FlagTravel;
    }

    public static void setFlagTravel(int flagTravel) {
        FlagTravel = flagTravel;
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
        setContentView(R.layout.activity_travel__details);
        Party_Normal = (TextView) findViewById(R.id.TravelNormalParty);
        Party_Silver = (TextView) findViewById(R.id.TravelSilverParty);
        Party_Gold = (TextView) findViewById(R.id.TravelGoldParty);
        Full_Normal = (TextView) findViewById(R.id.TravelNormalFull);
        Full_Silver = (TextView) findViewById(R.id.TravelSilverFull);
        Full_Gold = (TextView) findViewById(R.id.TravelGoldFull);
        Title = (TextView) findViewById(R.id.TitleCompareCompanyTravel);
        if (getFlagTravel() == 1) {
            Party_Normal.setText(2 + " BD");
            Party_Silver.setText(4 + " BD");
            Party_Gold.setText(8 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("Al Ahlia Insurance, Travel");
        } else if (getFlagTravel() == 2) {
            Party_Normal.setText(4 + " BD");
            Party_Silver.setText(8 + " BD");
            Party_Gold.setText(10 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("AXA Insurance, Travel");
        } else if (getFlagTravel() == 3) {
            Party_Normal.setText(4 + " BD");
            Party_Silver.setText(12 + " BD");
            Party_Gold.setText(18 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("Takaful Insurance, Travel");
        } else if (getFlagTravel() == 4) {
            Party_Normal.setText(4 + " BD");
            Party_Silver.setText(5 + " BD");
            Party_Gold.setText(6 + " BD");
            Full_Normal.setText("--" + " --");
            Full_Silver.setText("--" + " --");
            Full_Gold.setText("--" + " --");
            Title.setText("Gulf Union Insurance, Travel");
        } else {
            Toast.makeText(Travel_Details.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
    public void BackAgain_Travel(View view){
        Intent intent = new Intent(Travel_Details.this,MainActivity.class);
        startActivity(intent);
    }

}
