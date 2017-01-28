package structural_design_patterns.adapter_pattern;

/**
 * Created by ashwin on 24/1/17.
 */

public class AdapterPattern
{
    public static void main(String[] args)
    {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}

interface MediaPlayer
{
    public void play(String audioType, String filename);
}

interface AdvancedMediaPlayer
{
    public void playVlc(String filename);
    public void playMp4(String filename);
}

class VlcPlayer implements AdvancedMediaPlayer
{
    @Override
    public void playVlc(String fileName)
    {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName)
    {
        //do nothing
    }
}

class Mp4Player implements AdvancedMediaPlayer
{
    @Override
    public void playVlc(String fileName)
    {
        //do nothing
    }

    @Override
    public void playMp4(String fileName)
    {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}

// Adapter allows MediaPlayer
class MediaAdapter implements MediaPlayer
{
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType)
    {
        if(audioType.equalsIgnoreCase("vlc") )
        {
            advancedMusicPlayer = new VlcPlayer();
        }
        else if (audioType.equalsIgnoreCase("mp4"))
        {
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName)
    {
        if(audioType.equalsIgnoreCase("vlc"))
        {
            advancedMusicPlayer.playVlc(fileName);
        }
        else if(audioType.equalsIgnoreCase("mp4"))
        {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}

// Adapter
class AudioPlayer implements MediaPlayer
{
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName)
    {
        //inbuilt support to play mp3 music files
        if(audioType.equalsIgnoreCase("mp3"))
        {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        // MediaAdapter is providing MediaPlayer support to play AdvancedMediaPlayer file formats
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4"))
        {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else
        {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}