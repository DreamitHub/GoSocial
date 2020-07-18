package com.demoPurpose.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;

import com.demoPurpose.R;
import com.demoPurpose.common.Constants;
import com.google.android.material.snackbar.Snackbar;

public class SuperAppCompatActivity extends IntelliCodeActivity {
    private static final String TAG = "SuperAppCompatActivity";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    protected Activity selfContext;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selfContext = this;
        sharedPreferences = getSharedPreferences(Constants.sharedPreferences, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    protected void hideKeyboard() {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(viewGroup.getWindowToken(), 0);
    }


    protected void showSnackbar(@NonNull String message) {
        View view = findViewById(android.R.id.content);
        if (view != null) {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
        } else {
            showSnackbar(message);
        }
    }

    protected void displayOutMessage(String message, boolean isDisplay) {
        if (isDisplay) {
            System.out.println(TAG + "::" + message);
        }
    }

    protected void showProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = new ProgressDialog(this, R.style.MyTheme);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    protected void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
