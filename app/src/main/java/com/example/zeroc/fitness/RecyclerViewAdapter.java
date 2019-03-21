package com.example.zeroc.fitness;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<String> data = new ArrayList<>();

    public RecyclerViewAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_lesson_button_1 , viewGroup , false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        recyclerViewHolder.tvLessonName.setText(data.get(i));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvLessonName ;
        ImageView imgGiftLessonAction;
        public RecyclerViewHolder(View itemView){
            super(itemView);
            tvLessonName = (TextView) itemView.findViewById(R.id.tvLessonName);
            imgGiftLessonAction = itemView.findViewById(R.id.imgGiftLessonAction);
        }

    }
}
