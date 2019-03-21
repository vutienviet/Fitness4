package com.example.zeroc.fitness;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.zeroc.fitness.R;

public class TrainingFragment extends Fragment {


    private OnFragmentManager mListener;
    Button imgButton1;
    Button imgButton2;
    Button imgButton3;
    Button imgButton4;
    Button imgButton5;
    public TrainingFragment() {
        // Required empty public constructor
    }




//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_training , container , false);

        imgButton1 = view.findViewById(R.id.imgButton1);
        imgButton2 =view.findViewById(R.id.imgButton2);
        imgButton3 =view.findViewById(R.id.imgButton3);
        imgButton4 = view.findViewById(R.id.imgButton4);
        imgButton5 = view.findViewById(R.id.imgButton5);

        imgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity() , "Click" , Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentManager) {
////            mListener = (OnFragmentManager) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentManager");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

}
