package com.madrefoca.cafe_tango.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.madrefoca.cafe_tango.R;
import com.madrefoca.cafe_tango.adapters.PhasesViewPagerAdapter;

public class PhasesActivity extends AppCompatActivity {

    //Initializing the views and variables
    ViewPager viewPager;
    PhasesViewPagerAdapter phasesPagerAdapter;
    CharSequence titles[] = {"fase 1", "Fase 2", "Fase 3"};
    int numboftabs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phases);

        // Creating The SchoolsViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        phasesPagerAdapter = new PhasesViewPagerAdapter(getSupportFragmentManager(), titles, numboftabs);
        // Assigning ViewPager View and setting the adapter
        viewPager = (ViewPager) findViewById(R.id.viewPagerPhases);
        viewPager.setAdapter(phasesPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayoutPhases);
        tabLayout.setupWithViewPager(viewPager);
    }
}
