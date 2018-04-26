package org.surincampus.org.buribum.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import org.surincampus.org.buribum.R;

public class MyAlert {

//    Explicit

    private Context context;   //channel for communication

    public MyAlert(Context context) {
        this.context = context;

    }  //constructor


    public void normalDialog(String titleString, String messageString) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.cool);
        builder.setTitle(titleString);
        builder.setMessage(messageString);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        builder.show();

    }

}  //Main class
