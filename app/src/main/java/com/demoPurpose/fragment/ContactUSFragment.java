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
import com.demoPurpose.databinding.FragmentPrivacyBinding;

public class ContactUSFragment extends Fragment implements ICallback {
    private HomePageActivity mainActivity;
    private View view;
    private static final String TAG = "ContactUSFragment";
    private FragmentPrivacyBinding fragmentPrivacyBinding;

    public static ContactUSFragment newInstance() {

        Bundle args = new Bundle();
        ContactUSFragment fragment = new ContactUSFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPrivacyBinding = FragmentPrivacyBinding.inflate(inflater, container, false);
        view = fragmentPrivacyBinding.getRoot();
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