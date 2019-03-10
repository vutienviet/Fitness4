package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.MeFragment;
import fragment.ReportFragment;
import fragment.TrainingFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int positions) {
        Fragment fragment = null;
        switch (positions){
            case 0:
                fragment = new TrainingFragment();
                break;
            case 1:
                fragment = new ReportFragment();
                break;
            case 2:
                fragment = new MeFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;

    }

    @Override
    public  CharSequence getPageTitle(int positions){
        String tittle  = "";
        switch (positions){
            case 0:
                tittle = "Training";
                break;
            case 1:
                tittle = "Report";
                break;
            case 2:
                tittle = "Me";
                break;
        }
        return tittle;
    }
}
