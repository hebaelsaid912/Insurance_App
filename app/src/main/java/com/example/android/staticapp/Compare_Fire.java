package com.example.android.staticapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Compare_Fire extends AppCompatActivity {
    Spinner packageTypeSpinner;
    Spinner buildingTypeSpinner;
    EditText BuildingArea;
    Button FireCompare;
    public static String AhliaResult_fire ;
    public static String AXAResult_fire ;
    public static String TakafulResult_fire ;
    public static String GulfResult_fire ;
    double AhliaRes_fire ,  AXARes_fire,TakafulRes_fire,GulfRes_fire;
    int Fireflag = 4;
    String Building_Area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare__fire);
        BuildingArea = (EditText) findViewById(R.id.buildingArea_Fire);
        packageTypeSpinner = (Spinner) findViewById(R.id.Spinner_PackageType_FireCompare) ;
        ArrayList<String> items_1 = new ArrayList<String>();
        items_1.add("Normal");
        items_1.add("Silver");
        items_1.add("Gold");
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_1);
        adapter_1.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        packageTypeSpinner.setAdapter(adapter_1);
        buildingTypeSpinner = (Spinner) findViewById(R.id.Spinner_BuildingType_FireCompare) ;
        ArrayList<String> items_2 = new ArrayList<String>();
        items_2.add("Villa");
        items_2.add("Multistory");
        items_2.add("Office");
        items_2.add("Warehouse");
        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_2);
        adapter_2.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        buildingTypeSpinner.setAdapter(adapter_2);
        FireCompare = (Button) findViewById(R.id.fireCompare);
        FireCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CompareQuotationsPrice.setFlag(Fireflag);
                String packageType = packageTypeSpinner.getSelectedItem().toString();
                String BuildingType = buildingTypeSpinner.getSelectedItem().toString();
                Building_Area = BuildingArea.getText().toString() +"";
                if(!Building_Area.equals("")) {
                    int Area = Integer.parseInt(BuildingArea.getText().toString());
                    switch (packageType) {
                        case "Normal":
                            if (Area >= 300) {
                                switch (BuildingType) {
                                    case "Villa":
                                        AhliaRes_fire = 600 + (600 * 0.23);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 200 + (200 * 0.23);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 120 + (120 * 0.23);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 400 + (400 * 0.23);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Multistory":
                                        AhliaRes_fire = 600 + (600 * 0.4);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 200 + (200 * 0.4);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 120 + (120 * 0.4);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 400 + (400 * 0.4);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Office":
                                        AhliaRes_fire = 600 + (600 * 0.32);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 200 + (200 * 0.32);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 120 + (120 * 0.32);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 400 + (400 * 0.32);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Warehouse":
                                        AhliaRes_fire = 600 + (600 * 0.27);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 200 + (200 * 0.27);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 120 + (120 * 0.27);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 400 + (400 * 0.27);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    default:
                                        Toast.makeText(Compare_Fire.this,
                                                "please choose Building Type !",
                                                Toast.LENGTH_LONG).show();
                                }
                            } else if (Area < 300) {
                                switch (BuildingType) {
                                    case "Villa":
                                        AhliaRes_fire = 600 + (600 * 0.03);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 200 + (200 * 0.03);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 120 + (120 * 0.03);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 400 + (400 * 0.03);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Multistory":
                                        AhliaRes_fire = 600 + (600 * 0.2);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 200 + (200 * 0.2);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 120 + (120 * 0.2);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 400 + (400 * 0.2);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Office":
                                        AhliaRes_fire = 600 + (600 * 0.12);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 200 + (200 * 0.12);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 120 + (120 * 0.12);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 400 + (400 * 0.12);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Warehouse":
                                        AhliaRes_fire = 600 + (600 * 0.07);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 200 + (200 * 0.07);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 120 + (120 * 0.07);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 400 + (400 * 0.07);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    default:
                                        Toast.makeText(Compare_Fire.this,
                                                "please choose Building Type !",
                                                Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(Compare_Fire.this,
                                        "Make sure you write Building model and check used or new car!",
                                        Toast.LENGTH_LONG).show();
                            }
                            break;
                        case "Silver":
                            if (Area >= 300) {
                                switch (BuildingType) {
                                    case "Villa":
                                        AhliaRes_fire = 800 + (800 * 0.23);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 400 + (400 * 0.23);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 160 + (150 * 0.23);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 890 + (890 * 0.23);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Multistory":
                                        AhliaRes_fire = 800 + (800 * 0.4);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 400 + (400 * 0.4);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 160 + (160 * 0.4);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 890 + (890 * 0.4);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Office":
                                        AhliaRes_fire = 800 + (800 * 0.32);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 400 + (400 * 0.32);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 160 + (160 * 0.32);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 890 + (890 * 0.32);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Warehouse":
                                        AhliaRes_fire = 800 + (800 * 0.27);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 400 + (400 * 0.27);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 160 + (160 * 0.27);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 890 + (890 * 0.27);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    default:
                                        Toast.makeText(Compare_Fire.this,
                                                "please choose Building Type !",
                                                Toast.LENGTH_LONG).show();
                                }
                            } else if (Area < 300) {
                                switch (BuildingType) {
                                    case "Villa":
                                        AhliaRes_fire = 800 + (800 * 0.03);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 400 + (400 * 0.03);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 160 + (160 * 0.03);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 890 + (890 * 0.03);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Multistory":
                                        AhliaRes_fire = 800 + (800 * 0.2);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 400 + (400 * 0.2);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 160 + (160 * 0.2);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 890 + (890 * 0.2);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Office":
                                        AhliaRes_fire = 800 + (800 * 0.12);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 400 + (400 * 0.12);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 160 + (160 * 0.12);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 890 + (890 * 0.12);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Warehouse":
                                        AhliaRes_fire = 800 + (800 * 0.07);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 400 + (400 * 0.07);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 160 + (160 * 0.07);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 890 + (890 * 0.07);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    default:
                                        Toast.makeText(Compare_Fire.this,
                                                "please choose Building Type !",
                                                Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(Compare_Fire.this,
                                        "Make sure you write Building model and check used or new car!",
                                        Toast.LENGTH_LONG).show();
                            }
                            break;
                        case "Gold":
                            if (Area >= 300) {
                                switch (BuildingType) {
                                    case "Villa":
                                        AhliaRes_fire = 1700 + (1700 * 0.23);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 900 + (900 * 0.23);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 250 + (250 * 0.23);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 956 + (956 * 0.23);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Multistory":
                                        AhliaRes_fire = 1700 + (1700 * 0.4);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 900 + (900 * 0.4);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 250 + (250 * 0.4);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 956 + (956 * 0.4);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Office":
                                        AhliaRes_fire = 1700 + (1700 * 0.32);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 900 + (900 * 0.32);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 250 + (250 * 0.32);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 956 + (956 * 0.32);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Warehouse":
                                        AhliaRes_fire = 1700 + (1700 * 0.27);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 900 + (900 * 0.27);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 250 + (250 * 0.27);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 956 + (956 * 0.27);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    default:
                                        Toast.makeText(Compare_Fire.this,
                                                "please choose Building Type !",
                                                Toast.LENGTH_LONG).show();
                                }
                            } else if (Area < 300) {
                                switch (BuildingType) {
                                    case "Villa":
                                        AhliaRes_fire = 1700 + (800 * 0.03);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 900 + (900 * 0.03);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 250 + (250 * 0.03);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 956 + (956 * 0.03);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Multistory":
                                        AhliaRes_fire = 1700 + (1700 * 0.2);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 900 + (900 * 0.2);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 250 + (250 * 0.2);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 956 + (956 * 0.2);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Office":
                                        AhliaRes_fire = 1700 + (1700 * 0.12);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 900 + (900 * 0.12);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 250 + (250 * 0.12);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 956 + (956 * 0.12);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    case "Warehouse":
                                        AhliaRes_fire = 1700 + (1700 * 0.07);
                                        AhliaResult_fire = "" + AhliaRes_fire;
                                        System.out.println(AhliaResult_fire);
                                        AXARes_fire = 900 + (900 * 0.07);
                                        AXAResult_fire = "" + AXARes_fire;
                                        System.out.println(AXAResult_fire);
                                        TakafulRes_fire = 250 + (250 * 0.07);
                                        TakafulResult_fire = "" + TakafulRes_fire;
                                        System.out.println(TakafulResult_fire);
                                        GulfRes_fire = 956 + (956 * 0.07);
                                        GulfResult_fire = "" + GulfRes_fire;
                                        System.out.println(GulfResult_fire);
                                        Go_ResulCompare();
                                        break;
                                    default:
                                        Toast.makeText(Compare_Fire.this,
                                                "please choose Building Type !",
                                                Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(Compare_Fire.this,
                                        "Make sure you write Building model and check used or new car!",
                                        Toast.LENGTH_LONG).show();
                            }
                            break;
                        default:
                            Toast.makeText(Compare_Fire.this,
                                    "please choose package Type !", Toast.LENGTH_LONG).show();
                    }
                }else {
                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Fire.this);
                    mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();

                }
            }
        });
    }
    void Go_ResulCompare() {
        Intent intent = new Intent(Compare_Fire.this,CompareQuotationsPrice.class);
        startActivity(intent);
    }
}