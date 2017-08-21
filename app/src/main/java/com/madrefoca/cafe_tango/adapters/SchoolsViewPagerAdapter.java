package com.madrefoca.cafe_tango.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.madrefoca.cafe_tango.fragments.GenericSchoolTab;
import com.madrefoca.cafe_tango.fragments.SchoolTab1;
import com.madrefoca.cafe_tango.fragments.SchoolTab2;
import com.madrefoca.cafe_tango.fragments.SchoolTab3;

/**
 * Created by Fernando on 8/6/2017.
 */

public class SchoolsViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence titles[]; // This will Store the Titles of the Tabs which are Going to be passed when SchoolsViewPagerAdapter is created
    int numbOfTabs; // Store the number of tabs, this will also be passed when the SchoolsViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public SchoolsViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int numberOfTabs) {
        super(fm);

        this.titles = mTitles;
        this.numbOfTabs = numberOfTabs;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if (position == 0) // if the position is 0 we are returning the First tab
        {
            SchoolTab1 tab1 = new SchoolTab1();
            return tab1;
        } else if (position == 1) {
            SchoolTab2 tab2 = new SchoolTab2();
            return tab2;
        } else if (position == 2) {
            SchoolTab3 tab3 = new SchoolTab3();
            return tab3;
        } else {
            GenericSchoolTab genericSchoolTab = new GenericSchoolTab();
            return genericSchoolTab;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return numbOfTabs;
    }
}
