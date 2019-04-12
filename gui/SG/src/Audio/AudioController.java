package Audio;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class AudioController {
	private Clip controller;
	private Media media;
	private MediaPlayer player;
	   /**
     	* The constructor AudioController takes in a sound files path as an argument and makes it into an object
     	*/
	public AudioController(String title) 
	{
		 try {

				 media = new Media(title);
				 player = new MediaPlayer(media);
				
			   
			  } catch (Exception e) {
			   System.err.println(e.getMessage());
			  }
			 }
	/**
     	* playSong takes the MediaPlayer object created and plays it in a loop till stopped.
     	*/
	public void playSong() {

		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.seek(Duration.ZERO);
		player.play();
	}
	   /**
    	 * playEffect is for sound effects instead of songs, the sound is played once and that's it
   	  */
	public void playEffect() {
		player.seek(Duration.ZERO);
		player.play();
	}
	 /**
    	 * stop will stop the sound from playing
   	  */
	public void stop() {
		player.stop();
		
	}
	

}
