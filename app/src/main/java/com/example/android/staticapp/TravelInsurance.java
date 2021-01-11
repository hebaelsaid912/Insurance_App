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
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class TravelInsurance extends AppCompatActivity {
    Spinner packageTypeSpinner;
    Spinner policyTypeSpinner;
    RadioButton ahliaInsurance_1;
    RadioButton axaInsurance_2;
    RadioButton takafulInsurance_3;
    RadioButton gulfInsurance_4;
    EditText travel_name;
    EditText passport_no;
    EditText destination_country;
    Spinner Return_userday , Return_usermonth , Return_useryear;
    Spinner Travel_userday , Travel_usermonth , Travel_useryear;
   public static String Policy_Type;
   public static String userID = login.user_id;
   public static String travelName, package_type, PassportNo, Company_Id , DestinationCountry , TravelDate , ReturnDate, ExpireDate;
    public static String TotalPrice="" ;
    Button GetTravelQuotation_Insurance;
    int CompanyFlag_ID;
    public static int FlagInsurance_Travel = 3;
    double totalCarPrice ;
    public static String CodeInsurance , s1;
    long diffDays=0;
    LocalDate d1 , d2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_insurance);
        ahliaInsurance_1 = (RadioButton) findViewById(R.id.AhliaInsurance_Travel);
        ahliaInsurance_1.setChecked(true);
        axaInsurance_2 = (RadioButton) findViewById(R.id.AXAInsurance_Travel);
        takafulInsurance_3 = (RadioButton) findViewById(R.id.TakafulInsurance_Travel);
        gulfInsurance_4 = (RadioButton) findViewById(R.id.GulfInsurance_Travel);
        policyTypeSpinner = (Spinner) findViewById(R.id.Spinner_PolicyType_TravelInsurance);
        travel_name = (EditText) findViewById(R.id.travelNameInsurance);
        passport_no = (EditText) findViewById(R.id.PassportNoInsurance);
        Travel_userday = (Spinner) findViewById(R.id.travelDay_Insurance);
        ArrayList<String> days = new ArrayList<String>();
        days.add("Day");
        for (int i=1 ; i<=31 ; i++){
            days.add(""+i);
        }
        ArrayAdapter<String> Dayadapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, days);
        Dayadapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        Travel_userday.setAdapter(Dayadapter);
        Travel_usermonth = (Spinner) findViewById(R.id.travelMonth_Insurance);
        ArrayList<String> month = new ArrayList<String>();
        month.add("Month");
        for (int i=1 ; i<=12 ; i++){
            month.add(""+i);
        }
        ArrayAdapter<String> Monthadapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, month);
        Monthadapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        Travel_usermonth.setAdapter(Monthadapter);
        Travel_useryear = (Spinner) findViewById(R.id.travelYear_Insurance);
        ArrayList<String> year = new ArrayList<String>();
        year.add("Year");
        year.add("2021");

        ArrayAdapter<String> Yearadapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, year);
        Yearadapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        Travel_useryear.setAdapter(Yearadapter);
        Return_userday = (Spinner) findViewById(R.id.returnDay_Insurance);
        Return_userday.setAdapter(Dayadapter);
        Return_usermonth = (Spinner) findViewById(R.id.returnMonth_Insurance);
        Return_usermonth.setAdapter(Monthadapter);
        Return_useryear = (Spinner) findViewById(R.id.returnYear_Insurance);
        Return_useryear.setAdapter(Yearadapter);
        destination_country = (EditText) findViewById(R.id.DestinationCountryInsurance);
        ArrayList<String> items = new ArrayList<String>();
        items.add("full_coverage");
        items.add("3rd_party");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items);
        adapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        policyTypeSpinner.setAdapter(adapter);

        packageTypeSpinner = (Spinner) findViewById(R.id.Spinner_PackageType_TravelInsurance) ;
        ArrayList<String> items_1 = new ArrayList<String>();
        items_1.add("normal");
        items_1.add("silver");
        items_1.add("gold");
        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this, R.layout.listitem_carcliam_policynumber, items_1);
        adapter_1.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
        packageTypeSpinner.setAdapter(adapter_1);
        System.out.println("jkzsfhzdkljfgsdlkf"+diffDays);
        GetTravelQuotation_Insurance = (Button) findViewById(R.id.GetTravelQuotationInsurance);
        GetTravelQuotation_Insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Policy_Type = policyTypeSpinner.getSelectedItem().toString();
                package_type = packageTypeSpinner.getSelectedItem().toString();
                travelName = travel_name.getText().toString();
                PassportNo = passport_no.getText().toString();
                DestinationCountry = destination_country.getText().toString();
                if (ahliaInsurance_1.isChecked()) {
                    CompanyFlag_ID = 1;
                } else if (axaInsurance_2.isChecked()) {
                    CompanyFlag_ID = 2;
                } else if (takafulInsurance_3.isChecked()) {
                    CompanyFlag_ID = 3;
                } else if (gulfInsurance_4.isChecked()) {
                    CompanyFlag_ID = 4;
                } else {
                    AlertDialog.Builder mess =  new AlertDialog.Builder(TravelInsurance.this);
                    mess.setMessage("please choose Company !").setTitle("Alert !").setCancelable(true).show();

                }
                Company_Id = "" + CompanyFlag_ID;
                long rand15Digt = (long) (Math.random() * 100000000000000L);
                    s1 = "TIns" + rand15Digt;
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                ExpireDate = date;
                System.out.println(ExpireDate);
                String Td="";
                Td =Travel_userday.getSelectedItem().toString();
                String Tm="";
                Tm =Travel_usermonth.getSelectedItem().toString();
                String Ty="";
                Ty =Travel_useryear.getSelectedItem().toString();
                String Rd = "";
                Rd =Return_userday.getSelectedItem().toString();
                String Rm="";
                Rm =Return_usermonth.getSelectedItem().toString();
                String Ry="";
                Ry =Return_useryear.getSelectedItem().toString();
                String mm ="";
                String dd ="";
                String Tmm ="";
                String Tdd ="";
                if(!Td.equals("Day") && !Tm.equals("Month")&& !Ty.equals("Year")
                        && !Rd.equals("Day") && !Rm.equals("Month")&& !Ry.equals("Year")) {
                 if(!travelName.equals("") && !PassportNo.equals("") && !DestinationCountry.equals("")&&
                         !Company_Id.equals("") && !ExpireDate.equals("") && !Td.equals("")&&
                 !Tm.equals("") && !Ty.equals("") && !Rd.equals("")&& !Rm.equals("")&& !Ry.equals("")){

                     int month = Integer.parseInt(Tm);
                     int day = Integer.parseInt(Td);
                     int Tmonth = Integer.parseInt(Rm);
                     int Tday = Integer.parseInt(Rd);
                     if (month< 10 && month > 0 ) {
                         mm = "0" + month;
                         if( day < 10 && day > 0) {
                             dd = "0" + day;
                         }
                     } else {
                         if( day < 10 && day > 0) {
                             dd = "0" + day;
                         }else{
                             dd = Td;
                         }
                         mm = Tm;

                     }
                     if (Tday < 10 & Tday > 0) {
                         if(Tmonth < 10 && Tmonth > 0) {
                             Tmm = "0" + Tmonth;
                         }
                         Tdd = "0" + Tday;
                     }else {
                         if (Tmonth < 10 && Tmonth > 0) {
                             Tmm = "0" + Tmonth;
                         } else {
                             Tmm = Rm;
                         }
                         Tdd = Rd;
                     }
                             d1 = LocalDate.parse(Ty + "-" + mm + "-" + dd, DateTimeFormatter.ISO_LOCAL_DATE);
                             d2 = LocalDate.parse(Ry + "-" + Tmm + "-" + Tdd, DateTimeFormatter.ISO_LOCAL_DATE);
                             Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
                             if(diff.toDays()<0){
                                diffDays = diff.toDays()*-1;
                             }else{
                                 diffDays = diff.toDays();
                             }
                         Log.i("MainActivity", Policy_Type);
                         Log.i("MainActivity", package_type);
                         Log.i("MainActivity", userID);
                         Log.i("MainActivity", Company_Id);
                         Log.i("MainActivity", DestinationCountry);
                         Log.i("MainActivity", travelName);
                         Log.i("MainActivity", PassportNo);
                         totalPrice(diffDays);
                         Log.i("MainActivity", TotalPrice);
                         Log.i("MainActivity", s1);
                         System.out.println("diffDays"+ diffDays);
                         confirmInsurance.setFlagResultInsurenceDone(FlagInsurance_Travel);
                         Intent intent = new Intent(TravelInsurance.this, confirmInsurance.class);
                         startActivity(intent);
                    }else {
                         AlertDialog.Builder mess =  new AlertDialog.Builder(TravelInsurance.this);
                         mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();
                     }
                }else{
                    AlertDialog.Builder mess =  new AlertDialog.Builder(TravelInsurance.this);
                    mess.setMessage("Please make sure you choose value for day, month and year").setTitle("Alert !").setCancelable(true).show();
                }

            }
        });
    }

    private void totalPrice(long diffDays) {
            switch (package_type) {
                case "normal":
                    switch (Integer.parseInt(Company_Id)) {
                        case 1:
                            System.out.println(diffDays);
                            totalCarPrice = 2.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        case 2:
                            totalCarPrice = 4.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        case 3:
                            totalCarPrice = 4.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        case 4:
                            totalCarPrice = 4.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        default:
                            Toast.makeText(TravelInsurance.this,
                                    "please choose Company !", Toast.LENGTH_LONG).show();
                    }
                    break;
                case "silver":
                    switch (Integer.parseInt(Company_Id)) {
                        case 1:
                            totalCarPrice = 4.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        case 2:
                            totalCarPrice = 8.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        case 3:
                            totalCarPrice = 12.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        case 4:
                            totalCarPrice = 5.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        default:
                            Toast.makeText(TravelInsurance.this,
                                    "please choose Company !", Toast.LENGTH_LONG).show();
                    }
                    break;
                case "gold":
                    switch (Integer.parseInt(Company_Id)) {
                        case 1:
                            totalCarPrice = 8.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        case 2:
                            totalCarPrice = 10.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        case 3:
                            totalCarPrice = 18.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        case 4:
                            totalCarPrice = 6.0 * diffDays;
                            TotalPrice = "" + totalCarPrice;
                            System.out.println(TotalPrice);
                            break;
                        default:
                            Toast.makeText(TravelInsurance.this,
                                    "please choose Company !", Toast.LENGTH_LONG).show();
                    }
                    break;
                default:
                    Toast.makeText(TravelInsurance.this,
                            "please choose package Type !", Toast.LENGTH_LONG).show();
            }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        //replaces the default 'Back' button action
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            this.startActivity(new Intent(TravelInsurance.this,MainActivity.class));

        }
        return true;
    }
}