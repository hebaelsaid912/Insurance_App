package com.example.android.staticapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HealthListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    ArrayList<String> policy_number = new ArrayList<>();
    ArrayList<String> company_id = new ArrayList<>();
    ArrayList<String> insured_name = new ArrayList<>();
    ArrayList<String> insured_cpr = new ArrayList<>();
    ArrayList<String> policy_type = new ArrayList<>();
    ArrayList<String> dentel_cover = new ArrayList<>();
    ArrayList<String> ment_cover = new ArrayList<>();
    ArrayList<String> expire_date = new ArrayList<>();
    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> package_type = new ArrayList<>();
    TextView RecentCar_PolicyNumber;
    TextView RecentCar_CompanyName;
    TextView RecentCar_InsuredName;
    TextView RecentCar_InsuredCPR;
    TextView RecentCar_Dentel;
    TextView RecentCar_Ment;
    TextView RecentCar_PolicyType;
    TextView RecentCar_PolicyPackage;
    TextView RecentCar_ExpireDate;
    TextView RecentCar_Price;

    public HealthListAdapter(Activity context,  ArrayList<String> policy_number,
                             ArrayList<String> company_id, ArrayList<String> dentel_cover,
                             ArrayList<String> ment_cover,ArrayList<String> insured_name,
                             ArrayList<String> insured_cpr,  ArrayList<String> policy_type,  ArrayList<String> expire_date,
                          ArrayList<String> price,  ArrayList<String> package_type) {
        super(context, R.layout.list_item_health,policy_number);
        this.context=context;
        this.policy_number = policy_number;
        this.company_id = company_id;
        this.dentel_cover = dentel_cover;
        this.ment_cover = ment_cover;
        this.insured_cpr = insured_cpr;
        this.insured_name = insured_name;
        this.expire_date = expire_date;
        this.price = price;
        this.package_type = package_type;
        this.policy_type = policy_type;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item_health, null,true);
        RecentCar_CompanyName = rowView.findViewById(R.id.RecentHealthCompanyName);
        RecentCar_InsuredName = rowView.findViewById(R.id.RecentHealthInsuredName);
        RecentCar_InsuredCPR = rowView.findViewById(R.id.RecentHealthInsuredCPR);
        RecentCar_Dentel = rowView.findViewById(R.id.RecentHealthDentelCover);
        RecentCar_Ment = rowView.findViewById(R.id.RecentHealthMaternityCover);
        RecentCar_PolicyNumber = rowView.findViewById(R.id.RecentHealthPolicyNumber);
        RecentCar_PolicyType = rowView.findViewById(R.id.RecentHealthPolicyType);
        RecentCar_PolicyPackage = rowView.findViewById(R.id.RecentHealthPolicyPackage);
        RecentCar_ExpireDate = rowView.findViewById(R.id.RecentHealthExpireDate);
        RecentCar_Price = rowView.findViewById(R.id.RecentHealthPrice);
        if(company_id.get(position).equals("1")) {
            RecentCar_CompanyName.setText("Al Ahlia Insurance");
        }else if(company_id.get(position).equals("2")) {
            RecentCar_CompanyName.setText("AXA Insurance");
        }else if(company_id.get(position).equals("3")) {
            RecentCar_CompanyName.setText("Takaful Insurance");
        }else {
            RecentCar_CompanyName.setText("Gulf Union Insurance");
        }
        RecentCar_InsuredCPR.setText(insured_cpr.get(position));
        RecentCar_InsuredName.setText(insured_name.get(position));
        RecentCar_Dentel.setText(dentel_cover.get(position));
        RecentCar_Ment.setText(ment_cover.get(position));
        RecentCar_PolicyNumber.setText(policy_number.get(position));
        RecentCar_PolicyType.setText(policy_type.get(position));
        RecentCar_PolicyPackage.setText(package_type.get(position));
        RecentCar_ExpireDate.setText(expire_date.get(position));
        RecentCar_Price.setText(price.get(position));

        return rowView;

    };
}
