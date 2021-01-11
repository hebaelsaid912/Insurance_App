package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuccessfullyClaim extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfully_claim);
    }
    public void Go_HomePage(View view) {
        Intent intent = new Intent(SuccessfullyClaim.this,MainActivity.class);
        startActivity(intent);
    }
}