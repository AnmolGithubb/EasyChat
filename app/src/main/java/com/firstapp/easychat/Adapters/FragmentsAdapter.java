package com.firstapp.easychat.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.firstapp.easychat.Fragments.ChatsFragment;

public class FragmentsAdapter extends FragmentPagerAdapter {


    public FragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new ChatsFragment();
            default: return  new ChatsFragment();
        }

    }

    @Override
    public int getCount() {
        return 1;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0) {
            title = "CHATS";
            return title;

        }

        return title;
    }
}
