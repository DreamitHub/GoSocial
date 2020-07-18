package com.demoPurpose.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.demoPurpose.R;
import com.demoPurpose.activity.HomePageActivity;
import com.demoPurpose.adapter.HomePageListAdapter;
import com.demoPurpose.adapter.StoryListAdapter;
import com.demoPurpose.common.ICallback;
import com.demoPurpose.common.MyOnClickListener;
import com.demoPurpose.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.HashMap;

import static android.widget.LinearLayout.VERTICAL;

public class HomeFragment extends Fragment implements ICallback {
    private HomePageActivity mainActivity;
    private View view;
    private static final String TAG = "HomeFragment";
    private FragmentHomeBinding fragmentHomeBinding;
    private ArrayList<HashMap<String, String>> postArrayList = new ArrayList<>();
    private ArrayList<HashMap<String, String>> storyList = new ArrayList<>();
    private StoryListAdapter storyListAdapter;
    private HomePageListAdapter postListAdapter;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        view = fragmentHomeBinding.getRoot();
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
        /*fragmentHomeBinding.rcvStoryData is used for story data*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        fragmentHomeBinding.rcvStoryData.setLayoutManager(linearLayoutManager);

        /*fragmentHomeBinding.rcvStoryData is used for Main home page data*/
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(mainActivity);
        fragmentHomeBinding.rclHomeData.setLayoutManager(linearLayoutManager1);
        DividerItemDecoration decoration = new DividerItemDecoration(mainActivity, VERTICAL);
        Drawable verticalDivider = ContextCompat.getDrawable(mainActivity, R.color.grey);
        decoration.setDrawable(verticalDivider);
        fragmentHomeBinding.rclHomeData.addItemDecoration(decoration);
        loadStoryData();
        loadPostData();

    }

    @Override
    public void attachEventListeners() {

    }

    private void loadStoryData() {
        for (int i = 0; i < 8; i++) {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            if (i % 2 == 0) {
                stringStringHashMap.put("storyphotoname", "Peter");
            } else {
                stringStringHashMap.put("storyphotoname", "Mark");
            }
            storyList.add(stringStringHashMap);
        }
        storyListAdapter = new StoryListAdapter(mainActivity, storyList, new MyOnClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        fragmentHomeBinding.rcvStoryData.setAdapter(storyListAdapter);
    }

    private void loadPostData() {
        for (int i = 0; i < 4; i++) {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            if (i % 2 == 0) {
                stringStringHashMap.put("postusername", "I support Narendra modi");
                stringStringHashMap.put("postusertime", "1h");
                stringStringHashMap.put("postuserdescription", "Defence minister Rajnath sinh offered prayers at Amarnath temple today. ");
                stringStringHashMap.put("postimagedesclink", "https://www.divyabhaskar.co.in/national/news/arriving-at-the-amarnath-temple-the-defense-minister-can-visit-the-forward-locations-on-the-loc-127525564.html");
                stringStringHashMap.put("postuserlike", "0");
                stringStringHashMap.put("postusercomment", "1");
                stringStringHashMap.put("postusershare", "0");

            } else {
                stringStringHashMap.put("postusername", "Indian National congress-Gujarat");
                stringStringHashMap.put("postusertime", "1d");
                stringStringHashMap.put("postuserdescription", "Rahul gandhi's discussion on he causes of Chinese Infiltration");
                stringStringHashMap.put("postimagedesclink", "https://www.patrika.com/political-news/rahul-gandhi-explained-why-did-china-choose-this-time-to-infiltrate-ladakh-6275961/");
                stringStringHashMap.put("postuserlike", "0");
                stringStringHashMap.put("postusercomment", "1");
                stringStringHashMap.put("postusershare", "0");
            }
            postArrayList.add(stringStringHashMap);
        }
        postListAdapter = new HomePageListAdapter(mainActivity, postArrayList, new MyOnClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        fragmentHomeBinding.rclHomeData.setAdapter(postListAdapter);

    }
}