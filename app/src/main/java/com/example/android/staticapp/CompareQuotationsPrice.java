package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CompareQuotationsPrice extends AppCompatActivity {
TextView ahliaPrice;
TextView axaPrice;
TextView takafulPrice;
TextView gulfPrice;
    private static int Flag=0;

    public static int getFlag() {
        return Flag;
    }

    public static void setFlag(int flag) {
        Flag = flag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_quotations_price);
        ahliaPrice = (TextView) findViewById(R.id.AhliaPrice);
        axaPrice = (TextView) findViewById(R.id.AxAPrice);
        takafulPrice = (TextView) findViewById(R.id.TakafulPrice);
        gulfPrice = (TextView) findViewById(R.id.GulfPrice);
        if (getFlag() == 1) {
            Compare_Car compare_car = new Compare_Car();
            ahliaPrice.setText(compare_car.AhliaResult + " BD");
            axaPrice.setText(compare_car.AXAResult + " BD");
            takafulPrice.setText(compare_car.TakafulResult + " BD");
            gulfPrice.setText(compare_car.GulfResult + " BD");
        } else if (getFlag() == 2) {
            Compare_Health compare_health = new Compare_Health();
            ahliaPrice.setText(compare_health.AhliaResult_health + " BD");
            axaPrice.setText(compare_health.AXAResult_health + " BD");
            takafulPrice.setText(compare_health.TakafulResult_health + " BD");
            gulfPrice.setText(compare_health.GulfResult_health + " BD");

        } else if (getFlag() == 3) {
            Compare_Travel compare_travel = new Compare_Travel();
            ahliaPrice.setText(compare_travel.AhliaResult_travel + " BD");
            axaPrice.setText(compare_travel.AXAResult_travel + " BD");
            takafulPrice.setText(compare_travel.TakafulResult_travel + " BD");
            gulfPrice.setText(compare_travel.GulfResult_travel + " BD");

        } else if (getFlag() == 4) {
            Compare_Fire compare_fire = new Compare_Fire();
            ahliaPrice.setText(compare_fire.AhliaResult_fire + " BD");
            axaPrice.setText(compare_fire.AXAResult_fire + " BD");
            takafulPrice.setText(compare_fire.TakafulResult_fire + " BD");
            gulfPrice.setText(compare_fire.GulfResult_fire + " BD");
        } else {
            Toast.makeText(CompareQuotationsPrice.this, "Error", Toast.LENGTH_LONG).show();
        }

    }
    public void BackAgain(View view){
        Intent intent = new Intent(CompareQuotationsPrice.this,MainActivity.class);
        startActivity(intent);
    }

}