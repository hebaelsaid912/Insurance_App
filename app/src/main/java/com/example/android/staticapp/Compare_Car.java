package com.example.android.staticapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Compare_Car extends AppCompatActivity {
    Spinner policyTypeSpinner;
    Spinner packageTypeSpinner;
    Spinner CarTypeSpinner;
    Button CarCompare;
    EditText carmodel;
    RadioButton usedCar;
    RadioButton newCar;
    public static String AhliaResult ;
    public static String AXAResult ;
    public static String TakafulResult ;
    public static String GulfResult ;
    double AhliaRes ,  AXARes,TakafulRes,GulfRes;
    int Carflag = 1;
    int Model=0;
    String policyType, packageType, CarType, Car_ModelYear , carModel="";
    String Car_UserNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare__car);
        carmodel = (EditText) findViewById(R.id.carModel);
        usedCar = (RadioButton) findViewById(R.id.UsedCar);
        newCar = (RadioButton) findViewById(R.id.NewCar);
        policyTypeSpinner = (Spinner) findViewById(R.id.Spinner_PolicyType_CarCompare) ;
        ArrayList<String> items = new ArrayList<String>();
        items.add("Full Coverage");
        items.add("3rd Party");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items);
        adapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        policyTypeSpinner.setAdapter(adapter);
        packageTypeSpinner = (Spinner) findViewById(R.id.Spinner_PackageType_CarCompare) ;
        ArrayList<String> items_1 = new ArrayList<String>();
        items_1.add("Normal");
        items_1.add("Silver");
        items_1.add("Gold");
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_1);
        adapter_1.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        packageTypeSpinner.setAdapter(adapter_1);

        CarTypeSpinner = (Spinner) findViewById(R.id.Spinner_CarType_CarCompare) ;
        ArrayList<String> items_2 = new ArrayList<String>();
        items_2.add("Jeep");
        items_2.add("Van");
        items_2.add("Sport");
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_2);
        adapter_2.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        CarTypeSpinner.setAdapter(adapter_2);
        CarCompare = (Button) findViewById(R.id.CarCompare);
        CarCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CompareQuotationsPrice.setFlag(Carflag);
                policyType = policyTypeSpinner.getSelectedItem().toString();
                packageType = packageTypeSpinner.getSelectedItem().toString();
                CarType = CarTypeSpinner.getSelectedItem().toString();
                carModel = carmodel.getText().toString();
                if(usedCar.isChecked()){
                    Car_UserNew = "used";
                }else if(newCar.isChecked()){
                    Car_UserNew = "new";
                }
                System.out.println(policyType);
                System.out.println(packageType);
                System.out.println(Car_ModelYear);
                System.out.println(CarType);
                System.out.println(Car_UserNew);
                if (!policyType.equals("") && !packageType.equals("") && !CarType.equals("") &&
                        !carModel.equals("")) {
                    Model = Integer.parseInt(carModel);
                    Car_ModelYear = "" + Model;
                    if (policyType.equals("Full Coverage")) {
                        switch (packageType) {
                            case "Normal":
                                if (Model > 2010 && usedCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 200 + (200 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            System.out.println(AhliaResult);
                                            AXARes = 180 + (180 * 0.14);
                                            AXAResult = "" + AXARes;
                                            System.out.println(AXAResult);
                                            TakafulRes = 150 + (150 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            System.out.println(TakafulResult);
                                            GulfRes = 100 + (100 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            System.out.println(GulfResult);
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 200 + (200 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 180 + (180 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 150 + (150 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 100 + (100 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 200 + (200 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 180 + (180 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 150 + (150 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 100 + (100 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model > 2010 && newCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 200 + (200 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 180 + (180 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 150 + (150 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 100 + (100 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 200 + (200 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 180 + (180 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 150 + (150 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 100 + (100 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 200 + (200 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 180 + (180 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 150 + (150 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 100 + (100 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model <= 2010) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 200 + (200 * 0.09);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 180 + (180 * 0.09);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 150 + (150 * 0.09);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 100 + (100 * 0.09);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 200 + (200 * 0.10);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 180 + (180 * 0.10);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 150 + (150 * 0.10);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 100 + (100 * 0.10);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 200 + (200 * 0.18);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 180 + (180 * 0.18);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 150 + (150 * 0.18);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 100 + (100 * 0.18);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Car.this);
                                    mess.setMessage("Make sure you write car model and check used or new car!").setTitle("Alert !").setCancelable(true).show();
                                }
                                break;
                            case "Silver":
                                if (Model > 2010 && usedCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 210 + (210 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 200 + (200 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 180 + (180 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 160 + (160 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 210 + (210 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 200 + (200 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 180 + (180 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 160 + (160 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 210 + (210 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 200 + (200 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 180 + (180 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 160 + (160 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model > 2010 && newCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 210 + (210 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 200 + (200 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 180 + (180 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 160 + (160 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 210 + (210 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 200 + (200 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 180 + (180 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 160 + (160 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 210 + (210 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 200 + (200 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 180 + (180 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 160 + (160 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model <= 2010) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 210 + (210 * 0.09);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 200 + (200 * 0.09);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 180 + (180 * 0.09);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 160 + (160 * 0.09);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 210 + (210 * 0.10);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 200 + (200 * 0.10);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 180 + (180 * 0.10);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 160 + (160 * 0.10);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 210 + (210 * 0.18);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 200 + (200 * 0.18);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 180 + (180 * 0.18);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 160 + (160 * 0.18);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Car.this);
                                    mess.setMessage("Make sure you write car model and check used or new car!").setTitle("Alert !").setCancelable(true).show();
                                }
                                break;
                            case "Gold":
                                if (Model > 2010 && usedCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 260 + (260 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 230 + (230 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 240 + (240 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 250 + (250 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 260 + (260 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 230 + (230 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 240 + (240 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 250 + (250 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 260 + (260 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (230 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 240 + (240 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 250 + (250 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model > 2010 && newCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 260 + (260 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 230 + (230 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 240 + (240 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 250 + (250 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 260 + (260 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 230 + (230 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 240 + (240 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 250 + (250 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 260 + (260 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (230 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 240 + (240 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 250 + (250 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model <= 2010) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 260 + (260 * 0.09);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 230 + (230 * 0.09);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 240 + (240 * 0.09);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 250 + (250 * 0.09);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 260 + (260 * 0.10);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 230 + (230 * 0.10);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 240 + (240 * 0.10);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 250 + (250 * 0.10);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 260 + (260 * 0.18);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (230 * 0.18);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 240 + (240 * 0.18);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 250 + (250 * 0.18);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Car.this);
                                    mess.setMessage("Make sure you write car model and check used or new car!").setTitle("Alert !").setCancelable(true).show();

                                }
                                break;
                            default:
                                Toast.makeText(Compare_Car.this,
                                        "please choose package Type !", Toast.LENGTH_LONG).show();
                        }

                    } else if (policyType.equals("3rd Party")) {
                        switch (packageType) {
                            case "Normal":
                                if (Model > 2010 && usedCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 105 + (105 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 120 + (120 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 60 + (60 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 60 + (60 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 105 + (105 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 120 + (120 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 60 + (60 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 60 + (60 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 105 + (105 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 120 + (120 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 60 + (60 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 60 + (60 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model > 2010 && newCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 105 + (105 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 120 + (120 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 60 + (60 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 60 + (60 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 105 + (105 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 120 + (120 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 60 + (60 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 60 + (60 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 105 + (105 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 120 + (120 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 60 + (60 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 60 + (60 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model <= 2010) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 105 + (105 * 0.09);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 120 + (120 * 0.09);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 60 + (60 * 0.09);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 60 + (60 * 0.09);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 105 + (105 * 0.10);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 120 + (120 * 0.10);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 60 + (60 * 0.10);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 60 + (60 * 0.10);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 105 + (105 * 0.18);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 120 + (120 * 0.18);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 60 + (60 * 0.18);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 60 + (60 * 0.18);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Car.this);
                                    mess.setMessage("Make sure you write car model and check used or new car!").setTitle("Alert !").setCancelable(true).show();
                                }
                                break;
                            case "Silver":
                                if (Model > 2010 && usedCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 115 + (115 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (130 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 80 + (80 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 70 + (70 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 115 + (115 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (130 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 80 + (80 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 70 + (70 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 115 + (115 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (130 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 80 + (80 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 70 + (70 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model > 2010 && newCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 115 + (115 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (130 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 80 + (80 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 70 + (70 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 115 + (115 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (130 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 80 + (80 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 70 + (70 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 115 + (115 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (130 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 80 + (80 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 70 + (70 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model <= 2010) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 115 + (115 * 0.09);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (130 * 0.09);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 80 + (80 * 0.09);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 70 + (70 * 0.09);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 115 + (115 * 0.10);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (130 * 0.10);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 80 + (80 * 0.10);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 70 + (70 * 0.10);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 115 + (115 * 0.18);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 130 + (130 * 0.18);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 80 + (80 * 0.18);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 70 + (70 * 0.18);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Car.this);
                                    mess.setMessage("Make sure you write car model and check used or new car!").setTitle("Alert !").setCancelable(true).show();
                                }
                                break;
                            case "Gold":
                                if (Model > 2010 && usedCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 130 + (130 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 140 + (140 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 100 + (100 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 90 + (90 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 130 + (130 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 140 + (140 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 100 + (100 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 90 + (90 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 130 + (130 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 140 + (140 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 100 + (100 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 90 + (90 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model > 2010 && newCar.isChecked()) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 130 + (130 * 0.14);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 140 + (140 * 0.14);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 100 + (100 * 0.14);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 90 + (90 * 0.14);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 130 + (130 * 0.15);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 140 + (140 * 0.15);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 100 + (100 * 0.15);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 90 + (90 * 0.15);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 130 + (130 * 0.23);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 140 + (140 * 0.23);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 100 + (100 * 0.23);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 90 + (90 * 0.23);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else if (Model <= 2010) {
                                    switch (CarType) {
                                        case "Jeep":
                                            AhliaRes = 130 + (130 * 0.09);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 140 + (140 * 0.09);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 100 + (100 * 0.09);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 90 + (90 * 0.09);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Van":
                                            AhliaRes = 130 + (130 * 0.10);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 140 + (140 * 0.10);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 100 + (100 * 0.10);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 90 + (90 * 0.10);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        case "Sport":
                                            AhliaRes = 130 + (130 * 0.18);
                                            AhliaResult = "" + AhliaRes;
                                            AXARes = 140 + (140 * 0.18);
                                            AXAResult = "" + AXARes;
                                            TakafulRes = 100 + (100 * 0.18);
                                            TakafulResult = "" + TakafulRes;
                                            GulfRes = 90 + (90 * 0.18);
                                            GulfResult = "" + GulfRes;
                                            Go_ResulCompare();
                                            break;
                                        default:
                                            Toast.makeText(Compare_Car.this,
                                                    "please choose Car Type !",
                                                    Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Car.this);
                                    mess.setMessage("Make sure you write car model and check used or new car!").setTitle("Alert !").setCancelable(true).show();
                                }
                                break;
                            default:
                                Toast.makeText(Compare_Car.this,
                                        "please choose package Type !", Toast.LENGTH_LONG).show();
                        }
                    }

                }else {
                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Car.this);
                    mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();

                }
            }
        });

    }

     void Go_ResulCompare() {
        Intent intent = new Intent(Compare_Car.this,CompareQuotationsPrice.class);
        startActivity(intent);
    }
}