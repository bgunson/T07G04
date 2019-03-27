package handlers;

import drivers.BattleshipGalactica;
import gui.AttackScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnAttackHandler implements EventHandler<ActionEvent>{

    BattleshipGalactica session;
    int x;
    int y;
    
    public BtnAttackHandler(BattleshipGalactica session, int x, int y){
        this.session = session;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void handle(ActionEvent event){
        
        //todo
        session.getGame().playRound(x, y);

    }
}
