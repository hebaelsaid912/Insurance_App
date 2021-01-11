package com.example.android.staticapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;

public class login extends AppCompatActivity {
public static String user_id="0" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button signin = (Button) findViewById(R.id.signIn);
        final Intent i = new Intent(this, MainActivity.class);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = (EditText) findViewById(R.id.signIn_Email);
                final String Email = email.getText().toString();
                EditText pass = (EditText) findViewById(R.id.signIn_Password);
                final String Pass = pass.getText().toString();
                Log.i("MainActivity", Email);
                Log.i("MainActivity", Pass);
              /*  try {
                    Boolean result = new UserDB().check(Email, Pass);
                    if (result == true) {
                        Toast.makeText(login.this, "Done", Toast.LENGTH_LONG).show();
                        startActivity(i);
                    } else {
                        Toast.makeText(login.this, "Name or Password is not Correct!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    Log.i("oooooooooo", "rrrrrrrrrrr");
                }*/
                if(!Email.equals("")&& !Pass.equals("")) {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "email";
                            field[1] = "password";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = Email;
                            data[1] = Pass;

                            PutData putData = new PutData(Routes.login, "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    System.out.println(result);
                                        try {
                                            JSONObject loginmessage = new JSONObject(result);
                                            String Message =  loginmessage.get("message").toString();
                                            if(Message.equals("login success")){
                                                JSONObject   Getuser_id = (JSONObject) loginmessage.get("data");
                                                user_id = (String) Getuser_id.get("id");
                                                System.out.println(user_id);
                                                Intent intent = new Intent(login.this,MainActivity.class);
                                                startActivity(intent);
                                                AlertDialog.Builder mess =  new AlertDialog.Builder(login.this);
                                                mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();


                                        }else{
                                                AlertDialog.Builder mess =  new AlertDialog.Builder(login.this);
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
                }else{
                    AlertDialog.Builder mess =  new AlertDialog.Builder(login.this);
                    mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();
                }

            }

        });
    }
    public void Go_forget(View view) {
        Intent intent = new Intent(login.this,forget_Email.class);
        startActivity(intent);
    }

    public void Go_SignUp(View view) {
        Intent intent = new Intent(login.this,signup.class);
        startActivity(intent);
    }
    public void TestHomeActivity(View view) {
        Intent intent = new Intent(login.this,MainActivity.class);
        startActivity(intent);
    }

}