package com.example.android.staticapp;

public class Routes {
    //public static String ROOT="http://10.0.2.2/insurance/insurance-app-api-master/public/index.php";
    public static String ROOT="http://mufix.org/insurance_app/public/";

    /* User Routes */
    public static String login             =ROOT+"?controller=user&action=login";
    public static String register          =ROOT+"?controller=user&action=register";
    public static String get_user_info       =ROOT+"?controller=user&action=get_user_info";
    public static String update_profile       =ROOT+"?controller=user&action=update_profile";
    /* Car Routes */
    public static String show_all_insurance_Car       =ROOT+"?controller=car&action=show_all_insurance";
    public static String show_all_claim_Car      =ROOT+"?controller=car&action=show_all_claim";
    public static String make_new_insurance_Car       =ROOT+"?controller=car&action=make_new_insurance";
    public static String make_new_claim_Car       =ROOT+"?controller=car&action=make_new_claim";
    /* Fire Routes */
    public static String show_all_insurance_Fire      =ROOT+"?controller=fire&action=show_all_insurance";
    public static String show_all_claim_Fire       =ROOT+"?controller=fire&action=show_all_claim";
    public static String make_new_insurance_Fire       =ROOT+"?controller=fire&action=make_new_insurance";
    public static String make_new_claim_Fire       =ROOT+"?controller=fire&action=make_new_claim";
    /* Travel Routes */
    public static String show_all_insurance_Travel      =ROOT+"?controller=travel&action=show_all_insurance";
    public static String show_all_claim_Travel       =ROOT+"?controller=travel&action=show_all_claim";
    public static String make_new_insurance_Travel       =ROOT+"?controller=travel&action=make_new_insurance";
    public static String make_new_claim_Travel       =ROOT+"?controller=travel&action=make_new_claim";
    /* Health Routes */
    public static String show_all_insurance_Health      =ROOT+"?controller=health&action=show_all_insurance";
    public static String show_all_claim_Health       =ROOT+"?controller=health&action=show_all_claim";
    public static String make_new_insurance_Health      =ROOT+"?controller=health&action=make_new_insurance";
    public static String make_new_claim_Health       =ROOT+"?controller=health&action=make_new_claim";

}