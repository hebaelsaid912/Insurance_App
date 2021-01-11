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

public class FirePolicies extends AppCompatActivity {
    ArrayList<String> policy_number = new ArrayList<>();
    ArrayList<String> company_id= new ArrayList<>();
    ArrayList<String> building_area = new ArrayList<>();
    ArrayList<String> building_type = new ArrayList<>();
    ArrayList<String> expire_date = new ArrayList<>();
    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> package_type = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_policies);
        ListView productListView = (ListView) findViewById(R.id.listfire);
        View emptyView = findViewById(R.id.empty_view_fire);
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
                                map.put("company_id",e.getString("company_id"));
                                map.put("package_type",e.getString("package_type"));
                                map.put("building_area",e.getString("building_area"));
                                map.put("building_type",e.getString("building_type"));
                                map.put("total_price",e.getString("total_price"));
                                map.put("expire_date",e.getString("expire_date"));
                                company_id.add(map.get("company_id")) ;
                                policy_number.add(map.get("code")) ;
                                package_type.add(map.get("package_type"));
                                building_area.add(map.get("building_area"));
                                building_type.add(map.get("building_type"));
                                price.add(map.get("total_price"));
                                expire_date.add(map.get("expire_date")) ;
                                System.out.println(map);
                            }
                            FireListAdapter adapter = new FireListAdapter(FirePolicies.this,policy_number,company_id,
                                    building_area,building_type,expire_date,price,package_type);
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