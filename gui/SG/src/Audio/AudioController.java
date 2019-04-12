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
	public AudioController(String title) 
	{
		 try {

				 media = new Media(title);
				 //Media path = new Media( new File(title).toURI().toString());
				 player = new MediaPlayer(media);
				//player.setAutoPlay(true);
			   
			  } catch (Exception e) {
			   System.err.println(e.getMessage());
			  }
			 }
	
	public void playSong() {

		player.setCycleCount(MediaPlayer.INDEFINITE);
		player.seek(Duration.ZERO);
		player.play();
	}
	public void playEffect() {
		player.seek(Duration.ZERO);
		player.play();
	}
	public void stop() {
		player.stop();
		
	}
	

}
