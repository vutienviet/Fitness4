package com.example.zeroc.fitness;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.zeroc.fitness.fragment.MeFragment;
import com.example.zeroc.fitness.fragment.ReportFragment;
import com.example.zeroc.fitness.fragment.TrainingFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayoutMain;
    public ViewPager viewPagerMain;
    private ListView lvMain;

//    TabItem tabTraining;
//    TabItem tabReport;
//    TabItem tabMe;
//    private FirebaseAnalytics mFirebaseAnalytics;
//    private int[] tabIcons = {
//            R.drawable.icon_training,
//            R.drawable.icon_report,
//            R.drawable.icon_me
//    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();


    }

//    private void Control() {
//        FragmentManager manager = getSupportFragmentManager();
//        PagerAdapter adapter = new PagerAdapter(manager);
//
//        viewPagerMain.setAdapter(adapter);
//        tabLayoutMain.setupWithViewPager(viewPagerMain);
//
//        viewPagerMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutMain));
//        tabLayoutMain.setTabsFromPagerAdapter(adapter);
//        tabLayoutMain.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPagerMain));
//        tabLayoutMain.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayoutMain.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayoutMain.getTabAt(2).setIcon(tabIcons[2]);
//
//
//
//
//
//    }

    private void AnhXa() {

//        tabLayoutMain = findViewById(R.id.tabLayoutMain);
//        viewPagerMain = findViewById(R.id.viewpapperpMain);
//        tabTraining = findViewById(R.id.tabTraining);
//        tabReport = findViewById(R.id.tabReport);
//        tabMe = findViewById(R.id.tabMe);
//        lvMain = findViewById(R.id.lvButton1);

        BottomNavigationView bottomNavigationView = findViewById( R.id.navigation );
        bottomNavigationView.setOnNavigationItemReselectedListener( mOnNavigationItemSelectedListener );

    }

   private BottomNavigationView.OnNavigationItemReselectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemReselectedListener() {

       @Override
       public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
           Fragment fragment;
           switch (menuItem.getItemId()){
               case R.id.navigation_training:
                   fragment = new TrainingFragment();
                   loadFragment( fragment );
                  break;
               case R.id.navigation_report:
                   fragment = new ReportFragment();
                   loadFragment( fragment );
                   break;
               case R.id.navigation_me:
                   fragment = new MeFragment();
                   loadFragment( fragment );
                   break;
           }
       }
   };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
  }
