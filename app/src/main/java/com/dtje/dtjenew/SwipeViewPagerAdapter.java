package com.dtje.dtjenew;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by User on 6/13/2015.
 */
public class SwipeViewPagerAdapter extends FragmentPagerAdapter {

    public SwipeViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0:
                return new RandomFragment();
            case 1:
                return new VoteFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

}
