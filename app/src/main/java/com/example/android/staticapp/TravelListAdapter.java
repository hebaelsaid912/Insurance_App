package com.example.android.staticapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TravelListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    ArrayList<String> policy_number = new ArrayList<>();
    ArrayList<String> company_id = new ArrayList<>();
    ArrayList<String> destenation = new ArrayList<>();
    ArrayList<String> expire_date = new ArrayList<>();
    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> package_type = new ArrayList<>();
    TextView RecentCar_PolicyNumber;
    TextView RecentCar_CompanyName;
    TextView RecentCar_Destenation;
    TextView RecentCar_PolicyPackage;
    TextView RecentCar_ExpireDate;
    TextView RecentCar_Price;

    public TravelListAdapter(Activity context,  ArrayList<String> policy_number,  ArrayList<String> company_id,
                          ArrayList<String> destenation, ArrayList<String> expire_date,
                             ArrayList<String> price,  ArrayList<String> package_type) {
        super(context, R.layout.list_item_travel,policy_number);
        this.context=context;
        this.policy_number = policy_number;
        this.company_id = company_id;
        this.destenation = destenation;
        this.expire_date = expire_date;
        this.price = price;
        this.package_type = package_type;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item_travel, null,true);
        RecentCar_CompanyName = rowView.findViewById(R.id.RecentTravelCompanyName);
        RecentCar_Destenation = rowView.findViewById(R.id.RecentTravelDestenation);
        RecentCar_PolicyNumber = rowView.findViewById(R.id.RecentTravelPolicyNumber);
        RecentCar_PolicyPackage = rowView.findViewById(R.id.RecentTravelPolicyPackage);
        RecentCar_ExpireDate = rowView.findViewById(R.id.RecentTravelExpireDate);
        RecentCar_Price = rowView.findViewById(R.id.RecentTravelPrice);
        if(company_id.get(position).equals("1")) {
            RecentCar_CompanyName.setText("Al Ahlia Insurance");
        }else if(company_id.get(position).equals("2")) {
            RecentCar_CompanyName.setText("AXA Insurance");
        }else if(company_id.get(position).equals("3")) {
            RecentCar_CompanyName.setText("Takaful Insurance");
        }else {
            RecentCar_CompanyName.setText("Gulf Union Insurance");
        }
        RecentCar_Destenation.setText(destenation.get(position));
        RecentCar_PolicyNumber.setText(policy_number.get(position));
        RecentCar_PolicyPackage.setText(package_type.get(position));
        RecentCar_ExpireDate.setText(expire_date.get(position));
        RecentCar_Price.setText(price.get(position));

        return rowView;

    };
}
