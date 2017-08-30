package com.madrefoca.cafe_tango.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.madrefoca.cafe_tango.adapters.SchoolsViewPagerAdapter;

import com.madrefoca.cafe_tango.R;
import com.madrefoca.cafe_tango.model.SchoolHouse;

import java.util.ArrayList;

public class SchoolsActivity extends AppCompatActivity {

    //Initializing the views and variables
    ViewPager viewPager;
    SchoolsViewPagerAdapter pagerAdapter;
    CharSequence[] titles;
    int numboftabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schools);

        // Receiving the Data
        Intent i = getIntent();

        Bundle bundle = getIntent().getExtras();
        ArrayList<SchoolHouse> schoolHousearraylist = bundle.getParcelableArrayList("schoolHouseList");

        this.getTitlesFromSchoolHouseList(schoolHousearraylist);

        numboftabs = schoolHousearraylist.size();

        // Creating The SchoolsViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        pagerAdapter = new SchoolsViewPagerAdapter(getSupportFragmentManager(), titles, numboftabs);

        // Assigning ViewPager View and setting the adapter
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
     private void getTitlesFromSchoolHouseList( ArrayList<SchoolHouse> schoolHouseArraylist) {
         int i = 0;
         titles = new String[schoolHouseArraylist.size()];
         for(SchoolHouse schoolHouse : schoolHouseArraylist){
             titles[i] = schoolHouse.getSchoolName();
             i++;
         }
     }
}
