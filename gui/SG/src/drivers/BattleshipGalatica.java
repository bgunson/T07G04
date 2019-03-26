package drivers;

import gui.FirstScene;
import gui.SecondScene;
import logic.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * TO DO:
 * - i broke the ai and i don't know how to fix it
 * - end the game when all ships are sunk
 * - update visuals
 * - add labels to explain whats happening
 */

public class BattleshipGalatica extends Application{
    Stage stage;
    Game game = new Game();

    
    public void setScene(Scene scene){
        stage.setScene(scene);
    }
    
    public Game getGame(){
        return game;
    }
    
    public void start(Stage stage){
        
        this.stage = stage;
        stage.setTitle("BATTLESHIP GALATICA THE IV");
        stage.show();
        
        FirstScene scene = new FirstScene(this);
        //SecondScene scene = new SecondScene(this);
        
        scene.setup();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
