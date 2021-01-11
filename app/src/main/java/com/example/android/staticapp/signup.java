package com.example.android.staticapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class signup extends AppCompatActivity {
    private EditText username , useremail;
    private EditText userphone;
    private EditText usertelephone;
    private Spinner userday , usermonth , useryear;
    private EditText userpassword;
    private EditText userflat;
    private EditText userbuilding;
    private EditText userroad;
    private EditText usercity;
    private EditText usercpr;
    private RadioButton usergendermale ,usergenderfemale;
    public String Gender ;
    String UserName="" , UserPhone="",UserTelephone="", UserEmail="",UBirthDate="", UserPassword="";
    String UserFlat="", UserBuilding="", UserRoad="", UserCity="",UserCPR="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = (EditText) findViewById(R.id.userName);
        userphone = (EditText) findViewById(R.id.userphone);
        usertelephone = (EditText) findViewById(R.id.usertelephone);
        useremail = (EditText) findViewById(R.id.useremail);
        userday = (Spinner) findViewById(R.id.userday);
        ArrayList<String> day = new ArrayList<String>();
        day.add("Day");
        for (int i=1 ; i<=31 ; i++){
            day.add(""+i);
        }
        ArrayAdapter<String> Dayadapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, day);
        Dayadapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        userday.setAdapter(Dayadapter);
        usermonth = (Spinner) findViewById(R.id.usermonth);
        ArrayList<String> month = new ArrayList<String>();
        month.add("Month");
        for (int i=1 ; i<=12 ; i++){
            month.add(""+i);
        }
        ArrayAdapter<String> Monthadapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, month);
        Monthadapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        usermonth.setAdapter(Monthadapter);
        useryear = (Spinner) findViewById(R.id.useryear);
        ArrayList<String> year = new ArrayList<String>();
        year.add("Year");
        int i = 2021;
        while(i>=1960){
            year.add(""+i);
            i--;
        }
        ArrayAdapter<String> Yearadapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, year);
        Yearadapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        useryear.setAdapter(Yearadapter);
        userpassword = (EditText) findViewById(R.id.userpassword);
        userflat = (EditText) findViewById(R.id.userflat);
        userbuilding = (EditText) findViewById(R.id.userbuilding);
        userroad = (EditText) findViewById(R.id.userroad);
        usercity = (EditText) findViewById(R.id.usercity);
        usercpr = (EditText) findViewById(R.id.cpr);
        usergendermale = (RadioButton) findViewById(R.id.usergendermale);
        usergenderfemale = (RadioButton) findViewById(R.id.usergenderfemale);
        Button signup = (Button) findViewById(R.id.signup);
        TextView signin = (TextView) findViewById(R.id.signIn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 UserName = username.getText().toString();
                 UserPhone = userphone.getText().toString();
                 UserTelephone = usertelephone.getText().toString();
                 UserEmail = useremail.getText().toString();
                String userDay = userday.getSelectedItem().toString();
                String userMonth = usermonth.getSelectedItem().toString();
                String userYear = useryear.getSelectedItem().toString();
                if(!userDay.equals("Day") && !userMonth.equals("Month") && !userYear.equals("Year")) {
                    UBirthDate = userDay + "-" + userMonth + "-" + userYear;
                    UserPassword = userpassword.getText().toString();
                    if (usergendermale.isChecked()) {
                        Gender = "male";
                    } else if (usergenderfemale.isChecked()) {
                        Gender = "female";
                    }
                    UserFlat = userflat.getText().toString();
                    UserBuilding = userbuilding.getText().toString();
                    UserRoad = userroad.getText().toString();
                    UserCity = usercity.getText().toString();
                    UserCPR = usercpr.getText().toString();
                    Log.i("MainActivity", UserName);
                    Log.i("MainActivity", UserPhone);
                    Log.i("MainActivity", UserTelephone);
                    Log.i("MainActivity", UserEmail);
                    Log.i("MainActivity", userDay);
                    Log.i("MainActivity", userMonth);
                    Log.i("MainActivity", userYear);
                    Log.i("MainActivity", UBirthDate);
                    Log.i("MainActivity", UserPassword);
                    /* Log.i("MainActivity",Gender);*/
                    Log.i("MainActivity", UserFlat);
                    Log.i("MainActivity", UserBuilding);
                    Log.i("MainActivity", UserRoad);
                    Log.i("MainActivity", UserCPR);
                    Log.i("MainActivity", UserCity);
                    if (!UserName.equals("") && !UserPhone.equals("") && !UserTelephone.equals("") && !UserEmail.equals("") &&
                            !UBirthDate.equals("") && !UserPassword.equals("") && !Gender.equals("") &&
                            !UserFlat.equals("") && !UserBuilding.equals("") && !UserRoad.equals("") &&
                            !UserCPR.equals("") && !UserCity.equals("")) {
                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                //Starting Write and Read data with URL
                                //Creating array for parameters
                                String[] field = new String[12];
                                field[0] = "name";
                                field[1] = "email";
                                field[2] = "mobile";
                                field[3] = "telephone";
                                field[4] = "date_of_birth";
                                field[5] = "gender";
                                field[6] = "cpr";
                                field[7] = "password";
                                field[8] = "city";
                                field[9] = "road";
                                field[10] = "building";
                                field[11] = "flat";
                                //Creating array for data
                                String[] data = new String[12];
                                data[0] = UserName;
                                data[1] = UserEmail;
                                data[2] = UserPhone;
                                data[3] = UserTelephone;
                                data[4] = UBirthDate;
                                data[5] = Gender;
                                data[6] = UserCPR;
                                data[7] = UserPassword;
                                data[8] = UserCity;
                                data[9] = UserRoad;
                                data[10] = UserBuilding;
                                data[11] = UserFlat;
                                System.out.println(data);
                                PutData putData = new PutData(Routes.register, "POST", field, data);
                                if (putData.startPut()) {
                                    if (putData.onComplete()) {
                                        String result = putData.getResult();
                                        System.out.println(result + "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                                        try {
                                            JSONObject signInmessage = new JSONObject(result);
                                            String Message = signInmessage.get("message").toString();
                                            if (Message.equals("register success")) {
                                                JSONObject Getuser_id = (JSONObject) signInmessage.get("data");
                                                Intent intent = new Intent(signup.this, login.class);
                                                startActivity(intent);
                                                AlertDialog.Builder mess = new AlertDialog.Builder(signup.this);
                                                mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();

                                            } else {
                                                AlertDialog.Builder mess = new AlertDialog.Builder(signup.this);
                                                mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();
                                            }
                                            Log.i("PutData", result);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                //End Write and Read data with URL
                            }
                        });
                    } else {
                        AlertDialog.Builder mess = new AlertDialog.Builder(signup.this);
                        mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();

                    }
                }else{
                    AlertDialog.Builder mess =  new AlertDialog.Builder(signup.this);
                    mess.setMessage("Please make sure you have entered all the required fields and " +
                            "choose value for day, month and year").setTitle("Alert !").setCancelable(true).show();
                }
            }

        });

    }


    public void Go_SignIn(View view) {
        Intent intent = new Intent(signup.this,login.class);
        startActivity(intent);
    }
}