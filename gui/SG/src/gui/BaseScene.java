package gui;

import Audio.AudioController;
import drivers.BattleshipGalactica;
import javafx.scene.Scene;

/*
Abstract parent class for our scene objects.
 */
public abstract class BaseScene {

    // Scene variable and current session instances.
    private Scene scene;
    private BattleshipGalactica battleshipGalatica;

    /**
     * Constructor that sets the session as the one in progress.
     */
    public BaseScene(BattleshipGalactica battleshipGalatica){
     this.battleshipGalatica = battleshipGalatica;
    }

    /**
     * @return the current scene.
     */
    public Scene getScene(){
    	
        return scene;
    }

    /**
     * @return the current driver object.
     */
    public BattleshipGalactica getSession(){
    	
        return battleshipGalatica;
    }

    /**
     * Set the current scene to a specified Scene.
     */
    public void setScene(Scene scene){
    	
        this.scene = scene;
    }

    // Sets up the scene
    public abstract void setup();

    /**
     * Display the scene.
     */
    protected void display(){

        battleshipGalatica.setScene(this.scene);
    }
}
