package spotify.app;
import java.util.ArrayList;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist;
    private User owner;

    public Playlist(String title , User owner){
        playlist = new ArrayList<>();
        this.title = title;
        this.owner = owner;
    }

    public void editTitle(String password , String newTitle){
        if(!password.equals(this.owner.getPassword())){
            throw new InvalidOperationException("Password is invalid");
        }

        this.title = newTitle;
    }

    public void addMusic(String password , Music music){
        if(!password.equals(this.owner.getPassword())){
            throw new InvalidOperationException("Password is invalid");
        }

        for(Music oldMusic : playlist){
            if((oldMusic.getTitle().equals(music.getTitle())) && (oldMusic.getSinger().getUsername().equals(music.getSinger().getUsername())) ){
                throw new InvalidOperationException("The music is repetitive");
            }
        }

        playlist.add(music);
    }

    public void removeMusic(String password , Music music){
        if(!password.equals(this.owner.getPassword())){
            throw new InvalidOperationException("Password is invalid");
        }

        boolean notFound = true;
        for(Music oldMusic : playlist){
            if((oldMusic.getTitle().equals(music.getTitle())) && (oldMusic.getSinger().getUsername().equals(music.getSinger().getUsername())) ){
                playlist.remove(oldMusic);
                notFound = false;
                break;
            }
        }

        if(notFound){
            throw new InvalidOperationException("This music is not found");
        }

    }

    public ArrayList<Music> Search(String title){
        ArrayList<Music> musics = new ArrayList<>();
        for(Music music : playlist){
            if(music.getTitle().equals(title)){
                musics.add(music);
            }
        }

        if(musics.isEmpty()){
            return null;
        }

        return musics;
    }

    public Music Search(String title , String signerUsername){
        for(Music music : playlist){
            if((music.getTitle().equals(title)) && (music.getSinger().getUsername().equals(signerUsername))){
                return music;
            }
        }

        return null;
    }

    public void playPlaylist(){
        for(Music music : playlist){
            music.play();
        }
    }

    public ArrayList<Music> getPlaylist(){
        return playlist;
    }

    public User getOwner(){
        return owner;
    }

    public String getTitle(){
        return title;
    }
}
