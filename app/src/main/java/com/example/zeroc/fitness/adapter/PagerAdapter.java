package com.example.zeroc.fitness.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.zeroc.fitness.fragment.MeFragment;
import com.example.zeroc.fitness.fragment.ReportFragment;
import com.example.zeroc.fitness.fragment.TrainingFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {



    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int positions) {

        switch (positions) {
            case 0:
                return new TrainingFragment();
            case 1:
                return new ReportFragment();
            case 2:
                return new MeFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position){
        String title = "";
        switch (position){
            case 0:
                title = "Training";
                break;
            case 1:
                title = "Report";
                break;
            case 2:
                title = "ME";
                break;
        }
        return title;
    }
    @Override
    public int getCount() {
        return 3;

    }
    public void setUpTabIcon(){

    }

}
