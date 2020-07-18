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
import com.demoPurpose.databinding.FragmentHelpCenterBinding;

public class HelpCenterFragment extends Fragment implements ICallback {
    private HomePageActivity mainActivity;
    private View view;
    private static final String TAG = "HelpCenterFragment";
    private FragmentHelpCenterBinding fragmentHelpCenterBinding;

    public static HelpCenterFragment newInstance() {

        Bundle args = new Bundle();
        HelpCenterFragment fragment = new HelpCenterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentHelpCenterBinding = FragmentHelpCenterBinding.inflate(inflater, container, false);
        view = fragmentHelpCenterBinding.getRoot();
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