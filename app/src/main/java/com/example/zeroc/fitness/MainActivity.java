package com.example.zeroc.fitness;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayoutMain;
    public ViewPager viewPagerMain;
    private ListView lvMain;

    TabItem tabTraining;
    TabItem tabReport;
    TabItem tabMe;
    private FirebaseAnalytics mFirebaseAnalytics;
    private int[] tabIcons = {
            R.drawable.icon_training,
            R.drawable.icon_report,
            R.drawable.icon_me
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Control();

    }

    private void Control() {
        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(manager);

        viewPagerMain.setAdapter(adapter);
        tabLayoutMain.setupWithViewPager(viewPagerMain);

        viewPagerMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutMain));
        tabLayoutMain.setTabsFromPagerAdapter(adapter);
        tabLayoutMain.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPagerMain));
        tabLayoutMain.getTabAt(0).setIcon(tabIcons[0]);
        tabLayoutMain.getTabAt(1).setIcon(tabIcons[1]);
        tabLayoutMain.getTabAt(2).setIcon(tabIcons[2]);





    }

    private void AnhXa() {

        tabLayoutMain = findViewById(R.id.tabLayoutMain);
        viewPagerMain = findViewById(R.id.viewpapperpMain);
        tabTraining = findViewById(R.id.tabTraining);
        tabReport = findViewById(R.id.tabReport);
        tabMe = findViewById(R.id.tabMe);
        lvMain = findViewById(R.id.lvButton1);
    }
  }
