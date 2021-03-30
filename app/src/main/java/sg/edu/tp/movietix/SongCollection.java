package sg.edu.tp.movietix;

public class SongCollection {

    private Song[] songs = new Song[3];

    public SongCollection(){
        prepareSongs();
    }


    public Song getSongByIndex (int index){

        Song song =  null;

        if (index >= 0 && index < songs.length){
            song = songs[index];
        }
        return song;

    }

    //getter for previous song
    public Song getPrevSong (String currentSongId){

        Song song =  null;

        for (int index = 0; index < songs.length; index++){
            String tempSongId = songs[index].getId();
            if (tempSongId.equals(currentSongId) && (index > 0)){
                song = songs[index - 1];
                break;
            }
        }
        return song;

    }

    //getter for next song
    public Song getNextSong(String currentSongId){
        Song song =  null;

        for (int index = 0; index < songs.length; index++){
            String tempSongId = songs[index].getId();
            if (tempSongId.equals(currentSongId) && (index < songs.length - 1)){
                song = songs[index + 1];
                break;
            }
        }
        return song;
    }

    // searching for id of song
    public Song searchById(String id){
        //create temporary song object
        Song song = null;

        for (int index=0; index < songs.length; index++ ){
            song = songs[index];
            if (song.getId().equals(id)){
                return song;
            }
        }
        return song;
    }

    //song data
    private void prepareSongs (){
        Song WakandaOrigins = new Song(
                "songpic1", "Wakanda Origins","Ludwig Göransson",
                "b4260b40f2a8c4426bf371a88509234901b085b8?cid=2afe87a64b0042dabf51f37318616965",
                4.66,"blackpanther");

        Song WhenCanISeeYouAgain = new Song(
                "songpic2", "When Can I See You Again","Owl City",
                "30997eb73792afc37d6a0c42a05e47d7b0d8dca9?cid=2afe87a64b0042dabf51f37318616965",
                4.36,"antman");

        Song IllCallHimAntony = new Song(
                "songpic3", "I'll Call Him Antony", " Christophe Beck",
                "369a96098cbef942f4ce2cbfe6ad2ef47f77786f?cid=2afe87a64b0042dabf51f37318616965",
                3.14,"wreckitralph");

        songs[0] = WakandaOrigins;
        songs[1] = WhenCanISeeYouAgain;
        songs[2] = IllCallHimAntony;

    }

}
