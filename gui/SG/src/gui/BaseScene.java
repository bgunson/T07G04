package gui;

import Audio.AudioController;
import drivers.BattleshipGalactica;
import javafx.scene.Scene;

public abstract class BaseScene {
    private Scene scene;
    private BattleshipGalactica battleshipGalatica;
    public BaseScene(BattleshipGalactica battleshipGalatica){
     this.battleshipGalatica = battleshipGalatica;
    }
    //Returns scene
    public Scene getScene(){
    	
        return scene;
    }
    //returns the battleshipgGalactica session
    public BattleshipGalactica getSession(){
    	
        return battleshipGalatica;
    }
     /**
     * @param takes a scene as a parameter and sets the scene to that
     */
    public void setScene(Scene scene){
    	
        this.scene = scene;
    }

    // Sets up the scene
    public abstract void setup();
    
    protected void display(){
    	
        battleshipGalatica.setScene(this.scene);
    }
}
