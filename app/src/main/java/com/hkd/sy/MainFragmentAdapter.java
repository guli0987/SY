package com.hkd.sy;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainFragmentAdapter extends FragmentPagerAdapter {
    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment=new IndexFragment();
                break;
            case 1:
                fragment=new OrderFragment();
                break;
            case 2:
                //fragment=new OrderFragment();
                fragment=new MyselfFragment();
                break;
            default:
                break;
        }
        return fragment;

    }

    @Override
    public int getCount() {
        return 3;
    }
}
