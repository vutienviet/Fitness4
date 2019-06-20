package com.example.zeroc.fitness.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.zeroc.fitness.R;
import com.example.zeroc.fitness.model.Item;

import java.util.List;

public class CustomListMeAdapter  extends BaseAdapter {

    private List<Item> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListMeAdapter(List<Item> listData, LayoutInflater layoutInflater, Context context) {
        this.listData = listData;
        this.layoutInflater = layoutInflater;
        this.context = context;
    }
    public CustomListMeAdapter(Context aContext,  List<Item> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public CustomListMeAdapter() {

    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate( R.layout.item_listview_me, null);
            holder = new CustomListMeAdapter.ViewHolder();
            holder.tvMe = (TextView) convertView.findViewById(R.id.textViewItemMe);
//            holder.btnAdd = convertView.findViewById( R.id.btnAdd );
//            holder.populationView = (TextView) convertView.findViewById(R.id.textView_population);
            convertView.setTag(holder);
        } else {
            holder = (CustomListMeAdapter.ViewHolder) convertView.getTag();
        }
        Item item = this.listData.get(position);
        holder.tvMe.setText(item.getName());

        return convertView;
    }

    static class ViewHolder {
       TextView tvMe;
    }
}
