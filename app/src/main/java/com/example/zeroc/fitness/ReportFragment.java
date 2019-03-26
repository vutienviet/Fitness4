package com.example.zeroc.fitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ReportFragment extends Fragment {
    ListView listView ;
    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this com.example.zeroc.fitness.fragment
        View view = inflater.inflate(R.layout.fragment_report, container, false);
//        ArrayList<Item> listItem = getListData();
//        listView = view.findViewById(R.id.lvButton1);
//        listView.setAdapter(new ListviewLessionAdapter(getActivity() , listItem));

        return view;

    }
//    private ArrayList<Item> getListData(){
//        ArrayList<Item> list = new ArrayList<Item>();
//
//        Item item = new Item();
//        item.setNameLession("jumpingjack");
//        item.setImageLession("img_jumpingjack");
//        item.setDurations(30);
//
//        list.add(item);
//        return list;
//    }


}
