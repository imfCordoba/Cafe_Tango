package com.madrefoca.cafe_tango.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.madrefoca.cafe_tango.adapters.SchoolsViewPagerAdapter;

import com.madrefoca.cafe_tango.R;

public class SchoolsActivity extends AppCompatActivity {

    //Initializing the views and variables
    ViewPager viewPager;
    SchoolsViewPagerAdapter pagerAdapter;
    CharSequence titles[] = {"Escuela 1", "Escuela 2", "Escuela 3"};
    int numboftabs = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);

        Intent i = getIntent();
        // Receiving the Data
        String illnessName = i.getStringExtra("IllnessName");



        // Creating The SchoolsViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        pagerAdapter = new SchoolsViewPagerAdapter(getSupportFragmentManager(), titles, numboftabs);

        // Assigning ViewPager View and setting the adapter
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
