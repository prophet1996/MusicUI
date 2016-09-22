package innoviz.niec.com.musicui.AppFragments;

import android.app.ActionBar;
import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import innoviz.niec.com.musicui.R;

/**
 * Created by PROPHET on 25-08-2016.
 */
public class ListenNowFrag extends android.support.v4.app.Fragment {


    private static final String IMAGEVIEW_TAG = "icon bitmap";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if(savedInstanceState!=null||container==null) {
            return null;
        }
        View v = inflater.inflate(R.layout.listen_now_frag, container, false);
        final ViewPager mViewPager;
        ListenPagerAdapter mListenPagerAdapter;
        final TabLayout mTablayout;

        mListenPagerAdapter = new ListenPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager = (ViewPager) v.findViewById(R.id.view_pager);
        mViewPager.setAdapter(mListenPagerAdapter);
        mTablayout=(TabLayout)v.findViewById(R.id.tabs);
        mTablayout.post(new Runnable() {
            @Override
            public void run() {
                mTablayout.setupWithViewPager(mViewPager);
            }
        });
        FloatingActionButton fab=(FloatingActionButton) v.findViewById(R.id.fab);
        fab.setTag(IMAGEVIEW_TAG);
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
              //  ClipData.Item item = new ClipData.Item(v.getTag());
               // ClipData dragData = new ClipData(v.getTag(),ClipData.MIMETYPE_TEXT_PLAIN,item);
            return  true;
            }
        });
        fab.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                Toast.makeText(getActivity(), "dragged", Toast.LENGTH_SHORT).show();
                Log.d("drag","drag");
                return true;
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return v;
    }

    public class ListenPagerAdapter extends FragmentPagerAdapter    {
        public ListenPagerAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:

                    Log.d("AllSongs","fg1");
                    return new AllSongsFrag();

                case 1:

                    Log.d("AllSongs","fg2");
                    return new AllSongsFrag();


                case 2:

                    Log.d("AllSongs","fg3");
                    return new AllSongsFrag();



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
