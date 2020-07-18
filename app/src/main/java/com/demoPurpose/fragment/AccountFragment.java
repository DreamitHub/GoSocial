package com.demoPurpose.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.demoPurpose.activity.HomePageActivity;
import com.demoPurpose.common.ICallback;
import com.demoPurpose.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment implements ICallback {
    private HomePageActivity mainActivity;
    private View view;
    private static final String TAG = "AccountFragment";
    private FragmentAccountBinding fragmentAccountBinding;

    public static AccountFragment newInstance() {

        Bundle args = new Bundle();
        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater, container, false);
        view = fragmentAccountBinding.getRoot();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainActivity = (HomePageActivity) getActivity();
        setupControlReferences();
        attachEventListeners();
    }

    @Override
    public void setupControlReferences() {

    }

    @Override
    public void attachEventListeners() {

    }
}