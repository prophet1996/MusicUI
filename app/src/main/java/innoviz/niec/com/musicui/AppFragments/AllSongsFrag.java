package innoviz.niec.com.musicui.AppFragments;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import innoviz.niec.com.musicui.Adapter.RecyclerAdapter;
import innoviz.niec.com.musicui.R;
import innoviz.niec.com.musicui.SongInfo;

/**
 * Created by PROPHET on 25-08-2016.
 */
public class AllSongsFrag extends Fragment {

    private Button b1;
    private ArrayList<SongInfo> mDataSet = new ArrayList<SongInfo>();

    public AllSongsFrag() {
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (savedInstanceState != null||container==null) {
            return null;
        }
        View v = inflater.inflate(R.layout.all_songs_frag, container, false);
        ContentResolver cr = getActivity().getContentResolver();
        Uri musicUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = cr.query(musicUri, null, null, null, null);
        if (musicCursor != null && musicCursor.moveToFirst()) {
            int titleColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media._ID);
            int artistColumnn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);

            do {
                long id = musicCursor.getLong(idColumn);
                String artist = musicCursor.getString(artistColumnn);
                String title = musicCursor.getString(titleColumn);
                mDataSet.add(new SongInfo(title, artist, id));

            } while (musicCursor.moveToNext());
        }


        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new RecyclerAdapter(mDataSet);
        mRecyclerView.setAdapter(mAdapter);
        Thread ST = new Thread(new SongList());
        ST.start();

        b1 = (Button) v.findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cx = v.getHeight();
                int cy = v.getWidth();

                float finalrad = (float) Math.hypot(cx, cy);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Animator anim = ViewAnimationUtils.createCircularReveal(v, cx, cy, finalrad, 0);
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {

                            b1.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                }


            }
        });
        return v;
    }

    private class SongList implements Runnable {

        @Override
        public void run() {

        }
    }

}
