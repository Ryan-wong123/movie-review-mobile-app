package sg.edu.tp.movietix;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import sg.edu.tp.movietix.util.AppUtil;

public class SoundPlayer extends AppCompatActivity {

    private static final String BASE_URL = "https://p.scdn.co/mp3-preview/";

    private String songId = "";
    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    private String coverArt = "";
    private String url = "";

    private MediaPlayer player = null;
    private int musicPosition = 0;
    private Button btnPlayPause = null;

    private SongCollection songCollection = new SongCollection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_player);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        retrieveData();
        displaySong(title, artiste, coverArt);
    }


    public void playOrPauseMusic (View view){
        if (player == null){
            preparePlayer();
        }

        if (!player.isPlaying()){
            if (musicPosition >0){
                player.seekTo(musicPosition);
            }
            player.start();
            btnPlayPause.setText("Pause");

            setTitle("Now Playing: " + title + " - " + artiste);
            gracefullyStopWhenMusicEnds();
        }
        else{
            pauseMusic();
        }
    }

    private void gracefullyStopWhenMusicEnds(){
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                boolean hasNextMusic = prepareNextSong();
                //If there is still a player and there is  a next song
                if (player != null){
                    btnPlayPause.setText("Play");
                    musicPosition = 0;
                    setTitle("");
                    player.stop();
                    player.release();
                    player = null;
                }
                //If there is not a next music to play
                if (!hasNextMusic){
                    //Get the first song
                    Song startsong = songCollection.getSongByIndex(0);
                    //Assign the ID, file link, etc.
                    songId = startsong.getId();
                    title = startsong.getTitle();
                    artiste = startsong.getArtiste();
                    fileLink = startsong.getFileLink();
                    coverArt = startsong.getCoverArt();

                    url = BASE_URL + fileLink;
                    displaySong(title, artiste, coverArt);
                    stopActivties();
                }

                //Play the music.
                preparePlayer();
                if (musicPosition >0){
                    player.seekTo(musicPosition);

                }
                player.start();
                btnPlayPause.setText("Pause");

                setTitle("Now Playing: " + title + " - " + artiste);

                gracefullyStopWhenMusicEnds();
            }
        });
    }


    //pausing music
    private void stopActivties(){
        if (player != null){
            btnPlayPause.setText("PLAY");
            musicPosition = 0;
            setTitle("");
            player.stop();
            player.release();
            player = null;
        }
    }

    //Prepares the next song, returns true if the music has been successfully prepared
    private Boolean prepareNextSong(){
        Song nextSong = songCollection.getNextSong(songId);
        boolean prepareSuccess = (nextSong != null);
        //If it was successful at getting the next song
        if (prepareSuccess) {
            songId = nextSong.getId();
            title = nextSong.getTitle();
            artiste = nextSong.getArtiste();
            fileLink = nextSong.getFileLink();
            coverArt = nextSong.getCoverArt();


            url = BASE_URL + fileLink;
            displaySong(title, artiste, coverArt);
            stopActivties();

        }
        return prepareSuccess;
    }

    //play next song
    public void playNext(View view){
        //Prepare the next song and check if its successful at doing so
        if (prepareNextSong()) {
            //Play next song if its successful at preparing the next song
            playOrPauseMusic(view);
        }
    }

    //play previous song
    public void playPrevious(View view){

        Song prevSong = songCollection.getPrevSong(songId);
        if (prevSong != null){
            songId = prevSong.getId();
            title = prevSong.getTitle();
            artiste = prevSong.getArtiste();
            fileLink = prevSong.getFileLink();
            coverArt = prevSong.getCoverArt();


            url = BASE_URL + fileLink;
            displaySong(title, artiste, coverArt);
            stopActivties();
            playOrPauseMusic(view);
        }
    }

    //pause the music
    private void pauseMusic(){
        player.pause();
        musicPosition = player.getCurrentPosition();
        btnPlayPause.setText("Play");
    }

    //preparing the player to play music
    private void preparePlayer(){
        player = new MediaPlayer();

        try{
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource(url);
            player.prepare();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    //displaying data onto player screen
    private void displaySong(String title, String artiste, String coverArt){
      //getting title name
        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);

        //getting artiste name
        TextView txtArtiste = findViewById(R.id.txtArtiste);
        txtArtiste.setText(artiste);

        //getting image
        int imageId = AppUtil.getImageIdFromDrawable(this, coverArt);
        ImageView imageCoverArt = findViewById(R.id.imgCoverArt);
        imageCoverArt.setImageResource(imageId);
    }

    //getting song information
    private void retrieveData(){
        Bundle songData = this.getIntent().getExtras();
        songId = songData.getString("id");
        title = songData.getString("title");
        artiste = songData.getString("artiste");
        fileLink = songData.getString("fileLink");
        coverArt = songData.getString("coverArt");

        url = BASE_URL + fileLink;

    }
}
