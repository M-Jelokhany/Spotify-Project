package spotify.app;

public class PremiumBehavior implements UserBehavior{
    private int month;

    public PremiumBehavior(int month){
        if(month <= 0 ){
            throw new InvalidOperationException("Invalid month");
        }

        this.month = month;
    }

    @Override
    public void createPlaylist(String Title, User Owner) {
        Playlist playlist = new Playlist(Title , Owner);
        Owner.getPlaylists().add(playlist);
    }

    @Override
    public void playMusic(Music music) {
        music.play();
    }

    @Override
    public void buyPremium(User owner, int month) {
        if(month <= 0){
            throw new InvalidOperationException("Invalid month");
        }

        ((PremiumBehavior) owner.getBehavior()).month += month;
    }
}
