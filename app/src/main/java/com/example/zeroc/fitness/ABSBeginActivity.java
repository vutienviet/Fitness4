package com.example.zeroc.fitness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.zeroc.fitness.adapter.RecyclerviewAdapter;
import com.example.zeroc.fitness.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ABSBeginActivity extends AppCompatActivity {

    List<Item> exerciseList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerviewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_absbegin );

        initData();
        recyclerView = findViewById(R.id.recyclerViewABS);
        adapter = new RecyclerviewAdapter(exerciseList,getBaseContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        exerciseList.add( new Item( R.drawable.totoro1 , "Tottoro" ) );
        exerciseList.add( new Item( R.drawable.giphy , "Tottoro" ) );
        exerciseList.add( new Item( R.drawable.gym_dumble , "Tottoro" ) );
        exerciseList.add( new Item( R.drawable.l1 , "Tottoro" ) );
        exerciseList.add( new Item( R.drawable.squat , "Tottoro" ) );
        exerciseList.add( new Item( R.drawable.totoro1 , "Tottoro" ) );
        exerciseList.add( new Item( R.drawable.totoro1 , "Tottoro" ) );
        exerciseList.add( new Item( R.drawable.totoro1 , "Tottoro" ) );

    }
}
