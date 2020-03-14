package com.e.birdbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Bird_List_Activity extends RecyclerView.Adapter<Bird_List_Activity.ActivityViewHolder> {
    private ArrayList<UI_List_Item> birdList;
   public static class ActivityViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView birdName;
        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            //imageView.findViewById(R.id.ImageView);
            //imageView = imageView.findViewById(R.id.ImageView);
            birdName = itemView.findViewById(R.id.TextName);
        }
    }

    public Bird_List_Activity(ArrayList<UI_List_Item> birdList){
        this.birdList = birdList;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        ActivityViewHolder viewHolder = new ActivityViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        UI_List_Item currentItem = birdList.get(position);
       // holder.imageView.setImageResource(currentItem.getBirdImage());
        holder.birdName.setText(currentItem.getBirdName());

    }

    @Override
    public int getItemCount() {
        return birdList.size();
    }
}