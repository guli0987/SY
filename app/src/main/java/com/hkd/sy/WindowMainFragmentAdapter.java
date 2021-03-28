package com.hkd.sy;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.hkd.sy.WindowFragment.DetailsFragment;
import com.hkd.sy.WindowFragment.EvaluationFragment;
import com.hkd.sy.WindowFragment.OrderDishesFragment;

public class WindowMainFragmentAdapter extends FragmentPagerAdapter {
    public WindowMainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment=new OrderDishesFragment();
                break;
            case 1:
                fragment=new DetailsFragment();
                break;
            case 2:
                fragment=new EvaluationFragment();
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
