package com.example.zeroc.fitness.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zeroc.fitness.R;

public class FragmentMyWork extends Fragment {
         private TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.item_lession, container, false);
        tv = view.findViewById(R.id.tvsss);
        return view;
    }

}
