package com.demoPurpose.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.demoPurpose.R;

public class SplashScreenActivity extends SuperAppCompatActivity {
    private static final String TAG = "SplashScreenActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_spalsh);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                redirectToSignin();
            }
        }, 1000);
    }

    private void redirectToSignin() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }

}
