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
import com.demoPurpose.common.Constants;
import com.demoPurpose.common.MyOnClickListener;

import java.util.ArrayList;
import java.util.HashMap;

public class HomePageListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private MyOnClickListener onClickListener;
    private Context context;
    private ArrayList<HashMap<String, String>> hashMapArrayList;

    public HomePageListAdapter(Context mContext, ArrayList<HashMap<String, String>> arrayList, MyOnClickListener mOnClickListener) {
        this.context = mContext;
        hashMapArrayList = arrayList;
        this.onClickListener = mOnClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.r_home_list, parent, false);
        return new ItemViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.postUserName.setText(hashMapArrayList.get(position).get("postusername"));
        itemViewHolder.postUserTime.setText(hashMapArrayList.get(position).get("postusertime"));
        itemViewHolder.postDescription.setText(hashMapArrayList.get(position).get("postuserdescription"));
        itemViewHolder.postImgDescLink.setText(hashMapArrayList.get(position).get("postimagedesclink"));
        /*itemViewHolder.llShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemViewHolder.txtLike.setText(Constants.likeCounter++);
            }
        });
        itemViewHolder.llLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemViewHolder.txtComment.setText(Constants.commentCount++);
            }

        });
        itemViewHolder.llComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemViewHolder.txtShare.setText(Constants.shareCounter++);
            }
        });
        itemViewHolder.txtComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemViewHolder.txtLike.setText(Constants.likeCounter++);
            }
        });
        itemViewHolder.txtShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemViewHolder.txtComment.setText(Constants.commentCount++);
            }

        });
        itemViewHolder.txtComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemViewHolder.txtShare.setText(Constants.shareCounter++);
            }
        });
        itemViewHolder.postMoreImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return hashMapArrayList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView postUserImg;
        private TextView postUserName;
        private TextView postUserTime;
        private ImageView postMoreImg;
        private TextView postDescription;
        private ImageView postDescImg;
        private TextView postImgDescLink;
        private LinearLayoutCompat llLike;
        private LinearLayoutCompat llComment;
        private LinearLayoutCompat llShare;
        private TextView txtLike;
        private TextView txtComment;
        private TextView txtShare;

        public ItemViewHolder(View itemView) {
            super(itemView);
            postUserImg = itemView.findViewById(R.id.post_user_img);
            postUserName = itemView.findViewById(R.id.post_user_name);
            postUserTime = itemView.findViewById(R.id.post_user_time);

            postMoreImg = itemView.findViewById(R.id.post_img_more);

            postDescription = itemView.findViewById(R.id.txt_post_description);
            postDescImg = itemView.findViewById(R.id.post_description_img);
            postImgDescLink = itemView.findViewById(R.id.txt_post_img_link);

            llLike = itemView.findViewById(R.id.ll_like);
            llComment = itemView.findViewById(R.id.ll_comment);
            llShare = itemView.findViewById(R.id.ll_share);

            txtLike = itemView.findViewById(R.id.txt_like);
            txtComment = itemView.findViewById(R.id.txt_comment);
            txtShare = itemView.findViewById(R.id.txt_share);
        }

    }
}
