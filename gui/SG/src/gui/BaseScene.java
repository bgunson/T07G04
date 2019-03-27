package gui;

import drivers.BattleshipGalactica;
import javafx.scene.Scene;

public abstract class BaseScene {
    private Scene scene;
    private BattleshipGalactica battleshipGalatica;
    
    public BaseScene(BattleshipGalactica battleshipGalatica){
     this.battleshipGalatica = battleshipGalatica;
    }
    
    public Scene getScene(){
        return scene;
    }
    
    public BattleshipGalactica getSession(){
        return battleshipGalatica;
    }
    
    public void setScene(Scene scene){
        this.scene = scene;
    }
    
    public BattleshipGalactica getSG(){
        return battleshipGalatica;
    }
    
    // Sets up the scene
    public abstract void setup();
    
    protected void display(){
        battleshipGalatica.setScene(this.scene);
    }
}
