package com.octohub.pil4u.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class AccoutUtils {


    private final static String mobile_number = "mobile_number";
    private final static String username = "username";
    private final static String role = "role";
    private final static String subLocality = "subLocality";
    private final static String address = "address";




    // File Preferences
    private static SharedPreferences getSharedPreferences(final Context context){

        return  context.getSharedPreferences(AppConstantUtils.PREF_FILE_NAMEsd, Context.MODE_PRIVATE);
    }

    // Settings Preferences
    private static SharedPreferences getDefaultSharedPreferences(final Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }



    public static void setMobile_number(Context context,String mobile_numbers){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        sharedPreferences.edit().putString(mobile_number,mobile_numbers).apply();
    }

    public static String getMobile_number(Context context){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(mobile_number,"");
    }


    public static void setUsername(Context context,String username){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        sharedPreferences.edit().putString(username,username).apply();
    }

    public static String getUsername(Context context){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(username,"");
    }

    public static void setRole(Context context,String role){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        sharedPreferences.edit().putString(role,role).apply();
    }

    public static String getRole(Context context){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(role,"");
    }


    public static void setAddress(Context context,String address){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        sharedPreferences.edit().putString(address,address).apply();
    }

    public static String getAddress(Context context){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(address,"");
    }

    public static void setSubLocality(Context context,String subLocality){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        sharedPreferences.edit().putString(subLocality,subLocality).apply();
    }

    public static String getSubLocality(Context context){

        SharedPreferences sharedPreferences = getSharedPreferences(context);
        return sharedPreferences.getString(subLocality,"");
    }



    public static void clearActiveUserDetails(final Context context) {
        Log.d(TAG, "Clearing active account");
        SharedPreferences sp = getSharedPreferences(context);
        sp.edit()
                .remove(mobile_number)
                .remove(username)
                .remove(role)
                .remove(address)
                .remove(subLocality)
                .apply();
    }

}
