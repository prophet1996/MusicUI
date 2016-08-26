package innoviz.niec.com.musicui.AppFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import innoviz.niec.com.musicui.R;

/**
 * Created by PROPHET on 25-08-2016.
 */
public class AllSongsFrag extends Fragment{

public AllSongsFrag(){}
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState ){
        View v=inflater.inflate(R.layout.all_songs_frag,container,false);
        return v;
    }

}
