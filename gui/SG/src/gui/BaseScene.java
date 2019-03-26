package gui;

import drivers.BattleshipGalatica;
import javafx.scene.Scene;

public abstract class BaseScene {
    private Scene scene;
    private BattleshipGalatica battleshipGalatica;
    
    public BaseScene(BattleshipGalatica battleshipGalatica){
     this.battleshipGalatica = battleshipGalatica;
    }
    
    public Scene getScene(){
        return scene;
    }
    
    public BattleshipGalatica getSession(){
        return battleshipGalatica;
    }
    
    public void setScene(Scene scene){
        this.scene = scene;
    }
    
    public BattleshipGalatica getSG(){
        return battleshipGalatica;
    }
    
    // Sets up the scene
    public abstract void setup();
    
    protected void display(){
        battleshipGalatica.setScene(this.scene);
    }
}
