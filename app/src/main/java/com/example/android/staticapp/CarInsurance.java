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

public class CarInsurance extends AppCompatActivity {
    Spinner policyTypeSpinner;
    Spinner packageTypeSpinner;
    Spinner CarTypeSpinner;
    RadioButton ahliaInsurance_1;
    RadioButton axaInsurance_2;
    RadioButton takafulInsurance_3;
    RadioButton gulfInsurance_4;
    RadioButton carinsurance_used;
    RadioButton carinsurance_new;
    int CompanyFlag_ID;
    EditText carmakeModel;
    EditText carModelYear;
    EditText carregNum;
    EditText carCCHP;
    EditText carValue;
    EditText carseating;
    Button get_car_Insurance;
    public static String userID = login.user_id;
    public static String Policy_Type, Package_Type, Car_Type, Company_Id, Car_Model, Car_ModelYear;
    public static String Car_CC, Car_Value, Car_Seating, Car_UserNew="", Car_RegNum, TotalPrice="", ExpireDate;
    int FlagTotalPrice_Car = 0;
    public static int FlagInsurance_Car = 1;
    double totalCarPrice ;
    public static String CodeInsurance , s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_insurance);
        carmakeModel = (EditText) findViewById(R.id.carMakeModel);
        carModelYear = (EditText) findViewById(R.id.CarIDModel);
        carregNum = (EditText) findViewById(R.id.CarRegNum);
        carCCHP = (EditText) findViewById(R.id.CarCCHP);
        carValue = (EditText) findViewById(R.id.CarValueInsurance);
        carseating = (EditText) findViewById(R.id.CarSeating);
        carinsurance_used = (RadioButton) findViewById(R.id.CarInsurance_Used);
        carinsurance_new = (RadioButton) findViewById(R.id.CArInsurance_New);
        ahliaInsurance_1 = (RadioButton) findViewById(R.id.AhliaInsurance);
        ahliaInsurance_1.setChecked(true);
        axaInsurance_2 = (RadioButton) findViewById(R.id.AXAInsurance);
        takafulInsurance_3 = (RadioButton) findViewById(R.id.TakafulInsurance);
        gulfInsurance_4 = (RadioButton) findViewById(R.id.GulfInsurance);
        policyTypeSpinner = (Spinner) findViewById(R.id.Spinner_PolicyType_CarInsurance);
        ArrayList<String> items = new ArrayList<String>();
        items.add("full_coverage");
        items.add("3rd_party");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items);
        adapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        policyTypeSpinner.setAdapter(adapter);

        packageTypeSpinner = (Spinner) findViewById(R.id.Spinner_PackageType_CarInsurance);
        ArrayList<String> items_1 = new ArrayList<String>();
        items_1.add("normal");
        items_1.add("silver");
        items_1.add("gold");
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_1);
        adapter_1.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        packageTypeSpinner.setAdapter(adapter_1);

        CarTypeSpinner = (Spinner) findViewById(R.id.Spinner_CarType_CarInsurance);
        ArrayList<String> items_2 = new ArrayList<String>();
        items_2.add("jeep");
        items_2.add("van");
        items_2.add("sport");
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_2);
        adapter_2.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        CarTypeSpinner.setAdapter(adapter_2);

        get_car_Insurance = (Button) findViewById(R.id.GetCarQuotationInsurance);
        get_car_Insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ahliaInsurance_1.isChecked()) {
                    CompanyFlag_ID = 1;
                    FlagTotalPrice_Car = 1;
                } else if (axaInsurance_2.isChecked()) {
                    CompanyFlag_ID = 2;
                    FlagTotalPrice_Car = 2;
                } else if (takafulInsurance_3.isChecked()) {
                    CompanyFlag_ID = 3;
                    FlagTotalPrice_Car = 3;
                } else if (gulfInsurance_4.isChecked()) {
                    CompanyFlag_ID = 4;
                    FlagTotalPrice_Car = 4;
                } else {
                    Toast.makeText(CarInsurance.this,
                            "please choose Company !", Toast.LENGTH_LONG).show();
                }
                Policy_Type = policyTypeSpinner.getSelectedItem().toString();
                Package_Type = packageTypeSpinner.getSelectedItem().toString();
                Car_Type = CarTypeSpinner.getSelectedItem().toString();
                Car_Model = carmakeModel.getText().toString();
                Car_ModelYear = carModelYear.getText().toString();
                Car_CC = carCCHP.getText().toString();
                if (carinsurance_new.isChecked()) {
                    Car_UserNew = "new";
                } else if (carinsurance_used.isChecked()) {
                    Car_UserNew = "used";
                }
                Car_Seating = carseating.getText().toString();
                Car_Value = carValue.getText().toString();
                Car_RegNum = carregNum.getText().toString();
                Company_Id = "" + CompanyFlag_ID;
                long rand15Digt = (long) (Math.random() * 100000000000000L);
                    s1 = "CIns" + rand15Digt;
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                ExpireDate = date;
                System.out.println(ExpireDate);
                    if (!Policy_Type.equals("") && !Package_Type.equals("") && !Car_Type.equals("") && !Car_Model.equals("") &&
                            !Car_ModelYear.equals("") && !Car_CC.equals("") && !Car_UserNew.equals("") &&
                            !Car_Seating.equals("") && !Car_Value.equals("") && !Car_RegNum.equals("") &&
                            !userID.equals("") && !Company_Id.equals("")) {
                        Log.i("MainActivity", Policy_Type);
                        Log.i("MainActivity", Package_Type);
                        Log.i("MainActivity", Car_Type);
                        Log.i("MainActivity", Car_Model);
                        Log.i("MainActivity", Car_ModelYear);
                        Log.i("MainActivity", Car_CC);
                        Log.i("MainActivity", Car_Seating);
                        Log.i("MainActivity", Car_Value);
                        Log.i("MainActivity", Car_RegNum);
                        Log.i("MainActivity", userID);
                        Log.i("MainActivity", Company_Id);
                        Log.i("MainActivity", Car_UserNew);
                        totalPrice();
                        System.out.println(TotalPrice);
                        Log.i("MainActivity", s1);
                        confirmInsurance.setFlagResultInsurenceDone(FlagInsurance_Car);
                        Intent intent = new Intent(CarInsurance.this, confirmInsurance.class);
                        startActivity(intent);

                    } else {
                        AlertDialog.Builder mess =  new AlertDialog.Builder(CarInsurance.this);
                        mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();
                    }


            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //replaces the default 'Back' button action
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.startActivity(new Intent(CarInsurance.this, MainActivity.class));

        }
        return true;
    }

    public void totalPrice() {
        if(!Car_ModelYear.equals("")) {
            int Model = Integer.parseInt(Car_ModelYear);
            if (Policy_Type.equals("full_coverage")) {
                switch (Package_Type) {
                    case "normal":
                        if (Model > 2010 && carinsurance_used.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 200 + (200 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 180 + (180 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 150 + (150 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 100 + (100 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 200 + (200 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 180 + (180 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 150 + (150 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 100 + (100 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 200 + (200 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 180 + (180 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 150 + (150 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 100 + (100 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model > 2010 && carinsurance_new.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 200 + (200 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 180 + (180 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 150 + (150 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 100 + (100 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 200 + (200 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 180 + (180 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 150 + (150 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 100 + (100 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 200 + (200 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 180 + (180 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 150 + (150 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 100 + (100 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model <= 2010) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 200 + (200 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 180 + (180 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 150 + (150 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 100 + (100 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 200 + (200 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 180 + (180 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 150 + (150 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 100 + (100 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 200 + (200 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 180 + (180 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 150 + (150 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 100 + (100 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(CarInsurance.this,
                                    "Make sure you write car model and check used or new car!",
                                    Toast.LENGTH_LONG).show();
                        }
                        break;
                    case "silver":
                        if (Model > 2010 && carinsurance_used.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 210 + (210 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 200 + (200 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 180 + (180 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 160 + (160 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 210 + (210 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 200 + (200 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 180 + (180 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 160 + (160 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 210 + (210 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 200 + (200 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 180 + (180 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 160 + (160 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model > 2010 && carinsurance_new.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 210 + (210 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 200 + (200 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 180 + (180 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 160 + (160 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 210 + (210 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 200 + (200 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 180 + (180 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 160 + (160 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 210 + (210 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 200 + (200 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 180 + (180 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 160 + (160 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model <= 2010) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 210 + (210 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 200 + (200 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 180 + (180 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 160 + (160 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 210 + (210 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 200 + (200 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 180 + (180 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 160 + (160 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 210 + (210 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 200 + (200 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 180 + (180 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 160 + (160 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(CarInsurance.this,
                                    "Make sure you write car model and check used or new car!",
                                    Toast.LENGTH_LONG).show();
                        }
                        break;
                    case "gold":
                        if (Model > 2010 && carinsurance_used.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 260 + (260 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 230 + (230 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 240 + (240 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 250 + (250 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 260 + (260 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 230 + (230 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 240 + (240 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 250 + (250 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 260 + (260 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (230 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 240 + (240 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 250 + (250 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model > 2010 && carinsurance_new.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 260 + (260 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 230 + (230 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 240 + (240 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 250 + (250 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 260 + (260 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 230 + (230 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 240 + (240 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 250 + (250 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 260 + (260 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (230 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 240 + (240 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 250 + (250 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model <= 2010) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 260 + (260 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 230 + (230 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 240 + (240 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 250 + (250 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 260 + (260 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 230 + (230 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 240 + (240 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 250 + (250 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 260 + (260 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (230 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 240 + (240 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 250 + (250 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(CarInsurance.this,
                                    "Make sure you write car model and check used or new car!",
                                    Toast.LENGTH_LONG).show();
                        }
                        break;
                    default:
                        Toast.makeText(CarInsurance.this,
                                "please choose package Type !", Toast.LENGTH_LONG).show();
                }

            } else if (Policy_Type.equals("3rd_party")) {
                switch (Package_Type) {
                    case "normal":
                        if (Model > 2010 && carinsurance_used.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 105 + (105 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 120 + (120 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 60 + (60 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 60 + (60 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 105 + (105 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 120 + (120 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 60 + (60 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 60 + (60 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 105 + (105 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 120 + (120 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 60 + (60 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 60 + (60 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model > 2010 && carinsurance_new.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 105 + (105 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 120 + (120 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 60 + (60 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 60 + (60 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 105 + (105 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 120 + (120 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 60 + (60 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 60 + (60 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 105 + (105 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 120 + (120 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 60 + (60 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 60 + (60 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model <= 2010) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 105 + (105 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 120 + (120 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 60 + (60 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 60 + (60 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 105 + (105 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 120 + (120 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 60 + (60 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 60 + (60 * 0.100);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 105 + (105 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 120 + (120 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 60 + (60 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 60 + (60 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(CarInsurance.this,
                                    "Make sure you write car model and check used or new car!",
                                    Toast.LENGTH_LONG).show();
                        }
                        break;
                    case "silver":
                        if (Model > 2010 && carinsurance_used.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 115 + (115 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (130 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 80 + (80 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 70 + (70 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 115 + (115 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (130 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 80 + (80 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 70 + (70 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 115 + (115 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (130 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 80 + (80 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 70 + (70 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }

                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model > 2010 && carinsurance_new.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 115 + (115 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (130 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 0 + (80 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 70 + (70 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 115 + (115 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (130 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 80 + (80 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 70 + (70 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 115 + (115 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (130 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 80 + (80 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 70 + (70 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model <= 2010) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 115 + (115 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (130 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 80 + (80 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 70 + (70 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 115 + (115 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (130 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 80 + (80 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 70 + (70 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 115 + (115 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 130 + (130 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 80 + (80 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 70 + (70 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(CarInsurance.this,
                                    "Make sure you write car model and check used or new car!",
                                    Toast.LENGTH_LONG).show();
                        }
                        break;
                    case "gold":
                        if (Model > 2010 && carinsurance_used.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 130 + (130 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 140 + (140 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 100 + (100 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 90 + (90 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 130 + (130 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 140 + (140 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 100 + (100 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 90 + (90 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 130 + (130 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 140 + (140 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 100 + (100 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 90 + (90 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model > 2010 && carinsurance_new.isChecked()) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 130 + (130 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 140 + (140 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 100 + (100 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 90 + (90 * 0.14);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 130 + (130 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 140 + (140 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 100 + (100 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 90 + (90 * 0.15);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 130 + (130 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 140 + (140 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 100 + (100 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 90 + (90 * 0.23);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else if (Model <= 2010) {
                            switch (Car_Type) {
                                case "jeep":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 130 + (130 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 140 + (140 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 100 + (100 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 90 + (90 * 0.09);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "van":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 130 + (130 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 140 + (140 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 100 + (100 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 90 + (90 * 0.10);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                case "sport":
                                    switch (Integer.parseInt(Company_Id)) {
                                        case 1:
                                            totalCarPrice = 130 + (130 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 2:
                                            totalCarPrice = 140 + (140 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 3:
                                            totalCarPrice = 100 + (100 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        case 4:
                                            totalCarPrice = 90 + (90 * 0.18);
                                            TotalPrice = "" + totalCarPrice;
                                            System.out.println(TotalPrice);
                                            break;
                                        default:
                                            Toast.makeText(CarInsurance.this,
                                                    "please choose Company !", Toast.LENGTH_LONG).show();
                                    }
                                    break;
                                default:
                                    Toast.makeText(CarInsurance.this,
                                            "please choose Car Type !",
                                            Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(CarInsurance.this,
                                    "Make sure you write car model and check used or new car!",
                                    Toast.LENGTH_LONG).show();
                        }
                        break;
                    default:
                        Toast.makeText(CarInsurance.this,
                                "please choose package Type !", Toast.LENGTH_LONG).show();
                }
            }
        }else{
            AlertDialog.Builder mess =  new AlertDialog.Builder(CarInsurance.this);
            mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();
        }
    }
}

