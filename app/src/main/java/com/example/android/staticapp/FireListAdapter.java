package com.example.android.staticapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FireListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    ArrayList<String> policy_number = new ArrayList<>();
    ArrayList<String> company_id= new ArrayList<>();
    ArrayList<String> building_area = new ArrayList<>();
    ArrayList<String> building_type = new ArrayList<>();
    ArrayList<String> policy_type = new ArrayList<>();
    ArrayList<String> expire_date = new ArrayList<>();
    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> package_type = new ArrayList<>();
    TextView RecentCar_PolicyNumber;
    TextView RecentCar_CompanyName;
    TextView RecentCar_BuildingArea;
    TextView RecentCar_BuildingType;
    TextView RecentCar_PolicyType;
    TextView RecentCar_PolicyPackage;
    TextView RecentCar_ExpireDate;
    TextView RecentCar_Price;

    public FireListAdapter(Activity context,  ArrayList<String> policy_number,  ArrayList<String> company_id,
                          ArrayList<String> building_area,ArrayList<String> building_type,  ArrayList<String> expire_date,
                          ArrayList<String> price,  ArrayList<String> package_type) {
        super(context, R.layout.list_item_car,policy_number);
        this.context=context;
        this.policy_number = policy_number;
        this.company_id = company_id;
        this.building_area = building_area;
        this.building_type = building_type;
        this.policy_type = policy_type;
        this.expire_date = expire_date;
        this.price = price;
        this.package_type = package_type;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item_fire, null,true);
        RecentCar_CompanyName = rowView.findViewById(R.id.RecentFireCompanyName);
        RecentCar_BuildingType = rowView.findViewById(R.id.RecentFireBuildingType);
        RecentCar_BuildingArea = rowView.findViewById(R.id.RecentFireBuildingArea);
        RecentCar_PolicyNumber = rowView.findViewById(R.id.RecentFirePolicyNumber);
        RecentCar_PolicyPackage = rowView.findViewById(R.id.RecentFirePolicyPackage);
        RecentCar_ExpireDate = rowView.findViewById(R.id.RecentFireExpireDate);
        RecentCar_Price = rowView.findViewById(R.id.RecentFirePrice);
        if(company_id.get(position).equals("1")) {
            RecentCar_CompanyName.setText("Al Ahlia Insurance");
        }else if(company_id.get(position).equals("2")) {
            RecentCar_CompanyName.setText("AXA Insurance");
        }else if(company_id.get(position).equals("3")) {
            RecentCar_CompanyName.setText("Takaful Insurance");
        }else {
            RecentCar_CompanyName.setText("Gulf Union Insurance");
        }
        RecentCar_BuildingType.setText(building_type.get(position));
        RecentCar_BuildingArea.setText(building_area.get(position));
        RecentCar_PolicyNumber.setText(policy_number.get(position));
        RecentCar_PolicyPackage.setText(package_type.get(position));
        RecentCar_ExpireDate.setText(expire_date.get(position));
        RecentCar_Price.setText(price.get(position));

        return rowView;

    };

}
