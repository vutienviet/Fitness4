package com.example.zeroc.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class LessionActivity extends AppCompatActivity {
 private ImageView img1;
 private ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_training_button_1);

        lv1 = findViewById(R.id.lvButton1);

        ArrayList<Item> listItem = getListData();
        lv1.setAdapter(new ListviewLessionAdapter(this , listItem));

    }
    private ArrayList<Item> getListData(){
        ArrayList<Item> list = new ArrayList<Item>();
        Item item = new Item();
        item.setNameLession("jumpingjack");
        item.setImageLession("img_jumpingjack");
        item.setDurations(30);
        list.add(item);
        return list;
    }
}
