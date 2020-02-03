package com.example.apiassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apiassignment.model.Anime;
import com.example.apiassignment.R;


import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Anime> mData;
//    RequestOptions options;

    public RecyclerViewAdapter(Context context, List<Anime> data) {
        this.mContext = context;
        this.mData = data;
//        options = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        View view;
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        view = inflater.inflate(R.layout.anime_row_item,parent,false);
//
//        return new MyViewHolder(view);

        View v = LayoutInflater.from(mContext).inflate(R.layout.anime_row_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Anime currentItem = mData.get(position);

        int id = currentItem.getId();
        String title = currentItem.getTitle();

        holder.id.setText("ID : " +id);
        holder.title.setText("Title : " +title);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.anime_id);
            title = itemView.findViewById(R.id.anime_title);

        }
    }

    public void updateList(List<String> newList){
        mData = new ArrayList<>();

        mData.add((Anime) newList);
        notifyDataSetChanged();

    }
}
