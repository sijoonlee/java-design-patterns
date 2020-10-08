
Target: MediaPlayer
    defines the domain-specific interface that Client uses

Client: mp4, vlc
    mp4, vlc are incompatible with MediaPlayer interface
    collaborates with objects(AdvancedMediaPlayerAdapter) conforming to the Target interface(MediaPlayerInterface)

Adaptee: AdvancedMediaPlayer
    defines an existing interface that needs adapting
    
------------------------------------------------------------
interface MediaPlayerInterface {
    public void play(String audioType, String fileName);
}

class AudioPlayer implements MediaPlayerInterface {
    @Override
    public void play(String audioType, String filename)
    {
        if(audioType.equalsIgnoreCase("mp3")){
            System.out.println("Playing mp3 file. Name: " + filename);
        }
        else{
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

-----------------------------------------------------------

public class AdvancedMediaPlayerAdapter implements MediaPlayerInterface {
    AdvancedMediaPlayerInterface advancedMusicPlayer;

    public AdvancedMediaPlayerAdapter(AdvancedMediaPlayerInterface myMediaPlayer) {
        advancedMusicPlayer = myMediaPlayer;
    }

    @Override
    public void play(String audioType, String filename) {
        advancedMusicPlayer.loadFilename(filename);
        advancedMusicPlayer.listen();
    }
}

------------------------------------------------------------

interface AdvancedMediaPlayerInterface {
    public void loadFilename(String fileName);
    public void listen();
}

class VlcPlayer implements AdvancedMediaPlayerInterface{
    String myFile;

    @Override
    public void loadFilename(String filename) {
        myFile = filename;
    }

    @Override
    public void listen() {
        System.out.println("Playing vlc file.  Name: " + myFile);
    }
}

class Mp4Player implements AdvancedMediaPlayerInterface{
    String myFile;

    @Override
    public void loadFilename(String filename) {
        myFile = filename;
    }

    @Override
    public void listen() {
        System.out.println("Playing mp4 file.  Name: " + myFile);
    }
}

------------------------------------------------------------

public class Client {

    public static void main(String[] args) {

        MediaPlayerInterface audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "jasonsMusic.mp3");

        AdvancedMediaPlayerInterface mp4Player = new Mp4Player();
        MediaPlayerInterface advancedMediaPlayerAdapter1 = new AdvancedMediaPlayerAdapter(mp4Player);
        advancedMediaPlayerAdapter1.play("mp4", "alone.mp4");

        AdvancedMediaPlayerInterface vlcPlayer = new VlcPlayer();
        MediaPlayerInterface advancedMediaPlayerAdapter2 = new AdvancedMediaPlayerAdapter(vlcPlayer);
        advancedMediaPlayerAdapter2.play("vlc", "far far away.vlc");


        audioPlayer.play("vlc", "far far away.vlc");

    }
}
