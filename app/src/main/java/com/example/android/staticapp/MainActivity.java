package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private LinearLayout claimCar;
    private LinearLayout claimHealthy;
    private LinearLayout claimFire;
    private LinearLayout claimTravel;
    private LinearLayout CarinsuranceAdd;
    private LinearLayout HealthinsuranceAdd;
    private LinearLayout TravelinsuranceAdd;
    private LinearLayout FireinsuranceAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        claimCar = (LinearLayout) findViewById(R.id.claimCar);
        claimHealthy = (LinearLayout) findViewById(R.id.claimHealthy);
        claimFire = (LinearLayout) findViewById(R.id.claimFire);
        claimTravel = (LinearLayout) findViewById(R.id.claimTravel);
        CarinsuranceAdd = (LinearLayout) findViewById(R.id.CarinsuranceAdd);
        HealthinsuranceAdd = (LinearLayout) findViewById(R.id.HealthinsuranceAdd);
        FireinsuranceAdd = (LinearLayout) findViewById(R.id.FireinsuranceAdd);
        TravelinsuranceAdd = (LinearLayout) findViewById(R.id.TravelinsuranceAdd);
        claimCar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,CarClaim.class);
            startActivity(intent);
        });
        claimHealthy.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,HealthClaim.class);
            startActivity(intent);
        });
        claimFire.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,FireClaim.class);
            startActivity(intent);
        });
        claimTravel.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,TravelClaim.class);
            startActivity(intent);
        });
        CarinsuranceAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,CarInsurance.class);
            startActivity(intent);
        });
        HealthinsuranceAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,HealthInsurance.class);
            startActivity(intent);
        });
        TravelinsuranceAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,TravelInsurance.class);
            startActivity(intent);
        });
        FireinsuranceAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,FireInsurance.class);
            startActivity(intent);
        });

    }
    public void Go_Recent(View view) {
        Intent intent = new Intent(MainActivity.this,Recent.class);
        startActivity(intent);
    }
    public void Go_Profile(View view) {
        Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
        startActivity(intent);
    }
    public void Go_CompareCompany(View view) {
        Intent intent = new Intent(MainActivity.this,CompaniesCompare.class);
        startActivity(intent);
    }
    public void Go_ComparePrice(View view) {
        Intent intent = new Intent(MainActivity.this,ResultCompare.class);
        startActivity(intent);
    }

    public void Go_About(View view) {
        Intent intent = new Intent(MainActivity.this,AboutCompany.class);
        startActivity(intent);
    }
}