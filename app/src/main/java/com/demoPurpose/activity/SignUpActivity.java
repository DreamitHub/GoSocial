package com.demoPurpose.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.demoPurpose.common.ICallback;
import com.demoPurpose.databinding.ASignupBinding;
import com.polyak.iconswitch.IconSwitch;

public class SignUpActivity extends SuperAppCompatActivity implements ICallback {
    private static final String TAG = "SignUpActivity";
    private ASignupBinding aSignupBinding;
    private boolean isValid;
    private SignUpActivity signUpActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aSignupBinding = ASignupBinding.inflate(getLayoutInflater());
        View view = aSignupBinding.getRoot();
        setContentView(view);
        setupControlReferences();
        attachEventListeners();
    }

    @Override
    public void setupControlReferences() {
        signUpActivity = this;
    }

    @Override
    public void attachEventListeners() {
        aSignupBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isValid = Validation();
                if (isValid)
                    startActivity(new Intent(signUpActivity, HomePageActivity.class));
                else
                    showSnackbar("All fields are mandotory!!!");
            }
        });


        aSignupBinding.genderSwitch.setCheckedChangeListener(new IconSwitch.CheckedChangeListener() {
            @Override
            public void onCheckChanged(IconSwitch.Checked current) {
                displayOutMessage("" + current.name(), true);
            }
        });

    }

    private boolean Validation() {
        if (TextUtils.isEmpty(aSignupBinding.edtSignupFirstname.getText().toString().trim())) {
            return false;
        } else if (TextUtils.isEmpty(aSignupBinding.edtSignupLastname.getText().toString().trim())) {
            return false;
        } else if (TextUtils.isEmpty(aSignupBinding.edtSignupEmailAddress.getText().toString().trim())) {
            return false;
        } else if (TextUtils.isEmpty(aSignupBinding.edtSignupPassword.getText().toString().trim())) {
            return false;
        } else if (TextUtils.isEmpty(aSignupBinding.edtSignupConfirmPassword.getText().toString().trim())) {
            return false;
        } else {
            return true;
        }
    }


}
