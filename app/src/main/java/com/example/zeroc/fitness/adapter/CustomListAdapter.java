package com.example.zeroc.fitness.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zeroc.fitness.R;
import com.example.zeroc.fitness.model.Item;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Item> listData;
    private LayoutInflater layoutInflater;
    private Context context;


    public CustomListAdapter(List<Item> listData, LayoutInflater layoutInflater, Context context) {
        this.listData = listData;
        this.layoutInflater = layoutInflater;
        this.context = context;
    }
    public CustomListAdapter(Context aContext,  List<Item> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public CustomListAdapter() {

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
            convertView = layoutInflater.inflate(R.layout.item_listview, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById( R.id.imageView);
            holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
//            holder.populationView = (TextView) convertView.findViewById(R.id.textView_population);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Item item = this.listData.get(position);
        holder.tvName.setText(item.getName());

        int imageId = this.getMipmapResIdByName(String.valueOf( item.getImg_id() ));

        holder.imageView.setImageResource(imageId);
        return convertView;
    }
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView tvName;

    }
}
