package innoviz.niec.com.musicui.Adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import innoviz.niec.com.musicui.R;
import innoviz.niec.com.musicui.SongInfo;

/**
 * Created by PROPHET on 28-08-2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public RecyclerAdapter(ArrayList<SongInfo> mDataSet) {
        this.mDataSet = mDataSet;
    }

    private ArrayList<SongInfo> mDataSet;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.song,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final SongInfo title=mDataSet.get(position);
        holder.textSongs.setText(title.getTitle());
        holder.textSongs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            remove(position);
            }
        });
        holder.textArtist.setText("BY "+title.getArtist());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView textSongs,textArtist;

       public ViewHolder(View v){
           super(v);
           textSongs=(TextView)v.findViewById(R.id.song);
           textArtist=(TextView)v.findViewById(R.id.artist);
       }

    }
    public void add(int position ,SongInfo item){
        mDataSet.add(position,item);
        notifyItemInserted(position);
    }
    public  void  remove(int position)    {
        mDataSet.remove(position);

        notifyItemRemoved(position);

    }
}
