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

//import de.hdodenhof.circleimageview.CircleImageView;

public class Bird_List_Activity extends RecyclerView.Adapter<Bird_List_Activity.ActivityViewHolder> {
    private ArrayList<UI_List_Item> birdList;
    private Context birdListContext;

   public static class ActivityViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView birdName;
        public RelativeLayout parentLayout;
        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            //imageView.findViewById(R.id.ImageView);
            //imageView = imageView.findViewById(R.id.ImageView);
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
       // holder.imageView.setImageResource(currentItem.getBirdImage());
        holder.birdName.setText(currentItem.getBirdName());

        holder.imageView = holder.imageView.findViewById(R.id.listingImage);
        int imageId = birdListContext.getResources().getIdentifier(currentItem.getBirdImage(),
                null, birdListContext.getPackageName());

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
           Dictionary<String, String> allBirds = res.getInfo();
           Enumeration<String> elements = allBirds.elements();

           while (elements.hasMoreElements()) {
               //System.out.println(allBirds.get(elements));
               birdName = elements.nextElement();
               System.out.println("DEBUG: element (name): " + birdName);
               imageName = elements.nextElement();
               System.out.println("DEBUG: element (image): " + imageName);
               birdList.add(new UI_List_Item(imageName, birdName));
           }
       } else
           System.out.println("ERROR: results in main activity are null");

    }
}
