package com.intuz.scopedstoragemodule;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PermissionActivity {

    public static int ALL_FILES_ACCESS_PERMISSION = 4;

    public static void requestAllFilesAccessPermission(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R || Environment.isExternalStorageManager()) {
            Toast.makeText(context, "We can access all files on external storage now", Toast.LENGTH_SHORT).show();
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setMessage("We need permission to access all files on external storage");
            alertDialogBuilder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                            ((AppCompatActivity) context).startActivityForResult(intent, ALL_FILES_ACCESS_PERMISSION);
                        }
                    });

            alertDialogBuilder.setNegativeButton("Cancel", null);

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

}
