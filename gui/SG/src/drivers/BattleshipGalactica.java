package drivers;

import Audio.AudioController;
import gui.FirstScene;
import gui.ShipPlaceScene;
import logic.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BattleshipGalactica extends Application{
    Stage stage;
    Game game = new Game();
    private AudioController backgroundMusic = new AudioController(BattleshipGalactica.class.getResource("/Resources/Audio/MainMenu.mp3").toExternalForm());
    
    public void setScene(Scene scene){
    	
        stage.setScene(scene);
    }
    
    public Game getGame(){
    	backgroundMusic.stop();
        return game;
    }
    
    public void setGame(Game game) {

    	this.game = game;
    }
    
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
