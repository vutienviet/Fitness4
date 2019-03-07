package com.example.zeroc.fitness;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayoutMain;
    private ViewPager viewPagerMain;
    private ImageButton imgButton1;
    private ImageButton imgButton2;
    private ImageButton imgButton3;
    private ImageButton imgButton4;
    private ImageButton imgButton5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Control();
    }

    private void Control() {
        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new adapter.PagerAdapter(manager);

        viewPagerMain.setAdapter(adapter);
        tabLayoutMain.setupWithViewPager(viewPagerMain);

        viewPagerMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutMain));
        tabLayoutMain.setTabsFromPagerAdapter(adapter);
        tabLayoutMain.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPagerMain));

    }

    private void AnhXa() {
        tabLayoutMain = findViewById(R.id.tabLayoutMain);
        viewPagerMain = findViewById(R.id.viewpapperpMain);
        imgButton1 = findViewById(R.id.imgButton1);
        imgButton2 = findViewById(R.id.imgButton2);
        imgButton3 = findViewById(R.id.imgButton3);
        imgButton4 = findViewById(R.id.imgButton4);
        imgButton5 = findViewById(R.id.imgButton5);

    }
}
