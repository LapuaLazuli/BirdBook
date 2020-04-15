package com.e.birdbook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter birdListActivity;
    private RecyclerView.LayoutManager layoutManager;
    private Context context;

    public Context getContext()
    {
        return context;
    }

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<UI_List_Item> birdList = new ArrayList<>();
        String imageList = "/BirdBook/BirdBook/media/images/american_coot.jpg";

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        birdListActivity = new Bird_List_Activity(birdList, this, imageList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(birdListActivity);

        context = this;
    }
}
