package com.e.birdbook;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;
import de.hdodenhof.circleimageview.CircleImageView;

public class Bird_List_Activity extends RecyclerView.Adapter<Bird_List_Activity.ActivityViewHolder> {
    private ArrayList<UI_List_Item> birdList;
    private Context birdListContext;

   public static class ActivityViewHolder extends RecyclerView.ViewHolder{
        public CircleImageView imageView;
        public TextView birdName;
        public RelativeLayout parentLayout;
        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);

            birdName = itemView.findViewById(R.id.TextName);
            imageView = itemView.findViewById(R.id.listingImage);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public Bird_List_Activity(ArrayList<UI_List_Item> birdList, Context context){
       this.birdListContext = context;
        this.birdList = birdList;
       getAllData();

    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        ActivityViewHolder viewHolder = new ActivityViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, final int position) {
        UI_List_Item currentItem = birdList.get(position);
        holder.birdName.setText(currentItem.getBirdName());
        holder.imageView = holder.imageView.findViewById(R.id.listingImage);
        int imageId = birdListContext.getResources().getIdentifier(currentItem.getBirdImage(),
                "drawable", birdListContext.getPackageName());

        holder.imageView.setImageResource(imageId);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(birdListContext, birdInfoActivity.class);
                intent.putExtra("Bird", birdList.get(position).getBirdName());
                birdListContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return birdList.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public void getAllData(){
       Request req = BirdListingRequestPackager.BirdListRequest();
       UIFriendlyInfo res = Requester.request(req, this.birdListContext);
       String birdName, imageName;

       if(res != null) {
           List<String> allBirds = res.getValues();

           for(int i = 0; i < allBirds.size(); i += 2)
           {
               try
               {
                   birdName = allBirds.get(i);
                   imageName = allBirds.get(i+1);
                   System.out.println("DEBUG: LISTY = " + birdName + " " + imageName);
                   birdList.add(new UI_List_Item(imageName, birdName));
               }
               catch(Exception e)
               {
                   System.out.println("ERROR: Missing element");
               }

           }

       } else
           System.out.println("ERROR: results in main activity are null");

    }
}
