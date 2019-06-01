package com.example.zeroc.fitness.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zeroc.fitness.R;
import com.example.zeroc.fitness.model.Item;
import com.example.zeroc.fitness.model.ItemClickListener;

import java.util.List;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView img;
    public TextView tv;
    private ItemClickListener itemClickListener;

    public RecyclerViewHolder(@NonNull View itemView) {
        super( itemView );
        img = itemView.findViewById( R.id.ex_img);
        tv = itemView.findViewById(R.id.ex_name);
        itemView.setOnClickListener(this);
    }
public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
}
    @Override
    public void onClick(View v) {
        itemClickListener.onClick( v, getAdapterPosition() );
    }
}

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    private List<Item> listEx;
    private Context context;

    public RecyclerViewAdapter(List<Item> listEx, Context context) {
        this.listEx = listEx;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from( viewGroup.getContext() );
        View itemView = inflater.inflate( R.layout.item_lesson_button_1 , viewGroup , false );
        return new RecyclerViewHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        Glide.with(context).load(listEx.get(i).getImg_id()).into(recyclerViewHolder.img);
        recyclerViewHolder.tv.setText( listEx.get( i ).getName() );
        recyclerViewHolder.setItemClickListener( new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
//                Intent intent = new Intent(  );
            }
        } );
    }

    @Override
    public int getItemCount() {
        return listEx.size();
    }
}
