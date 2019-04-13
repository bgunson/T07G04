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
    	 *  AudioController takes a string of the audiofiles path then makes it an object
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
     	*  Play song starts playing whatever song the object is set to
     	*/
	public void playSong() {

		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.seek(Duration.ZERO);
		player.play();
	}
	 /**
    	 *  Plays an effect once
    	 */
	public void playEffect() {
		player.seek(Duration.ZERO);
		player.play();
	}
	 /**
    	 * Stops the song or effect being played
     	*/
	public void stop() {
		player.stop();
		
	}
	

}
