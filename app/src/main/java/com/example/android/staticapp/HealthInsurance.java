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

public class HealthInsurance extends AppCompatActivity {
    Spinner packageTypeSpinner;
    Spinner policyTypeSpinner;
    RadioButton ahliaInsurance_1;
    RadioButton axaInsurance_2;
    RadioButton takafulInsurance_3;
    RadioButton gulfInsurance_4;
    RadioButton DentelCareYes;
    RadioButton DentelCareNo;
    RadioButton MaternityYes;
    RadioButton MaternityNo;
    EditText InsuredNameHealthInsurance;
    EditText InsuredCPRHealthInsurance;
    public static String Policy_Type;
    public static String userID = login.user_id;
    public static String insuredName, package_type, insuredCPR, Company_Id , DentalCare="" ,MaternityHealth="", ExpireDate ;
    Button GetHealthQuotation_Insurance ;
    int CompanyFlag_ID;
    public static int FlagInsurance_Health = 2;
    public static String TotalPrice ;
    public static String CodeInsurance , s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_insurance);
        ahliaInsurance_1 = (RadioButton) findViewById(R.id.AhliaInsurance_Health);
        ahliaInsurance_1.setChecked(true);
        axaInsurance_2 = (RadioButton) findViewById(R.id.AXAInsurance_Health);
        takafulInsurance_3 = (RadioButton) findViewById(R.id.TakafulInsurance_Health);
        gulfInsurance_4 = (RadioButton) findViewById(R.id.GulfInsurance_Health);
        DentelCareYes = (RadioButton) findViewById(R.id.DentelHealthYes_Insurance);
        DentelCareNo = (RadioButton) findViewById(R.id.DentelHealthNo_Insurance);
        MaternityYes = (RadioButton) findViewById(R.id.MaternityHealthYes_Insurance);
        MaternityNo = (RadioButton) findViewById(R.id.MaternityHealthNo_Insurance);
        InsuredCPRHealthInsurance = (EditText) findViewById(R.id.InsuredCPR_HealthInsurance);
        InsuredNameHealthInsurance = (EditText) findViewById(R.id.InsuredName_HealthInsurance);
        policyTypeSpinner = (Spinner) findViewById(R.id.Spinner_PolicyType_HealthInsurance);
        ArrayList<String> items = new ArrayList<String>();
        items.add("full_coverage");
        items.add("3rd_party");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items);
        adapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        policyTypeSpinner.setAdapter(adapter);
        packageTypeSpinner = (Spinner) findViewById(R.id.Spinner_PackageType_HealthInsurance) ;
        ArrayList<String> items_1 = new ArrayList<String>();
        items_1.add("normal");
        items_1.add("silver");
        items_1.add("gold");
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_1);
        adapter_1.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        packageTypeSpinner.setAdapter(adapter_1);
        GetHealthQuotation_Insurance = (Button) findViewById(R.id.GetHealthQuotationInsurance);
        GetHealthQuotation_Insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Policy_Type = policyTypeSpinner.getSelectedItem().toString();
                package_type = packageTypeSpinner.getSelectedItem().toString();
                insuredName = InsuredNameHealthInsurance.getText().toString();
                insuredCPR = InsuredCPRHealthInsurance.getText().toString();

                if (ahliaInsurance_1.isChecked()) {
                    CompanyFlag_ID = 1;
                } else if (axaInsurance_2.isChecked()) {
                    CompanyFlag_ID = 2;
                } else if (takafulInsurance_3.isChecked()) {
                    CompanyFlag_ID = 3;
                } else if (gulfInsurance_4.isChecked()) {
                    CompanyFlag_ID = 4;
                } else {
                    Toast.makeText(HealthInsurance.this,
                            "please choose Company !", Toast.LENGTH_LONG).show();
                }
                Company_Id = "" + CompanyFlag_ID;
                if(DentelCareYes.isChecked()){
                    DentalCare = "yes";
                }else if(DentelCareNo.isChecked()){
                    DentalCare = "no";
                }
                if(MaternityYes.isChecked()){
                    MaternityHealth = "yes";
                }else if(MaternityNo.isChecked()){
                    MaternityHealth = "no";
                }
                long rand15Digt = (long) (Math.random() * 100000000000000L);
                    s1 = "HIns" + rand15Digt;
                    System.out.println(Company_Id);
                    System.out.println(userID);
                    System.out.println(Policy_Type);
                    System.out.println(package_type);
                    totalPrice();
                    System.out.println(TotalPrice);
                    System.out.println(DentalCare);
                    System.out.println(MaternityHealth);
                    System.out.println(insuredName);
                    System.out.println(insuredCPR);
                    System.out.println(s1);
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    String date = simpleDateFormat.format(new Date());
                    ExpireDate = date;
                    System.out.println(ExpireDate);
                    if(!Company_Id.equals("") && !insuredCPR.equals("") && !insuredName.equals("") &&
                    !DentalCare.equals("") && !MaternityHealth.equals("") && !TotalPrice.equals("")){
                        confirmInsurance.setFlagResultInsurenceDone(FlagInsurance_Health);
                        Intent intent = new Intent(HealthInsurance.this, confirmInsurance.class);
                        startActivity(intent);

                    } else {
                        AlertDialog.Builder mess =  new AlertDialog.Builder(HealthInsurance.this);
                        mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();
                    }
                }


        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //replaces the default 'Back' button action
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            this.startActivity(new Intent(HealthInsurance.this,MainActivity.class));
        }
        return true;
    }
    public void totalPrice() {
        switch (package_type) {
            case "normal":
                switch (Integer.parseInt(Company_Id)) {
                    case 1:
                        TotalPrice = "" + 220;
                        System.out.println(TotalPrice);
                        break;
                    case 2:
                        TotalPrice = "" + 420;
                        System.out.println(TotalPrice);
                        break;
                    case 3:
                        TotalPrice ="" + 240;
                        System.out.println(TotalPrice);
                        break;
                    case 4:
                        TotalPrice = "" + 200;
                        System.out.println(TotalPrice);
                        break;
                    default:
                        Toast.makeText(HealthInsurance.this,
                                "please choose Company !", Toast.LENGTH_LONG).show();
                }
                break;
            case "silver":
                switch (Integer.parseInt(Company_Id)) {
                    case 1:
                        TotalPrice = "" + 245;
                        System.out.println(TotalPrice);
                        break;
                    case 2:
                        TotalPrice = "" + 480;
                        System.out.println(TotalPrice);
                        break;
                    case 3:
                        TotalPrice ="" + 420;
                        System.out.println(TotalPrice);
                        break;
                    case 4:
                        TotalPrice = "" + 300;
                        System.out.println(TotalPrice);
                        break;
                    default:
                        Toast.makeText(HealthInsurance.this,
                                "please choose Company !", Toast.LENGTH_LONG).show();
                }
                break;
            case "gold":
                switch (Integer.parseInt(Company_Id)) {
                    case 1:
                        TotalPrice = "" + 480;
                        System.out.println(TotalPrice);
                        break;
                    case 2:
                        TotalPrice = "" + 510;
                        System.out.println(TotalPrice);
                        break;
                    case 3:
                        TotalPrice ="" + 610;
                        System.out.println(TotalPrice);
                        break;
                    case 4:
                        TotalPrice = "" + 400;
                        System.out.println(TotalPrice);
                        break;
                    default:
                        Toast.makeText(HealthInsurance.this,
                                "please choose Company !", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                Toast.makeText(HealthInsurance.this,
                        "please choose package Type !", Toast.LENGTH_LONG).show();
        }
    }
}