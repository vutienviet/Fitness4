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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayoutMain;
    private ViewPager viewPagerMain;
    TabItem tabTraining;
    TabItem tabReport;
    TabItem tabMe;
    private FirebaseAnalytics mFirebaseAnalytics;

//    Button imgButton1;
//    Button imgButton2;
//    Button imgButton3;
//    Button imgButton4;
//    Button imgButton5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        Control();
        // fragment manager = getFragmentManager
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager();





    }

    private void Control() {
        FragmentManager manager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(manager);

        viewPagerMain.setAdapter(adapter);
        tabLayoutMain.setupWithViewPager(viewPagerMain);

        viewPagerMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutMain));
        tabLayoutMain.setTabsFromPagerAdapter(adapter);
        tabLayoutMain.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPagerMain));

    }

    private void AnhXa() {
        tabLayoutMain = findViewById(R.id.tabLayoutMain);
        viewPagerMain = findViewById(R.id.viewpapperpMain);
        tabTraining = findViewById(R.id.tabTraining);
        tabReport = findViewById(R.id.tabReport);
        tabMe = findViewById(R.id.tabMe);
//        imgButton1 = findViewById(R.id.imgButton1);
//        imgButton2 =findViewById(R.id.imgButton2);
//        imgButton3 =findViewById(R.id.imgButton3);
//        imgButton4 =findViewById(R.id.imgButton4);
//        imgButton5 =findViewById(R.id.imgButton5);

    }
}
