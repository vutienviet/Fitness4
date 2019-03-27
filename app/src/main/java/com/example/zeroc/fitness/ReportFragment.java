package com.example.zeroc.fitness;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class ReportFragment extends Fragment {
    ListView listView ;
    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this com.example.zeroc.fitness.fragment
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        ArrayList<Item2> listItem2 = getListData();
        listView = view.findViewById(R.id.lvReport);
        listView.setAdapter(new ListViewReportAdapter(getActivity() , listItem2));

        return view;

    }
    private ArrayList<Item2> getListData(){
        ArrayList<Item2> list = new ArrayList<Item2>();
        Item2 item = new Item2();
        Item2 item2 = new Item2();
        Item2 item3 = new Item2();
        item.setNameReport("Các chế độ dinh dưỡng khi tập gym");
        item.setImageReport("img_healthyfood");
        item.setDurationsReport("Việc có một chế dộ ăn hợp lý là vấn đề cần thiết khi tập luyện");
        item2.setNameReport("Thức ăn giúp bạn giảm cân");
        item2.setImageReport("img_weightlossfood");
        item2.setDurationsReport("Giảm cân đang là vấn đề cần thiết cho các bạn nữ khi luyện tập");
        item3.setNameReport("Cộng cụ giúp bạn tập luyện mỗi ngày ở nhà");
        item3.setImageReport("img_tool");
        item3.setDurationsReport("Công cụ dây đàn hồi có thể thực hiện được nhiều bài tập khác nhau đang là lý tưởng cho những ai thích tập thể hình ở nhà");



        list.add(item);
        list.add(item2);
        list.add(item3);
        return list;
    }


}
