package spotify.app;

public class RegularBehavior implements UserBehavior{
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String Title, User Owner){
        throw new InvalidOperationException("Regular user can not create playlist");
    }

    @Override
    public void playMusic(Music music){
        if(playingLimit <= 0){
            throw new InvalidOperationException("Sorry , your playing limit is reached");
        }

        music.play();
        playingLimit -= 1;
    }

    @Override
    public void buyPremium(User owner, int month){
        owner.setBehavior(new PremiumBehavior(month));
    }
}

