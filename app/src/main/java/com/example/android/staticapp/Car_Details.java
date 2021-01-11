package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Car_Details extends AppCompatActivity {
    private static int FlagCar=0;

    public static int getFlagCar() {
        return FlagCar;
    }

    public static void setFlagCar(int flagCar) {
        FlagCar = flagCar;
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
        setContentView(R.layout.activity_car__details);
        Party_Normal = (TextView) findViewById(R.id.CarNormalParty);
        Party_Silver = (TextView) findViewById(R.id.CarSilverParty);
        Party_Gold = (TextView) findViewById(R.id.CarGoldParty);
        Full_Normal = (TextView) findViewById(R.id.CarNormalFull);
        Full_Silver = (TextView) findViewById(R.id.CarSilverFull);
        Full_Gold = (TextView) findViewById(R.id.CarGoldFull);
        Title = (TextView) findViewById(R.id.TitleCompareCompanyCar);
        if (getFlagCar() == 1) {
            Party_Normal.setText(105 + " BD");
            Party_Silver.setText(115 + " BD");
            Party_Gold.setText(130 + " BD");
            Full_Normal.setText(200 + " BD");
            Full_Silver.setText(210 + " BD");
            Full_Gold.setText(260 + " BD");
            Title.setText("Al Ahlia Insurance, Car");
        } else if (getFlagCar() == 2) {
            Party_Normal.setText(120 + " BD");
            Party_Silver.setText(130 + " BD");
            Party_Gold.setText(140 + " BD");
            Full_Normal.setText(180 + " BD");
            Full_Silver.setText(200 + " BD");
            Full_Gold.setText(230 + " BD");
            Title.setText("AXA Insurance, Car");
        } else if (getFlagCar() == 3) {
            Party_Normal.setText(60 + " BD");
            Party_Silver.setText(80 + " BD");
            Party_Gold.setText(100 + " BD");
            Full_Normal.setText(150 + " BD");
            Full_Silver.setText(180 + " BD");
            Full_Gold.setText(240 + " BD");
            Title.setText("Takaful Insurance, Car");
        } else if (getFlagCar() == 4) {
            Party_Normal.setText(60 + " BD");
            Party_Silver.setText(70 + " BD");
            Party_Gold.setText(90 + " BD");
            Full_Normal.setText(100 + " BD");
            Full_Silver.setText(160 + " BD");
            Full_Gold.setText(250 + " BD");
            Title.setText("Gulf Gulf Union Insurance, Car");
        } else {
            Toast.makeText(Car_Details.this, "Error", Toast.LENGTH_LONG).show();
        }
    }
    public void BackAgain_Car(View view){
        Intent intent = new Intent(Car_Details.this,MainActivity.class);
        startActivity(intent);
    }

}