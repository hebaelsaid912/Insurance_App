package com.example.android.staticapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONException;
import org.json.JSONObject;

public class confirmInsurance extends AppCompatActivity {
    private static int Flag=0;

    public static int getFlagResultInsurenceDone() {
        return Flag;
    }

    public static void setFlagResultInsurenceDone(int flag) {
        Flag = flag;
    }
    CheckBox accept;
    TextView priceInsurance;
    CarInsurance car;
    HealthInsurance health;
    FireInsurance fire;
    TravelInsurance travel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_insurance);
        accept = (CheckBox) findViewById(R.id.AddCarInsurance);
        priceInsurance = (TextView) findViewById(R.id.CarInsurancePrice);
        if (getFlagResultInsurenceDone() == 1) {
            priceInsurance.setText(car.TotalPrice+" BHD");
        } else if (getFlagResultInsurenceDone() == 2) {
            priceInsurance.setText(health.TotalPrice+" BHD");
        } else if (getFlagResultInsurenceDone() == 3) {
            priceInsurance.setText(travel.TotalPrice+" BHD");

        } else if (getFlagResultInsurenceDone() == 4) {
            priceInsurance.setText(fire.TotalPrice+" BHD");
        } else {
            Toast.makeText(confirmInsurance.this, "Error", Toast.LENGTH_LONG).show();
        }

    }

    public void Go_ResultActivity(View view) {
        if(accept.isChecked()) {
            if (getFlagResultInsurenceDone() == 1) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[15];
                        field[0] = "company_id";
                        field[1] = "user_id";
                        field[2] = "policy_type";
                        field[3] = "package_type";
                        field[4] = "total_price";
                        field[5] = "car_reg_num";
                        field[6] = "car_cc";
                        field[7] = "car_seating";
                        field[8] = "car_value";
                        field[9] = "car_status";
                        field[10] = "car_type";
                        field[11] = "car_model_year";
                        field[12] = "car_model";
                        field[13] = "expire_date";
                        field[14] = "code";
                        //Creating array for data
                        String[] data = new String[15];
                        data[0] = car.Company_Id;
                        data[1] = car.userID;
                        data[2] = car.Policy_Type;
                        data[3] = car.Package_Type;
                        data[4] = car.TotalPrice;
                        data[5] = car.Car_RegNum;
                        data[6] = car.Car_CC;
                        data[7] = car.Car_Seating;
                        data[8] = car.Car_Value;
                        data[9] = car.Car_UserNew;
                        data[10] = car.Car_Type;
                        data[11] = car.Car_ModelYear;
                        data[12] = car.Car_Model;
                        data[13] = car.ExpireDate;
                        data[14] = car.s1;
                        System.out.println(data);
                        PutData putData = new PutData(Routes.make_new_insurance_Car, "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                System.out.println(result + "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                                try {
                                    JSONObject signInmessage = new JSONObject(result);
                                    String Message = signInmessage.get("message").toString();
                                    ResultInsuranceDone.setFlagResultInsurence(car.FlagInsurance_Car);
                                    if (Message.equals("added success")) {
                                        Intent intent = new Intent(confirmInsurance.this, ResultInsuranceDone.class);
                                        startActivity(intent);
                                        AlertDialog.Builder mess =  new AlertDialog.Builder(confirmInsurance.this);
                                        mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();
                                    } else {
                                        AlertDialog.Builder mess =  new AlertDialog.Builder(confirmInsurance.this);
                                        mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();
                                    }
                                    Log.i("PutData", result);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Log.i("PutData", result);

                            }
                        }
                    }
                    //End Write and Read data with URL

                });

            } else if (getFlagResultInsurenceDone() == 2) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[11];
                        field[0] = "company_id";
                        field[1] = "user_id";
                        field[2] = "policy_type";
                        field[3] = "package_type";
                        field[4] = "total_price";
                        field[5] = "dental";
                        field[6] = "maternity";
                        field[7] = "insured_name";
                        field[8] = "insured_cpr";
                        field[9] = "code";
                        field[10] = "expire_date";

                        //Creating array for data
                        String[] data = new String[11];
                        data[0] = health.Company_Id;
                        data[1] = health.userID;
                        data[2] = health.Policy_Type;
                        data[3] = health.package_type;
                        data[4] = health.TotalPrice;
                        data[5] = health.DentalCare;
                        data[6] = health.MaternityHealth;
                        data[7] = health.insuredName;
                        data[8] = health.insuredCPR;
                        data[9] = health.s1;
                        data[10] = health.ExpireDate;
                        System.out.println(data);
                        PutData putData = new PutData(Routes.make_new_insurance_Health, "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                System.out.println(result + "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                                ResultInsuranceDone.setFlagResultInsurence(health.FlagInsurance_Health);
                                try {
                                    JSONObject signInmessage = new JSONObject(result);
                                    String Message = signInmessage.get("message").toString();
                                    if (Message.equals("added success")) {
                                        Intent intent = new Intent(confirmInsurance.this, ResultInsuranceDone.class);
                                        startActivity(intent);
                                        AlertDialog.Builder mess =  new AlertDialog.Builder(confirmInsurance.this);
                                        mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();
                                    } else {
                                        AlertDialog.Builder mess =  new AlertDialog.Builder(confirmInsurance.this);
                                        mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();
                                    }
                                    Log.i("PutData", result);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                });

            } else if (getFlagResultInsurenceDone() == 3) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[10];
                        field[0] = "company_id";
                        field[1] = "user_id";
                        field[2] = "policy_type";
                        field[3] = "package_type";
                        field[4] = "total_price";
                        field[5] = "destination";
                        field[6] = "traveller_name";
                        field[7] = "traveller_passport";
                        field[8] = "expire_date";
                        field[9] = "code";
                        //Creating array for data
                        String[] data = new String[10];
                        data[0] = travel.Company_Id;
                        data[1] = travel.userID;
                        data[2] = travel.Policy_Type;
                        data[3] = travel.package_type;
                        data[4] = travel.TotalPrice;
                        data[5] = travel.DestinationCountry;
                        data[6] = travel.travelName;
                        data[7] = travel.PassportNo;
                        data[8] = travel.ExpireDate;
                        data[9] = travel.s1;
                        System.out.println(data);
                        PutData putData = new PutData(Routes.make_new_insurance_Travel, "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                System.out.println(result + "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                                ResultInsuranceDone.setFlagResultInsurence(travel.FlagInsurance_Travel);
                                try {
                                    JSONObject signInmessage = new JSONObject(result);
                                    String Message = signInmessage.get("message").toString();
                                    if (Message.equals("added success")) {
                                        Intent intent = new Intent(confirmInsurance.this, ResultInsuranceDone.class);
                                        startActivity(intent);
                                        AlertDialog.Builder mess =  new AlertDialog.Builder(confirmInsurance.this);
                                        mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();
                                    } else {
                                        AlertDialog.Builder mess =  new AlertDialog.Builder(confirmInsurance.this);
                                        mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();
                                    }
                                    Log.i("PutData", result);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Log.i("PutData", result);
                            }
                        }
                    }
                });


            } else if (getFlagResultInsurenceDone() == 4) {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[9];
                        field[0] = "company_id";
                        field[1] = "user_id";
                        field[2] = "policy_type";
                        field[3] = "package_type";
                        field[4] = "total_price";
                        field[5] = "building_area";
                        field[6] = "building_type";
                        field[7] = "expire_date";
                        field[8] = "code";
                        //Creating array for data
                        String[] data = new String[9];
                        data[0] = fire.Company_Id;
                        data[1] = fire.userID;
                        data[2] = fire.Policy_Type;
                        data[3] = fire.package_type;
                        data[4] = fire.TotalPrice;
                        data[5] = fire.buildingArea;
                        data[6] = fire.building_type;
                        data[7] = fire.ExpireDate;
                        data[8] = fire.s1;
                        System.out.println(data);
                        PutData putData = new PutData(Routes.make_new_insurance_Fire, "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                System.out.println(result + "uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                                ResultInsuranceDone.setFlagResultInsurence(fire.FlagInsurance_Fire);
                                try {
                                    JSONObject signInmessage = new JSONObject(result);
                                    String Message = signInmessage.get("message").toString();
                                    if (Message.equals("added success")) {
                                        Intent intent = new Intent(confirmInsurance.this, ResultInsuranceDone.class);
                                        startActivity(intent);
                                        AlertDialog.Builder mess =  new AlertDialog.Builder(confirmInsurance.this);
                                        mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();
                                    } else {
                                        AlertDialog.Builder mess =  new AlertDialog.Builder(confirmInsurance.this);
                                        mess.setMessage(Message).setTitle("Alert !").setCancelable(true).show();
                                    }
                                    Log.i("PutData", result);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }
                });
            } else {
                Toast.makeText(confirmInsurance.this, "Error", Toast.LENGTH_LONG).show();
            }
        }else{
           AlertDialog.Builder mess =  new AlertDialog.Builder(this);
           mess.setMessage("please make sure select customer agreement").setTitle("Alert !").setCancelable(true).show();

        }
    }
}