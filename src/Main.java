import spotify.app.Music;
import spotify.app.User;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            User amir = new User("amir", "12345678");
            User amir1 = new User("amir" , "135792468");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println();
        }

        try{
            User ali = new User("ali" , "1234567");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        User farhad = new User("farhad" , "12345678");
        User hasan = new User("hasan" , "135792468");
        User ali = new User("ali" , "19283746");

        farhad.follow(hasan);

        System.out.println("farhad following : " + farhad.getFollowingList().getFirst().getUsername());
        System.out.println("hasan follow by : " + hasan.getFollowerList().getFirst().getUsername());
        System.out.println();

        try{
            farhad.createPlaylist("best playlist");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println();
        }

        farhad.buyPremium(3);
        farhad.createPlaylist("best playlist");

        Music music1 = new Music("salam" , hasan);
        farhad.playMusic(music1);
        System.out.println();

        Music music2 = new Music("salam" , ali);

        ArrayList<Music> musics = Music.Search("salam");
        Music music3 = Music.Search("salam" , "hasan");

        assert musics != null;
        assert music3 != null;
        System.out.println("Music singer : " + musics.getFirst().getSinger().getUsername());
        System.out.println("Music singer : " + musics.get(1).getSinger().getUsername());
        System.out.println("Music singer : " + music3.getSinger().getUsername());
        System.out.println();

        System.out.println("Farhad playlist name : " + farhad.getPlaylists().getFirst().getTitle());
        System.out.println();

        farhad.getPlaylists().getFirst().editTitle("12345678","best playlist in the world");

        System.out.println("New farhad playlist name : " + farhad.getPlaylists().getFirst().getTitle());
        System.out.println();

        farhad.getPlaylists().getFirst().addMusic("12345678" , music2);

        System.out.println("Music name : " + farhad.getPlaylists().getFirst().Search("salam" , "ali").getSinger().getUsername());
        System.out.println();

        farhad.getPlaylists().getFirst().removeMusic("12345678" , music2);
        Music music4 = farhad.getPlaylists().getFirst().Search("salam" , "ali");
        if(music4 == null){
            System.out.println("Music with title \"salam\" and singer \"ali\" is not found ");
        }


    }
}