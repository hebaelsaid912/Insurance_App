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

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Compare_Travel extends AppCompatActivity {
    Spinner packageTypeSpinner;
    Button travelCompare;
    Spinner returnDay;
    Spinner returnMonth;
    Spinner returnYear;
    Spinner travelDay;
    Spinner travelMonth;
    Spinner travelYear;
    public static String AhliaResult_travel ;
    public static String AXAResult_travel ;
    public static String TakafulResult_travel ;
    public static String GulfResult_travel ;
    double AhliaRes_travel ,  AXARes_travel ,TakafulRes_travel,GulfRes_travel;
    int NumberOfDays=0;
    int Travelflag = 3;
    EditText travelName , travelPasportnum , destenationContry;
    String TName="" , TpasNum="" , desCon="" , tday="" , tmonth="", tyear="" , rday="" , rmonth="" , ryear="" , ExpireDate ;
    long diffDays=0;
    LocalDate d1 , d2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare__travel);
        travelName = (EditText) findViewById(R.id.TravelNameCompare);
        travelPasportnum = (EditText) findViewById(R.id.TravelPassportNumCompare);
        destenationContry = (EditText) findViewById(R.id.DestinationCountryCompare);
        returnDay = (Spinner) findViewById(R.id.returnDay_Compare);
        ArrayList<String> days = new ArrayList<String>();
        days.add("Day");
        for (int i=1 ; i<=31 ; i++){
            days.add(""+i);
        }
        ArrayAdapter<String> Dayadapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, days);
        Dayadapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        returnDay.setAdapter(Dayadapter);
        returnMonth = (Spinner) findViewById(R.id.returnMonth_Compare);
        ArrayList<String> month = new ArrayList<String>();
        month.add("Month");
        for (int i=1 ; i<=12 ; i++){
            month.add(""+i);
        }
        ArrayAdapter<String> Monthadapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, month);
        Monthadapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        returnMonth.setAdapter(Monthadapter);
        returnYear = (Spinner) findViewById(R.id.returnYear_Compare);
        ArrayList<String> year = new ArrayList<String>();
        year.add("Year");
        year.add("2021");

        ArrayAdapter<String> Yearadapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, year);
        Yearadapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        returnYear.setAdapter(Yearadapter);
        travelDay = (Spinner) findViewById(R.id.travelDay_Compare);
        travelDay.setAdapter(Dayadapter);
        travelMonth = (Spinner) findViewById(R.id.travelMonth_Compare);
        travelMonth.setAdapter(Monthadapter);
        travelYear = (Spinner) findViewById(R.id.travelYear_Compare);
        travelYear.setAdapter(Yearadapter);
        packageTypeSpinner = (Spinner) findViewById(R.id.Spinner_PackageType_TravelCompare) ;
        ArrayList<String> items_1 = new ArrayList<String>();
        items_1.add("Normal");
        items_1.add("Silver");
        items_1.add("Gold");
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_1);
        adapter_1.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        packageTypeSpinner.setAdapter(adapter_1);
        travelCompare = (Button) findViewById(R.id.TravelCompare);
        travelCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CompareQuotationsPrice.setFlag(Travelflag);

                String packageType = packageTypeSpinner.getSelectedItem().toString();
                TName = travelName.getText().toString();
                TpasNum = travelPasportnum.getText().toString();
                desCon = destenationContry.getText().toString();
                rday = returnDay.getSelectedItem().toString();
                rmonth = returnMonth.getSelectedItem().toString();
                ryear = returnYear.getSelectedItem().toString();
                tday = travelDay.getSelectedItem().toString();
                tmonth = travelMonth.getSelectedItem().toString();
                tyear = travelYear.getSelectedItem().toString();
                String mm ="";
                String dd ="";
                String Tmm ="";
                String Tdd ="";
                if(!TName.equals("") && !TpasNum.equals("") && !desCon.equals("")
                && !tday.equals("Day") && !tmonth.equals("Month") && !tyear.equals("Year")
                && !rday.equals("Day") && !rmonth.equals("Month") && !ryear.equals("Year")) {
                    int month = Integer.parseInt(rmonth);
                    int day = Integer.parseInt(rday);
                    int Tmonth = Integer.parseInt(tmonth);
                    int Tday = Integer.parseInt(tday);
                    if (month < 10 && month > 0 && day < 10 && day > 0) {
                        mm = "0" + month;
                        dd = "0" + day;
                    } else {
                        mm = "" + month;
                        dd = "" + day;
                    }
                    if ((Tday < 10 & Tday > 0) || (Tmonth < 10 && Tmonth > 0)) {
                        Tmm = "0" + Tmonth;
                        Tdd = "0" + Tday;
                    } else {
                        Tmm = "" + Tmonth;
                        Tdd = "" + Tday;
                    }
                    d1 = LocalDate.parse(ryear + "-" + mm + "-" + dd, DateTimeFormatter.ISO_LOCAL_DATE);
                    d2 = LocalDate.parse(tyear+"-"+Tmm+ "-"+Tdd, DateTimeFormatter.ISO_LOCAL_DATE);
                    Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
                    diffDays = diff.toDays() * -1;
                    System.out.println(Tdd);
                    System.out.println(Tmm);
                    System.out.println(dd);
                    System.out.println(mm);
                    switch (packageType) {
                        case "Normal":
                            AhliaRes_travel = 2.0 * diffDays;
                            AhliaResult_travel = "" + AhliaRes_travel;
                            System.out.println(AhliaResult_travel + "aaaaaaaa");
                            AXARes_travel = 4.0 * diffDays;
                            AXAResult_travel = "" + AXARes_travel;
                            System.out.println(AXAResult_travel + "bbbbbbb");
                            TakafulRes_travel = 4.0 * diffDays;
                            TakafulResult_travel = "" + TakafulRes_travel;
                            System.out.println(TakafulResult_travel + "nnnnnnnn");
                            GulfRes_travel = 4.0 * diffDays;
                            GulfResult_travel = "" + GulfRes_travel;
                            System.out.println(GulfResult_travel + "oooooo");
                            Go_ResulCompare();
                            break;
                        case "Silver":
                            AhliaRes_travel = 4.0 * diffDays;
                            AhliaResult_travel = "" + AhliaRes_travel;
                            System.out.println(AhliaResult_travel);
                            AXARes_travel = 8.0 * diffDays;
                            AXAResult_travel = "" + AXARes_travel;
                            System.out.println(AXAResult_travel);
                            TakafulRes_travel = 12.0 * diffDays;
                            TakafulResult_travel = "" + TakafulRes_travel;
                            System.out.println(TakafulResult_travel);
                            GulfRes_travel = 5.0 * diffDays;
                            GulfResult_travel = "" + GulfRes_travel;
                            System.out.println(GulfResult_travel);
                            Go_ResulCompare();
                            break;
                        case "Gold":
                            AhliaRes_travel = 8.0 * diffDays;
                            AhliaResult_travel = "" + AhliaRes_travel;
                            System.out.println(AhliaResult_travel);
                            AXARes_travel = 10.0 * diffDays;
                            AXAResult_travel = "" + AXARes_travel;
                            System.out.println(AXAResult_travel);
                            TakafulRes_travel = 18.0 * diffDays;
                            TakafulResult_travel = "" + TakafulRes_travel;
                            System.out.println(TakafulResult_travel);
                            GulfRes_travel = 6.0 * diffDays;
                            GulfResult_travel = "" + GulfRes_travel;
                            System.out.println(GulfResult_travel);
                            Go_ResulCompare();
                            break;
                        default:
                            AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Travel.this);
                            mess.setMessage("please choose package Type !").setTitle("Alert !").setCancelable(true).show();
                    }
                }else{
                    AlertDialog.Builder mess =  new AlertDialog.Builder(Compare_Travel.this);
                    mess.setMessage("Please make sure you have entered all the required fields and" +
                            " choose value for day, month and year").setTitle("Alert !").setCancelable(true).show();
                }
            }
            });
        }
        void Go_ResulCompare(){
            Intent intent = new Intent(Compare_Travel.this,CompareQuotationsPrice.class);
            startActivity(intent);
        }
}