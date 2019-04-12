package drivers;

import Audio.AudioController;
import gui.FirstScene;
import gui.ShipPlaceScene;
import logic.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Main driver that acts as a link between our logic and GUI.
 */
public class BattleshipGalactica extends Application{

    // Instance of Stage and new Game object
    Stage stage;
    Game game = new Game();
    // Music
    private AudioController backgroundMusic = new AudioController(BattleshipGalactica.class.getResource("/Resources/Audio/MainMenu.mp3").toExternalForm());

    /**
     * Set scene with specified scene.
     */
    public void setScene(Scene scene){
    	
        stage.setScene(scene);
    }

    /**
     * @return the current game being run.
     */
    public Game getGame(){
    	backgroundMusic.stop();
        return game;
    }

    /**
     * Set the current game with a specified one.
     */
    public void setGame(Game game) {

    	this.game = game;
    }

    /**
     * Start the main driver, excecutes when the program is run.
     */
    public void start(Stage stage){
		
		backgroundMusic.playSong();
    	
        this.stage = stage;
        stage.setTitle("BATTLESHIP GALACTICA THE IV");
        stage.show();
        

        FirstScene scene = new FirstScene(this);
        
        scene.setup();
    }

    /**
     * Main method.
     */
    public static void main(String[] args){
        launch(args);
    }
}
