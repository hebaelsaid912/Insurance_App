package com.example.android.staticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class CarPolicies extends AppCompatActivity {
    ArrayList<String> policy_number = new ArrayList<>();
    ArrayList<String> company_id= new ArrayList<>();
    ArrayList<String> reg_num = new ArrayList<>();
    ArrayList<String> policy_type = new ArrayList<>();
    ArrayList<String> expire_date = new ArrayList<>();
    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> status = new ArrayList<>();
    ArrayList<String> package_type = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_policies);
        ListView productListView = (ListView) findViewById(R.id.listcar);
        View emptyView = findViewById(R.id.empty_view_car);
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
                PutData putData = new PutData(Routes.show_all_insurance_Car, "POST", field, data);
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
                                String s = e.getString("code");
                                System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq" + s);
                                String s1 = e.getString("company_id");
                                System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq" + s1);
                                String s2 = e.getString("expire_date");
                                System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq" + s2);
                                map.put("code",e.getString("code"));
                                map.put("company_id",e.getString("company_id"));
                                map.put("policy_type",e.getString("policy_type"));
                                map.put("package_type",e.getString("package_type"));
                                map.put("car_reg_num",e.getString("car_reg_num"));
                                map.put("total_price",e.getString("total_price"));
                                map.put("expire_date",e.getString("expire_date"));
                                company_id.add(map.get("company_id")) ;
                                policy_number.add(map.get("code")) ;
                                policy_type.add(map.get("policy_type"));
                                package_type.add(map.get("package_type"));
                                reg_num.add(map.get("car_reg_num"));
                                price.add(map.get("total_price"));
                                expire_date.add(map.get("expire_date")) ;
                                System.out.println(map);
                            }
                            System.out.println(company_id);
                            System.out.println(policy_number);
                            System.out.println(policy_type);
                            System.out.println(reg_num);
                            System.out.println(price);
                            System.out.println(package_type);
                            System.out.println(expire_date);
                            CarListAdapter adapter = new CarListAdapter(CarPolicies.this,policy_number,company_id,
                                    reg_num,policy_type,expire_date,price,package_type);
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