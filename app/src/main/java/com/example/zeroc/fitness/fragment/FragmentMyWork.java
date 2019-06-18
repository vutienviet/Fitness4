package com.example.zeroc.fitness.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zeroc.fitness.R;
import com.example.zeroc.fitness.adapter.CustomAdapter;
import com.example.zeroc.fitness.model.Item;
import com.example.zeroc.fitness.model.OnClickItemTab1;

import java.util.ArrayList;

import Database.DatabaseHelper;

public class FragmentMyWork extends Fragment {

    CustomAdapter adapter;
    OnClickItemTab1 onClickItemTab1;


    ArrayList<Item> excercisesList = new ArrayList<Item>();
    ArrayList<Item> listitem = new ArrayList<Item>();
    private RecyclerView recyclerViewListExChoosen;


    public void setOnClickItemTab1(OnClickItemTab1 onClickItemTab1) {
        this.onClickItemTab1 = onClickItemTab1;
    }

    public static FragmentMyWork getInstance(){
        return new FragmentMyWork();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.item_lession, container, false );

        recyclerViewListExChoosen = view.findViewById( R.id.recyclerViewListExChoosen );
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        InitData();
        adapter = new CustomAdapter( excercisesList , getContext() , onClickItemTab1 );
        recyclerViewListExChoosen.setAdapter( adapter );
        recyclerViewListExChoosen.setLayoutManager( manager );

//        recyclerViewListExChoosen.setAdapter( new CustomListAdapter( getActivity().getApplicationContext(), excercisesList ) );


        return view;
    }

//  public boolean check(String search){
//     search = edtSearch.getText().toString();
//     DatabaseHelper db = new DatabaseHelper( getActivity().getApplicationContext() );
//     if (search.equals( db.searchEx( search ) )){
//         return true;
//     }
//     return false;
//    }

    public void InitData() {
        DatabaseHelper db = new DatabaseHelper( getActivity().getApplicationContext() );

        listitem = (ArrayList<Item>) db.getAllEx();

        for (int i = 0; i < listitem.size(); i++) {
            if (listitem.get( i ).getId() == 1) {
                excercisesList.add( new Item( R.drawable.totoro1, listitem.get( i ).getName() ) );
            }
            if (listitem.get( i ).getId() == 2) {
                excercisesList.add( new Item( R.drawable.giphy, listitem.get( i ).getName() ) );
            }
            if (listitem.get( i ).getId() == 3) {
                excercisesList.add( new Item( R.drawable.gym_dumble, listitem.get( i ).getName() ) );
            }
            if (listitem.get( i ).getId() == 4) {
                excercisesList.add( new Item( R.drawable.dumbell_hand, listitem.get( i ).getName() ) );
            }
            if (listitem.get( i ).getId() == 5) {
                excercisesList.add( new Item( R.drawable.caldio1, listitem.get( i ).getName() ) );
            }
            if (listitem.get( i ).getId() == 6) {
                excercisesList.add( new Item( R.drawable.abs, listitem.get( i ).getName() ) );
            }
            if (listitem.get( i ).getId() == 7) {
                excercisesList.add( new Item( R.drawable.rower_ani_4, listitem.get( i ).getName() ) );
            }
            if (listitem.get( i ).getId() == 8) {
                excercisesList.add( new Item( R.drawable.l1, listitem.get( i ).getName() ) );
            }
        }
    }


}
