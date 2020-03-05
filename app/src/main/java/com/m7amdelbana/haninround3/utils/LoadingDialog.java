package com.m7amdelbana.haninround3.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.m7amdelbana.haninround3.R;

import java.util.Objects;

public class LoadingDialog {

    private Dialog dialog;

    public LoadingDialog(Context context) {
        dialog = new Dialog(context);
    }

    public void show() {
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void hide() {
        dialog.dismiss();
    }
}
