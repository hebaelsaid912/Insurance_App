package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthPolicies extends AppCompatActivity {
    ArrayList<String> policy_number = new ArrayList<>();
    ArrayList<String> company_id = new ArrayList<>();
    ArrayList<String> insured_name = new ArrayList<>();
    ArrayList<String> insured_cpr = new ArrayList<>();
    ArrayList<String> policy_type = new ArrayList<>();
    ArrayList<String> dentel_cover = new ArrayList<>();
    ArrayList<String> ment_cover = new ArrayList<>();
    ArrayList<String> expire_date = new ArrayList<>();
    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> package_type = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_policies);
        ListView productListView = (ListView) findViewById(R.id.listhealth);
        View emptyView = findViewById(R.id.empty_view_health);
        productListView.setEmptyView(emptyView);
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
                PutData putData = new PutData(Routes.show_all_insurance_Health, "POST", field, data);
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
                                map.put("company_id",e.getString("company_id"));
                                map.put("package_type",e.getString("package_type"));
                                map.put("policy_type",e.getString("policy_type"));
                                map.put("dental",e.getString("dental"));
                                map.put("maternity",e.getString("maternity"));
                                map.put("insured_name",e.getString("insured_name"));
                                map.put("insured_cpr",e.getString("insured_cpr"));
                                map.put("total_price",e.getString("total_price"));
                                map.put("expire_date",e.getString("expire_date"));
                                company_id.add(map.get("company_id")) ;
                                policy_number.add(map.get("code")) ;
                                package_type.add(map.get("package_type"));
                                dentel_cover.add(map.get("dental"));
                                ment_cover.add(map.get("maternity"));
                                insured_name.add(map.get("insured_name"));
                                insured_cpr.add(map.get("insured_cpr"));
                                price.add(map.get("total_price"));
                                expire_date.add(map.get("expire_date")) ;
                                policy_type.add(map.get("policy_type")) ;
                                System.out.println(map);
                            }

                            HealthListAdapter adapter = new HealthListAdapter(HealthPolicies.this,policy_number,company_id,
                                    dentel_cover,ment_cover,insured_name,insured_cpr,policy_type,expire_date,price,package_type);
                            productListView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

            //End Write and Read data with URL

        });
    }

}