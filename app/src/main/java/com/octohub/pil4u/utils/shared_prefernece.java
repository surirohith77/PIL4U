package com.octohub.pil4u.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class shared_prefernece {

    public SharedPreferences sp;
    Context context;

    public shared_prefernece(Context context){

        this.context = context;

        sp = context.getSharedPreferences("savefilesPilu",Context.MODE_PRIVATE);

    }

    public void writeloginstatus(boolean status){

        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("save",status);
        editor.commit();
    }

    public boolean readloginstatus(){

        boolean status = false;
        status = sp.getBoolean("save",false);
        return status;
    }
}
