package com.example.zeroc.fitness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zeroc.fitness.adapter.RecyclerviewAdapter;
import com.example.zeroc.fitness.model.Item;

import java.util.ArrayList;
import java.util.List;

import Database.DatabaseHelper;

public class ABSBeginActivity extends AppCompatActivity {

    List<Item> exerciseList = new ArrayList<Item>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerviewAdapter adapter;
    DatabaseHelper databaseHelper;

    private static final int MENU_ITEM_VIEW = 111;
    private static final int MENU_ITEM_EDIT = 222;
    private static final int MENU_ITEM_CREATE = 333;
    private static final int MENU_ITEM_DELETE = 444;
    private static final int MY_REQUEST_CODE = 1000;
    DatabaseHelper db = new DatabaseHelper( this );;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_absbegin );

        initData();
        recyclerView = findViewById( R.id.recyclerViewABS );
        adapter = new RecyclerviewAdapter( exerciseList, getBaseContext() );
        layoutManager = new LinearLayoutManager( this );


        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setAdapter( adapter );
    }

    private void initData() {

        Item item1 = new Item( "Warm Up!" );
        Item item2 = new Item( "Shake round" );
        Item item3 = new Item( "Dumble" );
        Item item4 = new Item( "Incline press" );
        Item item5 = new Item( "Cardio" );
        Item item6 = new Item( "Cardio" );
        Item item7 = new Item( "ABS" );
        Item item8 = new Item( "Rower" );

        db.addEx( item1 );
        db.addEx( item2 );

        db.addEx( item3 );
        db.addEx( item4 );
        db.addEx( item5 );
        db.addEx( item6 );
        db.addEx( item7 );
        db.addEx( item8 );
        List<Item> list = new ArrayList<Item>(  );
        list = db.getAllEx();
        for (int i = 0 ; i <list.size() ; i++){
            if (list.get( i ).getId() == 1){
                exerciseList.add( new Item( R.drawable.totoro1 , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 2){
                exerciseList.add( new Item( R.drawable.giphy , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 3){
                exerciseList.add( new Item( R.drawable.gym_dumble , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 4){
                exerciseList.add( new Item( R.drawable.dumbell_hand , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 5){
                exerciseList.add( new Item( R.drawable.caldio1 , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 6){
                exerciseList.add( new Item( R.drawable.abs , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 7){
                exerciseList.add( new Item( R.drawable.rower_ani_4 , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 8){
                exerciseList.add( new Item( R.drawable.l1 , list.get( i ).getName() ) );
            }
        }
    }
}
