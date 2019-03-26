package com.example.zeroc.fitness;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FragmentTrainingButton1 extends Fragment {

    ListView listView ;

    public FragmentTrainingButton1( ) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_training_button_1 , container , false);
       View view = inflater.inflate(R.layout.fragment_training_button_1 ,
               container ,false);
       ArrayList<Item> listItem = getListData();
       listView = view.findViewById(R.id.lvButton1);
       listView.setAdapter(new ListviewLessionAdapter(getActivity() , listItem));

       return view;
    }

    private ArrayList<Item> getListData(){
         ArrayList<Item> list = new ArrayList<Item>();
        Item item = new Item();
        item.setNameLession("jumpingjack");
        item.setImageLession("img_jumpingjack");
        item.setDurations(30);
        list.add(item);
        return list;
    }


}
