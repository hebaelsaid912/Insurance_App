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

public class Compare_Health extends AppCompatActivity {
    Spinner packageTypeSpinner;
    Button HealthCompare;
    public static String AhliaResult_health ;
    public static String AXAResult_health ;
    public static String TakafulResult_health ;
    public static String GulfResult_health ;
    double AhliaRes_health ,  AXARes_health,TakafulRes_health,GulfRes_health;
    int Healthflag = 2;
    EditText InsuredNameCompare;
    EditText InsuredCPRCompare;
    RadioButton dantelYes;
    RadioButton dantelNo;
    RadioButton maternityYes;
    RadioButton maternityNo;
    String insuredName , insuredCPR , dental="" , Maternity="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare__health);
        InsuredNameCompare = (EditText) findViewById(R.id.InsurdName_HealthCompare);

        InsuredCPRCompare = (EditText) findViewById(R.id.InsurdCPR_HealthCompare);

        dantelYes = (RadioButton) findViewById(R.id.dentelCareYes_Compare);
        dantelNo = (RadioButton) findViewById(R.id.dentelCareNo_Compare);

        maternityYes = (RadioButton) findViewById(R.id.MaterntyYes_Compare);
        maternityNo = (RadioButton) findViewById(R.id.MaterntyNo_Compare);

        packageTypeSpinner = (Spinner) findViewById(R.id.Spinner_PackageType_HealthCompare) ;
        ArrayList<String> items_1 = new ArrayList<String>();
        items_1.add("Normal");
        items_1.add("Silver");
        items_1.add("Gold");
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_1);
        adapter_1.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        packageTypeSpinner.setAdapter(adapter_1);
        HealthCompare = (Button) findViewById(R.id.HealthCompare);
        HealthCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CompareQuotationsPrice.setFlag(Healthflag);
                String packageType = packageTypeSpinner.getSelectedItem().toString();
                insuredName = InsuredNameCompare.getText().toString();
                insuredCPR = InsuredCPRCompare.getText().toString();
                if(dantelYes.isChecked()){
                    dental="yes";
                }else if(dantelNo.isChecked()){
                    dental = "No";
                }
                if (maternityYes.isChecked()){
                    Maternity = "yes";
                }else if(maternityNo.isChecked()){
                    Maternity = "No";
                }
                System.out.println(insuredName);
                System.out.println(insuredCPR);
                System.out.println(packageType);
                System.out.println(dental);
                System.out.println(Maternity);
                if(!insuredName.equals("") && !insuredCPR.equals("")
                        && !dental.equals("") && !Maternity.equals("")) {
                    switch (packageType) {
                        case "Normal":
                            AhliaResult_health = "" + 220;
                            System.out.println(AhliaResult_health);
                            AXAResult_health = "" + 420;
                            System.out.println(AXAResult_health);
                            TakafulResult_health = "" + 240;
                            System.out.println(TakafulResult_health);
                            GulfResult_health = "" + 200;
                            System.out.println(GulfResult_health);
                            Go_ResulCompare();
                            break;
                        case "Silver":
                            AhliaResult_health = "" + 245;
                            AXAResult_health = "" + 480;
                            TakafulResult_health = "" + 420;
                            GulfResult_health = "" + 300;
                            Go_ResulCompare();
                            break;
                        case "Gold":
                            AhliaResult_health = "" + 480;
                            AXAResult_health = "" + 510;
                            TakafulResult_health = "" + 610;
                            GulfResult_health = "" + 400;
                            Go_ResulCompare();
                            break;
                        default:
                            AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Health.this);
                            mess.setMessage("please choose package Type !").setTitle("Alert !").setCancelable(true).show();
                    }
                }else {
                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Health.this);
                    mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();

                }
            }
        });
    }
    void Go_ResulCompare(){
        Intent intent = new Intent(Compare_Health.this,CompareQuotationsPrice.class);
        startActivity(intent);
    }
}