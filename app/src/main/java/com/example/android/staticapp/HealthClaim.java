package com.example.android.staticapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthClaim extends AppCompatActivity {
    private static int RESULT_LOAD_IMAGE_Hospital = 1;
    private static int RESULT_LOAD_IMAGE_Pharmacy = 2;
    public static String IMAGE_PATH = "";
    Spinner policyNumberSpinner;
    private Button hospital_InvoiceButton;
    private Button Pharmacy_InvoiceButton;
    private ImageView hospital_InvoiceImage;
    private ImageView Pharmacy_InvoiceImage;
    public static final String DATA = "_data";
    private Button healthClaim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_claim);
        policyNumberSpinner = (Spinner) findViewById(R.id.Spinner_PolicyNumber_HealthClaim) ;
        ArrayList<String> items = new ArrayList<String>();
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
                PutData putData = new PutData(Routes.show_all_insurance_Health, "POST", field, data);
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
                                map.put("code",e.getString("code"));
                                items.add(map.get("code"));
                            }
                            System.out.println(items);
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(HealthClaim.this, R.layout.listitem_carcliam_policynumber, items);
                            adapter.setDropDownViewResource(R.layout.listitem_carcliam_policynumber);
                            policyNumberSpinner.setAdapter(adapter);
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

        hospital_InvoiceImage = (ImageView) findViewById(R.id.HospitalInvoiceImage) ;
        Pharmacy_InvoiceImage = (ImageView) findViewById(R.id.Pharmacy_InvoiceImage) ;
        hospital_InvoiceButton = (Button) findViewById(R.id.Hospital_InvoiceButton);
        hospital_InvoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Choose
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                i.setType("image/*");
                startActivityForResult(i, RESULT_LOAD_IMAGE_Hospital);

            }
        });
        Pharmacy_InvoiceButton = (Button) findViewById(R.id.Pharmacy_InvoiceButton);
        Pharmacy_InvoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Choose
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                i.setType("image/*");
                startActivityForResult(i, RESULT_LOAD_IMAGE_Pharmacy);

            }
        });
        healthClaim = (Button) findViewById(R.id.GetHealthClaim);
        healthClaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Pharmacy_InvoiceImage.getDrawable() != null  && hospital_InvoiceImage.getDrawable() != null) {
                    Intent intent = new Intent(HealthClaim.this, SuccessfullyClaim.class);
                    startActivity(intent);
                }else{
                    AlertDialog.Builder mess =  new AlertDialog.Builder(HealthClaim.this);
                    mess.setMessage("Please make sure you have entered all the required fields").setTitle("Alert !").setCancelable(true).show();

                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE_Hospital && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            System.out.println(selectedImage);
            hospital_InvoiceImage.setImageURI(selectedImage);
        }else if (requestCode == RESULT_LOAD_IMAGE_Pharmacy && resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            System.out.println(selectedImage);
            Pharmacy_InvoiceImage.setImageURI(selectedImage);

        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        //replaces the default 'Back' button action
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            this.startActivity(new Intent(HealthClaim.this,MainActivity.class));

        }
        return true;
    }
}