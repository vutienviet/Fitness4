package com.example.zeroc.fitness;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class ListviewLessionAdapter extends BaseAdapter {
    private static ArrayList<Item> listItem;
    private LayoutInflater mLayoutInflater;
    private Context context;


    public ListviewLessionAdapter(Context mcontex, ArrayList<Item> listItem) {
        this.context = mcontex;
        this.listItem = listItem;
        mLayoutInflater = LayoutInflater.from(mcontex);
    }



    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item_lesson_button_1 , null);
            holder = new ViewHolder();
            holder.imgLession = convertView.findViewById(R.id.imgGiftLessonAction);
            holder.tvnameLession = convertView.findViewById(R.id.tv_LessionName);
            holder.tvDurations = convertView.findViewById(R.id.tv_durations);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Item item = this.listItem.get(position);
        int imageld = this.getMipmapResIdByName(item.getImageLession());


        holder.imgLession.setImageResource(imageld);
        holder.tvnameLession.setText(item.getNameLession());
        holder.tvDurations.setText("durations : " + item.getDurations());

        return convertView;
    }



    public int getMipmapResIdByName(String resName){
        String pkgName = context.getPackageName();

        int resID = context.getResources().getIdentifier(resName , "mipmap" , pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder{
        ImageView imgLession;
        TextView tvnameLession;
        TextView tvDurations;
    }
}
