package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
    public void Go_SignUp(View view){
        Intent intent = new Intent(FirstActivity.this,signup.class);
        startActivity(intent);
    }
    public void Go_SignIn(View view){
        Intent intent = new Intent(FirstActivity.this,login.class);
        startActivity(intent);
    }
}