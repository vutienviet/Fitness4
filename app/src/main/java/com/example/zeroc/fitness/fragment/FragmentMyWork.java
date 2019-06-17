package com.example.zeroc.fitness.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.zeroc.fitness.R;
import com.example.zeroc.fitness.adapter.CustomListAdapter;
import com.example.zeroc.fitness.adapter.RecyclerviewAdapter;
import com.example.zeroc.fitness.model.Item;

import java.util.ArrayList;

import Database.DatabaseHelper;

public class FragmentMyWork extends Fragment {
    Context context;
    RecyclerviewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    EditText edtSearch;
    ArrayList<Item> excercisesList = new ArrayList<Item>();
    ArrayList<Item> listitem = new ArrayList<Item>();
//    private RecyclerView recyclerViewListExChoosen;

    private ListView recyclerViewListExChoosen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.item_lession, container, false );

        recyclerViewListExChoosen = view.findViewById( R.id.recyclerViewListExChoosen );
//        edtSearch = view.findViewById( R.id.edtSearch );

        InitData();

        recyclerViewListExChoosen.setAdapter( new CustomListAdapter( getActivity().getApplicationContext(), excercisesList ) );


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
                excercisesList.add( new Item( R.drawable.totoro1, listitem.get( i ).getName() ) );
            }
            if (listitem.get( i ).getId() == 3) {
                excercisesList.add( new Item( R.drawable.totoro1, listitem.get( i ).getName() ) );
            }
            if (listitem.get( i ).getId() == 4) {
                excercisesList.add( new Item( R.drawable.totoro1, listitem.get( i ).getName() ) );
            }
        }
    }


}
