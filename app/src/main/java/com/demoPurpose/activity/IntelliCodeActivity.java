package com.demoPurpose.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.demoPurpose.fragment.IntellicodeFragrment;


public class IntelliCodeActivity extends AppCompatActivity {
    protected Activity selfContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selfContext = IntelliCodeActivity.this;
    }

    /*Used to display snack bar */
    protected void showSnackBar(String message) {
        Toast.makeText(IntelliCodeActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    /*Used to hide the keyboard*/
    protected void hideKeyboard() {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(viewGroup.getWindowToken(), 0);
    }


    public Context getActivityContext() {
        return IntelliCodeActivity.this;
    }


    /**
     * Used to load the fragment
     *
     * @param containerId container control
     * @param fragment    fragment name to load the controls
     */
    public void showFragment(int containerId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.replace(containerId, fragment).commit();
    }

    /**
     * Used to load the fragment  with back state mgmt
     *
     * @param containerId container control
     * @param fragment    fragment name to load the controls
     */
    public void showFragmentWithoutAddToBackStack(int containerId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerId, fragment).commit();
    }

    /**
     * Clears all back state mgmt from fragment transitions
     */
    public void clearBackStack() {
        FragmentManager manager = getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStackImmediate(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public String getRecentFragmentName() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        String recentFragmentName = "";
        if (backStackEntryCount > 0) {
            FragmentManager.BackStackEntry backStackEntry = fragmentManager.getBackStackEntryAt(backStackEntryCount - 1);
            recentFragmentName = backStackEntry.getName();

        }
        return recentFragmentName;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
