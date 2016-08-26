package innoviz.niec.com.musicui.AppFragments;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import innoviz.niec.com.musicui.R;

/**
 * Created by PROPHET on 25-08-2016.
 */
public class ListenNowFrag extends android.support.v4.app.Fragment {


    private ViewPager mViewPager;
    private ListenPagerAdapter mListenPagerAdapter;
    private TabLayout mTablayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listen_now_frag, container, false);

        mListenPagerAdapter = new ListenPagerAdapter(getActivity().getSupportFragmentManager());
        final ActionBar actionBar = getActivity().getActionBar();
        mViewPager = (ViewPager) v.findViewById(R.id.view_pager);
        mViewPager.setAdapter(mListenPagerAdapter);
        mTablayout=(TabLayout)v.findViewById(R.id.tabs);
        mTablayout.setupWithViewPager(mViewPager);

        return v;
    }

    public class ListenPagerAdapter extends FragmentStatePagerAdapter    {
        public ListenPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    AllSongsFrag fg = new AllSongsFrag();
                    Log.d("AllSongs","fg1");
                    return fg;

                case 1:
                    AllSongsFrag fg1 = new AllSongsFrag();
                    Log.d("AllSongs","fg2");
                    return fg1;


                case 2:
                    AllSongsFrag fg2 = new AllSongsFrag();
                    Log.d("AllSongs","fg3");
                    return fg2;



            }return null;

        }

        @Override
        public int getCount() {
            return 3;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

}
