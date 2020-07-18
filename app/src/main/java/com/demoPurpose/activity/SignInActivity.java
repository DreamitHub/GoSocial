package com.demoPurpose.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demoPurpose.R;
import com.demoPurpose.common.ICallback;
import com.demoPurpose.databinding.ASigninBinding;

public class SignInActivity extends SuperAppCompatActivity implements ICallback {
    private ASigninBinding aSigninBinding;
    private boolean isValid;
    private SignInActivity signInActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aSigninBinding = ASigninBinding.inflate(getLayoutInflater());
        View view = aSigninBinding.getRoot();
        setContentView(view);
        setupControlReferences();
        attachEventListeners();
    }

    @Override
    public void setupControlReferences() {
        signInActivity = this;
        aSigninBinding.forgotPasswordLink.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    public void attachEventListeners() {
        aSigninBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isValid = Validation();
                if (isValid)
                    startActivity(new Intent(SignInActivity.this, HomePageActivity.class));
                else
                    showSnackbar("Username or password should not be blank...");
            }
        });
        aSigninBinding.forgotPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotPasswordDialog();
            }
        });
        aSigninBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(signInActivity, SignUpActivity.class));
            }
        });

    }

    private boolean Validation() {
        if (TextUtils.isEmpty(aSigninBinding.edtSigninUsername.getText().toString().trim())) {
            return false;
        } else if (TextUtils.isEmpty(aSigninBinding.edtSigninPassword.getText().toString().trim())) {
            return false;
        } else {
            return true;
        }
    }

    //    Creating popup dialog for all buttons
    private void forgotPasswordDialog() {
        LayoutInflater inflaterx = signInActivity.getLayoutInflater();
        View view = inflaterx.inflate(R.layout.d_forgot_password, null);
        final Dialog myDialog = new Dialog(signInActivity, R.style.BottomDialog);
        myDialog.setCanceledOnTouchOutside(true);
        myDialog.getWindow().setGravity(Gravity.BOTTOM);
        myDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);
        ImageView imgClosePopup = view.findViewById(R.id.img_close_popup);
        myDialog.setContentView(view);
        myDialog.show();
        myDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        imgClosePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
    }
}
