package drivers;

import Audio.AudioController;
import gui.FirstScene;
import logic.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BattleshipGalactica extends Application{
    Stage stage;
    Game game = new Game();
    private AudioController backgroundMusic = new AudioController(BattleshipGalactica.class.getResource("/Resources/Audio/MainMenu.mp3").toExternalForm());
    
	
      /**
     *  Takes scene as a parameter then sets stage to that scene
     */
    public void setScene(Scene scene){
    	
        stage.setScene(scene);
    }
      /**
     *  Is used to start the game after pressing start, additionally stops the menu music from playing
     */
    public Game getGame(){
    	backgroundMusic.stop();
        return game;
    }
     /**
     *  sets the game variable
     */
    public void setGame(Game game) {

    	this.game = game;
    }
    /**
     *  When the game is first launched it plays the menu music and loads the stage
     */
    public void start(Stage stage){
		
	backgroundMusic.playSong();
    	
        this.stage = stage;
        stage.setTitle("BATTLESHIP GALACTICA THE IV");
        stage.show();
        

        FirstScene scene = new FirstScene(this);
        
        scene.setup();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
