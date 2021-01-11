package com.example.android.staticapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class FireClaim extends AppCompatActivity {
    Spinner policyNumberSpinner;
    EditText DetailsFire;
    Button fireClaim;
    String Details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_claim);
        DetailsFire = (EditText) findViewById(R.id.FireDetailsClaim);
        policyNumberSpinner = (Spinner) findViewById(R.id.Spinner_PolicyNumber_FireClaim) ;
        ArrayList<String> items = new ArrayList<String>();
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                //Starting Write and Read data with URL
                //Creating array for parameters
                String[] field = new String[1];
                field[0] = "id";
                //Creating array for data
                String[] data = new String[1];
                data[0] = login.user_id;
                System.out.println(data);
                PutData putData = new PutData(Routes.show_all_insurance_Fire, "POST", field, data);
                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        String result = putData.getResult();
                        System.out.println(result + "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                        try {
                            JSONObject signInmessage = new JSONObject(result);
                            String Message = signInmessage.get("message").toString();
                            JSONArray Datajson = signInmessage.getJSONArray("data");
                            HashMap<String, String> map = new HashMap<String, String>();
                            for(int i=0;i<Datajson.length();i++) {
                                JSONObject e = Datajson.getJSONObject(i);
                                map.put("code",e.getString("code"));
                                items.add(map.get("code"));
                            }
                            System.out.println(items);
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(FireClaim.this, R.layout.listitem_carcliam_policynumber, items);
                            adapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
                            policyNumberSpinner.setAdapter(adapter);
                            Log.i("PutData", result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.i("PutData", result);

                    }
                }
            }
            //End Write and Read data with URL

        });

        fireClaim = (Button) findViewById(R.id.GetFireClaim);
        fireClaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Details = DetailsFire.getText().toString();
                if ( !Details.equals("")) {
                   Intent intent = new Intent(FireClaim.this, SuccessfullyClaim.class);
                    startActivity(intent);
                }else{
                    AlertDialog.Builder mess =  new AlertDialog.Builder(FireClaim.this);
                    mess.setMessage("Please Enter All Fields").setTitle("Alert !").setCancelable(true).show();

                }
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //replaces the default 'Back' button action
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            this.startActivity(new Intent(FireClaim.this,MainActivity.class));

        }
        return true;
    }
}