package spotify.app;
import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream;
    static ArrayList<Music> allMusics = new ArrayList<>();

    public Music(String title , User singer){
        this.title = title;
        this.singer = singer;
        numberOfStream = 0;
        allMusics.add(this);
    }

    public void play(){
        numberOfStream += 1;
        System.out.println("Music with title \"" + this.title + "\" and singer \"" + this.singer.getUsername() + "\" is playing");
    }

    public static ArrayList<Music> Search(String title){
        ArrayList<Music> musics = new ArrayList<>();
        for(Music music : allMusics){
            if(music.title.equals(title)){
                musics.add(music);
            }
        }

        if(musics.isEmpty()){
            return null;
        }

        return musics;
    }

    public static Music Search(String title , String signerUsername){
        for(Music music : allMusics){
            if((music.title.equals(title)) && (music.singer.getUsername().equals(signerUsername))){
                return music;
            }
        }

        return null;
    }

    public String getTitle(){
        return this.title;
    }

    public User getSinger(){
        return this.singer;
    }
}
