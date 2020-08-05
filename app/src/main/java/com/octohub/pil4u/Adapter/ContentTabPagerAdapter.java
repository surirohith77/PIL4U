package com.octohub.pil4u.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

/***
 ** Designed and developed by Rohith suri 20th june 2019
 */

public class ContentTabPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> tabFragments;
    private List<String> tabNames;

    public ContentTabPagerAdapter(FragmentManager manager, List<Fragment> tabFragments, List<String> tabNames){
        super(manager);
        this.tabFragments = tabFragments;
        this.tabNames = tabNames;
    }

    @Override
    public Fragment getItem(int position) {
        return tabFragments.get(position);
    }

    @Override
    public int getCount() {
        return tabNames.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames.get(position);
    }
}
