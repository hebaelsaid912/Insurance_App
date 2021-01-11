package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ResultInsuranceDone extends AppCompatActivity {
    private static int Flag=0;

    public static int getFlagResultInsurence() {
        return Flag;
    }

    public static void setFlagResultInsurence(int flag) {
        Flag = flag;
    }
    TextView code_Policy_Number;
    String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_insurance_done);
        code_Policy_Number = (TextView) findViewById(R.id.CodePolicyNumber);
        if (getFlagResultInsurence() == 1) {
            s1 = CarInsurance.s1;
            code_Policy_Number.setText(s1);
        } else if (getFlagResultInsurence() == 2) {
            s1 = HealthInsurance.s1;
            code_Policy_Number.setText(s1);
        } else if (getFlagResultInsurence() == 3) {
            s1 = TravelInsurance.s1;
            code_Policy_Number.setText(s1);

        } else if (getFlagResultInsurence() == 4) {
            s1 = FireInsurance.s1;
            code_Policy_Number.setText(s1);

        } else {
            Toast.makeText(ResultInsuranceDone.this, "Error", Toast.LENGTH_LONG).show();
        }

    }
    public void Go_AgainInsurance(View view) {
        if (getFlagResultInsurence() == 1) {
            Intent intent = new Intent(ResultInsuranceDone.this,CarInsurance.class);
            startActivity(intent);

        } else if (getFlagResultInsurence() == 2) {
            Intent intent = new Intent(ResultInsuranceDone.this,HealthInsurance.class);
            startActivity(intent);

        } else if (getFlagResultInsurence() == 3) {
            Intent intent = new Intent(ResultInsuranceDone.this,TravelInsurance.class);
            startActivity(intent);

        } else if (getFlagResultInsurence() == 4) {
            Intent intent = new Intent(ResultInsuranceDone.this,FireInsurance.class);
            startActivity(intent);

        }

    }
    public void Go_HomePage(View view) {
        Intent intent = new Intent(ResultInsuranceDone.this,MainActivity.class);
        startActivity(intent);
    }
}