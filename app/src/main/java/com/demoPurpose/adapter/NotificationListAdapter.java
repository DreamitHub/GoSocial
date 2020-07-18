package com.demoPurpose.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.demoPurpose.R;
import com.demoPurpose.common.MyOnClickListener;

import java.util.ArrayList;
import java.util.HashMap;

public class NotificationListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private MyOnClickListener onClickListener;
    private Context context;
    private ArrayList<HashMap<String, String>> hashMapArrayList;

    private NotificationListAdapter(Context mContext, ArrayList<HashMap<String, String>> arrayList, MyOnClickListener mOnClickListener) {
        this.context = mContext;
        hashMapArrayList = arrayList;
        this.onClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.r_notification_list, parent, false);
        return new ItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.storyUserName.setText(hashMapArrayList.get(position).get(""));
        itemViewHolder.llStorylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hashMapArrayList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private LinearLayoutCompat llStorylist;
        private ImageView storyUserImage;
        private TextView storyUserName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            llStorylist = itemView.findViewById(R.id.ll_story_list);
            storyUserImage = itemView.findViewById(R.id.story_user_img);
            storyUserName = itemView.findViewById(R.id.txt_story_username);

        }

    }
}
