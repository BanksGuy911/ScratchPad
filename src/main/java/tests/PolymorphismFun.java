package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

public class PolymorphismFun {
    // TODO: Define a class for MusicPlayer.
    // It should encapsulate its attributes and provide methods for
    // - adding tracks to the library
    // - playing the current track
    // - stopping music
    // - changing the current track (the new track is provided by the name)
    // - retrieving the list of tracks

    public static void main(String[] args) {
        // TODO: Create an instance of your MusicPlayer.
        BossMusicPlayer bossness = new BossMusicPlayer();

        // TODO: Demonstrate how your music player can add tracks, change to a specific track, then play music, and finally print the list of all tracks.
        Random rand = new Random();
        for(int i =0; i < 20; i++){
            int randomInt = rand.nextInt();
            if(randomInt % 2 == 0 )
                bossness.addTrack(new MP3Track(String.valueOf(i)));
            else 
                bossness.addTrack(new WAVTrack(String.valueOf(i)));
        }
        
        try {
            bossness.playTrack("1");
            bossness.stopMusic();
            bossness.playTrack("4");
            bossness.playTrack("7");
            bossness.printTracks();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } 
        System.out.println("Player as Json: " + bossness.toJson());
    }

    // TODO: Remember to explain your OOP design choice in the comments.
    /*
        The code speaks for itself. 
    */ 
}


abstract class AudioTrack {
	
    protected String name;
    
    public AudioTrack(String name){
        this.name = name;
    }
    public abstract void play();
    public abstract void stop();
    public void setName(String name){
        this.name = name; 
    }
    public String getName(){
        return name;
    }
    
    public String toJson() {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			return mapper.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
    	}
    }
}

class MP3Track extends AudioTrack {
    
    public MP3Track(String name){
        super(name);
    }

    @Override
    public void play(){
        System.out.println("Playing MP3 track: " + name);
    }
    @Override
    public void stop(){
        System.out.println("Stopping MP3 track: " + name);
    }
}

class WAVTrack extends AudioTrack {
    
    public WAVTrack(String name){
        super(name);
    }
    
    @Override
    public void play(){
        System.out.println("Playing WAV track: " + name);
    }
    
    @Override
    public void stop() {
        System.out.println("Stopping WAV track: " + name);
    }
}

interface MusicPlayer {
    public void addTrack(AudioTrack track);
    public void playTrack(String trackName) throws Exception;
    public void stopMusic();
    public void printTracks();
    public boolean playing();
}

class BossMusicPlayer implements MusicPlayer{
	
    private AudioTrack currentTrack;
    private HashMap<String, AudioTrack> tracks;
    private boolean playing;
    
    public BossMusicPlayer(){
        tracks = new HashMap<>(10);
        playing = false;
    }
    
    public void addTrack(AudioTrack track){
            tracks.putIfAbsent(track.getName(), track);
    }
    
    public void playTrack(String trackName) throws Exception {
        if(!tracks.containsKey(trackName))
            throw new Exception("Track is not present in the list of tracks. Please add first before playing");
        if(playing)
            currentTrack.stop();
        playing = false;
        currentTrack = tracks.get(trackName);
        currentTrack.play();
        playing = true;
        System.out.println("Current track playing is: " + currentTrack.getName());
    }
    public void stopMusic(){
        currentTrack.stop();
        playing = false;
        System.out.println("Stopped playing track: " + currentTrack.getName());
        
    }
    public void printTracks(){
        tracks.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach( entry -> System.out.println("Track: " + entry.getValue().getName()));
    }
    public boolean playing(){
        return playing;
    }
    
	public AudioTrack getCurrentTrack() {
		return currentTrack;
	}
	
	public HashMap<String, AudioTrack> getAllTracks(){
        return tracks;
    }
	
	public String toJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}
}