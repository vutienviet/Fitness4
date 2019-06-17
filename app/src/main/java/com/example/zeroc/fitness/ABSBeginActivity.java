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

        Item item1 = new Item( "Totoro1" );
        Item item2 = new Item( "Totoro2" );
        Item item3 = new Item( "Totoro3" );
        Item item4 = new Item( "Totoro4" );

        db.addEx( item1 );
        db.addEx( item2 );

        db.addEx( item3 );
        db.addEx( item4 );
        List<Item> list = new ArrayList<Item>(  );
        list = db.getAllEx();
        for (int i = 0 ; i <list.size() ; i++){
            if (list.get( i ).getId() == 1){
                exerciseList.add( new Item( R.drawable.totoro1 , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 2){
                exerciseList.add( new Item( R.drawable.totoro1 , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 3){
                exerciseList.add( new Item( R.drawable.totoro1 , list.get( i ).getName() ) );
            }
            if (list.get( i ).getId() == 4){
                exerciseList.add( new Item( R.drawable.totoro1 , list.get( i ).getName() ) );
            }
        }
    }
}
