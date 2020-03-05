package com.m7amdelbana.haninround3.utils;

import android.app.Activity;
import android.app.AlertDialog;

import com.m7amdelbana.haninround3.R;

public class ErrorDialog {

    private static AlertDialog alert;

    public static void show(Activity activity, String title, String message) {
        activity.runOnUiThread(() -> {
            final AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
            dialog.setTitle(title);
            dialog.setMessage(message);
            dialog.setCancelable(false);

            dialog.setPositiveButton(activity.getString(R.string.ok), (dialog1, whichButton) -> {

            });

            dialog.setNegativeButton(activity.getString(R.string.cancel), (dialog12, whichButton) -> {

            });

            if (alert != null && alert.isShowing()) {
                alert.dismiss();
            }

            alert = dialog.create();
            alert.show();
        });
    }
}
