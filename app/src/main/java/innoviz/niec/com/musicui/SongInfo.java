package innoviz.niec.com.musicui;

import android.util.Log;

/**
 * Created by PROPHET on 04-09-2016.
 */
public class SongInfo {
    String title,artist;
    long id;

    public SongInfo() {
        title="";
        id=-1;
        artist="";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SongInfo(String title, String artist, long id) {
        this.title = title;
        this.artist = artist;
        this.id = id;
        Log.d("SONGINFO","song made");
    }
}
