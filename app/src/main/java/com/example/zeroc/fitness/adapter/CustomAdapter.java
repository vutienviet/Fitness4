package com.example.zeroc.fitness.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zeroc.fitness.R;
import com.example.zeroc.fitness.model.Item;
import com.example.zeroc.fitness.model.OnClickItemTab1;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Item> listItem;
    Context context;
    OnClickItemTab1 onClickItemTab1;

    public CustomAdapter(ArrayList listItem, Context context, OnClickItemTab1 onClickItemTab1) {
        this.listItem = listItem;
        this.context = context;
        this.onClickItemTab1 = onClickItemTab1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_listview, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(params);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Glide.with( context ).load( listItem.get( position ).getImg_id() ).into( viewHolder.imageView );
        viewHolder.tvName.setText( listItem.get( position ).getName() );
        viewHolder.btnAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
//                onClickItemTab1.onClickItem("Item number " + position);
            }
        } );
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


     class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView imageView;
        TextView tvName;
        Button btnAdd;

         public ViewHolder(View itemView) {
             super(itemView);
             tvName = itemView.findViewById(R.id.tvName);
             imageView = itemView.findViewById( R.id.imageView );
             btnAdd = itemView.findViewById(R.id.btnAdd);
         }
    }
}
