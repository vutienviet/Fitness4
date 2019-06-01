package com.example.zeroc.fitness.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zeroc.fitness.model.Item2;
import com.example.zeroc.fitness.R;

import java.util.ArrayList;

public class ListViewReportAdapter extends BaseAdapter {
    private static ArrayList<Item2> listItem2;
    private LayoutInflater mLayoutInflater;
    private Context context;


    public ListViewReportAdapter(Context mcontex, ArrayList<Item2> listItem2) {
        this.context = mcontex;
        this.listItem2 = listItem2;
        mLayoutInflater = LayoutInflater.from(mcontex);
    }



    @Override
    public int getCount() {
        return listItem2.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder;
        if (convertView == null){
            convertView = mLayoutInflater.inflate( R.layout.item_report , null);
            viewHolder = new ListViewReportAdapter.ViewHolder();
            viewHolder.imageView2 = convertView.findViewById(R.id.imgGiftReportAction);
            viewHolder.tvReportLession = convertView.findViewById(R.id.tv_ReportName);
            viewHolder.tvReportDurations = convertView.findViewById(R.id.tv_ReportDurations);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ListViewReportAdapter.ViewHolder) convertView.getTag();
        }
        Item2 item = this.listItem2.get(position);
        int imageld = this.getMipmapResIdByName(item.getImageReport());


        viewHolder.imageView2.setImageResource(imageld);
        viewHolder.tvReportLession.setText(item.getNameReport());
        viewHolder.tvReportDurations.setText(item.getDurationsReport());



        return convertView;
    }



    public int getMipmapResIdByName(String resName){
        String pkgName = context.getPackageName();

        int resID = context.getResources().getIdentifier(resName , "mipmap" , pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder{
        ImageView imageView2;
        TextView tvReportLession;
        TextView tvReportDurations;
    }
}

