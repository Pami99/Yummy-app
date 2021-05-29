package com.example.cookingrecipe;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class LoadingDialog {
    private Activity activity;
    private AlertDialog alertDialog;

    LoadingDialog(Activity myActivity){
        activity = myActivity;
    }

    void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.customer_dialog, null));

        builder.setCancelable(false);

        alertDialog = builder.create();
        alertDialog.show();
    }

    void dismissed(){
        alertDialog.dismiss();
    }
}
