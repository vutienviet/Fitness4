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

import java.util.ArrayList;
import java.util.List;

public class FragmentTrainingButton1 extends Fragment {

    RecyclerView mRecyclerView ;
    RecyclerViewAdapter mRecyclerViewAdapter;
    private List<String> data ;

    public FragmentTrainingButton1( ) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_training_button_1 , container , false);
       View view = inflater.inflate(R.layout.fragment_training_button_1 , container ,false);
       mRecyclerView = view.findViewById(R.id.mRecyclerViewItemButton1);
       mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        fakeData();
       return view;
    }


    private void fakeData(){
        data = new ArrayList<>();
        data.add("JUMPING PACK");
        data.add("JUMPING PACK1");
        data.add("JUMPING PACK2");
        data.add("JUMPING PACK3");
        data.add("JUMPING PACK4");
        data.add("JUMPING PACK5");
        data.add("JUMPING PACK5");
        data.add("JUMPING PACK6");
        data.add("JUMPING PACK7");

//        mRecyclerView = new RecyclerView((Context) data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerViewAdapter = new RecyclerViewAdapter(data);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);




    }
}
