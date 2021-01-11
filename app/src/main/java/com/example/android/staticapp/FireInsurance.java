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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FireInsurance extends AppCompatActivity {
    Spinner packageTypeSpinner;
    Spinner policyTypeSpinner;
    Spinner buildingTypeSpinner;
    RadioButton ahliaInsurance_1;
    RadioButton axaInsurance_2;
    RadioButton takafulInsurance_3;
    RadioButton gulfInsurance_4;
    EditText BuildingArea_fireInsurance;
    Button GetFireQuotation_Insurance;
   public static String buildingArea, package_type, building_type, Company_Id , ExpireDate  ;
    public static String Policy_Type;
    public static String userID = login.user_id;
    int CompanyFlag_ID;
    public static int FlagInsurance_Fire = 4;
    public static String CodeInsurance , s1;
    public static String TotalPrice ;
    double totalCarPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_insurance);
        BuildingArea_fireInsurance = (EditText) findViewById(R.id.BuildingAreaFireInsurance);
        ahliaInsurance_1 = (RadioButton) findViewById(R.id.AhliaInsurance_Fire);
        ahliaInsurance_1.setChecked(true);
        axaInsurance_2 = (RadioButton) findViewById(R.id.AXAInsurance_Fire);
        takafulInsurance_3 = (RadioButton) findViewById(R.id.TakafulInsurance_Fire);
        gulfInsurance_4 = (RadioButton) findViewById(R.id.GulfInsurance_Fire);
        policyTypeSpinner = (Spinner) findViewById(R.id.Spinner_PolicyType_FireInsurance);
        ArrayList<String> items = new ArrayList<String>();
        items.add("full_coverage");
        items.add("3rd_party");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items);
        adapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        policyTypeSpinner.setAdapter(adapter);


        packageTypeSpinner = (Spinner) findViewById(R.id.Spinner_PackageType_FireInsurance);
        ArrayList<String> items_1 = new ArrayList<String>();
        items_1.add("normal");
        items_1.add("silver");
        items_1.add("gold");
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_1);
        adapter_1.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        packageTypeSpinner.setAdapter(adapter_1);

        buildingTypeSpinner = (Spinner) findViewById(R.id.Spinner_BuildingType_FireInsurance);
        ArrayList<String> items_2 = new ArrayList<String>();
        items_2.add("villa");
        items_2.add("multistory");
        items_2.add("office");
        items_2.add("warehouse");
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_2);
        adapter_2.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        buildingTypeSpinner.setAdapter(adapter_2);
        GetFireQuotation_Insurance = (Button) findViewById(R.id.GetFireQuotationInsurance);
        GetFireQuotation_Insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Policy_Type = policyTypeSpinner.getSelectedItem().toString();
                building_type = buildingTypeSpinner.getSelectedItem().toString();
                package_type = packageTypeSpinner.getSelectedItem().toString();
                buildingArea = BuildingArea_fireInsurance.getText().toString();

                if (ahliaInsurance_1.isChecked()) {
                    CompanyFlag_ID = 1;
                } else if (axaInsurance_2.isChecked()) {
                    CompanyFlag_ID = 2;
                } else if (takafulInsurance_3.isChecked()) {
                    CompanyFlag_ID = 3;
                } else if (gulfInsurance_4.isChecked()) {
                    CompanyFlag_ID = 4;
                } else {
                    Toast.makeText(FireInsurance.this,
                            "please choose Company !", Toast.LENGTH_LONG).show();
                }
                Company_Id = "" + CompanyFlag_ID;
                long rand15Digt = (long) (Math.random() * 100000000000000L);
                    s1 = "FIns" + rand15Digt;
                System.out.println(Company_Id);
                System.out.println(userID);
                System.out.println(Policy_Type);
                System.out.println(package_type);
                totalPrice();
                System.out.println(TotalPrice);
                System.out.println(building_type);
                System.out.println(buildingArea);
                System.out.println(s1);
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                ExpireDate = date;
                System.out.println(ExpireDate);
                if (!buildingArea.equals("") && !building_type.equals("") && !TotalPrice.equals("") &&
                        !ExpireDate.equals("") && !Company_Id.equals("")) {
                    confirmInsurance.setFlagResultInsurenceDone(FlagInsurance_Fire);
                    Intent intent = new Intent(FireInsurance.this, confirmInsurance.class);
                    startActivity(intent);

                } else {
                    AlertDialog.Builder mess =  new AlertDialog.Builder(FireInsurance.this);
                    mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();

                }


            }
        });
    }

    private void totalPrice() {
        if(!buildingArea.equals("")) {
            int Area = Integer.parseInt(buildingArea);
            switch (package_type) {
                case "normal":
                    if (Area >= 300) {
                        switch (building_type) {
                            case "villa":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 600 + (600 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 200 + (200 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 120 + (120 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 400 + (400 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }

                                break;
                            case "multistory":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 600 + (600 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 200 + (200 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 120 + (120 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 400 + (400 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "office":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 600 + (600 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 200 + (200 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 120 + (120 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 400 + (400 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }

                                break;
                            case "warehouse":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 6600 + (600 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 200 + (200 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 120 + (120 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 400 + (400 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }

                                break;
                            default:
                                Toast.makeText(FireInsurance.this,
                                        "please choose Building Type !",
                                        Toast.LENGTH_LONG).show();
                        }
                    } else if (Area < 300) {
                        switch (building_type) {
                            case "villa":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 600 + (600 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 200 + (200 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 120 + (120 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 400 + (400 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "multistory":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 600 + (600 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 200 + (200 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 120 + (120 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 400 + (400 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "office":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 600 + (600 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 200 + (200 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 120 + (120 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 400 + (400 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "warehouse":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 600 + (600 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 200 + (200 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 120 + (120 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 400 + (400 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }

                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Building Type !",
                                                Toast.LENGTH_LONG).show();
                                }

                    } else {

                        Toast.makeText(FireInsurance.this,
                                "Make sure you write Building model and check used or new car!",
                                Toast.LENGTH_LONG).show();
                    }
                    break;
                case "silver":
                    if (Area >= 300) {
                        switch (building_type) {
                            case "villa":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 800 + (800 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 400 + (400 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 160 + (150 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 890 + (890 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "multistory":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 800 + (800 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 400 + (400 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 160 + (160 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 890 + (890 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }

                                break;
                            case "office":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 800 + (800 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 400 + (400 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 160 + (160 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 890 + (890 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "warehouse":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 800 + (800 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 400 + (400 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 160 + (160 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 890 + (890 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            default:
                                Toast.makeText(FireInsurance.this,
                                        "please choose Building Type !",
                                        Toast.LENGTH_LONG).show();
                        }

                    } else if (Area < 300) {
                        switch (building_type) {
                            case "villa":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 800 + (800 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 400 + (400 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 160 + (160 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 890 + (890 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }

                                break;
                            case "multistory":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 800 + (800 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 400 + (400 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 160 + (160 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 890 + (890 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "office":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 800 + (800 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 400 + (400 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 160 + (160 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 890 + (890 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "warehouse":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 800 + (800 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 400 + (400 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 160 + (160 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 890 + (890 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            default:
                                Toast.makeText(FireInsurance.this,
                                        "please choose Building Type !",
                                        Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(FireInsurance.this,
                                "Make sure you write Building model and check used or new car!",
                                Toast.LENGTH_LONG).show();
                    }
                    break;
                case "gold":
                    if (Area >= 300) {
                        switch (building_type) {
                            case "villa":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 1700 + (1700 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 900 + (900 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 250 + (250 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 956 + (956 * 0.23);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "multistory":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 1700 + (1700 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 900 + (900 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 250 + (250 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 956 + (956 * 0.4);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "office":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 1700 + (1700 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 900 + (900 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 250 + (250 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 956 + (956 * 0.32);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "warehouse":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 1700 + (1700 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 900 + (900 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 250 + (250 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 956 + (956 * 0.27);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            default:
                                Toast.makeText(FireInsurance.this,
                                        "please choose Building Type !",
                                        Toast.LENGTH_LONG).show();
                        }
                    } else if (Area < 300) {
                        switch (building_type) {
                            case "villa":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 1700 + (800 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 900 + (900 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 250 + (250 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 956 + (956 * 0.03);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "multistory":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 1700 + (1700 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 900 + (900 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 250 + (250 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 956 + (956 * 0.2);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "office":
                                switch (Integer.parseInt(Company_Id)) {
                                    case 1:
                                        totalCarPrice = 1700 + (1700 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 900 + (900 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 250 + (250 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 956 + (956 * 0.12);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            case "warehouse":
                                switch (Integer.parseInt(Company_Id)){
                                    case 1:
                                        totalCarPrice = 1700 + (1700 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 2:
                                        totalCarPrice = 900 + (900 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 3:
                                        totalCarPrice = 250 + (250 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    case 4:
                                        totalCarPrice = 956 + (956 * 0.07);
                                        TotalPrice = "" + totalCarPrice;
                                        System.out.println(TotalPrice);
                                        break;
                                    default:
                                        Toast.makeText(FireInsurance.this,
                                                "please choose Company !", Toast.LENGTH_LONG).show();
                                }
                                break;
                            default:
                                Toast.makeText(FireInsurance.this,
                                        "please choose Building Type !",
                                        Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(FireInsurance.this,
                                "Make sure you write Building model and check used or new car!",
                                Toast.LENGTH_LONG).show();
                    }
                    break;
                default:
                    Toast.makeText(FireInsurance.this,
                            "please choose package Type !", Toast.LENGTH_LONG).show();
            }
        }else {
            AlertDialog.Builder mess =  new AlertDialog.Builder(FireInsurance.this);
            mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        //replaces the default 'Back' button action
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            this.startActivity(new Intent(FireInsurance.this,MainActivity.class));

        }
        return true;
    }
}