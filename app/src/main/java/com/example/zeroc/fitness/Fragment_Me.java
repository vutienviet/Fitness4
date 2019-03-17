package com.example.zeroc.fitness;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import java.util.Locale;

public class Fragment_Me extends PreferenceFragment implements Preference.OnPreferenceClickListener {

    final static int DEFAULT_GOAL = 10000;
    final static float DEFAULT_STEP_SIZE = Locale.getDefault() == Locale.US ? 2.5f : 75f;
    final static String DEFAULT_STEP_UNIT = Locale.getDefault() == Locale.US ? "ft" : "cm";

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        return false;
    }
}