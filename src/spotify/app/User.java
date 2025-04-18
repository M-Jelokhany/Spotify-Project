package spotify.app;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList;
    private ArrayList<User> followingList;
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists;
    private static ArrayList<User> allUsers = new ArrayList<>();

    public User(String username , String password){
        for(User user : allUsers){
            if(user.username.equals(username)){
                throw new InvalidOperationException("Username already exist");
            }
        }

        if(password.length() < 8){
            throw new InvalidOperationException("Password size must be more than 7 character");
        }

        this.username = username;
        this.password = password;
        this.behavior = new RegularBehavior();
        this.followerList = new ArrayList<>();
        this.followingList = new ArrayList<>();
        this.playlists = new ArrayList<>();
        allUsers.add(this);
    }

    public void follow (User user){
        this.followingList.add(user);
        user.followerList.add(this);
    }

    public void createPlaylist (String title){
        this.behavior.createPlaylist(title, this);
    }

    public void playMusic (Music music){
        this.behavior.playMusic(music);
    }

    public void buyPremium (int month){
        this.behavior.buyPremium(this , month);
    }

    public UserBehavior getBehavior(){
        return this.behavior;
    }

    public void setBehavior(UserBehavior behavior){
        this.behavior = behavior;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public ArrayList<Playlist> getPlaylists(){
        return this.playlists;
    }

    public ArrayList<User> getFollowerList(){
        return followerList;
    }

    public ArrayList<User> getFollowingList(){
        return followingList;
    }
}
