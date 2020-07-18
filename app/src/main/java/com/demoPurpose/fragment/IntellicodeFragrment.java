package com.demoPurpose.fragment;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.demoPurpose.MyAppicaion;


/**
 * Created by Darshan on 12-06-2017.
 */

public abstract class IntellicodeFragrment extends Fragment {

    protected void showToast(Activity activity, String message) {
//        SnackbarManager.show(Snackbar.with(getActivity()).text(message));
        if (!TextUtils.isEmpty(message)) {
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
        }
    }

    protected void hideKeyboard() {
        ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(android.R.id.content);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(viewGroup.getWindowToken(), 0);
    }

    protected void showKeyboard() {
        ViewGroup viewGroup = (ViewGroup) getActivity().findViewById(android.R.id.content);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(viewGroup, InputMethodManager.SHOW_IMPLICIT);
    }


    public abstract String getName();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    protected void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyAppicaion.getWeakReferenceActivity());
        builder.setMessage(message);
        builder.setPositiveButton("Ok", null);
        builder.create().show();
    }

    protected void showAlert(String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MyAppicaion.getWeakReferenceActivity());
        builder.setMessage(message);
        builder.setPositiveButton("Ok", onClickListener);
        builder.create().show();
    }

    protected void showUpdateAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Uri uri = Uri.parse("market://details?id=" + getActivity().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_CLEAR_TOP |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                    getActivity().finish();
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                }
            }
        });
        builder.create().show();
    }
}
