package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sg.edu.tp.movietix.util.AppUtil;

public class SoundTrackMenu extends AppCompatActivity {

    private SongCollection songCollection = new SongCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_track_menu);
    }

    public void bringupsongs (View view){
        String resourceId = AppUtil.getResourceId(this, view);
        Song selectedsong = songCollection.searchById(resourceId);
        AppUtil.popMessage(this ,"Streaming song " + selectedsong.getTitle());
        sendDataToActivity(selectedsong);
    }

    public void sendDataToActivity(Song song){
        Intent intent = new Intent(this, SoundPlayer.class);
        intent.putExtra("id", song.getId());
        intent.putExtra("title", song.getTitle());
        intent.putExtra("artiste", song.getArtiste());
        intent.putExtra("fileLink", song.getFileLink());
        intent.putExtra("coverArt", song.getCoverArt());

        startActivity(intent);
    }

}
