package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
TextView profile_name;
TextView profile_email;
TextView profile_CPR;
TextView profile_Birth;
TextView profile_gender;
TextView profile_flat;
TextView profile_building;
TextView profile_city;
TextView profile_mobile;
TextView profile_phone;
TextView profile_road;
TextView profile_welcome;
    String userName="" , userPhone="",userTelephone="", userEmail="",BirthDate="", userPassword="";
    String userFlat="", userBuilding="", userRoad="", userCity="",userCPR="", Gender="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile_welcome = (TextView) findViewById(R.id.profileWelcome);
        profile_name = (TextView) findViewById(R.id.ProfileName);
        profile_mobile = (TextView) findViewById(R.id.ProfileMobile);
        profile_phone = (TextView) findViewById(R.id.ProfilePhone);
        profile_email = (TextView) findViewById(R.id.ProfileEmail);
        profile_Birth = (TextView) findViewById(R.id.ProfileBirthDate);
        profile_CPR = (TextView) findViewById(R.id.ProfileCPR);
        profile_city = (TextView) findViewById(R.id.ProfileCity);
        profile_flat = (TextView) findViewById(R.id.ProfileFlat);
        profile_building = (TextView) findViewById(R.id.ProfileBuilding);
        profile_gender = (TextView) findViewById(R.id.ProfileGender);
        profile_road = (TextView) findViewById(R.id.ProfileRoad);
int idid = Integer.parseInt(login.user_id);
        Log.d("Main","idididididididididdididididi" + idid);
        if(idid>0){
            String[] field = new String[1];
            field[0] = "id";
            //Creating array for data
            String[] data = new String[1];
            data[0] = login.user_id;
            PutData putData = new PutData(Routes.get_user_info, "POST", field, data);
            if (putData.startPut()) {
                if (putData.onComplete()) {
                    String result = putData.getResult();
                    System.out.println(result);
                    try {
                        JSONObject loginmessage = new JSONObject(result);
                        JSONObject Getuser_id = (JSONObject) loginmessage.get("data");
                        userName = (String) Getuser_id.get("user_name");
                        System.out.println(userName);
                        profile_name.setText(userName);
                        profile_welcome.setText(userName);
                        userEmail = (String) Getuser_id.get("user_email");
                        System.out.println(userEmail);
                        profile_email.setText(userEmail);
                        userBuilding = (String) Getuser_id.get("user_building");
                        System.out.println(userBuilding);
                        profile_building.setText(userBuilding);
                        userRoad = (String) Getuser_id.get("user_road");
                        System.out.println(userRoad);
                        profile_road.setText(userRoad);
                        BirthDate = (String) Getuser_id.get("user_date_of_birth");
                        System.out.println(BirthDate);
                        profile_Birth.setText(BirthDate);
                        Gender = (String) Getuser_id.get("user_gender");
                        System.out.println(Gender);
                        profile_gender.setText(Gender);
                        userCPR = (String) Getuser_id.get("user_cpr");
                        System.out.println(userCPR);
                        profile_CPR.setText(userCPR);
                        userTelephone = (String) Getuser_id.get("user_telephone");
                        System.out.println(userTelephone);
                        profile_phone.setText(userTelephone);
                        userPhone = (String) Getuser_id.get("user_mobile");
                        System.out.println(userPhone);
                        profile_mobile.setText(userPhone);
                        userCity = (String) Getuser_id.get("user_city");
                        System.out.println(userCity);
                        profile_city.setText(userCity);
                        userFlat = (String) Getuser_id.get("user_flat");
                        System.out.println(userName);
                        profile_flat.setText(userFlat);
                        Log.i("PutData", result);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

        }else{
            System.out.println(login.user_id);
        }
    }



    public void Go_LogOut(View view) {
        Intent intent = new Intent(ProfileActivity.this,login.class);
        startActivity(intent);
    }
}
