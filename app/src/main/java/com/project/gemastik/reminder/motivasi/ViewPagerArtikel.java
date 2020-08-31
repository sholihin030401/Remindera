package com.project.gemastik.reminder.motivasi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerArtikel extends FragmentStatePagerAdapter {

    private final List<Fragment> fraglist = new ArrayList<>();
    private final List<String> fragTitle = new ArrayList<>();

    public ViewPagerArtikel(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fraglist.get(position);
    }

    @Override
    public int getCount() {
        return fraglist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragTitle.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        fraglist.add(fragment);
        fragTitle.add(title);
    }
}
